package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_action")
	private Integer idAction;

	private double budget;

	private String dateCreation;

	private String dateRealisation;

	private int impact;

	private String nom;

	@Lob
	private String objectif;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="id_contact")
	private Contact contact;

	//bi-directional many-to-one association to Situation
	@ManyToOne
	@JoinColumn(name="id_situation")
	private Situation situation;

	//bi-directional many-to-one association to Quartier
	@ManyToOne
	@JoinColumn(name="id_quartier")
	private Quartier quartier;

	//bi-directional many-to-one association to Typeaction
	@ManyToOne
	@JoinColumn(name="id_typeAction")
	private Typeaction typeaction;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="id_projet")
	private Projet projet;

	//bi-directional many-to-many association to Organisateur
	@ManyToMany
	@JoinTable(
		name="actionorganisateur"
		, joinColumns={
			@JoinColumn(name="id_action")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_organisateurs")
			}
		)
	private List<Organisateur> organisateurs;

	//bi-directional many-to-one association to Cible
	@OneToMany(mappedBy="action")
	private List<Cible> cibles;

	//bi-directional many-to-one association to Media
	@OneToMany(mappedBy="action")
	private List<Media> medias;

	//bi-directional many-to-many association to Partenaire
	@ManyToMany(mappedBy="actions")
	private List<Partenaire> partenaires;

	//bi-directional many-to-one association to Ressource
	@OneToMany(mappedBy="action")
	private List<Ressource> ressources;

	public Action() {
	}

	public int getIdAction() {
		return this.idAction;
	}

	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}

	public double getBudget() {
		return this.budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateRealisation() {
		return this.dateRealisation;
	}

	public void setDateRealisation(String dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public int getImpact() {
		return this.impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getObjectif() {
		return this.objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Situation getSituation() {
		return this.situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Quartier getQuartier() {
		return this.quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public Typeaction getTypeaction() {
		return this.typeaction;
	}

	public void setTypeaction(Typeaction typeaction) {
		this.typeaction = typeaction;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Organisateur> getOrganisateurs() {
		return this.organisateurs;
	}

	public void setOrganisateurs(List<Organisateur> organisateurs) {
		this.organisateurs = organisateurs;
	}

	public List<Cible> getCibles() {
		return this.cibles;
	}

	public void setCibles(List<Cible> cibles) {
		this.cibles = cibles;
	}

	public Cible addCible(Cible cible) {
		getCibles().add(cible);
		cible.setAction(this);

		return cible;
	}

	public Cible removeCible(Cible cible) {
		getCibles().remove(cible);
		cible.setAction(null);

		return cible;
	}

	public List<Media> getMedias() {
		return this.medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Media addMedia(Media media) {
		getMedias().add(media);
		media.setAction(this);

		return media;
	}

	public Media removeMedia(Media media) {
		getMedias().remove(media);
		media.setAction(null);

		return media;
	}

	public List<Partenaire> getPartenaires() {
		return this.partenaires;
	}

	public void setPartenaires(List<Partenaire> partenaires) {
		this.partenaires = partenaires;
	}

	public List<Ressource> getRessources() {
		return this.ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	public Ressource addRessource(Ressource ressource) {
		getRessources().add(ressource);
		ressource.setAction(this);

		return ressource;
	}

	public Ressource removeRessource(Ressource ressource) {
		getRessources().remove(ressource);
		ressource.setAction(null);

		return ressource;
	}

}