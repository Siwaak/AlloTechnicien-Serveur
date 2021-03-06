package com.siwaak.javauml.techniciendemande;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.exceptions.ExceptionHandlerClass;

import javassist.NotFoundException;



@RestController
public class TechnicienDemandeController extends ExceptionHandlerClass{

	@Autowired
	private TechnicienDemandeService technicienDemandeService;

	
	/***
	 * Ajouter un technicien à une demande comme candidat
	 * @param technicienId
	 * @param demandeId
	 * @throws NotFoundException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="ajoutertechniciendemande/{technicienId}/{demandeId}")
	public TechnicienDemande ajouterTechnicienDemande(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId) throws NotFoundException {
		return technicienDemandeService.ajouterTechnicienDemande(technicienId, demandeId);
	}

	/***
	 * Retirer la candidature d'un technicien pour une demande
	 * @param technicienId
	 * @param demandeId
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="supprimertechniciendemande/{technicienId}/{demandeId}")
	public void deleteTechnicienDemande(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId) {
		technicienDemandeService.deleteTechnicienDemande(technicienId, demandeId);
	}
	
	/***
	 * Ajouter une note à un technicien pour une intervention
	 * @param technicienId
	 * @param demandeId
	 * @param note
	 * @throws NotFoundException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="notertechniciendemande/{technicienId}/{demandeId}/{note}")
	public TechnicienDemande noterTechnicien(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId,@PathVariable("note") float note) throws NotFoundException {

		return technicienDemandeService.noterTechnicien(technicienId, demandeId, note);
	}
	
	/***
	 * Marquer un technicien comme choisi pour une demande
	 * @param technicienId
	 * @param demandeId
	 * @throws NotFoundException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="choisirtechniciendemande/{technicienId}/{demandeId}")
	public TechnicienDemande choisirTechnicien(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId) throws NotFoundException {
		return technicienDemandeService.choisirTechnicien(technicienId, demandeId);
	}
	
	/**
	 * Liste des demandes auquelles a postulé un technicien
	 * @param technicienId
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping(value="techniciens/{technicienId}/demandes")
	public Set<TechnicienDemande> demandesDunTechnicien(@PathVariable("technicienId") Long technicienId) throws NotFoundException{
		return technicienDemandeService.demandesDunTechnicien(technicienId);
	}
	
	
	/**
	 * Liste des techniciens qui ont postulés pour une demande
	 * @param technicienId
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping(value="/demandes/{demandeId}/techniciens")
	public Set<TechnicienDemande> techniciensPourDemandes(@PathVariable("demandeId") Long demandeId) throws NotFoundException{
		return technicienDemandeService.techniciensPourDemandes(demandeId);
	}
	

}


