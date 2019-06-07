package com.example.assoc.metier;

import java.util.List;
import java.util.Optional;


import com.example.assoc.entities.Quartier;

public interface QuartierMetier {
	
	
public Quartier add(Quartier quartier);
	
	


	public Quartier edit(Quartier quartier);
	
	
	
	
	
	public void delete(Quartier quartier);
	
	
	
	
	public List<Quartier> getAll();
	
	
	
	public Optional<Quartier> find(Integer id);

}
