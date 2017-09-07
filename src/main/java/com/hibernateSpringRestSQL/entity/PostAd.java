package com.hibernateSpringRestSQL.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post_ad")
public class PostAd {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="postid")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="description")
	private String description;
	@Column(name="userName")
	private String userName;
	
	public PostAd(int id, String title, String name, String category, String description, String userName) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.userName = userName;
	}
	public PostAd() {
		// TODO Auto-generated constructor stub
	}
	public PostAd(String title, String name, String category, String description, String userName) {
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "PostAd [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category + ", description="
				+ description + "]";
	}
	
	
}
