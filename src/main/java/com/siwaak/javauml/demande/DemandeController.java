package com.siwaak.javauml.demande;

//import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.techniciendemande.TechnicienDemande;
import com.siwaak.javauml.client.Client;

@RestController
public class DemandeController {

	@Autowired
	private DemandeService demandeService;
	
	@RequestMapping("/demandes")
	public List<Demande> getAllDemandes() {
		return demandeService.getAllDemandes();
	}
	
	@RequestMapping("/demandes/{id}")
	public Demande getDemande(@PathVariable("id") Long id) {
		return demandeService.getDemande(id);
	}
	
	@RequestMapping("/demandes/{id}/domaine")
	public Domaine getDomaineDemande(@PathVariable("id") Long id) {
		return demandeService.getDomaineDemande(id);
	}
	
	@RequestMapping("/demandes/{id}/client")
	public Client getClientDemande(@PathVariable("id") Long id) {
		return demandeService.getClientDemande(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/demandes/{id}/techniciens")
	public Set<TechnicienDemande> getDemandeTechniciens(@PathVariable("id") Long id){
		
		return demandeService.getDemandeTechniciens(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/demandes")
	public void addDemande(@RequestBody Demande demande) {
		demandeService.addDemande(demande);
	}
		
	@RequestMapping(method=RequestMethod.PUT, value="/demandes/{id}")
	public void updateDemande(@RequestBody Demande demande,@PathVariable("id") Long id) {
		demandeService.updateDemande(id,demande);
	}
	

	
	@RequestMapping(method=RequestMethod.DELETE, value="/demandes/{id}")
	public void deleteDemande(@PathVariable("id") Long id) {
		demandeService.deleteDemande(id);
	}
}


