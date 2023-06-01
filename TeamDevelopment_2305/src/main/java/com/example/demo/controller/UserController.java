package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;



/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	UserService userService;

	/**
	 * ユーザー一覧画面を表示
	 * @param model Model
	 * @return ユーザー一覧画面のHTML
	 */
	@GetMapping("/user/{id}")
	public String displayList(@PathVariable Integer id, Model model) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT content From posts WHERE user_id= ");
		sql.append(id);
//		List<UserEntity> userlist= sql.getResultList();
//		UserEntity user = userService.findById(id);
//		List<UserEntity> userlist = userService.searchAll();
		//情報を入力
		//UserEntity userlist = userService.findByUser_Id(id);
		//model.addAttribute("userlist", user);
		
		List<UserEntity> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		model.addAttribute("userlist", userlist);
		return "user/list";
	}
	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping("/user/add_user")
//	public String displayAdd(Model model) {
	public String displayAdd() {
//		model.addAttribute("userRequest", new UserRequest());
		return "user/add_user";
	}

	/**
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
//	@RequestMapping("/user/create")
//	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			// 入力チェックエラーの場合
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			model.addAttribute("validationError", errorList);
//			return "user/add";
//		}
//		// ユーザー情報の登録
//		userService.create(userRequest);
//		return "redirect:/user/list";
//	}

	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
//	@GetMapping("/user/{id}")
//	public String displayView(@PathVariable Integer id, Model model) {
//		UserEntity user = userService.findById(id);
//		model.addAttribute("userData", user);
//		return "user/view";
//
//	}
	/**
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Integer id, Model model) {
		UserEntity user = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(user.getId());
		//UserUpdateRequest.setContent(user.getContent());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "user/edit";
	}
	/**
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
//	@RequestMapping("/user/update")
//	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			model.addAttribute("validationError", errorList);
//			return "user/edit";
//		}
//		// ユーザー情報の更新
//		userService.update(userUpdateRequest);
//		return String.format("redirect:/user/%d", userUpdateRequest.getId());
//	}
	@RequestMapping("/user/edit")
//	public String displayAdd(Model model) {
	public String displayEdit() {
//		model.addAttribute("userRequest", new UserRequest());
		return "user/edit";
	}
	
	
	@RequestMapping("/user/reply")
//	public String displayAdd(Model model) {
	public String displayReply() {
//		model.addAttribute("userRequest", new UserRequest());
		return "user/reply";
	}

	/**
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
//	@GetMapping("/user/{id}/delete")
//	public String delete(@PathVariable Integer id, Model model) {
//		// ユーザー情報の削除
//		userService.delete(id);
//		return "redirect:/user/list";
//	}
	@GetMapping("/user/{id}/delete/delte_content")
	public String delete(UserRequest userRequest,Model model){
		userService.delete(userRequest.getId());
		return "/user/list";
	}
	
	
	//@PathVariableを追加した
	@GetMapping("/user/{id}/delete")
	public String displaydelete(@PathVariable Integer id, Model model) {
		  UserEntity editEntity = userService.findByUser_Id(id);
		  UserRequest editForm = new UserRequest();
		  editForm.setId(editEntity.getId());
		  editForm.setContent(editEntity.getContent());
		  model.addAttribute("editForm", editForm);
		return "/user/delete";
	}
	//}
}

