package com.siwaak.javauml.domaine;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.exceptions.ExceptionHandlerClass;


@RestController
public class DomaineController extends ExceptionHandlerClass{

	@Autowired
	private DomaineService domaineService;
	
	@RequestMapping("/domaines")
	public List<Domaine> getAllDomaines() {
		return domaineService.getAllDomaines();
	}
	
	@RequestMapping("/domaines/{id}")
	public Domaine getDomaine(@PathVariable("id") Long id) {
		return domaineService.getDomaine(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/domaines")
	public void addDomaine(@RequestBody Domaine domaine) {
		domaineService.addDomaine(domaine);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/domaines/{id}")
	public void updateDomaine(@RequestBody Domaine domaine,@PathVariable("id") Long id) {
		domaine.setId(id);
		domaineService.updateDomaine(id,domaine);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/domaines/{id}")
	public void deleteDomaine(@PathVariable("id") Long id) {
		domaineService.deleteDomaine(id);
	}
	
	/**
	 * Ajouter un technicien à un domaine
	 * @param technicienId
	 * @param domaineId
	 */
	@RequestMapping(method=RequestMethod.POST, value="/domaines/{domaineId}/techniciens/{technicienId}")
	public void ajouterTechnicien(@PathVariable("technicienId") Long technicienId,@PathVariable("domaineId") Long domaineId) {
		domaineService.ajouterTechnicien(technicienId,domaineId);
	}
}


