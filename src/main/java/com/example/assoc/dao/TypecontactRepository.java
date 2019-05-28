package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assoc.entities.Typecontact;

public interface TypecontactRepository extends JpaRepository<Typecontact, Integer>, TypecontactRepositoryCustom{

}
