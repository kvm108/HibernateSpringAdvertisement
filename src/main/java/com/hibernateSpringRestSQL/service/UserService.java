package com.hibernateSpringRestSQL.service;

import java.util.List;

import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.PostAd;
import com.hibernateSpringRestSQL.entity.UserSession;
import com.hibernateSpringRestSQL.entity.User;

public interface UserService {
	public String createUser(User user);
	public Categories createCategory(Categories categories);
	
	/*public String loginUser(User user);
	public String logout(String authToken);
*/
	public List<Categories> getCategories();
	/*
	public List<ActionsCollection> getActions(String authToken);

	public Advertisement postAd(Advertisement ad, String authToken);
	
	*/
	public UserSession loginUser(User login);
	public PostAd postAd(String authToken, PostAd postad);
	public List<PostAd> getPostedAds(String authToken);
	public List<PostAd> getPostedAdsLoggedUser(String authToken);
	public String deleteAd(String authToken, int id);
}

