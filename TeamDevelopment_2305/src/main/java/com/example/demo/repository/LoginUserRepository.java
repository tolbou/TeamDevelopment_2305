package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUserEntity;

@Repository
public class LoginUserRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String SELECT_USER_BY_EMAIL = "SELECT email, password FROM users WHERE email = :email";
	private static final BeanPropertyRowMapper<LoginUserEntity> USER_ROW_MAPPER = BeanPropertyRowMapper.newInstance(LoginUserEntity.class);

	public LoginUserEntity findByEmail(String email) {
		SqlParameterSource param = new MapSqlParameterSource("email", email);
		List<LoginUserEntity> userList = template.query(SELECT_USER_BY_EMAIL, param, USER_ROW_MAPPER);
		if (userList.isEmpty()) {
			return null;
		}
		return userList.get(0);
	}

   	
}
