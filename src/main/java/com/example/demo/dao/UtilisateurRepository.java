package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{
	
	@Query("select u from Utilisateur u where email=:email and mdp=:password")
	  public Utilisateur authentificationUtilisation(@Param("email")String email,  @Param("password")String password);
	
	@Query("select u from Utilisateur u where email=:email")
	  public Utilisateur consulterUtilisation(@Param("email")String email);
	
	@Modifying
	@Query("update Utilisateur u set"
	 		+ " u.validation=:validation"
	 		+ " where u.email=:email") 
	public void gererInscriptionUtilisateur(@Param("email")String email, @Param("validation")String validation);
	
	
	  @Query("select u from Utilisateur u")
	  public Page<Utilisateur>listeUtilisateurs(org.springframework.data.domain.Pageable page);
	  
	  @Query("SELECT COUNT(u) FROM Utilisateur u ")
	    public long nombreDUtilisateurs();
	  
	  @Query("SELECT COUNT(u) FROM Utilisateur u WHERE u.validation='validé'")
	    public long nombreDUtilisateursValide();
	  //@Query("SELECT COUNT(u) FROM User u WHERE u.name=:name")
	    //long aMethodNameOrSomething(@Param("name") String name);
	 
	
}
