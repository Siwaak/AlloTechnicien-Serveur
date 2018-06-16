package com.siwaak.javauml.demande;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.domaine.DomaineRepository;
import com.siwaak.javauml.client.Client;
import com.siwaak.javauml.client.ClientRepository;

@Service
public class DemandeService {
	
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private DomaineRepository domaineRepository;

	public List<Demande> getAllDemandes() {
	
		List<Demande> demandes = new ArrayList<>();
		
		demandeRepository.findAll().forEach(demandes::add);
		
		return demandes;
	}
	
	public Demande getDemande(Long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return demandeRepository.findById(id).orElse(null);
		
	}

	public void addDemande(Demande demande, Long clientId, Long domaineId) {
		//techniciens.add(topic);
		Domaine domaine = domaineRepository.findById(domaineId).orElse(null);
		Client client = clientRepository.findById(clientId).orElse(null);
		
		demande.setClient(client);
		demande.setDomaine(domaine);
		demandeRepository.save(demande);
		
	}

	public void updateDemande(Long id, Demande demande) {
		
		demandeRepository.save(demande);		
	}

	public void deleteDemande(Long id) {
		demandeRepository.deleteById(id);		
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
