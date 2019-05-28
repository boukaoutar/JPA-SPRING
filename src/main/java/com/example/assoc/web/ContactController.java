package com.example.assoc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.dao.TypecontactRepository;
import com.example.assoc.dao.TypeorganismeRepository;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;
import com.example.assoc.entities.Typecontact;
import com.example.assoc.entities.Typeorganisme;

@Controller

public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	OrganismeRepository organismeRepository;
	@Autowired
	TypeorganismeRepository typeorganismeRepository;
	@Autowired
	TypecontactRepository typecontactRepository;

	@RequestMapping("/index.html")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/form.html")
	public String form()
	{
		return "form";
	}
	
	
	@RequestMapping(value="/signupp",method=RequestMethod.GET)
	public String signup(Model model)
	{
		model.addAttribute("contact", new Contact());
		model.addAttribute("organisme", new Organisme());
		
		List<Typeorganisme> types = typeorganismeRepository.findAll();
		model.addAttribute("typeorganisme", types);
		
		return "signupp";
	}
	//@RequestMapping(value="/SaveNewUser",method=RequestMethod.POST)
	@RequestMapping("/SaveNewUser")
	public String NewUser(Contact c , Organisme o,@RequestParam("id_type_organism") String id,Model model, BindingResult result)
	{
		Typecontact tc = typecontactRepository.getIdByNom("admin");
		
		List<Typeorganisme> types = typeorganismeRepository.findAll();
		model.addAttribute("typeorganisme", types);
		
		if(c.getNom().matches("[a-zA-Z]+")==true) {
			
			if(c.getPrenom().matches("[a-zA-Z]+")==true) {
				if(contactRepository.FindByEmail(c.getEmail())==false) {
					Typeorganisme to = typeorganismeRepository.FindByid(Integer.parseInt(id));
					o.setTypeorganisme(to);
					c.setIdOrganisme(o);
					c.setTypecontact(tc);
					organismeRepository.save(o);
					contactRepository.save(c);
					//return logiiiiin
				}
				else {
					model.addAttribute("alreadyRegisteredMessage","Email existe dèja !");
					//email and organisme exist deja existe deja
					System.out.println("email and organisme existe deja erreeeeer !!!");
					return "signupp";
				}
			}
			else {
				//ereur prenom
				model.addAttribute("prenomInvalidMessage","Prenom invalid !");
				return "signupp";
			}
			
		}
		else {
			//erreur nom
			model.addAttribute("nomInvalidMessage","Nom invalid !");
			return "signupp";
		}
		
		return "signupp";
	}
	
	

	@RequestMapping("/form_advanced.html")
	public String formAD()
	{
		return "form_advanced";
	}
	
	@RequestMapping("/form_validation.html")
	public String formVLD()
	{
		return "form_validation";
	}
	
	@RequestMapping("/form_wizards.html")
	public String formWIZARDS()
	{
		return "form_wizards";
	}
	
	@RequestMapping("/form_upload.html")
	public String formUPLOAD()
	{
		return "form_upload";
	}
	
	@RequestMapping("/form_buttons.html")
	public String formBUTTONS()
	{
		return "form_buttons";
	}
	
	@RequestMapping("/tables.html")
	public String tables()
	{
		return "tables";
	}
	
	@RequestMapping("/tables_dynamic.html")
	public String tablesD()
	{
		return "tables_dynamic";
	}

	@RequestMapping("/fixed_sidebar.html")
	public String fixedS()
	{
		return "fixed_sidebar";
	}
	
	@RequestMapping("/fixed_footer.html")
	public String fixedF()
	{
		return "fixed_footer";
	}
}
