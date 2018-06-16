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
	
	public List<Domaine> getAllDomaines() {
	
		List<Domaine> domaines = new ArrayList<>();
		
		domaineRepository.findAll().forEach(domaines::add);
		
		return domaines;
	}
	
	public Domaine getDomaine(Long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return domaineRepository.findById(id).orElse(null);
		
	}

	public void addDomaine(Domaine domaine) {
		//techniciens.add(topic);
		
		domaineRepository.save(domaine);
		
	}

	public void updateDomaine(Long id, Domaine domaine) {

		
		domaineRepository.save(domaine);
		
	}

	public void deleteDomaine(Long id) {
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
