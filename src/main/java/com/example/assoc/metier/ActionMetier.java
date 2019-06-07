package com.example.assoc.metier;

import java.util.List;
import java.util.Optional;

import com.example.assoc.entities.Action;


public interface ActionMetier {
	
	
public Action add(Action action);
	
	


	public Action edit(Action action);
	
	
	
	
	
	public void delete(Action action);
	
	
	
	
	public List<Action> getAll();
	
	
	public List<Action> getMyActions(Integer IdContact);
	
	
	
	public Optional<Action> find(Integer id);

}
