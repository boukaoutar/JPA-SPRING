package com.example.assoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.assoc.entities.Typecontact;
import com.example.assoc.entities.Typeorganisme;

public class TypecontactRepositoryImpl implements TypecontactRepositoryCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Typecontact getIdByNom(String nom) {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNativeQuery("SELECT em.* FROM assoc.typecontact as em WHERE em.nom = ? ", Typecontact.class);
        
        query.setParameter(1, nom);
        
        Typecontact tc  = (Typecontact) query.getResultList().get(0);
        
		return tc;
	}

}
