package com.hibernateSpringRestSQL.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.PostAd;
import com.hibernateSpringRestSQL.entity.User;
import com.hibernateSpringRestSQL.entity.UserSession;

public class UserSQLDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Transactional
	public String createUser(User user) {
		String reg = "Registration unsuccessful";
		List<User> userLogin = (List<User>) getHibernateTemplate().find("from User where userName=?",
				user.getUserName());

		System.out.println("User login in register : " + userLogin);
		if (userLogin.size() == 0) {
			reg = "Registration Successful";
			getHibernateTemplate().save(user);
		} else {
			reg = "Registration unsuccessful";
		}
		return reg;
	}

	@Transactional
	public Categories createCategory(Categories categories) {
		getHibernateTemplate().save(categories);
		return categories;
	}

	@Transactional
	public List<Categories> getCategories() {

		List<Categories> categories = (List<Categories>) getHibernateTemplate().find("from Categories"); // HQL
		System.out.println("Cat : "+ categories);
		return categories;
	}

	@Transactional
	public UserSession loginUser(User user) {
		List<User> userLogin = (List<User>) getHibernateTemplate().find("from User where userName=? AND password=?",
				user.getUserName(), user.getPassword());
		User currentUser = userLogin.get(0);
		
		System.out.println("Current user : "+currentUser);
		UserSession userSession = new UserSession();

		userSession.setUsername(currentUser.getUserName());
		userSession.setLast_updated_date(new Date());
		userSession.setAuthToken("" + Math.random());

		getHibernateTemplate().save(userSession);
		return userSession;
	}

	@Transactional
	public PostAd postAd(String authToken, PostAd postad) {
		if(authToken != null) {
			List<String> userNameList = (List<String>) getHibernateTemplate().find("select us.username from UserSession us where authToken=?", authToken);
			System.out.println("List "+userNameList);
			String userName = userNameList.get(0);
			postad.setUserName(userName);
			System.out.println("Saving post ad"+postad);
			getHibernateTemplate().save(postad);
		}
		return postad;
	}
	
	@Transactional
	public List<PostAd> getPostedAd(String authToken) {
		List<PostAd> postedAds = null;
		if(authToken != null) {
			postedAds = (List<PostAd>) getHibernateTemplate().find("from PostAd");
			System.out.println("Posted!!"+postedAds);
		}
		return postedAds;
	}

	@Transactional
	public List<PostAd> getPostedAdsLoggedUser(String authToken) {
		List<PostAd> postedAds = null;
		if(authToken != null) {
			List<String> userNameList = (List<String>) getHibernateTemplate().find("select us.username from UserSession us where authToken=?", authToken);
			System.out.println("List "+userNameList);
			String userName = userNameList.get(0);
			postedAds = (List<PostAd>) getHibernateTemplate().find("from PostAd p where userName = ?",userName);
			System.out.println("Posted!!"+postedAds);
		}
		return postedAds;
	}

	@Transactional
	public String deleteAd(String authToken, int id) {
		List<String> userNameList = (List<String>) getHibernateTemplate().find("delete from PostAd pa where id=?", id);
		System.out.println("List "+userNameList);
		return authToken;
	}
}
