package com.siwaak.javauml.demande;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.exceptions.ExceptionHandlerClass;

import javassist.NotFoundException;

import com.siwaak.javauml.client.Client;
@RestController
public class DemandeController extends ExceptionHandlerClass{

	@Autowired
	private DemandeService demandeService;
	
	/**
	 * L'ensemble des demandes
	 * @return
	 */
	@RequestMapping("/demandes")
	public List<Demande> getAllDemandes() {
		return demandeService.getAllDemandes();
	}
	
	
	/**
	 * Récupérer une demande
	 * @param id
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping("/demandes/{id}")
	public Demande getDemande(@PathVariable("id") Long id) throws NotFoundException {
		return demandeService.getDemande(id);
	}
	
	/**
	 * Récupérer le domande d'une demande
	 * @param id
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping("/demandes/{id}/domaine")
	public Domaine getDomaineDemande(@PathVariable("id") Long id) throws NotFoundException {
		return demandeService.getDomaineDemande(id);
	}
	
	/**
	 * Récupérer le client d'une demande
	 * @param id
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping("/demandes/{id}/client")
	public Client getClientDemande(@PathVariable("id") Long id) throws NotFoundException {
		return demandeService.getClientDemande(id);
	}
	

	/**
	 * Ajouter une demande
	 * @param demande
	 * @param clientId
	 * @param domaineId
	 * @throws NotFoundException Une erreur 404 sera renvoyée si le client ou le domaine n'existe pas
	 */
	@RequestMapping(method=RequestMethod.POST, value="/demandes/ajout/{clientId}/{domaineId}")
	public Demande addDemande(@RequestBody Demande demande,@PathVariable("clientId") Long clientId,@PathVariable("domaineId") Long domaineId) throws NotFoundException {

		return demandeService.addDemande(demande,clientId,domaineId);
	}
	
	/**
	 * Modifier une demande
	 * @param demande
	 * @param id
	 * @throws NotFoundException 
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/demandes/{id}")
	public Demande updateDemande(@RequestBody Demande demande,@PathVariable("id") Long id) throws NotFoundException {
		return demandeService.updateDemande(id,demande);
	}
	

	/**
	 * Supprimer une demande
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/demandes/{id}")
	public void deleteDemande(@PathVariable("id") Long id) {
		demandeService.deleteDemande(id);
	}
}


