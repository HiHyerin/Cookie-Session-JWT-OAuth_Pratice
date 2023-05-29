package com.hk.csj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.csj.service.UserService;
import com.hk.csj.vo.UserVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signUp")
	public String signUpForm() {
		return "join";
	}
	
	@PostMapping("/signUp1")
	public String signUp(UserVO userVO) {
		userService.joinUser(userVO);
		System.out.println("getUserId:"+userVO.getUserId());
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login1")
	public String login(UserVO userVO, HttpServletResponse response) {
		UserVO loginUser = userService.loginUser(userVO);
		Cookie idCookie = new Cookie("userId", loginUser.getUserId());
		response.addCookie(idCookie);
		return "redirect:home";
	}
	
	
	@GetMapping("/home")
	public String home(@CookieValue(name="userId", required=false) String userId, Model model, UserVO userVO) {
	    model.addAttribute("userId", userId);
	    System.out.println("userId: " + userId);
	    return "home";
	}
	
	
	
	
	
	
	
	
}
