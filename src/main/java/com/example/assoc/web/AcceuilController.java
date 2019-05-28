package com.example.assoc.web;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.entities.Organisme;

@Controller

public class AcceuilController {
	
	
	@Autowired
	private OrganismeRepository organismerepo;
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
	public String index(HttpSession session,Model model)
	{
		Optional<Organisme> organismes = organismerepo.findById(1);
		model.addAttribute( "organismes" , organismes.get());
		model.addAttribute( "contact" , "hahaha");
	
		
		return "index";
	}
	
	/*@RequestMapping("/form.html")
	public String form(Model model)
	{
		Optional<Organisme> organismes = organismerepo.findById(1);
		model.addAttribute( "organismes" , organismes.get());
		
		return "form";
	}*/

}
