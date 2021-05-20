package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin extends Profil{

	public Admin() {
			}

	public Admin(String email, String mdp, String nom, String prenom) {
		super(email, mdp, nom, prenom);
	}
	
	

}
