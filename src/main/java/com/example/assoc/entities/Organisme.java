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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_organisme")
	private Integer idOrganisme;

	@Lob
	private String adresse;
	
	@Column(name="nom_association",length=50,unique=false)
	private String nom_association;

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

	
	public Organisme(String adresse, String nom_association, String ville, Typeorganisme typeorganisme,
			Structure structure, List<Projet> projets) {
		super();
		this.adresse = adresse;
		this.nom_association = nom_association;
		this.ville = ville;
		this.typeorganisme = typeorganisme;
		this.structure = structure;
		this.projets = projets;
	}
	
	public Organisme() {
		super();

	}

	public Integer getIdOrganisme() {
		return idOrganisme;
	}

	public void setIdOrganisme(Integer idOrganisme) {
		this.idOrganisme = idOrganisme;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom_association() {
		return nom_association;
	}

	public void setNom_association(String nom_association) {
		this.nom_association = nom_association;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Typeorganisme getTypeorganisme() {
		return typeorganisme;
	}

	public void setTypeorganisme(Typeorganisme typeorganisme) {
		this.typeorganisme = typeorganisme;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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