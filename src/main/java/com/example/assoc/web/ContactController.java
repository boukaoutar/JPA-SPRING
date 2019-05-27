package com.example.assoc.web;



import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;

@Controller
public class ContactController {
	
	@Autowired
	ContactRepository contactrepository;
	
	@RequestMapping(value = {"/login"},method = {RequestMethod.POST, RequestMethod.GET})
	public String login (Model model)
	{
		model.addAttribute("contact",new Contact());
			return "login";
	}
	
	@RequestMapping(value = {"/typelogin"},method = {RequestMethod.POST, RequestMethod.GET})
	public String typelogin (@Valid Contact contact,BindingResult bindingresult,Model model,HttpSession httpsession)
	{

			if(contact.getEmail() == null) return "redirect:login";
			List<Organisme> ls = contactrepository.findorganismeByemail(contact.getEmail());

		
			if(bindingresult.hasErrors())
			{
				System.out.println("Error xxxxxxx : "+contact.getEmail());
				return "login";
			}
			
			if(ls.size()>0)
			{
				List<String> listorganisme = new ArrayList<String>();
				
				for(int i=0;i<ls.size();i++)
				{
					listorganisme.add(ls.get(i).getNom_association());
					System.out.println("organisme : "+ls.get(i).getNom_association());
				}
			
				model.addAttribute("listorganisme",listorganisme);
				httpsession.setAttribute("email",contact.getEmail());
				
				return "typelogin";
			}
			
			if(ls.size()<=0)
			{
				model.addAttribute("errorvalidation","ce compte n'existe pas !!");
				return "login";
			}
			
			return "redirect:index";
		
		
	}
	
	@RequestMapping(value = {"/passwordlogin"},method = {RequestMethod.POST, RequestMethod.GET})
	public String passwordlogin (@RequestParam(required=false,name="organisme") String organisme,HttpSession httpsession,Model model)
	{
		model.addAttribute("contact",new Contact());
		String email = (String) httpsession.getAttribute("email");
		httpsession.setAttribute("organisme", organisme);
		System.out.println("email session : "+email+"  organisme session : "+organisme);
		
		if(email == null || organisme == null)
		{
			return "redirect:login";
		}
			return "passwordlogin";
	}
	
	@RequestMapping(value = {"/connect"},method = {RequestMethod.POST, RequestMethod.GET})
	public String connect(HttpSession httpsession,@Valid Contact contact,BindingResult bindingresult,Model model)
	{


			String email = (String) httpsession.getAttribute("email");
			String organisme = (String) httpsession.getAttribute("organisme");
			
			Contact c = contactrepository.Connecting(email, organisme, contact.getPassword());
			if(email == null || organisme == null)
			{
				return "redirect:login";
			}

			
			if(bindingresult.hasErrors())
			{	
				System.out.println("Erroor xxxxxxxxxxxxxxx ");
				return "passwordlogin";
			}
			
			if(c == null) {
				model.addAttribute("errorvalidation","password incorrect !!");
				return "passwordlogin";
			}
			
			System.out.println("contact cin : "+c.getCin()+"  contact name : "+c.getNom()+" Type contact : "+c.getTypecontact().getNom());
			httpsession.setAttribute("contact", c);
			//httpsession.invalidate();

			return "redirect:index";
		
		
	}
	
	
	@RequestMapping(value = {"/index"},method = {RequestMethod.POST, RequestMethod.GET})
	public String index(HttpSession httpsession)
	{
		if(httpsession.getAttribute("contact") == null)
		{
			return "redirect:login";
		}
		return "index";
		
	}
	
	@RequestMapping("/form.html")
	public String form()
	{
		return "form";
	}
	
	@RequestMapping("/signup.html")
	public String signup()
	{
		return "signup";
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
