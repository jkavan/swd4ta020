package com.jkavan.SWD4TA020.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping(value={"/", "/index"})
	@ResponseBody
	public String returnIndex() {
		return "This is the main page";
	}

	@RequestMapping("/contact")
	@ResponseBody
	public String returnContact() {
		return "This is the contact page";
	}

	@RequestMapping("hello")
	@ResponseBody
	public String returnGreetingForName(
			@RequestParam(name = "location", required=false, defaultValue="Location") String location,
			@RequestParam(name = "name", required=false, defaultValue="Name") String name
	) {
		return "Welcome to the " + location + " " + name + "!";
	}
}
