package com.siwaak.javauml.utilisateur;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siwaak.javauml.exceptions.ExceptionHandlerClass;

import javassist.NotFoundException;

@RestController
public class UtilisateurController extends ExceptionHandlerClass{

	@Autowired
	private UtilisateurService utilisateurService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    public UtilisateurController(UtilisateurRepository utilisateurRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
			
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
    @PostMapping("/utilisateurs/inscription")
    public Utilisateur inscription(@RequestBody Utilisateur utilisateur) {
    	utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateur.getPassword()));
        return utilisateurService.ajouter(utilisateur);
    }
    
	
	@RequestMapping("/utilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateurs();
	}
	
	@RequestMapping("/utilisateurs/{id}")
	public Utilisateur getUtilisateur(@PathVariable("id") long id) {
		return utilisateurService.getUtilisateur(id);
	}
	
	@RequestMapping("/utilisateurs/id}")
	public Long getId(@PathVariable("email") String email) throws NotFoundException {
		return utilisateurService.getId(email);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/utilisateurs")
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.addUtilisateur(utilisateur);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/utilisateurs/{id}")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur,@PathVariable("id") long id) {
		return utilisateurService.updateUtilisateur(id,utilisateur);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/utilisateurs/{id}")
	public void deleteUtilisateur(@PathVariable("id") long id) {
		utilisateurService.deleteUtilisateur(id);
	}
	
	
}


