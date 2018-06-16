package com.siwaak.javauml.demande;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.siwaak.javauml.client.Client;
import com.siwaak.javauml.domaine.Domaine;


@Entity
public class Demande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String description;
	
	private String adresse;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "domaine_id")
	private Domaine domaine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;

		
	
	public Demande() {
		super();
	}

	public Demande(String description, String adresse) {
		super();
		this.description = description;
		this.adresse = adresse;
	}
	
	public Demande(String description, String adresse, Domaine domaine, Client client) {
		super();
		this.description = description;
		this.adresse = adresse;
		this.domaine = domaine;
		this.client = client;
	}


	public Demande(String domaine) {
		super();
		
		this.domaine = new Domaine();
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Domaine getDomaine() {
		return domaine;
	}


	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	/*public Set<TechnicienDemande> getTechnicienDemandes() {
		return technicienDemandes;
	}

	public void setTechnicienDemandes(Set<TechnicienDemande> technicienDemandes) {
		this.technicienDemandes = technicienDemandes;
	}
	
	public void ajouterTechnicienDemande(TechnicienDemande technicienDemande) {
		this.technicienDemandes.add(technicienDemande);
	}*/
	
}
