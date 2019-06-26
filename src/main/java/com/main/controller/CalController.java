package com.main.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.svInf.CalService;
import com.main.svInf.DateUtil;

@Controller
public class CalController {
	
	@Inject CalService calService;
	@Inject DateUtil dateUtil; 
	
	@RequestMapping(value = "/calMain", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> mainList() throws Exception {
		return calService.selectCrntCal(); 
		
	}
}
