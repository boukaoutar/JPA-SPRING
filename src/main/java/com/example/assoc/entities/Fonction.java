package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fonction database table.
 * 
 */
@Entity
@NamedQuery(name="Fonction.findAll", query="SELECT f FROM Fonction f")
public class Fonction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fonction")
	private Integer idFonction;

	private String nom;

	@Lob
	private String note;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="fonction")
	private List<Contact> contacts;

	public Fonction() {
	}

	public Integer getIdFonction() {
		return this.idFonction;
	}

	public void setIdFonction(Integer idFonction) {
		this.idFonction = idFonction;
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
		contact.setFonction(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setFonction(null);

		return contact;
	}

}