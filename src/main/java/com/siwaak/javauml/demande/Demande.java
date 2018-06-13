package com.siwaak.javauml.demande;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.siwaak.javauml.client.Client;
import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.techniciendemande.TechnicienDemande;


@Entity
public class Demande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "domaine_id")
	private Domaine domaine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	
    @OneToMany(mappedBy="demande", fetch = FetchType.EAGER)
	private Set<TechnicienDemande> technicienDemandes = new HashSet<>();
    
		
	
	public Demande() {
		super();
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
	
	public Set<TechnicienDemande> getTechnicienDemandes() {
		return technicienDemandes;
	}

	public void setTechnicienDemandes(Set<TechnicienDemande> technicienDemandes) {
		this.technicienDemandes = technicienDemandes;
	}
	
	public void ajouterTechnicienDemande(TechnicienDemande technicienDemande) {
		this.technicienDemandes.add(technicienDemande);
	}
	
}
