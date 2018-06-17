package com.siwaak.javauml.utilisateur;

import java.util.ArrayList;
import javassist.NotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public List<Utilisateur> getAllUtilisateurs() {
	
		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		utilisateurRepository.findAll().forEach(utilisateurs::add);
		
		return utilisateurs;
	}
	
	public Utilisateur getUtilisateur(long id) {
		//return techniciens.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return utilisateurRepository.findById(id).orElse(null);
		
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		//techniciens.add(topic);
		
		 return utilisateurRepository.save(utilisateur);
		
	}

	public Utilisateur updateUtilisateur(long id, Utilisateur utilisateur) {
		
		return utilisateurRepository.save(utilisateur);
		
	}

	public void deleteUtilisateur(long id) {
		//techniciens.removeIf(t -> t.getId().equals(id));
		
		utilisateurRepository.deleteById(id);
		
	}

	public Utilisateur ajouter(Utilisateur user) {
		// TODO Auto-generated method stub
		
		return utilisateurRepository.save(user);
		
	}

	public Long getId(String email) throws NotFoundException {
		Utilisateur utilisateur =  utilisateurRepository.findByEmail(email);
		
		if(utilisateur == null ) {
			throw new NotFoundException("L'utilisateur d'email: "+ email + " n'existe pas !");
		}
		
		return utilisateur.getId();
	}
}
