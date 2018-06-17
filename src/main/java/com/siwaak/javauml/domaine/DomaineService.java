package com.siwaak.javauml.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.technicien.Technicien;
import com.siwaak.javauml.technicien.TechnicienRepository;

import javassist.NotFoundException;

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
	
	public Domaine getDomaine(Long id) throws NotFoundException {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Domaine domaine = domaineRepository.findById(id).orElse(null);
		if (domaine == null ) {
			throw new NotFoundException("Le domaine d'id: " + id + " n'existe pas !");
		}
		
		return domaine;
		
	}

	public Domaine addDomaine(Domaine domaine) {
		//techniciens.add(topic);
		
		return domaineRepository.save(domaine);
		
	}

	public Domaine updateDomaine(Long id, Domaine domaine) throws NotFoundException {
		if (!domaineRepository.existsById(id)) {
				throw new NotFoundException("Le domaine d'id: " + id + " n'existe pas !");
		}
		
		domaine.setId(id);
		return domaineRepository.save(domaine);
		
	}

	public void deleteDomaine(Long id) {
		//techniciens.removeIf(t -> t.getId().equals(id));
		
		domaineRepository.deleteById(id);
		
	}
	
	public Domaine ajouterTechnicien(Long technicienId, Long domaineId) throws NotFoundException {
		Domaine domaine = domaineRepository.findById(domaineId).orElse(null);
		if (domaine == null ) {
			throw new NotFoundException("Le domaine d'id: " + domaineId + " n'existe pas !");
		}
		Technicien technicien = technicienRepository.findById(technicienId).orElse(null);
		if (technicien == null ) {
			throw new NotFoundException("Le technicien d'id: " + technicienId + " n'existe pas !");
		}
		domaine.ajouterTechnicien(technicien);
		return domaineRepository.save(domaine);
	}
}
