package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contact")
	private Integer idContact;

	private String cin;

	private String dateAdhesion;

	private String dateNaiss;

	private String email;

	private String lieuNaiss;

	private String nom;

	private int numeroVote;

	@Lob
	private String photo;

	private String prenom;

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
	
	public Contact(String cin, String dateAdhesion, String dateNaiss, String email, String lieuNaiss, String nom,
			int numeroVote, String photo, String prenom) {
		super();
		this.cin = cin;
		this.dateAdhesion = dateAdhesion;
		this.dateNaiss = dateNaiss;
		this.email = email;
		this.lieuNaiss = lieuNaiss;
		this.nom = nom;
		this.numeroVote = numeroVote;
		this.photo = photo;
		this.prenom = prenom;
	}

	public Contact(String cin, String dateAdhesion, String dateNaiss, String email, String lieuNaiss, String nom,
			int numeroVote, String photo, String prenom, List<Action> actions, Typecontact typecontact,
			Fonction fonction, Categoirecontact categoirecontact, Profession profession, List<Adresse> adresses,
			List<Historique> historiques, List<Telephone> telephones) {
		super();
		this.cin = cin;
		this.dateAdhesion = dateAdhesion;
		this.dateNaiss = dateNaiss;
		this.email = email;
		this.lieuNaiss = lieuNaiss;
		this.nom = nom;
		this.numeroVote = numeroVote;
		this.photo = photo;
		this.prenom = prenom;
		this.actions = actions;
		this.typecontact = typecontact;
		this.fonction = fonction;
		this.categoirecontact = categoirecontact;
		this.profession = profession;
		this.adresses = adresses;
		this.historiques = historiques;
		this.telephones = telephones;
	}

	public Integer getIdContact() {
		return this.idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getDateAdhesion() {
		return this.dateAdhesion;
	}

	public void setDateAdhesion(String dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public String getDateNaiss() {
		return this.dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLieuNaiss() {
		return this.lieuNaiss;
	}

	public void setLieuNaiss(String lieuNaiss) {
		this.lieuNaiss = lieuNaiss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumeroVote() {
		return this.numeroVote;
	}

	public void setNumeroVote(int numeroVote) {
		this.numeroVote = numeroVote;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Action addAction(Action action) {
		getActions().add(action);
		action.setContact(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setContact(null);

		return action;
	}

	public Typecontact getTypecontact() {
		return this.typecontact;
	}

	public void setTypecontact(Typecontact typecontact) {
		this.typecontact = typecontact;
	}

	public Fonction getFonction() {
		return this.fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Categoirecontact getCategoirecontact() {
		return this.categoirecontact;
	}

	public void setCategoirecontact(Categoirecontact categoirecontact) {
		this.categoirecontact = categoirecontact;
	}

	public Profession getProfession() {
		return this.profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public List<Historique> getHistoriques() {
		return this.historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Historique addHistorique(Historique historique) {
		getHistoriques().add(historique);
		historique.setContact(this);

		return historique;
	}

	public Historique removeHistorique(Historique historique) {
		getHistoriques().remove(historique);
		historique.setContact(null);

		return historique;
	}

	public List<Telephone> getTelephones() {
		return this.telephones;
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