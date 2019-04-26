package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zone database table.
 * 
 */
@Entity
@NamedQuery(name="Zone.findAll", query="SELECT z FROM Zone z")
public class Zone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_zone")
	private Integer idZone;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Quartier
	@OneToMany(mappedBy="zone")
	private List<Quartier> quartiers;

	public Zone() {
	}

	public int getIdZone() {
		return this.idZone;
	}

	public void setIdZone(int idZone) {
		this.idZone = idZone;
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

	public List<Quartier> getQuartiers() {
		return this.quartiers;
	}

	public void setQuartiers(List<Quartier> quartiers) {
		this.quartiers = quartiers;
	}

	public Quartier addQuartier(Quartier quartier) {
		getQuartiers().add(quartier);
		quartier.setZone(this);

		return quartier;
	}

	public Quartier removeQuartier(Quartier quartier) {
		getQuartiers().remove(quartier);
		quartier.setZone(null);

		return quartier;
	}

}