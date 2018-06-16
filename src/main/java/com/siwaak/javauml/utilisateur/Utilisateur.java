package com.siwaak.javauml.utilisateur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;


@Entity
@Table(
uniqueConstraints=
    @UniqueConstraint(columnNames={"email"})
)
public class Utilisateur {

	/**
	 * Clé primaire de la classe, sa valeure est incrémentée automatiquement
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * Identifiant de l'utilisateur pour l'authentification
	 */
	@Email
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String tel;
	
	
	public Utilisateur() {
		super();
	}	

	public Utilisateur(String email, String password, String nom, String prenom, String tel) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String login) {
		this.email = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
