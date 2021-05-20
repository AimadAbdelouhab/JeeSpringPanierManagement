package com.example.demo.web;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AdminRepository;
import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Commercant;
import com.example.demo.entities.Panier;
import com.example.demo.entities.Utilisateur;
import com.example.demo.metier.IAdminMetier;
import com.example.demo.metier.ICommercantMetier;
//
import com.example.demo.metier.IUtilisateurMetier;

@ControllerAdvice
@Controller
public class UtilisateurController {

	@Autowired
	private IUtilisateurMetier um;
	@Autowired
	private UtilisateurRepository ur;
	@Autowired
	private AdminRepository ar;
	@Autowired
	private IAdminMetier am;
	
	@Autowired
	private ICommercantMetier cm;
	
	public static Utilisateur uti;
	public static Commercant cs;
	
	
	

	 @GetMapping("/connexion_utilisateur")
	  public ModelAndView authentificationUtilisateur() {
	  ModelAndView mav=new ModelAndView("index"); 
	  mav.addObject("utilisateur",new Utilisateur ());
	  
	  return mav; }
	  
	  
	  
	  @PostMapping("/connexion_utilisateur") 
	  public String authentificationUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
	  uti=um.authentificationUtilisation(utilisateur.getEmail(),utilisateur.getMdp());
	  //Utilisateur u =ar.
	  if(Objects.nonNull(uti)) {
		  return "redirect:/accueil_utilisateur";
	  
	  }else return "redirect:/inscriptionUtilisateur"; }
	  
	  
	/*  @RequestMapping(value="/inscriptionUtilisateur", method=RequestMethod.POST)
	  public String inscriptionUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		um.inscription(utilisateur.getEmail(), utilisateur.getMdp(), utilisateur.getNom(), utilisateur.getPrenom());
		//ur.save(utilisateur);
		  return "redirect:/connexion_utilisateur";
		  
		  
	  }
	  
	  */
	  
	  @GetMapping("/inscriptionUtilisateur") 
	  public ModelAndView inscriptionUtilisateur() {
	  ModelAndView mav=new ModelAndView("inscription"); 
	  mav.addObject("utilisateur",new Utilisateur ());
	  
	  return mav; }
	  
	  
	  
	  @PostMapping("/inscriptionUtilisateur")
	  public String inscriptionUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		  um.inscription(utilisateur.getEmail(), utilisateur.getMdp(), utilisateur.getNom(), utilisateur.getPrenom());
			 
	 return "redirect:/connexion_utilisateur"; }
	  
	  
	  
	  
	  
	  
	
	@RequestMapping("/accueil_utilisateur")
	public String indexUtilisateur(Model model, String email){
		//Utilisateur utilisateur =am.consulterUtilisateur(email);
		model.addAttribute("utilisateur", uti);
		try{
		Page <Panier> listePanier= um.listePanier(0, 4000);
		model.addAttribute("listePanier", listePanier);
		}catch(Exception e){
			model.addAttribute("exception",e);
			
		}
		return "pageUti";
		
	}
	
	
	
	 @RequestMapping("/consulterPanier/{id_panier}")
		public String consulterPanier(Model model,@PathVariable(value="id_panier") Long id_panier){

			try {
				Panier p = um.consulterUnPanier(id_panier);
				System.out.println(p);
				model.addAttribute("p",p);

			} catch (Exception e) {
				model.addAttribute("excection",e);
			}

			return "voirPanierUti";

		}
	  
	  @RequestMapping("/reserverPanier/{id_panier}")
		public String reserverPanier(Model model,@PathVariable(value="id_panier") Long id_panier){

			try {
				um.ModifierReserverPanier(uti.getEmail(),id_panier, "réservé");
			} catch (Exception e) {
				model.addAttribute("excection",e);
			}

			return "redirect:/accueil_utilisateur";

		}
	 
	  
	  @RequestMapping("/listeReservation")
	  public String listeReservation(Model model) {
		  
		  try{
		  Page <Panier> listePanierReserve= um.listePanierReserve(0, 4000);
			model.addAttribute("listePanierReserve", listePanierReserve);
		  }catch(Exception e){
				model.addAttribute("exception",e);
				
			}
		  
		  return "reserve";
	  }
	  
	  @RequestMapping("/confirmerPanier/{id_panier}")
		public String confirmerPanier(Model model,@PathVariable(value="id_panier") Long id_panier){

			try {
				um.ModifierConfirmerPanier(id_panier, "confirmé");
			} catch (Exception e) {
				model.addAttribute("excection",e);
			}

			return "redirect:/listeReservation";

		}
	  
	  
	  
		  @RequestMapping("/listeCommercant")
		  public String listeCommercant(Model model) {
			  
			  try{
			  Page <Commercant> listeCommercant= um.listeCommercant(0, 4000);
				model.addAttribute("listeCommercant", listeCommercant);
			  }catch(Exception e){
					model.addAttribute("exception",e);
					
				}
			  
			  return "pageUtiCom";
		  }
		  
		  

			 
		  
		  @GetMapping("/connexion_commercant") 
		  public ModelAndView authentificationCommercant() {
		  ModelAndView mav=new ModelAndView("indexCommercant"); 
		  mav.addObject("commercant",new Commercant ());
		  
		  return mav; }
		  
		  
		  
		  @PostMapping("/connexion_commercant")
		  public String authentificationCommercant(@ModelAttribute("commercant") Commercant commercant) {
		  cs=cm.authentificationCommercant(commercant.getEmail(),commercant.getMdp());
		  
		  System.out.println(cs.getEmail());
		  //Utilisateur u =ar.
		  if(Objects.nonNull(cs)) {
			  return "redirect:/accueil_commercant";
		  
		  }else return "redirect:/inscription"; }
		  
		  
		  
		 
		  
		  @GetMapping("/inscriptionCommercant") 
		  public ModelAndView inscriptionCommercant() {
		  ModelAndView mav=new ModelAndView("inscriptionCommercant"); 
		  mav.addObject("commercant",new Commercant ());
		  
		  return mav; }
		  
		  
		  
		  @PostMapping("/inscriptionCommercant")
		  public String inscriptionCommercant(@ModelAttribute("commercant") Commercant commercant) {
			  cm.inscription(commercant.getEmail(), commercant.getMdp(), commercant.getNom(), commercant.getPrenom(), commercant.getLocalisation(), commercant.getCategorie());
				 
		 return "redirect:/connexion_commercant"; }
		  
		  
		  
	
	
	@RequestMapping("/accueil_commercant")
	public String indexCommercant(Model model, String email){
		//Utilisateur utilisateur =am.consulterUtilisateur(email);
		model.addAttribute("commercant", cs);
		try{
		Page <Panier> listePanierCommercant= cm.ListePanierCommercant(cs.getEmail(),0, 4000);
		model.addAttribute("listePanierCommercant", listePanierCommercant);
		}catch(Exception e){
			model.addAttribute("exception",e);
			
		}
		return "pageCommercant";
	}
	
	
	  
	  
	  @GetMapping("/ajouterPanier") 
	  public ModelAndView ajouterPanier() {
	  ModelAndView mav=new ModelAndView("ajoutPanier"); 
	  mav.addObject("panier",new Panier());
	  
	  return mav; }
	  
	  
	  
	  @PostMapping("/ajouterPanier") 
	  public String ajouterPanier(@ModelAttribute("panier") Panier panier) {
		  cm.AjouterUnPanier(panier.getTitre(), panier.getDescription(), panier.getLocalisation(), panier.getCategorie(),cs);
	  //Utilisateur u =ar.
		  return "redirect:/accueil_commercant"; }
	  
	  
	  
	  @GetMapping("/modifierPanier/{id_panier}") 
	  public ModelAndView modifierPanier(@PathVariable(value="id_panier") Long id_panier) {
	  ModelAndView mav=new ModelAndView("modifPanier");
	  Panier panier= um.consulterUnPanier(id_panier);
	  mav.addObject("panier",panier);
	  
	  return mav; }
	  
	  
	  
	  @PostMapping("/modifierPanier/{id_panier}") 
	  public String modifierPanier(@ModelAttribute("panier") Panier panier,@PathVariable(value="id_panier") Long id_panier) {
		  cm.ModifierUnPanier(id_panier, panier.getTitre(), panier.getDescription(), panier.getLocalisation(), panier.getCategorie());
	  //Utilisateur u =ar.
		  return "redirect:/accueil_commercant"; }
	  
	  
	  @RequestMapping("/supprimerPanier/{id_panier}")
			public String supprimerPanier(Model model,@PathVariable(value="id_panier") Long id_panier){

				try {
					cm.SupprimerUnPanier(um.consulterUnPanier(id_panier));
				} catch (Exception e) {
					model.addAttribute("excection",e);
				}

				return "redirect:/accueil_commercant";

			}
	  
	  
	  
	 
			/*
			 * @PostMapping("/") public String
			 * authentification(@ModelAttribute("commercant") Commercant commercant) {
			 * Commercant
			 * com=cm.authentificationCommercant(commercant.getEmail(),commercant.getMdp());
			 * if(Objects.nonNull(com)) { return "redirect:/inscription";
			 * 
			 * }else return "redirect:/"; }
			 * 
			 */
	/*
	 * @GetMapping("/inscription") public String showRegistrationForm(Model model) {
	 * model.addAttribute("user", new Utilisateur());
	 * 
	 * return "signup_form"; }
	 */
}
