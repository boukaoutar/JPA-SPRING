package com.example.assoc.metier;

import java.util.List;
import java.util.Optional;


import com.example.assoc.entities.Projet;

public interface ProjetMetier {
	
public Projet add(Projet projet);
	
	


	public Projet edit(Projet projet);
	
	
	
	
	
	public void delete(Projet projet);
	
	
	
	
	public List<Projet> getAll();
	
	
	
	public Optional<Projet> find(Integer id);

}
