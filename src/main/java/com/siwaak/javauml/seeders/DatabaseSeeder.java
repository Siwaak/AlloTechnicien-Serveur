package com.siwaak.javauml.seeders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.siwaak.javauml.client.ClientRepository;
import com.siwaak.javauml.demande.Demande;
import com.siwaak.javauml.demande.DemandeRepository;
import com.siwaak.javauml.utilisateur.Utilisateur;
import com.siwaak.javauml.utilisateur.UtilisateurRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Component
public class DatabaseSeeder {


    private JdbcTemplate jdbcTemplate;
    Faker faker = new Faker(new Locale("fr"));
    private UtilisateurRepository utilisateurRepository;
    private ClientRepository clientRepository;
    private DemandeRepository demandeRepository;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Autowired
    public DatabaseSeeder(JdbcTemplate jdbcTemplate, UtilisateurRepository utilisateurRepository,
			ClientRepository clientRepository, DemandeRepository demandeRepository) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.utilisateurRepository = utilisateurRepository;
		this.clientRepository = clientRepository;
		this.demandeRepository = demandeRepository;
	}


	@EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUtilisateursTable();
        seedClientsTable();
        seedDemandesTable();
    }

    private void seedDemandesTable() {
	
		
	}


	private void seedClientsTable() {
		
		
	}


	private void seedUtilisateursTable() {
		
		for(int i=0;i<10;i++) {
			Utilisateur utilisateur = new Utilisateur(faker.internet().emailAddress(),
					bCryptPasswordEncoder.encode(faker.internet().password()) ,
					faker.address().firstName(),
					faker.address().lastName(),
					faker.phoneNumber().cellPhone());
			
			utilisateurRepository.save(utilisateur);
		}

		Utilisateur utilisateur = new Utilisateur("allo@technicien.com", bCryptPasswordEncoder.encode("password"), "AlloTechnicien", "admin", "0102030405");
		
		utilisateurRepository.save(utilisateur);
		
		
	}

}
