package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.spring.domain.BusinessInfo;
import com.service.spring.domain.TmtUser;
import com.service.spring.model.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping()
public class UserController {
	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/";
	}

	// 일반 유저 회원가입
	@PostMapping("register/generalUser")
	public String registerGeneralUser(@RequestBody TmtUser pvo) throws Exception{
		System.out.println("aa==============");
//		pvo.setConsumptionCat1(1);
		pvo.setUserName("Aa");
//		pvo.setCertType("1");
		System.out.println(pvo);
		userService.insertUser(pvo);
		return "redirect:/";
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
	
	
	@RequestMapping("/login")
	public ResponseEntity<String> login(@RequestBody TmtUser pvo, HttpServletRequest request) throws Exception {
		
		System.out.println(pvo);
		TmtUser rvo = userService.login(pvo);
		System.out.println(rvo);
		if(rvo != null) {
			// login, update는 반드시 session에 값을 바인딩
			request.getSession().setAttribute("vo", rvo);
			System.out.println("널아님");
			return ResponseEntity.ok(objectMapper.writeValueAsString(rvo));
		}
		return null;
	}
	
	
	@GetMapping("idExist")
	public String idExist(@RequestParam String generalId, Model model) throws Exception{
		String id = userService.idExist(generalId);
		if(id!=null) {
			model.addAttribute("existId", id);
			return "exist";
		}else return null;
	}
	
	@GetMapping("nicknameExist")
	public String nicknameExist(@RequestParam String userNickname, Model model) throws Exception{
	  String nickname = userService.nicknameExist(userNickname);
	  if (nickname != null) {
	    model.addAttribute("existNickname", nickname);
	    return "exist";
	  } else {
	    return null;
	  }
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