package com.siwaak.javauml.technicien;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.siwaak.javauml.utilisateur.Utilisateur;

@Entity
public class Technicien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private float note;	
	
	@OneToOne
	private Utilisateur utilisateur;  
	
   // @OneToMany(mappedBy="technicien", fetch = FetchType.EAGER)
	//private Set<TechnicienDemande> technicienDemandes = new HashSet<>();

	
	public Technicien() {
		super();
	}
	
	public Technicien(float note, Utilisateur utilisateur) {
		super();
		this.note = note;
		this.utilisateur  = utilisateur;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	/*public void ajouterTechnicienDemande(TechnicienDemande technicienDemande) {
		this.technicienDemandes.add(technicienDemande);
	}

	public Set<TechnicienDemande> getTechnicienDemandes() {
		return technicienDemandes;
	}

	public void setTechnicienDemandes(Set<TechnicienDemande> technicienDemandes) {
		this.technicienDemandes = technicienDemandes;
	}*/
	
	
	
	
}
