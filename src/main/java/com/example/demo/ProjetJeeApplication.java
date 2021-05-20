package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;

import com.example.demo.dao.AdminRepository;
import com.example.demo.dao.CommercantRepository;
import com.example.demo.dao.PanierRepository;
import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;
import com.example.demo.metier.IAdminMetier;
import com.example.demo.metier.ICommercantMetier;
import com.example.demo.metier.IUtilisateurMetier;


@SpringBootApplication
@ComponentScan({"com.example.demo"})
public class ProjetJeeApplication implements CommandLineRunner{
	@Autowired
	private CommercantRepository cr;
	@Autowired
	private UtilisateurRepository ur;
	@Autowired
	private PanierRepository pr;
	@Autowired
	private AdminRepository ar;
	@Autowired
	private IUtilisateurMetier um;
	@Autowired
	private ICommercantMetier cm;
	@Autowired
	private IAdminMetier am;

	public static void main(String[] args) {
		
		SpringApplication.run(ProjetJeeApplication.class, args);
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("__________________________________________________");		
		System.out.println("Teste creation: \n");
		Commercant c1 =cr.save(new Commercant("email3","mdp","nom","prenom","localisation","categorie"));
		Commercant ct =cr.save(new Commercant("email12","mdp","nom","prenom","localisation","categorie"));
		Utilisateur u1 =ur.save(new Utilisateur("email4","mdp1","nom1","prenom1"));
		Commercant c2 =cr.save(new Commercant("email2","mdp2","nom2","prenom2","localisation2","categorie2"));
		
		Admin a =  ar.save(new Admin ( "emailAdmin", "mdp", "nomé", "prenom"));
		//System.out.println(c1+"\n"+c2+"\n"+p);
			
		Panier p = pr.save(new Panier("titre", " description", "localisation", "categorie",c1)); 
		Panier p2 = pr.save(new Panier("panier 2 ", " description2", "localisation2", "categorie2",c1));
		Panier p3 = pr.save(new Panier("titre", " description", "localisation", "categorie",c1)); 
		Panier p24 = pr.save(new Panier("panier 2 ", " description2", "localisation2", "categorie2",c1));
		Panier p4 = pr.save(new Panier("titre", " description", "localisation", "categorie",c1)); 
		Panier p25 = pr.save(new Panier("panier 2 ", " description2", "localisation2", "categorie2",c1));
		
		Panier p0 = pr.save(new Panier("titre", " description", "localisation", "categorie",c1)); 
		Panier p257 = pr.save(new Panier("panier 2 ", " description2", "localisation2", "categorie2",c1));
		Panier p47 = pr.save(new Panier("titre", " description", "localisation", "categorie",c1)); 
		Panier p27 = pr.save(new Panier("panier 2 ", " description2", "localisation2", "categorie2",c1));
		
		System.out.println("__________________________________________________");
		System.out.println("Teste utilisateur \n");
		
		um.inscription("email4","mdp1","nom1","prenom1");
		
		Panier pc=um.consulterUnPanier((long) 1);
		System.out.println("panier titre"+pc.getTitre());
		Page pl = um.rechercherPanierLocalisation("localisation", 0, 20);
		System.out.println("panier localisation : "+pl.getContent());
		
		Page pcat = um.rechercherPanierCategorie("categorie2", 0, 20);
		System.out.println("paniercatégorie : "+pcat.getContent());
		
		Page plp = um.listePanier( 0, 20);
		System.out.println("panier Liste : "+plp.getContent());
		
		Page prpc = um.rechercherPanierCommercant( "nom","prenom",0, 20);
		System.out.println("paniers commercant: "+prpc.getContent());
		
		Page prcl = um.rechercherCommercantLocalisation( "localisation",0, 20);
		System.out.println("commercant localisation: "+prcl.getContent());
		
		Page prcc = um.rechercherCommercantCategorie( "categorie",0, 20);
		System.out.println("commercant categorie: "+prcc.getContent());
		
		Page plc = um.listeCommercant( 0, 20);
		System.out.println("commercant categorie: "+plc.getContent());
		
		Commercant com=um.consulterUnCommercant("email3");
		System.out.println("commercant : "+com.getNom());
		
		um.ModifierReserverPanier(u1.getEmail(),p2.getId(),"reservé");
		um.ModifierConfirmerPanier(p2.getId(),"confirmé");
		
		System.out.println("nombre de paniers réservé: "+am.nombreDePaniersReserves());
		
		System.out.println("nombre de paniers confirmées: "+am.nombreDePaniersConfirmes());
		
		System.out.println("__________________________________________________");
		System.out.println("Teste commercant \n ");
		
		Page plpc = cm.ListePanierCommercant("email3", 0, 20);
		System.out.println("commercant liste panier: "+plpc.getContent());
		
		Panier pajo = cm.AjouterUnPanier("mon panier", "desco", "akbou", "smidh", c1);
		System.out.println("le panier acjouté: "+pajo);
		
		cm.SupprimerUnPanier((Panier)plpc.getContent().get(0));
		
		cm.ModifierUnPanier(pajo.getId(), "apanyi", "lknl","memme", "le");
		
		System.out.println("__________________________________________________");
		System.out.println("Teste admin \n ");
		
		am.gererInscriptionUtilisateur(u1.getEmail(),"validé");
		System.out.println("l utilisateur est :"+u1.getValidation());
		
		am.gererInscriptionCommercant(c1.getEmail(),"validé");
		System.out.println("le commercant  est"+c1.getValidation());
		
		Page plua = am.listeUtilisateurs( 0, 20);
		System.out.println("Utilisateurs liste  "+plua.getContent());
		
		Page plca = am.listeCommercants( 0, 20);
		
		System.out.println("Commercant liste  "+plca.getContent());
		
		System.out.println("nombre d utilisateurs iscrits: "+am.nombreDUtilisateurs());
		
		System.out.println("nombre d utilisatgeurs validés: "+am.nombreDUtilisateursValide());
		
		System.out.println("nombre de commercants iscrits: "+am.nombreDeCommercants());
		
		System.out.println("nombre de commercants validés: "+am.nombreDeCommercantsValide());
		
		System.out.println("nombre de paniers : "+am.nombreDePaniers());
		
		System.out.println("nombre de paniers réservés: "+am.nombreDePaniersReserves());
		
		System.out.println("nombre de paniers confirmés: "+am.nombreDePaniersConfirmes());
		
	
		
			
		
	}

}
