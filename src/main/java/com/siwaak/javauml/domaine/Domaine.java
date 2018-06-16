package com.siwaak.javauml.domaine;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.siwaak.javauml.technicien.Technicien;

@Entity
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String designation;		
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "techniciens_domaines",
		joinColumns = {@JoinColumn(name = "domaine_id")},
		inverseJoinColumns = {@JoinColumn(name = "technicien_id")})
	private Set<Technicien> techniciens = new HashSet<>();	
	
	public Domaine() {
		super();
	}
	
	public Domaine(String designation) {
		super();
		
		this.designation = designation;
	}

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Set<Technicien> getTechniciens() {
		return techniciens;
	}

	public void setTechniciens(Set<Technicien> techniciens) {
		this.techniciens = techniciens;
	}
	
	
	public void ajouterTechnicien(Technicien technicien) {
		this.techniciens.add(technicien);
	}
	
	
	
}
