package com.example.assoc.metier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.dao.OrganismeRepository;
import com.example.assoc.entities.Organisme;



@Service
@Transactional
public class OrganismeMetierImp implements OrganismeMetier {

	
	@Autowired
	private OrganismeRepository organismeRepository;
	@Override
	public Organisme add(Organisme organisme) {
		// TODO Auto-generated method stub
		if( organisme!=null) 
		{
			Organisme org=organismeRepository.save(organisme);
			return org;
		}
		else return null;
		
	}

	@Override
	public Organisme edit(Organisme organisme) {
		// TODO Auto-generated method stub
		if( organisme!=null) 
		{
			Organisme org=organismeRepository.save(organisme);
			return org;
		}
		else return null;
	}

	@Override
	public void delete(Organisme organisme) {
		// TODO Auto-generated method stub
		if( organisme!=null) 
		{
			organismeRepository.delete(organisme);
		}
		
	}

	@Override
	public List<Organisme> getAll() {
		// TODO Auto-generated method stub
		try {
			List<Organisme> organismes = organismeRepository.findAll();
			if(!organismes.isEmpty())
			   return organismes;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
	}

	@Override
	public Optional<Organisme> find(Integer id) {
		// TODO Auto-generated method stub
		return organismeRepository.findById(id);
	}

}
