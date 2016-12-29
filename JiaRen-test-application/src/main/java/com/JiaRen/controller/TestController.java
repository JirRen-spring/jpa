package com.JiaRen.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/index")
	public String index(Map<String, Object> model,HttpServletRequest request) {
		model.put("test", "denghuizhi");
		return "/index";
	}
}
