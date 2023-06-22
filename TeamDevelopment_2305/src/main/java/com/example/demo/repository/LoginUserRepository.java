package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	private static final String SELECT_USER_BY_EMAIL = "SELECT email, password, username FROM users WHERE email = :email";
	private static final BeanPropertyRowMapper<LoginUserEntity> USER_ROW_MAPPER = BeanPropertyRowMapper.newInstance(LoginUserEntity.class);

	public LoginUserEntity findByEmail(String email) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		try {
			return template.queryForObject(SELECT_USER_BY_EMAIL, param, USER_ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}

