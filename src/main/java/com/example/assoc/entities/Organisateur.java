package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisateurs database table.
 * 
 */
@Entity
@Table(name="organisateurs")
@NamedQuery(name="Organisateur.findAll", query="SELECT o FROM Organisateur o")
public class Organisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_organisateurs")
	private Integer idOrganisateurs;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-many association to Action
	@ManyToMany(mappedBy="organisateurs")
	private List<Action> actions;

	//bi-directional many-to-one association to Ligneadherent
	@OneToMany(mappedBy="organisateur")
	private List<Ligneadherent> ligneadherents;

	public Organisateur() {
	}

	public Integer getIdOrganisateurs() {
		return this.idOrganisateurs;
	}

	public void setIdOrganisateurs(Integer idOrganisateurs) {
		this.idOrganisateurs = idOrganisateurs;
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

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Ligneadherent> getLigneadherents() {
		return this.ligneadherents;
	}

	public void setLigneadherents(List<Ligneadherent> ligneadherents) {
		this.ligneadherents = ligneadherents;
	}

	public Ligneadherent addLigneadherent(Ligneadherent ligneadherent) {
		getLigneadherents().add(ligneadherent);
		ligneadherent.setOrganisateur(this);

		return ligneadherent;
	}

	public Ligneadherent removeLigneadherent(Ligneadherent ligneadherent) {
		getLigneadherents().remove(ligneadherent);
		ligneadherent.setOrganisateur(null);

		return ligneadherent;
	}

}