package com.example.assoc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.EntityDAO;
import com.example.assoc.entities.Action;
import com.example.assoc.entities.Adresse;
import com.example.assoc.entities.Categoirecontact;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Fonction;
import com.example.assoc.entities.Historique;
import com.example.assoc.entities.Personne;
import com.example.assoc.entities.Profession;
import com.example.assoc.entities.Telephone;
import com.example.assoc.entities.Typecontact;
import com.example.assoc.metier.PersonneReposetory;

import net.bytebuddy.dynamic.Nexus;

@SpringBootApplication
public class JpaSpringApplication implements CommandLineRunner{
	
    @Autowired
	private ContactRepository contact;
    
	
	public static void main(String[] args) {
		SpringApplication.run(JpaSpringApplication.class, args);
		
		
		//ApplicationContext ctx = SpringApplication.run(JpaSpringApplication.class, args);
	
		//ContactRepository contactrepository = ctx.getBean(ContactRepository.class);
		
		//contactrepository.save(new Contact("rdachid","zadariou","rachidzdaariou@gmail.com","passdword123","JH33d22","25/25/22200","agdadir","25/25/2300",2,"ccdc.jpeg"));
		//contact.save(new Contact());
	
		//List<Personne> personnes = personneDAO.findByCle("%dan%");
		
	}

	@Override
	public void run(String... args) throws Exception {
		//contact.save(new Contact("jb525214","25/25/2200","20/01/2001","hicham@gmail.com","agadir","dandan",1,"cc.jpg","hicham"));
		
		//contact.save(new Contact("rachid","zaariou","rachidzaariou@gmail.com","password123","JH3322","25/25/2200","agadir","25/25/2300",2,"ccc.jpeg"));
		/*contact.save(new Contact("hassan","diiri","rachidzaariou@gmail.com","password123","JH3322","25/25/2200","agadir","25/25/2300",2,"ccc.jpeg"));
		contact.save(new Contact("brahim","safir","rachidzaariou@gmail.com","password123","JH3322","25/25/2200","agadir","25/25/2300",2,"ccc.jpeg"));*/
		
		/*List<Contact> lc = contact.FindByName("rachid");
		if(lc.size()!=0) {
			for(int i=0;i<lc.size();i++ )
				System.out.print(lc.get(i).getNom().toString());
		}*/
		contact.save(new Contact("Driss","Oujdi","rachidzaariou@gmail.com","password123","JH3322","25/25/2200","agadir","25/25/2300",2,"ccc.jpeg"));
		System.out.println("chi 7ajaaaaaaaaa");
//		List<Contact> lc = contact.findAll();
//		
//		if(lc.size()!=0) {
//			for(int i=0;i<lc.size();i++ )
//				System.out.println(lc.get(i).getNom().toString());
//		}
		//contact.FindByName("Oujdi");
		
		//System.out.print
		//contact.save(new Contact("rdachid","zadariou","rachidzdaariou@gmail.com","passdword123","JH33d22","25/25/22200","agdadir","25/25/2300",2,"ccdc.jpeg"));
	
	}

}
