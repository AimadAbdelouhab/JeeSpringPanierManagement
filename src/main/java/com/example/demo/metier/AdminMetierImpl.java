package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CommercantRepository;
import com.example.demo.dao.PanierRepository;
import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;

@Service
@Transactional
public class AdminMetierImpl implements IAdminMetier{
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	CommercantRepository commercantRepository;
	@Autowired
	PanierRepository panierRepository;
	
	@Override
	public void gererInscriptionUtilisateur(String email_utilisateur, String validation) {
		utilisateurRepository.gererInscriptionUtilisateur(email_utilisateur, validation);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gererInscriptionCommercant(String email_commercant, String validation) {
		commercantRepository.gererInscriptionCommercant(email_commercant, validation);
		
	}

	@Override
	public Page<Utilisateur> listeUtilisateurs(int page, int size) {
		Page<Utilisateur> u=utilisateurRepository.listeUtilisateurs(PageRequest.of(page, size)); 
		 if(u==null) throw new RuntimeException("Aucun utilisateur");
		 return u;	 
	}

	@Override
	public Page<Commercant> listeCommercants(int page, int size) {
		Page<Commercant> c=commercantRepository.listeCommercant(PageRequest.of(page, size)); 
		 if(c==null) throw new RuntimeException("Aucun commercant");
		 return c;
	}

	@Override
	public long nombreDUtilisateurs() {
		long r= utilisateurRepository.nombreDUtilisateurs();
		return r;
	}

	@Override
	public long nombreDUtilisateursValide() {
		long r= utilisateurRepository.nombreDUtilisateursValide();
		return r;
	}

	@Override
	public long nombreDeCommercants() {
		long r= commercantRepository.nombreDeCommercants();
		return r;
	}

	@Override
	public long nombreDeCommercantsValide() {
		long r= commercantRepository.nombreDeCommercantsValide();
		return r;
	}

	@Override
	public long nombreDePaniers() {
		long r= panierRepository.nombreDePaniers();
		return r;
	}

	@Override
	public long nombreDePaniersReserves() {
		long r= panierRepository.nombreDePaniersReserves();
		return r;
	}

	@Override
	public long nombreDePaniersConfirmes() {
		long r= panierRepository.nombreDePaniersConfirmes();
		return r;
	}

	@Override
	public Utilisateur consulterUtilisateur(String email_utilisateur) {
		Utilisateur u = utilisateurRepository.consulterUtilisation(email_utilisateur);
		return u;
	}

	
}
