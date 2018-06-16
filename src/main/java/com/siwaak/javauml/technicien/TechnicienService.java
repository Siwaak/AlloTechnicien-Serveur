package com.siwaak.javauml.technicien;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.utilisateur.Utilisateur;
import com.siwaak.javauml.utilisateur.UtilisateurRepository;

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
	
	public Technicien getTechnicien(Long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return technicienRepository.findById(id).orElse(null);
		
	}

	public void addTechnicien(Technicien technicien,Long utilisateurId) {
		//techniciens.add(topic);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
		technicien.setUtilisateur(utilisateur);
		technicienRepository.save(technicien);
		
	}

	public void updateTechnicien(String id, Technicien technicien) {
		
		technicienRepository.save(technicien);
		
	}

	public void deleteTechnicien(Long id) {
		
		technicienRepository.deleteById(id);
		
	}

}
