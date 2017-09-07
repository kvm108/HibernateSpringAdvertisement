package com.hibernateSpringRestSQL.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateSpringRestSQL.entity.User;
import com.hibernateSpringRestSQL.entity.Advertisement;
import com.hibernateSpringRestSQL.entity.Categories;
import com.hibernateSpringRestSQL.entity.PostAd;
import com.hibernateSpringRestSQL.entity.UserSession;
import com.hibernateSpringRestSQL.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/advertise")
public class UserController {

	@Autowired
	UserService userService;

	// Registration
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createUser(@RequestBody User user) {
		System.out.println("user = " + user);
		String u = userService.createUser(user);

		JSONObject jsonMessage = new JSONObject();
		jsonMessage.put("message", u);
		JSONObject jsonData = new JSONObject();
		jsonData.put("data", jsonMessage);
		JSONObject jsonDataOuter = new JSONObject();
		jsonDataOuter.put("data", jsonData);

		System.out.println("json data real" + jsonMessage.toString());

		return jsonMessage.toString();
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody User login) {
		
		UserSession us = userService.loginUser(login);
		
		JSONObject jsonMessage = new JSONObject();
		jsonMessage.put("auth-token", us.getAuthToken());
		jsonMessage.put("userId", us.getUsername());
	
		JSONObject jsonDataOuter = new JSONObject();
		jsonDataOuter.put("data", jsonMessage);
		
		return jsonDataOuter.toString();
	}
	
	@RequestMapping(value="/postAd",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String postAd(@RequestHeader(value="auth-token") String authToken,@RequestBody PostAd postad){
		System.out.println("Post ad aut : "+authToken);
//		PostAd pa = userService.postAd(authToken,postad);
//		System.out.println("Post Ad "+pa);
		PostAd postAd = userService.postAd(authToken,postad);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("mypostList", postAd);
		wrapper.put("data", jsonString);
		
		System.out.println("Posted Ad JSON: "+wrapper.toString());
		return wrapper.toString();
		
	}
	@RequestMapping(value="/categories",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCategories(){
		List<Categories> categories=userService.getCategories();
		System.out.println("Cat uc "+categories);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("itemList", categories);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	@RequestMapping(value="/posts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllPostedAds(@RequestHeader(value="auth-token") String authToken){
		List<PostAd> ads=userService.getPostedAds(authToken);
		System.out.println("Ads post "+ads);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("mypostList", ads);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	
	@RequestMapping(value="/postedUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getPostedAdsUserSpec(@RequestHeader(value="auth-token") String authToken){
		List<PostAd> ads=userService.getPostedAdsLoggedUser(authToken);
		System.out.println("Ads post User Specific "+ads);
		JSONObject jsonString=new JSONObject();
		JSONObject wrapper=new JSONObject();
		jsonString.put("mypostList", ads);
		wrapper.put("data", jsonString);
		return wrapper.toString();
	}
	@RequestMapping(value="/post",method=RequestMethod.DELETE)
	public @ResponseBody String getDeleted(@RequestHeader(value="auth-token") String authToken, @RequestParam(name="postId") int id){
		userService.deleteAd(authToken, id);
		return "Yay";
	}

	// {
	// "firstName": "Anand",
	// "lastName": "Kulkarni",
	// "userName": "anand",
	// "password": "anand123",
	// "email": "anand@gmail.com",
	// "phone": 12345
	// }

}
