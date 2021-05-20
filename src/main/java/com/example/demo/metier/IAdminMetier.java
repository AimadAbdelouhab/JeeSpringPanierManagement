package com.example.demo.metier;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;

public interface IAdminMetier {

	public Utilisateur consulterUtilisateur(String email_utilisateur);
	public void gererInscriptionUtilisateur(String email_utilisateur, String validation);
	public void gererInscriptionCommercant(String email_commercant, String validation);
	public Page<Utilisateur>  listeUtilisateurs(int page, int size);
	public Page<Commercant>  listeCommercants(int page, int size);
	public long nombreDUtilisateurs();
	public long nombreDUtilisateursValide();
	public long nombreDeCommercants();
	public long nombreDeCommercantsValide();
	public long nombreDePaniers();
	public long nombreDePaniersReserves();
	public long nombreDePaniersConfirmes();
	
}
