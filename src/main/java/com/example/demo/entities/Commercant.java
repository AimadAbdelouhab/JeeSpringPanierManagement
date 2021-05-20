package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Commercant")
public class Commercant extends Profil{
	private String localisation;
	private String categorie;
	@OneToMany(mappedBy="commercant",fetch=FetchType.LAZY )
	private Collection<Panier> paniers;
	private String validation;
	
	
	public Commercant() {
		
	}
	
			
	public Commercant(String email, String mdp, String nom, String prenom, String localisation, String categorie) {
		super(email, mdp, nom, prenom);
		this.localisation=localisation;
		this.categorie=categorie;
		this.validation="non validé";
	}


	
	public String getValidation() {
		return validation;
	}


	public void setValidation(String validation) {
		this.validation = validation;
	}


	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Collection<Panier> getPaniers() {
		return paniers;
	}
	public void setPaniers(Collection<Panier> paniers) {
		this.paniers = paniers;
	}
	

}
