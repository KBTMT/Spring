package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.domain.BusinessInfo;
import com.service.spring.domain.TmtUser;
import com.service.spring.model.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp";
	}

	// 일반 유저 회원가입
	@PostMapping("/regiseterGeneralUser")
	public String registerGeneralUser(TmtUser pvo) throws Exception{
		userService.insertUser(pvo);
		return "redirect:/index.jsp";
	}
	
	
	// 사업자 회원가입
	@PostMapping("/regiseterBusinessUser")
	public String registerBusinessUser(HttpServletRequest request, TmtUser businessRegisterUserInfo) throws Exception{
		if(businessRegisterUserInfo!=null) {
			request.getSession().setAttribute("businessRegisterUserInfo", businessRegisterUserInfo);
			return "businessRegisterNextLevel";
		}else return "redirect:/index.jsp";
	}
	
	
	@PostMapping("/businessRegisterNextLevel")
	public String businessRegisterNextLevel(HttpServletRequest request, BusinessInfo businessInfo) throws Exception{
		if(businessInfo!=null) {
			TmtUser businessRegisterUserInfo = (TmtUser)request.getSession().getAttribute("businessRegisterUserInfo");
			userService.insertUser(businessRegisterUserInfo);
			businessInfo.setGeneralId(businessRegisterUserInfo.getGeneralId());
			userService.insertBusiness(businessInfo);
			return "login";
		}else return "redirect:/index.jsp";
	}
	
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, TmtUser pvo) throws Exception {
		
		TmtUser rvo = userService.login(pvo);
		if(rvo != null) {
			// login, update는 반드시 session에 값을 바인딩
			request.getSession().setAttribute("vo", rvo);
		}
		return "redirect:/index.jsp";
	}
	
	
	@GetMapping("idExist")
	public String idExist(String generalId, Model model) throws Exception{
		String id = userService.idExist(generalId);
		if(id!=null) {
			model.addAttribute("existId", id);
			return "";
		}else return null;
	}
	
	
	@PostMapping("updateUser")
	public String updateUser(HttpSession session, TmtUser pvo) throws Exception {
		userService.updateUser(pvo);
		// 로그인된 상태에서만 수정 가능하도록
		if (session.getAttribute("vo") != null) { // 로그인된 상태라면
			session.setAttribute("vo", pvo);
			return "update_result";
		} else {
			return null;
		}
	}
	
	
	@PostMapping("updateBusiness")
	public String updateBusiness(HttpSession session, BusinessInfo pvo) throws Exception {
		userService.updateBusiness(pvo);
		// 로그인된 상태에서만 수정 가능하도록
		if (session.getAttribute("vo") != null) { // 로그인된 상태라면
			session.setAttribute("vo", pvo);
			return "update_result";
		} else {
			return null;
		}
	}
	
	
	
	
	@PostMapping("logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("vo") != null) { // 로그인된 상태라면 로그아웃시키자
			session.invalidate(); // 세션을 죽이고
			return "logout";
		}
		return null;
	}
}