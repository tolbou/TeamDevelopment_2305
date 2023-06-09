package com.example.demo.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.listentity.UserlistEntity;
import com.example.demo.listservice.UserlistService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserlistController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserlistService userlistService;

  /**
   * ユーザー情報一覧画面を表示
   *
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    List<UserlistEntity> userlist = userlistService.searchAll();
    model.addAttribute("userlist", userlist);
    return "user/list";
  }
  
//  @GetMapping(value = "/user/list")
//  public String displaylist(Model model) {
//	  return "user/list";  
//  }
//  
  
  
  

  /**
   * マイページを表示
   *
   * @param model Model
   * @return マイページ
   */
  @GetMapping(value = "/user/view")
  public String displayview(Model model) {
	  return "user/view";  
  }

  /**
   * マイページを表示
   *
   * @param id    表示するユーザーID
   * @param model Model
   * @return マイページ
   */
//  @GetMapping("/user/{id}")
//  public String displayView(@PathVariable Long id, Model model) {
//    return "user/view";
//  }

  /**
   * キーワード検索
   *
   * @param keyword 検索キーワード
   * @return 検索結果リスト
   */
  @GetMapping("/search")
  public List<UserlistEntity> search(@RequestParam String keyword) {
    List<UserlistEntity> results = userlistService.searchByKeyword(keyword);
    return results;
  }
}
