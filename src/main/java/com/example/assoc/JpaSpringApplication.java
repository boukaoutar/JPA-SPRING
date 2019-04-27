package com.example.assoc;

import java.util.List;

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
public class JpaSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JpaSpringApplication.class, args);
		ContactRepository contact = ctx.getBean(ContactRepository.class);
		contact.save(new Contact("jb525214","25/25/2200","20/01/2001","hicham@gmail.com","jadida","oujdi",1,"cc.jpg","driss"));
		//contact.save(new Contact());
		
		//List<Personne> personnes = personneDAO.findByCle("%dan%");
		
		
	}

}
