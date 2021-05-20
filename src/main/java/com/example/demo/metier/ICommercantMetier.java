package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;

public interface ICommercantMetier {
	
	public Commercant authentificationCommercant(String email,String password);
	
	public Commercant inscription(String email, String password,String nom, String prenom,  String localisation, String categorie);
	
	 public Page<Panier> ListePanierCommercant(String EmailCommercant, int page, int size);
	 
	 public Panier AjouterUnPanier(String titre, String description, String localisation, String categorie, Commercant commercant);
	 
	 public void SupprimerUnPanier(Panier panier);
	 
	 public void ModifierUnPanier(Long id,String titre, String description, String localisation, String categorie);
	
	
}
