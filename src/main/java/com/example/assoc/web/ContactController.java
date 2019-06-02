package com.example.assoc.web;



import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
			System.out.println("List Size xxxxxxx : "+ls.size()+" email : "+contact.getEmail());
		
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
			if(c.getTypecontact().getNom().equals("admin"))
				return "redirect:index";
			else
				return "redirect:communaute";
				
				
		
		
	}
	
	@RequestMapping(value = {"/logout"},method = {RequestMethod.POST, RequestMethod.GET})
	public String logout(HttpSession httpsession)
	{
		httpsession.invalidate();
		return "redirect:login";
		
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
	
	@RequestMapping(value = {"/communaute"},method = {RequestMethod.POST, RequestMethod.GET})
	public String communaute(HttpSession httpsession,Model model
			,@RequestParam(name="page",defaultValue="0") int p,@RequestParam(name="size",defaultValue="9") int s)
	{
		if(httpsession.getAttribute("contact") == null)
		{
			return "redirect:login";
		}
		Contact c = (Contact) httpsession.getAttribute("contact");
	
		
		Page<Contact> contactsCommunaute = contactrepository.findContactsByorganisme(c.getIdOrganisme().getIdOrganisme(),new PageRequest(p,s));
		model.addAttribute("contactsCommunaute",contactsCommunaute.getContent());
		int[] pages = new int[contactsCommunaute.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size",pages.length-1);
		model.addAttribute("pageCourant",p);
		/////////////////////////////////////////////
		model.addAttribute("active1","nav-item  active");
		model.addAttribute("active2","nav-item  ");
		model.addAttribute("active3","nav-item  ");
		/////////////////////////////////////////////
		model.addAttribute("colorcommunaute","nav-link bg-success");
		model.addAttribute("colorprofile","nav-link");
		model.addAttribute("coloraction","nav-link"); 
		
		
		model.addAttribute("dashboard","communaute");
		model.addAttribute("nomcontact",c.getPrenom()+" "+c.getNom());
		
		return "dashboard";
		
	}
	
	@RequestMapping(value = {"/userprofile"},method = {RequestMethod.POST, RequestMethod.GET})
	public String userprofile(HttpSession httpsession,Model model)
	{
		if(httpsession.getAttribute("contact") == null)
		{
			return "redirect:login";
		}

		model.addAttribute("active1","nav-item  ");
		model.addAttribute("active2","nav-item  active");
		model.addAttribute("active3","nav-item  ");
		//////////////////////
		model.addAttribute("colorcommunaute","nav-link");
		model.addAttribute("colorprofile","nav-link ");
		model.addAttribute("coloraction","nav-link"); 
		
		Contact c = (Contact) httpsession.getAttribute("contact");
		model.addAttribute("contact",c);
		
		model.addAttribute("dashboard","userprofile");
		model.addAttribute("nomcontact",c.getPrenom()+" "+c.getNom());
		return "dashboard";
		
	}
	
	@RequestMapping(value = {"/action"},method = {RequestMethod.POST, RequestMethod.GET})
	public String action(HttpSession httpsession,Model model)
	{
		if(httpsession.getAttribute("contact") == null)
		{
			return "redirect:login";
		}
		model.addAttribute("active1","nav-item  ");
		model.addAttribute("active2","nav-item  ");
		model.addAttribute("active3","nav-item  active");
		////////////////////////////////////////////
		model.addAttribute("colorcommunaute","nav-link");
		model.addAttribute("colorprofile","nav-link");
		model.addAttribute("coloraction","nav-link bg-info"); 
		
		Contact c = (Contact) httpsession.getAttribute("contact");
		model.addAttribute("dashboard","action");
		model.addAttribute("nomcontact",c.getPrenom()+" "+c.getNom());
		return "dashboard";
		
	}
	
	@RequestMapping(value = {"/updateprofile"},method = {RequestMethod.POST, RequestMethod.GET})
	public String updateprofile(@Valid Contact contact,HttpSession httpsession,Model model)
	{
		if(httpsession.getAttribute("contact") == null)
		{
			return "redirect:login";
		}
		Contact c = (Contact) httpsession.getAttribute("contact");
	
		
		contact.setIdContact(c.getIdContact());
		contact.setIdOrganisme(c.getIdOrganisme());
		contact.setTypecontact(c.getTypecontact());
		
		contactrepository.save(contact);
		httpsession.setAttribute("contact",contact);
		return "redirect:userprofile";
		
	}
	

}
