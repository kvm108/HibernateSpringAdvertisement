package com.hibernateSpringRestSQL.dao;

import java.util.List;

import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.PostAd;
import com.hibernateSpringRestSQL.entity.UserSession;
import com.hibernateSpringRestSQL.entity.User;

public interface UserDAO {
	public String createUser(User user);
	public UserSession loginUser(User user);
	public Categories createCategory(Categories categories);
	public List<Categories> getCategories();
	public PostAd postAd(String authToken, PostAd postad);
	public List<PostAd> getPostedAd(String authToken);
	public List<PostAd> getPostedAdsLoggedUser(String authToken);
	public String deleteAd(String authToken, int id);
}
