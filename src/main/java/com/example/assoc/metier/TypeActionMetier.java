package com.example.assoc.metier;

import java.util.List;
import java.util.Optional;


import com.example.assoc.entities.Typeaction;

public interface TypeActionMetier {
	
public Typeaction add(Typeaction taction);
	
	


	public Typeaction edit(Typeaction taction);
	
	
	
	
	
	public void delete(Typeaction taction);
	
	
	
	
	public List<Typeaction> getAll();
	
	
	
	public Optional<Typeaction> find(Integer id);

}
