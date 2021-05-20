package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	@Query("select p from Panier p where p.id=:x") 
	public Panier LePanier(@Param("x")Long idPanier);

	 @Query("select p from Panier p where p.localisation=:x")
	 public Page<Panier> rechercherPanierLocalisation(@Param("x")String localisation,org.springframework.data.domain.Pageable page);
	 
	 @Query("select p from Panier p where p.categorie=:x") 
	 public Page<Panier> rechercherPanierCategorie(@Param("x")String categorie,org.springframework.data.domain.Pageable page);
	 
	 @Query("select p from Panier p where p.reserve='reservé'") 
	 public Page<Panier> listePanierReserve(org.springframework.data.domain.Pageable page);
	
	 @Query("select p from Panier p") 
	 public Page<Panier> listePanier(org.springframework.data.domain.Pageable page);
	 
	 @Query("select p from Panier p join p.commercant c where c.nom=:x and c.prenom=:y") 
	 public Page<Panier> rechercherPanierCommercant(@Param("x")String nom,@Param("y")String prenom,org.springframework.data.domain.Pageable page);
	 
	 @Query("select p from Panier p join p.commercant c where c.email=:x") 
	 public Page<Panier> listePanierCommercant(@Param("x")String emailCommercant,org.springframework.data.domain.Pageable page);
	 
	 @Modifying
	 @Query("update Panier p set"
	 		+ " p.titre=:titre , p.description=:description , p.localisation=:localisation ,"
	 		+ " p.categorie=:categorie "
	 		+ " where p.id=:id ") 
	 public void ModifierPanier(
			 @Param(value ="id") Long id, 
			 @Param(value = "titre") String titre,
			 @Param(value = "description") String description,
			 @Param(value ="localisation") String localisation,
			 @Param(value = "categorie") String categorie);	


	@Query("SELECT COUNT(p) FROM Panier p ")
	public long nombreDePaniers();
	
	@Query("SELECT COUNT(p) FROM Panier p where p.reserve='reservé'")
	public long nombreDePaniersReserves();
	
	@Query("SELECT COUNT(p) FROM Panier p where p.confirme='confirmé'")
	public long nombreDePaniersConfirmes();
	
	
	@Modifying
    @Query("update Panier p set p.reserve=:reservation, p.utilisateur.id=:email where p.id=:id")
    void ModifierReserverPanier(@Param(value ="email") String email,@Param(value ="id") Long id, @Param(value ="reservation") String reservation);

	
    @Modifying
    @Query("update Panier p set p.confirme=:confirmation where p.id=:id")
    void ModifierConfirmerPanier(@Param(value ="id") Long id, @Param(value ="confirmation") String confirmation);

	
	
}

