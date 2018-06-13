package com.siwaak.javauml.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siwaak.javauml.utilisateur.Utilisateur;
import com.siwaak.javauml.utilisateur.UtilisateurRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public List<Client> getAllUtilisateurs() {
	
		List<Client> clients = new ArrayList<>();
		
		clientRepository.findAll().forEach(clients::add);
		
		return clients;
	}
	
	public Client getUtilisateur(Long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return clientRepository.findById(id).orElse(null);
		
	}

	public void addUtilisateur(Client client,Long utilisateurId) {
		//techniciens.add(topic);
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
		client.setUtilisateur(utilisateur);
		clientRepository.save(client);
		
	}

	public void updateUtilisateur(String id, Client client) {
		/*for(int i = 0; i < techniciens.size(); i++) {
			Client topic2 = techniciens.get(i);
			if(topic2.getId().equals(id)) {
				techniciens.set(i,topic);
				return;
				
			}
		}*/
		
		clientRepository.save(client);
		
	}

	public void deleteUtilisateur(Long id) {
		//techniciens.removeIf(t -> t.getId().equals(id));
		
		clientRepository.deleteById(id);
		
	}
}
