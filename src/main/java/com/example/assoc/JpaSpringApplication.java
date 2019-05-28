package com.example.assoc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.assoc.dao.ContactRepository;

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
		// TODO Auto-generated method stub
		
	}






}
