package com.example.assoc.metier;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.dao.ProjetRepository;
import com.example.assoc.entities.Projet;


@Service
@Transactional
public class ProjetMetierImp implements ProjetMetier {

	
	@Autowired
	private ProjetRepository projetRepository;
	@Override
	public Projet add(Projet projet) {
		// TODO Auto-generated method stub
		if( projet!=null) 
		{
			Projet prj=projetRepository.save(projet);
			return prj;
		}
		else return null;
		
	}

	@Override
	public Projet edit(Projet projet) {
		// TODO Auto-generated method stub
		
		if( projet!=null) 
		{
			Projet prj=projetRepository.save(projet);
			return prj;
		}
		else return null;
		
	}

	@Override
	public void delete(Projet projet) {
		// TODO Auto-generated method stub
		if( projet!=null) 
		{
			projetRepository.delete(projet);
		}
		
	}

	@Override
	public List<Projet> getAll() {
		// TODO Auto-generated method stub
		try {
			List<Projet> projets = projetRepository.findAll();
			if(!projets.isEmpty())
			   return projets;
			else 
				return Collections.emptyList();
		} catch (Exception e) {
			System.out.println(e.toString());
			 return Collections.emptyList();
		}
	}
	

	@Override
	public Optional<Projet> find(Integer id) {
		// TODO Auto-generated method stub
		return projetRepository.findById(id);

}
	}
