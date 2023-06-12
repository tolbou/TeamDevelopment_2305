package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUserEntity;

@Repository
public class LoginUserRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Userオブジェクトを生成するローマッパー.
	 */
	private static final RowMapper<LoginUserEntity> USER_ROW_MAPPER = new BeanPropertyRowMapper<>(LoginUserEntity.class);

	/**
	 * メールアドレスをもとにユーザーを検索します.
	 * 
	 * @param email メールアドレス
	 * @return ユーザー情報
	 */
	public LoginUserEntity findByEmail(String email) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id,name,email,password,zipcode,address,telephone from users WHERE email=:email;");
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		java.util.List<LoginUserEntity> userList = template.query(sql.toString(), param, USER_ROW_MAPPER);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	};
}

