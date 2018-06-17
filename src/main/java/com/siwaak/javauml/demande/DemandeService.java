package com.siwaak.javauml.demande;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.domaine.DomaineRepository;

import javassist.NotFoundException;

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
	
	public Demande getDemande(Long id) throws NotFoundException {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Demande demande = demandeRepository.findById(id).orElse(null);
		if(demande == null)
			throw new NotFoundException("La demande d'id: " + id + " n'existe pas !");
		
		return demande;
		
	}

	public Demande addDemande(Demande demande, Long clientId, Long domaineId) throws NotFoundException {
		//techniciens.add(topic);
		Domaine domaine = domaineRepository.findById(domaineId).orElse(null);
		Client client = clientRepository.findById(clientId).orElse(null);
		if (client == null ) {
				throw new NotFoundException("Le client d'id: " + clientId + " n'existe pas !");
		}
		
		if (domaine == null ) {
				throw new NotFoundException("Le domaine d'id: " + domaineId + " n'existe pas !");
		}
		demande.setClient(client);
		demande.setDomaine(domaine);
		return demandeRepository.save(demande);
		

		
	}

	public Demande updateDemande(Long id, Demande demande) throws NotFoundException {
		
		if(demandeRepository.existsById(id)) {
			demande.setId(id);
			 return demandeRepository.save(demande);
		}
		
		throw new NotFoundException("La demande d'id: " + id + " n'existe pas !");
	}

	public void deleteDemande(Long id) {
		demandeRepository.deleteById(id);		
	}


	public Domaine getDomaineDemande(Long id) throws NotFoundException {
		Demande demande = demandeRepository.findById(id).orElse(null);
		if(demande == null)
			throw new NotFoundException("La demande d'id: " + id + " n'existe pas !");
		return demande.getDomaine();
	}

	public Client getClientDemande(Long id) throws NotFoundException {
		Demande demande = demandeRepository.findById(id).orElse(null);
		if(demande == null)
			throw new NotFoundException("La demande d'id: " + id + " n'existe pas !");
		return demande.getClient();
	}

}
