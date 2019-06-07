package com.example.assoc.metier;

import java.util.List;
import java.util.Optional;

import com.example.assoc.entities.Ressource;

public interface RessourceMetier {

	
	
public Ressource add(Ressource ressource);
	
	


	public Ressource edit(Ressource ressource);
	
	
	
	
	
	public void delete(Ressource ressource);
	
	
	
	
	public List<Ressource> getAll();
	
	
	
	
	
	
	public Optional<Ressource> find(Integer id);
}
