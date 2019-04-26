package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assoc.entities.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {

}
