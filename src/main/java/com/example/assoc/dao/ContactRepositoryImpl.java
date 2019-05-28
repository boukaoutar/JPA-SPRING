package com.example.assoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import com.example.assoc.entities.Contact;

public class ContactRepositoryImpl implements ContactRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public boolean FindByEmailandID(String email, int id) {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNativeQuery("SELECT em.* FROM assoc.contact as em WHERE em.email = ? and em.id_organisme = ?", Contact.class);
        query.setParameter(1, email);
        
        query.setParameter(2, id);
        
        if(query.getResultList().isEmpty()==true) {
        	//doesn't exist
        	return false;
        }
		return true;
	}

	@Override
	public boolean FindByEmail(String email) {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNativeQuery("SELECT em.* FROM assoc.contact as em WHERE em.email = ?", Contact.class);
        query.setParameter(1, email);
        
        if(query.getResultList().isEmpty()==true) {
        	//doesn't exist
        	return false;
        }
		return true;
	}

}
