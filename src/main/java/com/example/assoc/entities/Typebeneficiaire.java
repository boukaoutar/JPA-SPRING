package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typebeneficiaire database table.
 * 
 */
@Entity
@NamedQuery(name="Typebeneficiaire.findAll", query="SELECT t FROM Typebeneficiaire t")
public class Typebeneficiaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_typebenef")
	private Integer idTypebenef;

	@Lob
	private String description;

	private String nom;

	//bi-directional many-to-one association to Cible
	@OneToMany(mappedBy="typebeneficiaire")
	private List<Cible> cibles;

	public Typebeneficiaire() {
	}

	public Integer getIdTypebenef() {
		return this.idTypebenef;
	}

	public void setIdTypebenef(Integer idTypebenef) {
		this.idTypebenef = idTypebenef;
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

	public List<Cible> getCibles() {
		return this.cibles;
	}

	public void setCibles(List<Cible> cibles) {
		this.cibles = cibles;
	}

	public Cible addCible(Cible cible) {
		getCibles().add(cible);
		cible.setTypebeneficiaire(this);

		return cible;
	}

	public Cible removeCible(Cible cible) {
		getCibles().remove(cible);
		cible.setTypebeneficiaire(null);

		return cible;
	}

}