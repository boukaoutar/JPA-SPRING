package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assoc.entities.Taches;

public interface TacheRepository extends JpaRepository<Taches,Integer> {

}