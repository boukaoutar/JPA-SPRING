package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the structure database table.
 * 
 */
@Entity
@NamedQuery(name="Structure.findAll", query="SELECT s FROM Structure s")
public class Structure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_structure")
	private Integer idStructure;

	private String adresse;

	private String dateCreation;

	private String email;

	private String fix;

	private String nom;

	@Lob
	private String objectif;

	@Lob
	private String siteWeb;

	private String telephone;

	private String ville;

	//bi-directional many-to-one association to Organisme
	@OneToMany(mappedBy="structure")
	private List<Organisme> organismes;

	public Structure() {
	}

	public int getIdStructure() {
		return this.idStructure;
	}

	public void setIdStructure(int idStructure) {
		this.idStructure = idStructure;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFix() {
		return this.fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
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

	public String getSiteWeb() {
		return this.siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Organisme> getOrganismes() {
		return this.organismes;
	}

	public void setOrganismes(List<Organisme> organismes) {
		this.organismes = organismes;
	}

	public Organisme addOrganisme(Organisme organisme) {
		getOrganismes().add(organisme);
		organisme.setStructure(this);

		return organisme;
	}

	public Organisme removeOrganisme(Organisme organisme) {
		getOrganismes().remove(organisme);
		organisme.setStructure(null);

		return organisme;
	}

}