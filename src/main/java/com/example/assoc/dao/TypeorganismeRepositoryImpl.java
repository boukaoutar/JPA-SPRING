package com.example.assoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.assoc.entities.Contact;
import com.example.assoc.entities.Typeorganisme;

public class TypeorganismeRepositoryImpl implements TypeorganismeRepositoryCustom {
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Typeorganisme FindByid(Integer id) {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNativeQuery("SELECT em.* FROM assoc.typeorganisme as em WHERE em.	id_type_orga = ? ", Typeorganisme.class);
        
        query.setParameter(1, id);
        
        /*if(query.getResultList().isEmpty()==true) {
        	//doesn't exist
        	return false;
        }*/
        
        Typeorganisme to  = (Typeorganisme) query.getResultList().get(0);
        
       
		return to;
		
	}

}
