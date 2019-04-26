package com.example.assoc.metier;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.dao.EntityDAO;
import com.example.assoc.entities.Personne;

@Repository
@Transactional
public class PersonneImplDAO implements EntityDAO<Personne>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne save(Personne p) {
		em.persist(p);
		return p;
	}

	@Override
	public List<Personne> findAll() {
		Query reQuery = em.createQuery("select p from Personne p");
		return reQuery.getResultList();
	}

	@Override
	public Personne findOne(Integer id) {
		Personne personne = em.find(Personne.class, id);
		return personne;
	}

	@Override
	public Personne update(Personne p) {
		em.merge(p);
		return p;
	}

	@Override
	public void delete(Integer id) {
		Personne personne = em.find(Personne.class, id);
		em.remove(personne);
	}

}
