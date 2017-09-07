package com.hibernateSpringRestSQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hibernateSpringRestSQL.dao.UserDAO;
import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.PostAd;
import com.hibernateSpringRestSQL.entity.UserSession;
import com.hibernateSpringRestSQL.entity.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	public String createUser(User user) {
//		System.out.println("In user service "+user);
		return userDao.createUser(user);
	}
	public Categories createCategory(Categories categories) {
		return userDao.createCategory(categories);
	}
	
	/*public String loginUser(User user) {
		return userDao.loginUser(user);
	}

	public String logout(String authToken){
		return userDao.logout(authToken);
	}*/
	public List<Categories> getCategories(){
		return userDao.getCategories();
	}
	/*
	public List<ActionsCollection> getActions(String authToken){
		return userDao.getActions(authToken);
	}
	public Advertisement postAd(Advertisement ad, String authToken){
		return userDao.postAd(ad, authToken);
	}*/
	public UserSession loginUser(User user) {
		return userDao.loginUser(user);
	}
	public PostAd postAd(String authToken, PostAd postad) {
		return userDao.postAd(authToken, postad);
	}
	public List<PostAd> getPostedAds(String authToken) {
		return userDao.getPostedAd(authToken);
	}
	public List<PostAd> getPostedAdsLoggedUser(String authToken) {
		return userDao.getPostedAdsLoggedUser(authToken);
	}
	public String deleteAd(String authToken, int id) {
		return userDao.deleteAd(authToken, id);
	}
}
