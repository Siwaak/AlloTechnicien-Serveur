package com.siwaak.javauml.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.technicien.Technicien;
import com.siwaak.javauml.technicien.TechnicienRepository;

@Service
public class DomaineService {
	
	@Autowired
	private DomaineRepository domaineRepository;
	@Autowired
	private TechnicienRepository technicienRepository;
	
	public List<Domaine> getAllUtilisateurs() {
	
		List<Domaine> domaines = new ArrayList<>();
		
		domaineRepository.findAll().forEach(domaines::add);
		
		return domaines;
	}
	
	public Domaine getUtilisateur(Long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return domaineRepository.findById(id).orElse(null);
		
	}

	public void addUtilisateur(Domaine domaine) {
		//techniciens.add(topic);
		
		domaineRepository.save(domaine);
		
	}

	public void updateUtilisateur(String id, Domaine domaine) {
		/*for(int i = 0; i < techniciens.size(); i++) {
			Client topic2 = techniciens.get(i);
			if(topic2.getId().equals(id)) {
				techniciens.set(i,topic);
				return;
				
			}
		}*/
		
		domaineRepository.save(domaine);
		
	}

	public void deleteUtilisateur(Long id) {
		//techniciens.removeIf(t -> t.getId().equals(id));
		
		domaineRepository.deleteById(id);
		
	}
	
	public void ajouterTechnicien(Long technicienId, Long domaineId) {
		Domaine domaine = domaineRepository.findById(domaineId).orElse(null);
		Technicien technicien = technicienRepository.findById(technicienId).orElse(null);
		domaine.ajouterTechnicien(technicien);
		domaineRepository.save(domaine);
	}
}
