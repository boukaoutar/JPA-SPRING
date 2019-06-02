package com.example.assoc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.assoc.entities.Action;
import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;

public interface ContactRepository  extends JpaRepository<Contact, Integer>{
	
	//@Query("select * from contact  where nom = 'n'")
	//public List<Contact> FindByName(@Param("n")String nom);
	
	@Query("select c.idOrganisme from Contact c where c.email =:x")
	public List<Organisme> findorganismeByemail(@Param("x")String email);
	
	@Query("select c from Contact c where c.email =:x and c.idOrganisme.nom_association =:y and c.password=:z")
	public Contact Connecting(@Param("x")String email,@Param("y")String organisme,@Param("z")String password);
	
	@Query("select c from Contact c where c.idOrganisme.idOrganisme =:x")
	public Page<Contact> findContactsByorganisme(@Param("x")Integer idorganisme, Pageable pageable);
	
	@Query("select a from Action a where a.contact.idOrganisme.idOrganisme =:x")
	public List<Action> findActionsByorganisme(@Param("x")Integer idorganisme);
	
}
