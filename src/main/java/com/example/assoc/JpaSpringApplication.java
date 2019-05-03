package com.example.assoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.assoc.dao.ContactRepository;
import com.example.assoc.dao.EntityDAO;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Personne;
import com.example.assoc.metier.PersonneReposetory;

import net.bytebuddy.dynamic.Nexus;

@SpringBootApplication
public class JpaSpringApplication implements CommandLineRunner{
	
	@Autowired
	private ContactRepository contact;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaSpringApplication.class, args);
		//contact.save(new Contact());
		
		//List<Personne> personnes = personneDAO.findByCle("%dan%");
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		contact.save(new Contact("jb525214","25/25/2200","20/01/2001","hicham@gmail.com","agadir","dandan",1,"cc.jpg","hicham"));		
	}

}
