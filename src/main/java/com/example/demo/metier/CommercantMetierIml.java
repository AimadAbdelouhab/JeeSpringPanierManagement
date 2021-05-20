package com.example.demo.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CommercantRepository;
import com.example.demo.dao.PanierRepository;
import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;
@Service
@Transactional
public class CommercantMetierIml implements ICommercantMetier{

	@Autowired
	PanierRepository panierRepository;
	@Autowired
	CommercantRepository commercantRepository;
	
	@Override 
	public Commercant inscription(String email, String password,String nom, String prenom,  String localisation, String categorie) { 
		Commercant C=new	Commercant(email, password, nom, prenom, localisation,categorie);
		commercantRepository.save(C);  // TODO Auto-generated method stub
		return C;
	}
	
	
	 @Override 
	 public Page<Panier> ListePanierCommercant(String emailCommercant, int page, int size) {
		 Page<Panier> p=panierRepository.listePanierCommercant(emailCommercant,PageRequest.of(page, size)); 
		 if(p==null) throw new RuntimeException("Ce commercant n'a pas de paniers");
		 return p;	 
	 }
	 
	 @Override 
	 public Panier AjouterUnPanier(String titre, String description, String localisation, String categorie,  Commercant commercant){
	 Panier P=new Panier(titre,description,localisation,categorie,commercant);
	 panierRepository.save(P);
	 return P;
			 }
	 
	 @Override 
	 public void SupprimerUnPanier(Panier panier) {
		 panierRepository.deleteById(panier.getId()); }
	 
	 @Override 
	 public void ModifierUnPanier(Long id,String titre, String description, String localisation, String categorie) { 
		 panierRepository.ModifierPanier(id, titre, description,localisation, categorie); }


	@Override
	public Commercant authentificationCommercant(String email, String password) {
		Commercant c =commercantRepository.authentificationCommercant(email, password);
		return c;
	}

	
}
