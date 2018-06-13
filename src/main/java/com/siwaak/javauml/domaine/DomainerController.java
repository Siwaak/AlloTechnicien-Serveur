package com.siwaak.javauml.domaine;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainerController {

	@Autowired
	private DomaineService domaineService;
	
	@RequestMapping("/domaines")
	public List<Domaine> getAllUtilisateurs() {
		return domaineService.getAllUtilisateurs();
	}
	
	@RequestMapping("/domaines/{id}")
	public Domaine getUtilisateur(@PathVariable("id") Long id) {
		return domaineService.getUtilisateur(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/domaines")
	public void addUtilisateur(@RequestBody Domaine domaine) {
		domaineService.addUtilisateur(domaine);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/domaines/{id}")
	public void updateUtilisateur(@RequestBody Domaine domaine,@PathVariable("id") String id) {
		domaineService.updateUtilisateur(id,domaine);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/domaines/{id}")
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		domaineService.deleteUtilisateur(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/domaines/{domaineId}/techniciens/{technicienId}")
	public void ajouterTechnicien(@PathVariable("technicienId") Long technicienId,@PathVariable("domaineId") Long domaineId) {
		domaineService.ajouterTechnicien(technicienId,domaineId);
	}
}


