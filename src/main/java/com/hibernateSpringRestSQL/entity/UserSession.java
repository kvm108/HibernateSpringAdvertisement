package com.hibernateSpringRestSQL.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_session")
public class UserSession {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="session_id")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="last_updated_date")
	private Date last_updated_date;
	@Column(name="auth_token")
	private String authToken;
	public UserSession() {
		// TODO Auto-generated constructor stub
	}

	public UserSession(int id, String username, Date last_updated_date, String authToken) {
		super();
		this.id = id;
		this.username = username;
		this.last_updated_date = last_updated_date;
		this.authToken = authToken;
	}

	public UserSession(int id, String username, Date last_updated_date) {
		super();
		this.id = id;
		this.username = username;
		this.last_updated_date = last_updated_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public String toString() {
		return "UserSession [id=" + id + ", username=" + username + ", last_updated_date=" + last_updated_date + "]";
	}

	
}
