package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typecontact database table.
 * 
 */
@Entity
@NamedQuery(name="Typecontact.findAll", query="SELECT t FROM Typecontact t")
public class Typecontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id_typeCont;

	private String nom;

	@Lob
	private String note;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="typecontact")
	private List<Contact> contacts;

	public Typecontact() {
	}

	public Integer getId_typeCont() {
		return this.id_typeCont;
	}

	public void setId_typeCont(Integer id_typeCont) {
		this.id_typeCont = id_typeCont;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setTypecontact(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setTypecontact(null);

		return contact;
	}

}