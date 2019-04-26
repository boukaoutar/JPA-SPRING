package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assoc.entities.Situation;

public interface SituationRepository extends JpaRepository<Situation, Integer>{

}
