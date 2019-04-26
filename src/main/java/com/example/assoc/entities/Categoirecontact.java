package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoirecontact database table.
 * 
 */
@Entity
@NamedQuery(name="Categoirecontact.findAll", query="SELECT c FROM Categoirecontact c")
public class Categoirecontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id_catCon;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="categoirecontact")
	private List<Contact> contacts;

	public Categoirecontact() {
	}

	public int getId_catCon() {
		return this.id_catCon;
	}

	public void setId_catCon(int id_catCon) {
		this.id_catCon = id_catCon;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setCategoirecontact(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setCategoirecontact(null);

		return contact;
	}

}