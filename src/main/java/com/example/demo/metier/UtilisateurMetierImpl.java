package com.example.demo.metier;

import java.util.List;

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
public class UtilisateurMetierImpl implements IUtilisateurMetier{
	@Autowired 
	private UtilisateurRepository utilisateurRepository;
	@Autowired 
	private PanierRepository panierRepository;
	@Autowired 
	private CommercantRepository commercantRepository;


	

	@Override
	public Utilisateur authentificationUtilisation(String email, String password) {
		Utilisateur u =utilisateurRepository.authentificationUtilisation(email, password);
		return u;
	}
	

	
	@Override 
	public Utilisateur inscription(String email, String password,String nom, String prenom) { 
		Utilisateur U=new	Utilisateur(email, password, nom, prenom);
		utilisateurRepository.save(U);  // TODO Auto-generated method stub
		return U;
	}
	
	
	@Override 
	public Panier consulterUnPanier(Long id_panier) {
		Panier p=panierRepository.LePanier(id_panier);
	if(p==null) throw new RuntimeException("Panier introuvble"); return p; }
	
	
	@Override 
	public Page<Panier> rechercherPanierLocalisation(String
	localisation, int page, int size) { 
		Page<Panier> p=panierRepository.rechercherPanierLocalisation(localisation,PageRequest.of(
	page, size)); 
	if(p==null) throw new
	RuntimeException("On trouve aucun panier appartenant à cette localisation");
	return p; }
	
	@Override 
	public Page<Panier> rechercherPanierCategorie(String categorie, int page, int size) { 
	Page<Panier> p=panierRepository.rechercherPanierCategorie(categorie,PageRequest.of(page,size)); 
	if(p==null) throw new RuntimeException("On trouve aucun panier appartenant à cette catégorie");
	return p; }
	
	
	@Override 
	public Page<Panier> listePanier(int page, int size) {
	return panierRepository.listePanier(PageRequest.of(page, size)); }
	
	
	@Override public Page<Panier> rechercherPanierCommercant(String nom, String
	prenom, int page, int size) { Page<Panier> p=panierRepository.rechercherPanierCommercant(nom,prenom,PageRequest.of(page, size));
	if(p==null) throw new RuntimeException("On trouve aucun panier appartenant à ce commercant");
    return p; }
	
	
	@Override 
	public Page<Commercant> rechercherCommercantLocalisation(String localisation, int page, int size) { 
		Page<Commercant> c=commercantRepository.rechercherCommercantLocalisation(localisation, PageRequest.of(page, size)); 
		if(c==null) throw new  RuntimeException("On trouve aucun commercant lié à cette localisation");
	    return c; }
	
	@Override 
	public Page<Commercant> rechercherCommercantCategorie(String categorie, int page, int size) {
		Page<Commercant> c=commercantRepository.rechercherCommercantCategorie(categorie,PageRequest.of(page, size));
		if(c==null) throw new RuntimeException("On trouve aucun commercant lié à cette catégorie"); 
		return c; }
	
	@Override 
	public Page<Commercant> listeCommercant(int page, int size) {
		return commercantRepository.listeCommercant(PageRequest.of(page, size)); }
	
	
	 @Override
	 public Commercant consulterUnCommercant(String email_commercant) {
     Commercant c=commercantRepository.LeCommercant(email_commercant); 
     if(c==null) throw new RuntimeException("Commercant introuvble"); 
     return c; }


	@Override
	public void ModifierReserverPanier(String email, Long id_panier, String reservation) {
		panierRepository.ModifierReserverPanier(email,id_panier, reservation);
		
	}


	@Override
	public void ModifierConfirmerPanier(Long id, String confirmation) {
		panierRepository.ModifierConfirmerPanier(id, confirmation);
			}



	@Override
	public Page<Panier> listePanierReserve(int page, int size) {
		return panierRepository.listePanierReserve(PageRequest.of(page, size));
	}


	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 *	 */
	
	/*
	 * @Override public Utilisateur authentification(String email, String password)
	 * { //Utilisateur u=utilisateurRepository.findOne(password); return null; }
	 * 
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 * 
	 */

}
