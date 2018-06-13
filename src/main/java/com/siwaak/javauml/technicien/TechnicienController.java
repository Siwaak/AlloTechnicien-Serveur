package com.siwaak.javauml.technicien;

//import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.techniciendemande.TechnicienDemande;

@RestController
public class TechnicienController {

	@Autowired
	private TechnicienService technicienService;

	
	/***
	 * 
	 * @return
	 */
	@RequestMapping("/techniciens")
	public List<Technicien> getAllTechniciens() {
		return technicienService.getAllTechniciens();
	}
	
	@RequestMapping("/techniciens/{id}")
	public Technicien getTechnicien(@PathVariable("id") Long id) {
		return technicienService.getTechnicien(id);
	}
	
	/***
	 * Liste des candidatures faites par un technicien
	 * @param id
	 * @return
	 */
	@RequestMapping("/techniciens/{id}/demandes")
	public Set<TechnicienDemande> getTechnicienDemandes(@PathVariable("id") Long id) {
		return technicienService.getTechnicienDemandes(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/utilisateurs/{utilisateurId}/techniciens")
	public void addTechnicien(@RequestBody Technicien technicien,@PathVariable("utilisateurId") Long utilisateurId) {
		
		technicienService.addTechnicien(technicien,utilisateurId );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/techniciens/{id}")
	public void updateTechnicien(@RequestBody Technicien technicien,@PathVariable("id") String id) {
		technicienService.updateTechnicien(id,technicien);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/techniciens/{id}")
	public void deleteTechnicien(@PathVariable("id") Long id) {
		technicienService.deleteTechnicien(id);
	}
	

}


