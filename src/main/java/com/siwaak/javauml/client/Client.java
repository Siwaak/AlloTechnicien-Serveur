package com.siwaak.javauml.client;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.siwaak.javauml.utilisateur.Utilisateur;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	/**
	 * Utilisateur correspondant à ce client.
	 * Un client correspond à un utilisateur et vice versa
	 */
	@OneToOne
	private Utilisateur utilisateur;
	
	
	public Client() {
		super();
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

	
}
