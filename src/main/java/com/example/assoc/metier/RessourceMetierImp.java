package com.example.assoc.metier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.dao.RessourceRepository;
import com.example.assoc.entities.Ressource;
@Service
@Transactional
public class RessourceMetierImp implements RessourceMetier {
  
	@Autowired
	RessourceRepository ressourceRepo;
	@Override
	public Ressource add(Ressource ressource) {
		if( ressource!=null) 
		{
			Ressource ress=ressourceRepo.save(ressource);
			return ress;
		}
		else return null;
	}

	@Override
	public Ressource edit(Ressource ressource) {
		if( ressource!=null) 
		{
			Ressource ress=ressourceRepo.save(ressource);
			return ress;
		}
		else return null;
	}

	@Override
	public void delete(Ressource ressource) {
		if( ressource!=null) 
		{
			ressourceRepo.delete(ressource);
		}
		
	}

	@Override
	public List<Ressource> getAll() {
		try {
			List<Ressource> ressources = ressourceRepo.findAll();
			if(!ressources.isEmpty())
			   return ressources;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
	}

	@Override
	public Optional<Ressource> find(Integer id) {
		return ressourceRepo.findById(id);
	}

}
