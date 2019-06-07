package com.example.assoc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ville")
	private Integer idVille;
	
	
	private String nom;
	
	//bi-directional many-to-one association to Organisme
	@OneToMany(mappedBy="ville")
	private List<Organisme> organismes;
	
	public Ville()
	{
		
	}

	public Integer getIdVille() {
		return this.idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Organisme> getOrganismes() {
		return organismes;
	}

	public void setOrganismes(List<Organisme> organismes) {
		this.organismes = organismes;
	}
	
	public Organisme addOrganisme(Organisme organisme) {
		getOrganismes().add(organisme);
		organisme.setVille(this);

		return organisme;
	}

	public Organisme removeOrganisme(Organisme organisme) {
		getOrganismes().remove(organisme);
		organisme.setTypeorganisme(null);

		return organisme;
	}

	

}
