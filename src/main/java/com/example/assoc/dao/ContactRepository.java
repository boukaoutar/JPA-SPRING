package com.example.assoc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;
import com.example.assoc.entities.Personne;

public interface ContactRepository  extends JpaRepository<Contact, Integer>{
	

	
	@Query("select c.idOrganisme from Contact c where c.email =:x")
	public List<Organisme> findorganismeByemail(@Param("x")String email);
	
	@Query("select c from Contact c where c.email =:x and c.idOrganisme.nom_association =:y and c.password=:z")
	public Contact Connecting(@Param("x")String email,@Param("y")String organisme,@Param("z")String password);

}
