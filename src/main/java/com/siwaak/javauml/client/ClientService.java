package com.siwaak.javauml.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.client.Client;
import com.siwaak.javauml.client.ClientRepository;
import com.siwaak.javauml.utilisateur.Utilisateur;
import com.siwaak.javauml.utilisateur.UtilisateurRepository;

import javassist.NotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public List<Client> getAllClients() {
	
		List<Client> clients = new ArrayList<>();
		
		clientRepository.findAll().forEach(clients::add);
		
		return clients;
	}
	
	public Client getClient(Long id) throws NotFoundException {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		Client client = clientRepository.findById(id).orElse(null);
		
		if (client == null ) {
			throw new NotFoundException("Client non trouvé");
			
		}
		return client;
		
	}

	public Client addClient(Client client,Long utilisateurId) throws NotFoundException {
		//techniciens.add(topic);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
		
		
		if (utilisateur == null ) {
			throw new NotFoundException("L'utilisateur d'identifiant " + utilisateurId +" n'a pas été trouvée");
			
		}
		
		client.setUtilisateur(utilisateur);
		return clientRepository.save(client);
		
	}

	public Client updateClient(Long id, Client client) throws Exception {
		if (clientRepository.existsById(id)) {
			client.setId(id);
			return clientRepository.save(client);
		}
		
		else {
			throw new NotFoundException("Le client d'id :" + id + " n'existe pas");
		}

	}

	public void deleteClient(Long id) {
		
		clientRepository.deleteById(id);
		
	}
}
