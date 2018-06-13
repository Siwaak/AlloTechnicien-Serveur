package com.siwaak.javauml.demande;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.techniciendemande.TechnicienDemande;
import com.siwaak.javauml.client.Client;

@Service
public class DemandeService {
	
	@Autowired
	private DemandeRepository demandeRepository;

	public List<Demande> getAllDemandes() {
	
		List<Demande> demandes = new ArrayList<>();
		
		demandeRepository.findAll().forEach(demandes::add);
		
		return demandes;
	}
	
	public Demande getDemande(Long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return demandeRepository.findById(id).orElse(null);
		
	}

	public void addDemande(Demande demande) {
		//techniciens.add(topic);
		
		demandeRepository.save(demande);
		
	}

	public void updateDemande(Long id, Demande demande) {
		demandeRepository.save(demande);		
	}

	public void deleteDemande(Long id) {
		demandeRepository.deleteById(id);		
	}

	/***
	 * Listes des techniciens candidats pour une demande
	 * @param id
	 * @return
	 */
	public Set<TechnicienDemande> getDemandeTechniciens(Long id) {
		
		Demande demande = demandeRepository.findById(id).orElse(null);
		
		return demande.getTechnicienDemandes();
	}

	public Domaine getDomaineDemande(Long id) {
		Demande demande = demandeRepository.findById(id).orElse(null);
		return demande.getDomaine();
	}

	public Client getClientDemande(Long id) {
		Demande demande = demandeRepository.findById(id).orElse(null);
		return demande.getClient();
	}

}
