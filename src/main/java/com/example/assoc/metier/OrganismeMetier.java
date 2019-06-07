package com.example.assoc.metier;

import java.util.List;
import java.util.Optional;

import com.example.assoc.entities.Organisme;


public interface OrganismeMetier {
	
public Organisme add(Organisme organisme);
	
	


	public Organisme edit(Organisme organisme);
	
	
	
	
	
	public void delete(Organisme organisme);
	
	
	
	
	public List<Organisme> getAll();
	
	
	
	public Optional<Organisme> find(Integer id);

}
