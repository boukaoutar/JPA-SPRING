package com.example.assoc.metier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.assoc.entities.Personne;

public interface PersonneReposetory extends JpaRepository<Personne, Integer>{
	@Query("select p from Personne p where p.nom like :x")
	public List<Personne> findByCle(@Param("x")String mc);

}
