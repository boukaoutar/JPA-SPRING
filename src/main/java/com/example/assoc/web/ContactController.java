package com.example.assoc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ContactController {
	@RequestMapping("/data")
	public String index()
	{
		return "index";
	}

}
