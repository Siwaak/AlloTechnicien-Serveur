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
	 */
	@RequestMapping("/demandes/{id}")
	public Demande getDemande(@PathVariable("id") Long id) {
		return demandeService.getDemande(id);
	}
	
	/**
	 * Récupérer le domande d'une demande
	 * @param id
	 * @return
	 */
	@RequestMapping("/demandes/{id}/domaine")
	public Domaine getDomaineDemande(@PathVariable("id") Long id) {
		return demandeService.getDomaineDemande(id);
	}
	
	/**
	 * Récupérer le client d'une demande
	 * @param id
	 * @return
	 */
	@RequestMapping("/demandes/{id}/client")
	public Client getClientDemande(@PathVariable("id") Long id) {
		return demandeService.getClientDemande(id);
	}
	

	/**
	 * Ajouter une demande
	 * @param demande
	 * @param clientId
	 * @param domaineId
	 */
	@RequestMapping(method=RequestMethod.POST, value="/demandes/ajout/{clientId}/{domaineId}")
	public void addDemande(@RequestBody Demande demande,@PathVariable("clientId") Long clientId,@PathVariable("domaineId") Long domaineId) {

		demandeService.addDemande(demande,clientId,domaineId);
	}
	
	/**
	 * Modifier une demande
	 * @param demande
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/demandes/{id}")
	public void updateDemande(@RequestBody Demande demande,@PathVariable("id") Long id) {
		demandeService.updateDemande(id,demande);
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


