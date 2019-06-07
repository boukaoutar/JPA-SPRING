package com.example.assoc.metier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.dao.QuartierRepository;

import com.example.assoc.entities.Quartier;


@Service
@Transactional
public class QuartierMetierImp implements QuartierMetier {

	@Autowired
	private QuartierRepository quartierRepository;
	
	@Override
	public Quartier add(Quartier quartier) {
		// TODO Auto-generated method stub
		if( quartier!=null) 
		{
			Quartier qrt=quartierRepository.save(quartier);
			return qrt;
		}
		else return null;
	}

	@Override
	public Quartier edit(Quartier quartier) {
		// TODO Auto-generated method stub
		if( quartier!=null) 
		{
			Quartier qrt=quartierRepository.save(quartier);
			return qrt;
		}
		else return null;
	}

	@Override
	public void delete(Quartier quartier) {
		// TODO Auto-generated method stub
		if( quartier!=null) 
		{
			quartierRepository.delete(quartier);
		
		}
		
		
	}

	@Override
	public List<Quartier> getAll() {
		// TODO Auto-generated method stub
		try {
			List<Quartier> quartiers = quartierRepository.findAll();
			if(!quartiers.isEmpty())
			   return quartiers;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
	}

	@Override
	public Optional<Quartier> find(Integer id) {
		// TODO Auto-generated method stub
		return quartierRepository.findById(id);
	}

}
