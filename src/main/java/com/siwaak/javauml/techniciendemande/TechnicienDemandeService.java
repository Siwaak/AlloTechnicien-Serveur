package com.siwaak.javauml.techniciendemande;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.demande.Demande;
import com.siwaak.javauml.demande.DemandeRepository;
import com.siwaak.javauml.technicien.Technicien;
import com.siwaak.javauml.technicien.TechnicienRepository;

import javassist.NotFoundException;

@Service
public class TechnicienDemandeService {
	
	@Autowired
	private TechnicienDemandeRepository technicienDemandeRepository;

	@Autowired
	private TechnicienRepository technicienRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	

	public TechnicienDemande ajouterTechnicienDemande(Long technicienId,Long demandeId) throws NotFoundException {
		
		Technicien technicien = technicienRepository.findById(technicienId).orElse(null);
		if (technicien == null ) {
			throw new NotFoundException("Le technicien d'id: " + technicienId + " n'existe pas !");
		}
		Demande demande = demandeRepository.findById(demandeId).orElse(null);
		if (demande == null ) {
			throw new NotFoundException("La demande d'id: " + demandeId + " n'existe pas !");
		}
		
		TechnicienDemande technicienDemande = new TechnicienDemande(demande,technicien);
		
		return technicienDemandeRepository.save(technicienDemande);
	}

	public void deleteTechnicienDemande(Long technicienId,Long demandeId) {
		
		technicienDemandeRepository.deleteByTechnicienIdAndDemandeId(technicienId, demandeId);
		
	}
	
	public TechnicienDemande noterTechnicien(Long technicienId, long demandeId, float note) throws NotFoundException {
		TechnicienDemande technicienDemande = technicienDemandeRepository.findByTechnicienIdAndDemandeId(technicienId, demandeId);
		if (technicienDemande == null ) {
			throw new NotFoundException("Le technicien d'id: " + technicienId +" n'a pas postulé pour la demande d'id " + demandeId);
		}
		
		technicienDemande.setNote(note);
		
		return technicienDemandeRepository.save(technicienDemande);
	}
	
	public TechnicienDemande choisirTechnicien(Long technicienId, long demandeId) throws NotFoundException {
		
		TechnicienDemande technicienDemande = technicienDemandeRepository.findByTechnicienIdAndDemandeId(technicienId, demandeId);
		if (technicienDemande == null ) {
			throw new NotFoundException("Le technicien d'id: " + technicienId +" n'a pas postulé pour la demande d'id " + demandeId);
		}
		technicienDemande.setChoisi(true);
		
		return technicienDemandeRepository.save(technicienDemande);
	}

	public Set<TechnicienDemande> demandesDunTechnicien(Long technicienId) throws NotFoundException {
		if (!technicienRepository.existsById(technicienId)) {
			throw new NotFoundException("Le technicien d'id: " + technicienId + " n'existe pas !");
		}
		
		return technicienDemandeRepository.findAllByTechnicienId(technicienId);
	}

	public Set<TechnicienDemande> techniciensPourDemandes(Long demandeId) throws NotFoundException {
		if(!demandeRepository.existsById(demandeId)) {
			throw new NotFoundException("La demande d'id: "+ demandeId + " n'existe pas !");
		}
		return technicienDemandeRepository.findAllByDemandeId(demandeId);
	}


}
