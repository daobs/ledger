package com.main.controller;

import java.util.HashMap;
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
import com.main.svInf.DailyService;
import com.main.svInf.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private DailyService daliyService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		List<MemberVO> memberList = null;
		memberList = memberService.selectMember();
		model.addAttribute("memberList", memberList);
		return "home";
	}
	
	@RequestMapping(value = "/daily", method = RequestMethod.GET)
	public String dayil(Locale locale, Model model) throws Exception {
		
		HashMap<String, Object>  map = new HashMap<String, Object> ();
		map = daliyService.selectDaily(null, 0);
		
		model.addAttribute("daliyArr", map);
		return "daily";
	}
	
	
}
