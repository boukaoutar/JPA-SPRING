package com.example.assoc.metier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.assoc.dao.TypeactionRepository;
import com.example.assoc.entities.Action;
import com.example.assoc.entities.Typeaction;


@Service
@Transactional
public class TypeActionMetierImp implements TypeActionMetier {
	
	@Autowired
	private TypeactionRepository typeactionRepo;

	@Override
	public Typeaction add(Typeaction taction) {
		if( taction!=null) 
		{
			Typeaction act=typeactionRepo.save(taction);
			return act;
		}
		else return null;
	}

	@Override
	public Typeaction edit(Typeaction taction) {
		if( taction!=null) 
		{
			Typeaction act=typeactionRepo.save(taction);
			return act;
		}
		else return null;
	}

	@Override
	public void delete(Typeaction taction) {
		if( taction!=null) 
		{
			typeactionRepo.delete(taction);
		}
	}

	@Override
	public List<Typeaction> getAll() {
		try {
			List<Typeaction> types = typeactionRepo.findAll();
			if(!types.isEmpty())
			   return types;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
	}

	@Override
	public Optional<Typeaction> find(Integer id) {
		return typeactionRepo.findById(id);
	}

}
