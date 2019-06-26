package com.main.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.dto.MemberVO;
import com.main.svInf.DateUtil;
import com.main.svInf.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	@Inject
	private DateUtil dateUtil;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		//현재 월
		String curtDt_YYYYMM = dateUtil.getCurrentDt("yyyy년 MM월");
		model.addAttribute("curtDt", curtDt_YYYYMM);
		
//		List<MemberVO> memberList = null;
//		memberList = service.selectMember();
//		model.addAttribute("memberList", memberList);
		return "home";
	}
	
	
}
