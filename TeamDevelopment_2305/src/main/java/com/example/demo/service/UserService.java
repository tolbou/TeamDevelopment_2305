package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserUpdateRequest;
//import com.example.demo.dto.UserRequest;
//import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー情報 全検索
	 * @return 検索結果
	 */
	public List<UserEntity> searchAll() {
		return userRepository.findAll();
	}
	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public UserEntity findById(Integer id) {
		return userRepository.getOne(id);
	}
	
	public UserEntity findByUser_Id(Integer id) {
		return userRepository.findById(id).get();
		
	}
	
	
	//1ユーザーの投稿だけ取得したい
	//@Autowired
//	public List<UserEntity> getList(String userName) {
//	  List<UserEntity> list = userRepository.findAll(Specification
//	    .where(userRepository.userNameContains(userName)));
//	    // 複数項目の場合は.and(),.or()でつなげる
//	}

	/**
	 * ユーザー情報 新規登録
	 * @param user ユーザー情報
	 */
//	public void create(UserRequest userRequest) {
//		Date now = new Date();
//		UserEntity user = new UserEntity();
//		user.setName(userRequest.getName());
//		user.setAddress(userRequest.getAddress());
//		user.setPhone(userRequest.getPhone());
//		user.setCreateDate(now);
//		user.setUpdateDate(now);
//		userRepository.save(user);
//	}
//	/**
//	 * ユーザー情報 更新
//	 * @param user ユーザー情報
//	 */
	public void update(UserUpdateRequest userUpdateRequest) {
		UserEntity user = findById(userUpdateRequest.getId());
		//user.setContent(userUpdateRequest.getContent());
		user.setUpdateDate(new Date());
		userRepository.save(user);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
}