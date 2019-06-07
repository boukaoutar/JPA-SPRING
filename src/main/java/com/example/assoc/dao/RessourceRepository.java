package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.assoc.entities.Ressource;

public interface RessourceRepository extends JpaRepository<Ressource, Integer>{
	@Transactional
	 @Modifying
	@Query("delete from Ressource where action.idAction=:id")
	public void deleteRessourceByActId(@Param("id")Integer idAction);

}
