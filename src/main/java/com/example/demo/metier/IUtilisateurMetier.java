package com.example.demo.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;

public interface IUtilisateurMetier {
	
	public Utilisateur authentificationUtilisation(String email, String password);
	
	public Utilisateur inscription(String email, String password, String nom,String prenom);
	
	public Panier consulterUnPanier(Long id_panier);
	
	public Page<Panier> rechercherPanierLocalisation(String localisation,int page,int size);
	
	public Page<Panier> rechercherPanierCategorie(String categorie,int page,int size);
	
	public Page<Panier> listePanier(int page,int size); 

	public Page<Panier> listePanierReserve(int page,int size); 
	
	public Page<Panier> rechercherPanierCommercant(String nom,String prenom,int page,int size);
	
	public Page<Commercant> rechercherCommercantLocalisation(String localisation,int page,int size);
	
	public Page<Commercant> rechercherCommercantCategorie(String categorie,int page,int size);
	
	 public Page<Commercant> listeCommercant(int page,int size);
	 
	 public Commercant consulterUnCommercant(String email_commercant);
	 
	 public void ModifierReserverPanier(String email, Long id, String reservation);
	 
	 public void ModifierConfirmerPanier( Long id, String confirmation);

	
	
	/*
	 * public Utilisateur authentification(String email, String password); public
	 * Utilisateur inscription(String email, String password, String nom,String
	 * prenom,String validation);
	 * 
	 *   
	 * 
	 * 
	 *  
	 */
}
