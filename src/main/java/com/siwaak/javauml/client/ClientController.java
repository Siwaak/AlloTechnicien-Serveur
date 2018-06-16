package com.siwaak.javauml.client;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	/***
	 * Liste des clients 
	 * @return
	 */
	@RequestMapping("/clients")
	public List<Client> getAllUtilisateurs() {
		return clientService.getAllUtilisateurs();
	}
	
	/**
	 * Le client qui dont l'id est passé en argument
	 * @param id
	 * @return
	 */
	@RequestMapping("/clients/{id}")
	public Client getUtilisateur(@PathVariable("id") Long id) {
		return clientService.getUtilisateur(id);
	}
	
	/**
	 * Créer le client associé à l'utilisateur dont l'id est passé en arguement.
	 * Le donné envoyés à travers la requète seront utilisées pour créer l'objet client
	 * @param client
	 * @param utilisateurId
	 */
	@RequestMapping(method=RequestMethod.POST, value="/utilisateurs/{utilisateurId}/clients")
	public void addUtilisateur(@RequestBody Client client,@PathVariable("utilisateurId") Long utilisateurId) {
		clientService.addUtilisateur(client,utilisateurId);
	}
	
	
	/**
	 * Mise à jour du client dont l'id est passé en argument
	 * Le donné envoyés à travers la requète seront utilisées pour créer l'objet client
	 * @param client
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/clients/{id}")
	public void updateUtilisateur(@RequestBody Client client,@PathVariable("id") String id) {
		clientService.updateUtilisateur(id,client);
	}
	
	/**
	 * suppression du client dont l'id est passé en argument
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/clients/{id}")
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		clientService.deleteUtilisateur(id);
	}
}


