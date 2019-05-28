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


		//contact.save(new Contact());
		System.out.println("chi haja");
		//List<Personne> personnes = personneDAO.findByCle("%dan%");

		
		//ApplicationContext ctx = SpringApplication.run(JpaSpringApplication.class, args);
	
		//ContactRepository contactrepository = ctx.getBean(ContactRepository.class);
		
		//contactrepository.save(new Contact("rdachid","zadariou","rachidzdaariou@gmail.com","passdword123","JH33d22","25/25/22200","agdadir","25/25/2300",2,"ccdc.jpeg"));
		//contact.save(new Contact());
	
		//List<Personne> personnes = personneDAO.findByCle("%dan%");
		
		
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
