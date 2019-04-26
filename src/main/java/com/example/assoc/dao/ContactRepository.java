package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assoc.entities.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Integer>{

}
