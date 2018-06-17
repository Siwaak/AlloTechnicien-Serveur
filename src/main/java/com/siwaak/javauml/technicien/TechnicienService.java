package com.siwaak.javauml.technicien;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.utilisateur.Utilisateur;
import com.siwaak.javauml.utilisateur.UtilisateurRepository;

import javassist.NotFoundException;

@Service
public class TechnicienService {
	
	@Autowired
	private TechnicienRepository technicienRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	
	public List<Technicien> getAllTechniciens() {
	
		List<Technicien> techniciens = new ArrayList<>();
		
		technicienRepository.findAll().forEach(techniciens::add);
		
		return techniciens;
	}
	
	public Technicien getTechnicien(Long id) throws NotFoundException {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Technicien technicien = technicienRepository.findById(id).orElse(null);
		if (technicien == null ) {
			throw new NotFoundException("Le technicien d'id: " + id + " n'existe pas !");
					
		}
		
		return technicien;
		
	}

	public Technicien addTechnicien(Technicien technicien,Long utilisateurId) throws NotFoundException {
		//techniciens.add(topic);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
		if (utilisateur == null ) {
			throw new NotFoundException("L'utilisateur d'id: " + utilisateurId + " n'existe pas !");
		}
		technicien.setUtilisateur(utilisateur);
		return technicienRepository.save(technicien);
		
	}

	public Technicien updateTechnicien(Long id, Technicien technicien) throws NotFoundException {
		if (!technicienRepository.existsById(id)) {
			throw new NotFoundException("Le technicien d'id: " + id + " n'existe pas !");		
		}
		technicien.setId(id);
		return technicienRepository.save(technicien);
		
	}

	public void deleteTechnicien(Long id) {
		
		technicienRepository.deleteById(id);
		
	}

}
