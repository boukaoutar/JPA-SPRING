package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assoc.entities.Contribution;

public interface ContributionRepository extends JpaRepository<Contribution, Integer>{

}
