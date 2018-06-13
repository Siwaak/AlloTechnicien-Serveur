package com.siwaak.javauml.techniciendemande;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TechnicienDemandeController {

	@Autowired
	private TechnicienDemandeService technicienDemandeService;

	
	/***
	 * Ajouter un technicien à une demande comme candidat
	 * @param technicienId
	 * @param demandeId
	 */
	@RequestMapping(method=RequestMethod.POST, value="ajoutertechniciendemande/{technicienId}/{demandeId}")
	public void ajouterTechnicienDemande(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId) {
		technicienDemandeService.ajouterTechnicienDemande(technicienId, demandeId);
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
	 */
	@RequestMapping(method=RequestMethod.POST, value="notertechniciendemande/{technicienId}/{demandeId}/{note}")
	public void noterTechnicien(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId,@PathVariable("note") float note) {

		technicienDemandeService.noterTechnicien(technicienId, demandeId, note);
	}
	
	/***
	 * Marquer un technicien comme choisi pour une demande
	 * @param technicienId
	 * @param demandeId
	 */
	@RequestMapping(method=RequestMethod.POST, value="choisirtechniciendemande/{technicienId}/{demandeId}")
	public void choisirTechnicien(@PathVariable("technicienId") Long technicienId,@PathVariable("demandeId") Long demandeId) {
		technicienDemandeService.choisirTechnicien(technicienId, demandeId);
	}
	

}


