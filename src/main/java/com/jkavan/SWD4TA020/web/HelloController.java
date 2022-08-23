package com.jkavan.SWD4TA020.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping("hello")
	public String returnHello(
			@RequestParam(name = "name", required=false, defaultValue="anonymous") String name,
			@RequestParam(name = "age", required=false, defaultValue="10") int age,
			Model model
	) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}
}
