package com.siwaak.javauml.client;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.exceptions.ExceptionHandlerClass;

import javassist.NotFoundException;

@RestController
public class ClientController  extends ExceptionHandlerClass{

	@Autowired
	private ClientService clientService;
	
	
	/***
	 * Liste des clients 
	 * @return
	 */
	@RequestMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	
	/**
	 * Le client dont l'id est passé en argument
	 * @param id
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping("/clients/{id}")
	public Client getClient(@PathVariable("id") Long id) throws NotFoundException {
		return clientService.getClient(id);
	}
	
	/**
	 * Créer le client associé à l'client dont l'id est passé en arguement.
	 * Le donné envoyés à travers la requète seront utilisées pour créer l'objet client
	 * 
	 * Une erreur 404 sera renvoyée si l'utilisateur n'existe pas
	 * @param client
	 * @param clientId
	 * @throws NotFoundException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/utilisateurs/{utilisateurId}/ajouterClient")
	public Client addClient(@RequestBody Client client,@PathVariable("utilisateurId") Long utilisateurId) throws NotFoundException {
		return clientService.addClient(client,utilisateurId);
	}
	
	
	/**
	 * Mise à jour du client dont l'id est passé en argument
	 * Le donné envoyés à travers la requète seront utilisées pour créer l'objet client
	 * 
	 * 
	 * @param client
	 * @param id
	 * @throws Exception  Une erreur 404 sera renvoyée si le client n'existe pas
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/clients/{id}")
	public Client updateClient(@RequestBody Client client,@PathVariable("id") Long id) throws Exception {
		
		//client.setId(id);
		return clientService.updateClient(id,client);
	}
	
	/**
	 * suppression du client dont l'id est passé en argument
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/clients/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
		clientService.deleteClient(id);
	}
	

	
}


