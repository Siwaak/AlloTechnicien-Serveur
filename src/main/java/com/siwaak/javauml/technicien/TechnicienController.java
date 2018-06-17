package com.siwaak.javauml.technicien;

//import java.util.Arrays;
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
public class TechnicienController extends ExceptionHandlerClass{

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
	public Technicien getTechnicien(@PathVariable("id") Long id) throws NotFoundException {
		return technicienService.getTechnicien(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/utilisateurs/{utilisateurId}/techniciens")
	public Technicien addTechnicien(@RequestBody Technicien technicien,@PathVariable("utilisateurId") Long utilisateurId) throws NotFoundException {
		
		return technicienService.addTechnicien(technicien,utilisateurId );
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/techniciens/{id}")
	public Technicien updateTechnicien(@RequestBody Technicien technicien,@PathVariable("id") Long id) throws NotFoundException {
		return technicienService.updateTechnicien(id,technicien);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/techniciens/{id}")
	public void deleteTechnicien(@PathVariable("id") Long id) {
		technicienService.deleteTechnicien(id);
	}
	

}


