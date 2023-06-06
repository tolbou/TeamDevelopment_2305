package com.example.demo.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//ユーザー情報 Entity

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

	//メールアドレス
	@Id
	@Column(name = "メールアドレス")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long email;

	@Column(name = "ユーザーネーム")
	private String username;

	//パスワード
	@Column(name = "パスワード")
	private String passward;

}