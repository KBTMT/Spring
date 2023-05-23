package com.service.spring.controller;

import java.util.Map;

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
//		pvo.setCertType("1");
		System.out.println(pvo);
		userService.insertUser(pvo);
		return "redirect:/";
	}
	
	
	// 사업자 회원가입
	@PostMapping("register/businessUser")
	public String registerBusinessUser(@RequestBody Map<String, Object> requestData) throws Exception{
		System.out.println(requestData);
//		System.out.println(requestData.get("tmtUser"));
//		System.out.println(requestData.get("businessInfo"));
		 // Map에서 데이터 추출
		System.out.println(1);
		TmtUser tmtUser = new TmtUser((String)requestData.get("generalId"), (String)requestData.get("userName"), (String)requestData.get("userNickname"), 
				(String)requestData.get("password"), (String)requestData.get("email"), (String)requestData.get("birthDate"),
				Integer.parseInt(requestData.get("job").toString()), Integer.parseInt(requestData.get("consumptionCat1").toString()),
				Integer.parseInt(requestData.get("financeCat").toString()), Integer.parseInt(requestData.get("salary").toString()),
				Integer.parseInt(requestData.get("saving").toString()),1);
		System.out.println(2);
		BusinessInfo businessInfo = new BusinessInfo((String)requestData.get("generalId"), (String)requestData.get("businessNum"), 
				(String)requestData.get("tradeName"), (String)requestData.get("location"));
		
//
//	    // tmtUser 객체에 데이터 설정
//	    TmtUser tmtUser = .setGeneralId((String) tmtUserData.get("generalId"));
//	    tmtUser.setUserName((String) tmtUserData.get("userName"));
//	    // 나머지 필드들도 동일한 방식으로 설정
//
//	    // businessInfo 객체에 데이터 설정
//	    BusinessInfo businessInfo.setGeneralId((String) businessInfoData.get("generalId"));
//	    businessInfo.setBusinessNum((String) businessInfoData.get("businessNum"));
//	    // 나머지 필드들도 동일한 방식으로 설정
	    // tmtUser, businessInfo 객체를 사용하여 로직 수행
//	    tmtUser.setTmtUserFlag(1);
//
//	    System.out.println(tmtUser);
//	    System.out.println(businessInfo);
//	    userService.insertUser(tmtUser);
//	    userService.insertBusiness(businessInfo);
//		tmtUser.setTmtUserFlag(1);
		System.out.println(tmtUser);
		System.out.println(businessInfo);
		userService.insertUser(tmtUser);
		userService.insertBusiness(businessInfo);
		return "redirect:/";
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
			System.out.println(ResponseEntity.ok(objectMapper.writeValueAsString(rvo)));
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