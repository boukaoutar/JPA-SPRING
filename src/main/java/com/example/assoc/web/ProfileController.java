package com.example.assoc.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.dao.TypetelephoneRepository;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;
import com.example.assoc.entities.Structure;
import com.example.assoc.entities.Typeorganisme;
import com.example.assoc.entities.Typetelephone;
import com.example.assoc.entities.Ville;

@Controller
public class ProfileController {


	@Autowired
	private OrganismeRepository organismerepo;
	
	@Autowired
	private ContactRepository contactrepo;
	
	@Autowired
	private TypetelephoneRepository telrepo;
	
	@RequestMapping("/profile.html")
	public String Profil(Model model,HttpSession httpsession)
	{
		Contact c = (Contact) httpsession.getAttribute("contact");
		
		Optional<Organisme> organismes = organismerepo.findById(c.getIdOrganisme().getIdOrganisme());
		model.addAttribute( "organismes" , organismes.get());
		
//		Optional<Contact> cntct = contactrepo.findById(1);
		model.addAttribute( "cntct" , c);
		
		
		List<Typetelephone> telList = telrepo.findAll();
		model.addAttribute( "telList" , telList);
		
		return "profile";
	}
	
	@RequestMapping("/updateCont") 
	  public String updateCont(Model model,String
	 idcont,String nom,String prenom, String cin,String
	  tel,String date,String lieu,String email,String
	 passone, String passtwo,HttpSession httpsession) {
		  //Structure structure;
		  System.out.println("ID Contact  "+idcont);
//		  Contact cn=contactrepo.findById(Integer.parseInt(idcont)).get();
		  Contact cn = (Contact) httpsession.getAttribute("contact");
		  Contact contac = cn;
		  
		  
			  cn.setNom(nom);
			  cn.setPrenom(prenom);
			  cn.setCin(cin);
			  cn.setNumTele(tel);
//			  && isValidFormat("DD/MM/YYYY", date)==true
		     if(date!=null ) { cn.setDateNaiss(date);}
		      
			  cn.setLieuNaiss(lieu);
			  cn.setEmail(email);
			
			  
			  if(passone.equals(passtwo) && passone.length()>8)
			  {
				  System.out.println("NNNNNNNNNNNNNNN"+passtwo);
				  cn.setPassword(passone);
				  contactrepo.save(cn);
				 
			  }
			  
			  else 
			  {
				  if(!contac.getPassword().equals(passone)) {
				  if(passone.length()<8)
				  {
					  model.addAttribute("msg","Le mot de passe contient moins de 8 caractères");
				  }
				  else
				  {
					  model.addAttribute("msg","Les deux mot de passe sont pas identique");
				  }
				  }
				  contactrepo.save(cn);
			  }
		
			  
//			
//			  contactrepo.save(cn);
		 

	  return Profil( model,httpsession); }
	 public static boolean isValidFormat(String format, String value) {
	        Date date = null;
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(format);
	            date = sdf.parse(value);
	            if (!value.equals(sdf.format(date))) {
	                date = null;
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return date != null;
	    }
	
}
