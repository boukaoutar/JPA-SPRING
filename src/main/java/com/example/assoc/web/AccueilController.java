package com.example.assoc.web;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.assoc.dao.ActionRepository;
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
	
	@Autowired
	private ActionRepository actionrepo;
	
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model model,HttpSession httpsession)
	{
		if(httpsession.getAttribute("contact") == null)
		{
			return "redirect:login";
		}
		Contact c = (Contact) httpsession.getAttribute("contact");
		
		if(c.getTypecontact().getNom().equals("admin")) {
			Optional<Organisme> organismes = organismerepo.findById(c.getIdOrganisme().getIdOrganisme());
			model.addAttribute( "organismes" , organismes.get());
			
//			Optional<Contact> cntct = contactrepo.findById(1);
			model.addAttribute( "cntct" , c);
			
			List<Taches> tch =tacheRepository.findAll();
			model.addAttribute("taches",tch);
			
			Long countadmins = contactrepo.findalladminByorganisme(c.getIdOrganisme().getIdOrganisme(),"admin");
			Long countmembre = contactrepo.findalladminByorganisme(c.getIdOrganisme().getIdOrganisme(),"membre");
			Long countactions = actionrepo.findallactionByorganisme(c.getIdOrganisme().getIdOrganisme());
			
		/*	System.out.print("count all admins : "+countadmins);
			System.out.print("count all membre : "+countmembre);
			System.out.print("count all aactions : "+countactions);*/
			model.addAttribute("countadmins",countadmins);
			model.addAttribute("countevents",countactions);
			model.addAttribute("countmembres",countmembre);
			
			return "index.html";
		}
		else
			return "redirect:communaute";
			
	
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
