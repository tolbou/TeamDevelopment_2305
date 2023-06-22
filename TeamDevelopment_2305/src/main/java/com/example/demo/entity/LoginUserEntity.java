package com.example.demo.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class LoginUserEntity {
	
	@Id
	@Column(name = "id")
	private  Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	@Column(name = "created_at")
	private Timestamp created_at;
	
	@Column(name = "updated_at")
	private Timestamp updated_at;

	//
	//	public String getPassword() {
	//		return password;
	//	}
	//
	//	public void setPassword(String password) {
	//		this.password = password;
	//	}
	//
	//	public String getEmail() {
	//		return email;
	//	}
	//
	//	public void setEmail(String email) {
	//		this.email = email;
	//	}

	

}
