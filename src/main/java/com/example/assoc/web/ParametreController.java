package com.example.assoc.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.dao.StructureRepository;
import com.example.assoc.dao.TypeorganismeRepository;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;
import com.example.assoc.entities.Structure;
import com.example.assoc.entities.Typeorganisme;



@Controller

public class ParametreController {

	
	@Autowired
	private ContactRepository contactrepo;
	
	@Autowired
	private StructureRepository structurerepo;
	
	@Autowired
	private OrganismeRepository organismerepo;
	
	@Autowired
	private TypeorganismeRepository typeorganismerepo;
	
	@RequestMapping("/parametre")
	public String Parametre(Model model,String admin)
	{
		List<Contact> contacts = contactrepo.findAll();
		model.addAttribute( "contacts" , contacts);
		
		Optional<Organisme> organismes = organismerepo.findById(2);
		model.addAttribute( "organismes" , organismes.get());
		
		List<Typeorganisme> orgaList = typeorganismerepo.findAll();
		model.addAttribute( "orgaList" , orgaList);
		
		System.out.print("admin value xxxxxx : "+admin);
		if(admin.equals("1")) {
			model.addAttribute( "administrationin" , "tab-pane fade active in");
			model.addAttribute( "associn" , "tab-pane fade ");
			model.addAttribute( "monorganisationin" , "tab-pane fade ");
			
		model.addAttribute( "monorganisation" , "");
		model.addAttribute( "administration" , "active");
		model.addAttribute( "assoc" , "");
		
		}else if (admin.equals("2")) {
			model.addAttribute( "associn" , "tab-pane fade active in");
			model.addAttribute( "administrationin" , "tab-pane fade ");
			model.addAttribute( "monorganisationin" , "tab-pane fade ");
			
		model.addAttribute( "monorganisation" , "");
		model.addAttribute( "administration" , "");
		model.addAttribute( "assoc" ,"active");
		}
		else
		{
			model.addAttribute( "monorganisationin" , "tab-pane fade active in");
			model.addAttribute( "administrationin" , "tab-pane fade ");
			model.addAttribute( "associn" , "tab-pane fade ");
			
			model.addAttribute( "monorganisation" , "active");
			model.addAttribute( "administration" ,"" );
			model.addAttribute( "assoc" , "");
		}
		
		return "parametre";
	}
	
	
	  @RequestMapping("/updateOrga") 
	  public String updateOrga(Model model,String
	  idorga,String firstname2,@RequestParam ("ville") String ville,String
	  adresse,String mailcontact,String telcontact,String fixcontact,String
	  siteweb,@RequestParam ("typeassoc") String typeassoc,String objectif,String
	  date) {
		  Structure structure;
		  System.out.println("ID orga  "+idorga);
		  Organisme organisme=organismerepo.findById(Integer.parseInt(idorga)).get();
		  Typeorganisme typeOrga=typeorganismerepo.findById(Integer.parseInt(typeassoc)).get();
		  
		  organisme.setNom_association(firstname2);
		  organisme.setAdresse(adresse);
		  organisme.setVille(ville);
		  organisme.setTypeorganisme(typeOrga);
		  
		  if(organisme.getStructure()==null)
		  {
		 structure =new Structure();
	     structure.setNom(firstname2);
	     structure.setAdresse(adresse);
	     
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date dateSys = new Date();
         String frmtDate = dateFormat.format(dateSys);
         structure.setDateCreation(frmtDate);
         
	     structure.setEmail(mailcontact);
	     structure.setFix(fixcontact);
	     structure.setTelephone(telcontact);
	     structure.setObjectif(objectif);
	     structure.setSiteWeb(siteweb);
	     structure.setVille(ville);
	     structurerepo.save(structure);
	     organisme.setStructure(structure);
	     organismerepo.save(organisme);
	     
	  } else 
	  {  Structure str=structurerepo.findById(organisme.getStructure().getIdStructure()).get();
	  str.setEmail(mailcontact);
	  str.setFix(fixcontact);
	  str.setTelephone(telcontact);
	  str.setObjectif(objectif);
	  str.setSiteWeb(siteweb);
	  str.setVille(ville);
	  str.setNom(firstname2);
	  str.setAdresse(adresse);
	  organisme.setStructure(str); 
	  organismerepo.save(organisme);
		  
	  }
	  return Parametre( model, "0"); }
	 
	
}
