package com.example.assoc.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;

@Controller
public class ContactController {
	
	@Autowired
	ContactRepository contactrepository;
	
	@RequestMapping(value = {"/login"},method = {RequestMethod.POST, RequestMethod.GET})
	public String login ()
	{
	
			return "login";
	}
	
	@RequestMapping(value = {"/typelogin"},method = {RequestMethod.POST, RequestMethod.GET})
	public String typelogin (@RequestParam(required=false,name="email") String email,Model model,HttpSession httpsession)
	{
			
			List<Organisme> ls = contactrepository.findorganismeByemail(email);
			
			if(ls.size()>0)
			{
				List<String> listorganisme = new ArrayList<String>();
				
				for(int i=0;i<ls.size();i++)
				{
					listorganisme.add(ls.get(i).getNom_association());
					System.out.println("organisme : "+ls.get(i).getNom_association());
				}
			
				model.addAttribute("listorganisme",listorganisme);
				httpsession.setAttribute("email", email);
				
				return "typelogin";
			}
			return "redirect:login";
		
	}
	
	@RequestMapping(value = {"/passwordlogin"},method = {RequestMethod.POST, RequestMethod.GET})
	public String passwordlogin (@RequestParam(required=false,name="organisme") String organisme,HttpSession httpsession)
	{
		System.out.println("radio clicked : "+organisme);
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
	public String connect(@RequestParam(required=false,name="password") String password,HttpSession httpsession)
	{
		String email = (String) httpsession.getAttribute("email");
		String organisme = (String) httpsession.getAttribute("organisme");
		
		Contact c = contactrepository.Connecting(email, organisme, password);
		if(email == null || organisme == null)
		{
			return "redirect:login";
		}else
		if(c == null) {
			return "passwordlogin";
		}
		System.out.println("contact cin : "+c.getCin()+"  contact name : "+c.getNom()+" Type contact : "+c.getTypecontact().getNom());
		/*if(bindingresult.hasErrors())
		{
			return "login";
		}*/
		return "index";
	}
	
	
	@RequestMapping(value = {"/index"},method = {RequestMethod.POST, RequestMethod.GET})
	public String index()
	{
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
