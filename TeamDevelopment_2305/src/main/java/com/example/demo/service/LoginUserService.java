package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUserEntity;
import com.example.demo.repository.LoginUserRepository;

@Service
public class LoginUserService implements UserDetailsService {

	@Autowired
	private LoginUserRepository LoginUserRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//メールアドレスによりユーザーを検索
		LoginUserEntity userEntity = LoginUserRepository.findByEmail(email);
		//バリデーションチェック　本記事の趣旨とは異なるので実装の詳しい説明は省略。
		if (userEntity == null) {
			throw new UsernameNotFoundException("そのEmaiは登録されていません");
		}
		//権限情報を格納するためのリストの作成、権限の付与
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		//		if(member.isAdmin()) {
		//		authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // 管理者権限付与
		//	}
		//ログインユーザーのコンストラクタを使用してインスタンスを生成する。
		return (UserDetails) new LoginUserEntity();
	}
}
