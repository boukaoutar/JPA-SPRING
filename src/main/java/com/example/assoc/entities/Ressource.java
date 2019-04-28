package com.example.assoc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ressource database table.
 * 
 */
@Entity
@NamedQuery(name="Ressource.findAll", query="SELECT r FROM Ressource r")
public class Ressource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ressource")
	private Integer idRessource;

	@Lob
	private String description;

	private double montant;

	//bi-directional many-to-one association to Contribution
	@OneToMany(mappedBy="ressource")
	private List<Contribution> contributions;

	//bi-directional many-to-one association to Action
	@ManyToOne
	@JoinColumn(name="id_action")
	private Action action;

	public Ressource() {
	}

	public Integer getIdRessource() {
		return this.idRessource;
	}

	public void setIdRessource(Integer idRessource) {
		this.idRessource = idRessource;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public List<Contribution> getContributions() {
		return this.contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public Contribution addContribution(Contribution contribution) {
		getContributions().add(contribution);
		contribution.setRessource(this);

		return contribution;
	}

	public Contribution removeContribution(Contribution contribution) {
		getContributions().remove(contribution);
		contribution.setRessource(null);

		return contribution;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}