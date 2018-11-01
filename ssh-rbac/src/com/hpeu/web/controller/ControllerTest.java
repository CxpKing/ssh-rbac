package com.hpeu.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerTest {
	@RequestMapping(value="/request1")
	public String request1(Map<String,Object> map) {
		String name = "cxp";
		map.put("name", name);
		return "/request2";
	}
	@RequestMapping(value="/request2")
	public String request2(@RequestParam(value="name",required=false) Map<String,Object> map) {
		
		
		map.put("age", 20);
		return "b";
	}
	
}
