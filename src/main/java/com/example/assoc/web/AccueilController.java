package com.example.assoc.web;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.dao.TacheRepository;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;
import com.example.assoc.entities.Taches;

@Controller

public class AccueilController {
	
	@Autowired
	private TacheRepository tacheRepository ;
	
	@Autowired
	private OrganismeRepository organismerepo;
	
	@Autowired
	private ContactRepository contactrepo;
	
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
	public String index(Model model)
	{
		Optional<Organisme> organismes = organismerepo.findById(1);
		model.addAttribute( "organismes" , organismes.get());
		
		Optional<Contact> cntct = contactrepo.findById(1);
		model.addAttribute( "cntct" , cntct.get());
	
		List<Taches> tch =tacheRepository.findAll();
		model.addAttribute("taches",tch);
		
		return "index";
	}
	
	/*@RequestMapping("/form.html")
	public String form(Model model)
	{
		Optional<Organisme> organismes = organismerepo.findById(1);
		model.addAttribute( "organismes" , organismes.get());
		
		return "form";
	}*/

	
	@RequestMapping(value="/AjouterTache")
	public String formTaches(Model model) {
		model.addAttribute("tache",new Taches());
		return "formTaches";
		
	}
	@RequestMapping(value="/saveTaches")
	public String saveTaches(String tch) {
		tacheRepository.save(new Taches(tch));
	 	return "redirect:/index.html";
	}
	@RequestMapping(value="/supprimer")
	public String supprimer(Integer id) {
		tacheRepository.deleteById(id);
		return "redirect:/index";
	}
	@RequestMapping(value="/edit")
	public String edit (Integer id,Model model) {
		Taches tch=tacheRepository.getOne(id);
		model.addAttribute("tache",tch);
		return "EditTache";
	}
	@RequestMapping(value="/UpdateTaches")
	public String updateTaches(Taches tch) {
		
		tacheRepository.save(tch);
	 	return "redirect:/index";
	}

}
