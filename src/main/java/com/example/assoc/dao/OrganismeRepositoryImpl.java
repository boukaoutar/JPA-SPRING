package com.example.assoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Organisme;

public class OrganismeRepositoryImpl implements OrganismeRepositoryCustom{
	
	@PersistenceContext
    EntityManager entityManager;


	@Override
	public boolean isNomExist(String nom_association) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("SELECT em.* FROM assoc.organisme as em WHERE em.nom_association = ? ", Organisme.class);
        query.setParameter(1, nom_association);
        
        if(query.getResultList().isEmpty()==true) {
        	//doesn't exist
        	return false;
        }
        else {
        	return true;
        }
	}

}
