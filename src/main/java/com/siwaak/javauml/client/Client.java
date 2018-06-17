package com.siwaak.javauml.client;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.siwaak.javauml.utilisateur.Utilisateur;

@Entity
@Table(
uniqueConstraints=
    @UniqueConstraint(columnNames={"utilisateur_id"})
)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	/**
	 * Adresse du client. Elle sera utilisée si une adresse n'est pas fournie pour une demande
	 */
	private String adresse;
	
	/**
	 * Utilisateur correspondant à ce client.
	 * Un client correspond à un utilisateur et vice versa
	 */
	@OneToOne
	private Utilisateur utilisateur;
	
	
	public Client() {
		super();
	}
	

	public Client(String adresse) {
		super();
		this.adresse = adresse;
	}


	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
