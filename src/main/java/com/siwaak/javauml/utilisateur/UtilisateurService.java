package com.siwaak.javauml.utilisateur;

import java.util.ArrayList;
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

	public void addUtilisateur(Utilisateur utilisateur) {
		//techniciens.add(topic);
		
		utilisateurRepository.save(utilisateur);
		
	}

	public void updateUtilisateur(long id, Utilisateur utilisateur) {
		/*for(int i = 0; i < techniciens.size(); i++) {
			Client topic2 = techniciens.get(i);
			if(topic2.getId().equals(id)) {
				techniciens.set(i,topic);
				return;
				
			}
		}*/
		
		utilisateurRepository.save(utilisateur);
		
	}

	public void deleteUtilisateur(long id) {
		//techniciens.removeIf(t -> t.getId().equals(id));
		
		utilisateurRepository.deleteById(id);
		
	}

	public void ajouter(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
		utilisateurRepository.save(utilisateur);
		
	}
}
