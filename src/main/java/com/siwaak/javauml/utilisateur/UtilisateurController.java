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



@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;
	private UtilisateurRepository utilisateurRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    public UtilisateurController(UtilisateurRepository utilisateurRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
			this.utilisateurRepository = utilisateurRepository;
			this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
    @PostMapping("/utilisateurs/inscription")
    public void inscription(@RequestBody Utilisateur user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        utilisateurService.ajouter(user);
    }
    
	@RequestMapping("/utilisateurs")
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAllUtilisateurs();
	}
	
	@RequestMapping("/utilisateurs/{id}")
	public Utilisateur getUtilisateur(@PathVariable("id") long id) {
		return utilisateurService.getUtilisateur(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/utilisateurs")
	public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.addUtilisateur(utilisateur);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/utilisateurs/{id}")
	public void updateUtilisateur(@RequestBody Utilisateur utilisateur,@PathVariable("id") long id) {
		utilisateurService.updateUtilisateur(id,utilisateur);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/utilisateurs/{id}")
	public void deleteUtilisateur(@PathVariable("id") long id) {
		utilisateurService.deleteUtilisateur(id);
	}
}


