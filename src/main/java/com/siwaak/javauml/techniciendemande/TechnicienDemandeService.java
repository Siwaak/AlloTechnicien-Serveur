package com.siwaak.javauml.techniciendemande;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.demande.Demande;
import com.siwaak.javauml.demande.DemandeRepository;
import com.siwaak.javauml.technicien.Technicien;
import com.siwaak.javauml.technicien.TechnicienRepository;

@Service
public class TechnicienDemandeService {
	
	@Autowired
	private TechnicienDemandeRepository technicienDemandeRepository;

	@Autowired
	private TechnicienRepository technicienRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	

	public void ajouterTechnicienDemande(Long technicienId,Long demandeId) {
		
		Technicien technicien = technicienRepository.findById(technicienId).orElse(null);
		Demande demande = demandeRepository.findById(demandeId).orElse(null);
		
		TechnicienDemande technicienDemande = new TechnicienDemande(demande,technicien);
		/*technicien.ajouterTechnicienDemande(technicienDemande);
		
		technicien.ajouterTechnicienDemande(technicienDemande);
		
		demande.ajouterTechnicienDemande(technicienDemande);
		
		demandeRepository.save(demande);
		technicienRepository.save(technicien);*/
		
		technicienDemandeRepository.save(technicienDemande);
	}

	public void deleteTechnicienDemande(Long technicienId,Long demandeId) {
		
		technicienDemandeRepository.deleteByTechnicienIdAndDemandeId(technicienId, demandeId);
		
	}
	
	public void noterTechnicien(Long technicienId, long demandeId, float note) {
		TechnicienDemande technicienDemande = technicienDemandeRepository.findByTechnicienIdAndDemandeId(technicienId, demandeId);
		technicienDemande.setNote(note);
		
		technicienDemandeRepository.save(technicienDemande);
	}
	
	public void choisirTechnicien(Long technicienId, long demandeId) {
		
		TechnicienDemande technicienDemande = technicienDemandeRepository.findByTechnicienIdAndDemandeId(technicienId, demandeId);
		technicienDemande.setChoisi(true);
		
		technicienDemandeRepository.save(technicienDemande);
	}

	public Set<TechnicienDemande> demandesDunTechnicien(Long technicienId) {
		// TODO Auto-generated method stub
		return technicienDemandeRepository.findAllByTechnicienId(technicienId);
	}

	public Set<TechnicienDemande> techniciensPourDemandes(Long demandeId) {
		// TODO Auto-generated method stub
		return technicienDemandeRepository.findAllByDemandeId(demandeId);
	}


}
