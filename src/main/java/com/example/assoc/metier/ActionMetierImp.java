package com.example.assoc.metier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.dao.ActionRepository;
import com.example.assoc.entities.Action;


@Service
@Transactional
public class ActionMetierImp implements ActionMetier{
	@Autowired
	private ActionRepository actionRepo;
	
	/*@PersistenceContext
    EntityManager entityManager;*/
	@Override
	public Action add(Action action) {
		
		if( action!=null) 
		{
			Action act=actionRepo.save(action);
			return act;
		}
		else return null;
	}

	@Override
	public Action edit(Action action) {
		if( action!=null) 
		{
			Action act=actionRepo.save(action);
			return act;
		}
		else return null;
	}

	@Override
	public void delete(Action action) {
		if( action!=null) 
		{
			actionRepo.delete(action);
		}
		
	}

	@Override
	public List<Action> getAll() {
		try {
			List<Action> actions = actionRepo.findAll();
			if(!actions.isEmpty())
			   return actions;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
		
	}

	@Override
	public Optional<Action> find(Integer id) {
		return actionRepo.findById(id);
	}

	@Override
	public List<Action> getMyActions(Integer IdContact) {
		try {
	        /*uery query = entityManager.createNativeQuery("select a from action a where a.id_contact like :id " +
	                "WHERE em.firstname LIKE ?", Action.class);
	        query.setParameter(1, firstName + "%")Q;*/

			List<Action> actions = actionRepo.findAll();
			if(!actions.isEmpty())
			   return actions;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
	}

}
