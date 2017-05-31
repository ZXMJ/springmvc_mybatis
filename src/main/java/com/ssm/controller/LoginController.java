package com.ssm.controller;


import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Title: ItemsController.java
 * Description:
 * Company: 
 * @author 范保申
 * @date 2016-4-5上午11:49:47
 * @version 1.0
 */

@Controller
@RequestMapping("/items")
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password){
		session.setAttribute("username", username);
		return "redirect:/items/queryItems.do";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/items/queryItems.do";
	}
}
