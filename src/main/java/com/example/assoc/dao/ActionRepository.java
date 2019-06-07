package com.example.assoc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.assoc.entities.Action;

public interface ActionRepository extends JpaRepository<Action, Integer>{

	@Query("select count(a) from Action a where a.contact.idOrganisme.idOrganisme =:x ")
	public Long findallactionByorganisme(@Param("x")Integer idOrganisme);
	
	@Query("select a from Action a where a.contact.idOrganisme.idOrganisme =:x ")
	public List<Action> findlistactionByorganisme(@Param("x")Integer idOrganisme);
	
}
