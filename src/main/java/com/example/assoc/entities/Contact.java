package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import javax.validation.constraints.Size;

import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */

//@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
@Entity
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"email", "id_organisme"})
	})
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contact")
	private Integer idContact;

	
	@ManyToOne
	@JoinColumn(name="id_organisme")
	private Organisme idOrganisme;
	
	private String nom;
	
	private String prenom;
	
	@Column(name="email",length=50)
	private String email;
	
	
	private String password;
	
	private String cin;
	
	private String dateNaiss;

	private String lieuNaiss;

	private String dateAdhesion;

	private int numeroVote;

	@Lob
	private String photo;

	

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="contact")
	private List<Action> actions;

	//bi-directional many-to-one association to Typecontact
	@ManyToOne
	@JoinColumn(name="id_typeCont")
	private Typecontact typecontact;

	//bi-directional many-to-one association to Fonction
	@ManyToOne
	@JoinColumn(name="id_fonction")
	private Fonction fonction;

	//bi-directional many-to-one association to Categoirecontact
	@ManyToOne
	@JoinColumn(name="id_catCon")
	private Categoirecontact categoirecontact;

	//bi-directional many-to-one association to Profession
	@ManyToOne
	@JoinColumn(name="id_profession")
	private Profession profession;

	//bi-directional many-to-many association to Adresse
	@ManyToMany(mappedBy="contacts")
	private List<Adresse> adresses;

	//bi-directional many-to-one association to Historique
	@OneToMany(mappedBy="contact")
	private List<Historique> historiques;

	//bi-directional many-to-one association to Telephone
	@OneToMany(mappedBy="contact")
	private List<Telephone> telephones;

	public Contact() {
	}
	
	public Contact(String nom, String prenom, String email, String password, String cin, String dateNaiss,
			String lieuNaiss, String dateAdhesion, int numeroVote, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.cin = cin;
		this.dateNaiss = dateNaiss;
		this.lieuNaiss = lieuNaiss;
		this.dateAdhesion = dateAdhesion;
		this.numeroVote = numeroVote;
		this.photo = photo;
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getLieuNaiss() {
		return lieuNaiss;
	}

	public void setLieuNaiss(String lieuNaiss) {
		this.lieuNaiss = lieuNaiss;
	}

	public String getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(String dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public int getNumeroVote() {
		return numeroVote;
	}

	public void setNumeroVote(int numeroVote) {
		this.numeroVote = numeroVote;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Typecontact getTypecontact() {
		return typecontact;
	}

	public void setTypecontact(Typecontact typecontact) {
		this.typecontact = typecontact;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Categoirecontact getCategoirecontact() {
		return categoirecontact;
	}

	public void setCategoirecontact(Categoirecontact categoirecontact) {
		this.categoirecontact = categoirecontact;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<Historique> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public Telephone addTelephone(Telephone telephone) {
		getTelephones().add(telephone);
		telephone.setContact(this);

		return telephone;
	}

	public Telephone removeTelephone(Telephone telephone) {
		getTelephones().remove(telephone);
		telephone.setContact(null);

		return telephone;
	}

}