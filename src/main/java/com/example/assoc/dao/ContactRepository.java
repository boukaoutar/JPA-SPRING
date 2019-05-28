package com.example.assoc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.entities.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Integer>, ContactRepositoryCustom{
	
	//@Query("select p from contact p where p.nom = 'n'")
	//public List<Contact> FindByEmailandID(@Param("n")String  email);
}

