package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class Utilisateur extends Profil{
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY )
	private Collection<Panier> paniers;
	private String validation;

	public Utilisateur() {
		
	}

	public Utilisateur(String email, String mdp, String nom, String prenom) {
		super(email, mdp, nom, prenom);
		this.validation="non validé";
		// TODO Auto-generated constructor stub
	}

	
	
	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public Collection<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(Collection<Panier> paniers) {
		this.paniers = paniers;
	}
	
	

}
