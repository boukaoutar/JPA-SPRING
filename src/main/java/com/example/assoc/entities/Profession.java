package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profession database table.
 * 
 */
@Entity
@NamedQuery(name="Profession.findAll", query="SELECT p FROM Profession p")
public class Profession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_profession")
	private Integer idProfession;

	private String nom;

	@Lob
	private String note;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="profession")
	private List<Contact> contacts;

	public Profession() {
	}

	public int getIdProfession() {
		return this.idProfession;
	}

	public void setIdProfession(int idProfession) {
		this.idProfession = idProfession;
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
		contact.setProfession(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setProfession(null);

		return contact;
	}

}