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

	public void addClient(Client client,Long utilisateurId) {
		//techniciens.add(topic);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
		client.setUtilisateur(utilisateur);
		clientRepository.save(client);
		
	}

	public void updateClient(Long id, Client client) {
		
		clientRepository.save(client);
		
	}

	public void deleteClient(Long id) {
		//techniciens.removeIf(t -> t.getId().equals(id));
		
		clientRepository.deleteById(id);
		
	}
}
