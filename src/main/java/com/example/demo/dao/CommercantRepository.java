package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;

public interface CommercantRepository extends JpaRepository<Commercant, String>{
	
	@Query("select u from Commercant u where email=:email and mdp=:password")
	  public Commercant authentificationCommercant(@Param("email")String email,  @Param("password")String password);
	
	@Query("select c from Commercant c where c.localisation=:x") 
	public Page<Commercant> rechercherCommercantLocalisation(@Param("x")String  localisation,org.springframework.data.domain.Pageable page);
	
	@Query("select c from Commercant c where c.categorie=:x") 
	public Page<Commercant> rechercherCommercantCategorie(@Param("x")String categorie,org.springframework.data.domain.Pageable page);
	
	@Query("select c from Commercant c") 
	public Page<Commercant> listeCommercant(org.springframework.data.domain.Pageable page);
	
	@Query("select c from Commercant c where c.id=:x") 
	public Commercant LeCommercant(@Param("x")String emailCommercant);
	
	@Modifying
	@Query("update Commercant c set"
	 		+ " c.validation=:validation"
	 		+ " where c.email=:email") 
	public void gererInscriptionCommercant(@Param("email")String email, @Param("validation")String validation);
	
	@Query("SELECT COUNT(c) FROM Commercant c ")
    public long nombreDeCommercants();
  
  @Query("SELECT COUNT(c) FROM Commercant c WHERE c.validation='validé'")
    public long nombreDeCommercantsValide();
	
	
}
