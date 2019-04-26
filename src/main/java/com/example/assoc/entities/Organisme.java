package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisme database table.
 * 
 */
@Entity
@NamedQuery(name="Organisme.findAll", query="SELECT o FROM Organisme o")
public class Organisme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_organisme")
	private Integer idOrganisme;

	@Lob
	private String adresse;

	private String nom;

	private String ville;

	//bi-directional many-to-one association to Typeorganisme
	@ManyToOne
	@JoinColumn(name="id_typeOrga")
	private Typeorganisme typeorganisme;

	//bi-directional many-to-one association to Structure
	@ManyToOne
	@JoinColumn(name="id_structure")
	private Structure structure;

	//bi-directional many-to-one association to Projet
	@OneToMany(mappedBy="organisme")
	private List<Projet> projets;

	public Organisme() {
	}

	public int getIdOrganisme() {
		return this.idOrganisme;
	}

	public void setIdOrganisme(int idOrganisme) {
		this.idOrganisme = idOrganisme;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Typeorganisme getTypeorganisme() {
		return this.typeorganisme;
	}

	public void setTypeorganisme(Typeorganisme typeorganisme) {
		this.typeorganisme = typeorganisme;
	}

	public Structure getStructure() {
		return this.structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Projet addProjet(Projet projet) {
		getProjets().add(projet);
		projet.setOrganisme(this);

		return projet;
	}

	public Projet removeProjet(Projet projet) {
		getProjets().remove(projet);
		projet.setOrganisme(null);

		return projet;
	}

}