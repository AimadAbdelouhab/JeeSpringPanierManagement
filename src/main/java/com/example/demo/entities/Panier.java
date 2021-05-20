package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Panier implements Serializable {
	
	@Id@GeneratedValue
	private Long id;
	private String titre;
	private String description;
	private String localisation;
	private String categorie;
	private String reserve;
	private String confirme;
	@ManyToOne//(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ID_COM")
	private Commercant commercant;
	@ManyToOne//(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ID_UTI")
	private Utilisateur utilisateur;
	
	
	
	
	public Panier() {
		
	}


	public Panier( String titre, String description, String localisation, String categorie,
			Commercant commercant) {
		super();
		this.titre = titre;
		this.description = description;
		this.localisation = localisation;
		this.categorie = categorie;
		this.reserve = "non reservé";
		this.commercant = commercant;
		this.confirme="non confirmé";
	}
	
	public Panier(String titre, String description, String localisation, String categorie, Utilisateur utilisateur,
			Commercant commercant) {
		super();
		//this.id = id;
		this.titre = titre;
		this.description = description;
		this.localisation = localisation;
		this.categorie = categorie;
		this.commercant = commercant;
		this.utilisateur=utilisateur;
		this.reserve = "non reservé";
		this.confirme="non confirmé";
	}
	
	
	
	
	public String getConfirme() {
		return confirme;
	}


	public void setConfirme(String confirme) {
		this.confirme = confirme;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public Commercant getCommercant() {
		return commercant;
	}
	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}
	
	
	
}
