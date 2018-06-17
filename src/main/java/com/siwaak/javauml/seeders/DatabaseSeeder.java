package com.siwaak.javauml.seeders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.siwaak.javauml.client.Client;
import com.siwaak.javauml.client.ClientRepository;
import com.siwaak.javauml.demande.Demande;
import com.siwaak.javauml.demande.DemandeRepository;
import com.siwaak.javauml.domaine.Domaine;
import com.siwaak.javauml.domaine.DomaineRepository;
import com.siwaak.javauml.technicien.Technicien;
import com.siwaak.javauml.technicien.TechnicienRepository;
import com.siwaak.javauml.techniciendemande.TechnicienDemande;
import com.siwaak.javauml.techniciendemande.TechnicienDemandeRepository;
import com.siwaak.javauml.utilisateur.Utilisateur;
import com.siwaak.javauml.utilisateur.UtilisateurRepository;

import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Cette classe permet d'intialiser la base de donnée en insérant des données de test dans chaque table.
 * @author Bilali
 *
 */
@Component
public class DatabaseSeeder {


    private Faker faker = new Faker(new Locale("fr"));
    private UtilisateurRepository utilisateurRepository;
    private ClientRepository clientRepository;
    private DemandeRepository demandeRepository;
    private TechnicienRepository technicienRepository;
    private DomaineRepository domaineRepository;
    private TechnicienDemandeRepository technicienDemandeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
	public DatabaseSeeder(UtilisateurRepository utilisateurRepository, ClientRepository clientRepository,
			DemandeRepository demandeRepository, TechnicienRepository technicienRepository,
			DomaineRepository domaineRepository, TechnicienDemandeRepository technicienDemandeRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.utilisateurRepository = utilisateurRepository;
		this.clientRepository = clientRepository;
		this.demandeRepository = demandeRepository;
		this.technicienRepository = technicienRepository;
		this.domaineRepository = domaineRepository;
		this.technicienDemandeRepository=technicienDemandeRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}



	@EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUtilisateursTable();
        seedClientsTable();
        seedDomainesTable();
        seedDemandesTable();
        seedTechniciensTable();       
        seedTechniciensDomainesTable();
        seedTechniciensDemandesTable();
    }

    private void seedTechniciensDomainesTable() {
		//On récupère tous les domaines et pour chacun, on associes un ou plusieurs techniciens
    	
    	List<Domaine> domaines = domaineRepository.findAll();
    	int i = 1;
    	for(Domaine domaine : domaines){
    		Set<Technicien> techniciens = domaine.getTechniciens();
    		for(int j=1;j<=i;++j) {
        		techniciens.add(technicienRepository.findById((long) j).orElse(null));
        		
    		}
    		domaineRepository.save(domaine);
    		++i;
    	}
		
	}



	private void seedTechniciensDemandesTable() {
    	//Candidature 1
		TechnicienDemande technicienDemande = new TechnicienDemande(demandeRepository.findById((long) 1).orElse(null),
				technicienRepository.findById((long) 1).orElse(null));
		technicienDemandeRepository.save(technicienDemande);
		
		//Candidature 2
		technicienDemande = new TechnicienDemande(demandeRepository.findById((long) 1).orElse(null),
				technicienRepository.findById((long) 2).orElse(null));
		technicienDemandeRepository.save(technicienDemande);
		
		//Candidature 3
		technicienDemande = new TechnicienDemande(demandeRepository.findById((long) 3).orElse(null),
				technicienRepository.findById((long) 3).orElse(null));
		technicienDemandeRepository.save(technicienDemande);
		
		//Candidature 4
		technicienDemande = new TechnicienDemande(demandeRepository.findById((long) 2).orElse(null),
				technicienRepository.findById((long) 4).orElse(null));
		technicienDemandeRepository.save(technicienDemande);

		
		//Candidature 5
		technicienDemande = new TechnicienDemande(demandeRepository.findById((long) 4).orElse(null),
				technicienRepository.findById((long) 1).orElse(null));
		technicienDemandeRepository.save(technicienDemande);

		
		//Candidature 6
		technicienDemande = new TechnicienDemande(demandeRepository.findById((long) 6).orElse(null),
				technicienRepository.findById((long) 3).orElse(null));
		technicienDemandeRepository.save(technicienDemande);
		
	}


	private void seedTechniciensTable() {
		//Technicien 1
		Technicien  technicien = new Technicien();			
		technicien.setUtilisateur(utilisateurRepository.findById((long) 1).orElse(null));			
		technicienRepository.save(technicien);
		
		//Technicien 2
		 technicien = new Technicien();			
		technicien.setUtilisateur(utilisateurRepository.findById((long) 2).orElse(null));			
		technicienRepository.save(technicien);
		
		//Technicien 3
		 technicien = new Technicien();			
		technicien.setUtilisateur(utilisateurRepository.findById((long) 3).orElse(null));			
		technicienRepository.save(technicien);
		
		//Technicien 4
		  technicien = new Technicien();			
		technicien.setUtilisateur(utilisateurRepository.findById((long) 4).orElse(null));			
		technicienRepository.save(technicien);
		
		//Technicien 5
		  technicien = new Technicien();			
		technicien.setUtilisateur(utilisateurRepository.findById((long) 8).orElse(null));			
		technicienRepository.save(technicien);
		
		//Technicien 6
		  technicien = new Technicien();			
		technicien.setUtilisateur(utilisateurRepository.findById((long) 11).orElse(null));			
		technicienRepository.save(technicien);
		
	}


	private void seedDomainesTable() {
		//Domaine 1
		Domaine domaine = new Domaine("Electricité");
		domaineRepository.save(domaine);
		
		//Domaine 2
		domaine = new Domaine("Electro-Ménager");
		domaineRepository.save(domaine);
		
		//Domaine 3
		domaine = new Domaine("Plomberie");
		domaineRepository.save(domaine);
		
		//Domaine 4
		domaine = new Domaine("Menuserie");
		domaineRepository.save(domaine);
		
		//Domaine 5
		domaine = new Domaine("Charpenterie");
		domaineRepository.save(domaine);
		
		//Domaine 6
		domaine = new Domaine("Soudure");
		domaineRepository.save(domaine);
		
	}


	private void seedDemandesTable() {
		
		//Demande 1
		Demande demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 1).orElse(null));
		demande.setClient(clientRepository.findById((long) 1).orElse(null));
		demandeRepository.save(demande);
		
		//Demande 2
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 1).orElse(null));
		demande.setClient(clientRepository.findById((long) 2).orElse(null));
		demandeRepository.save(demande);
		
		
		//Demande 3
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 2).orElse(null));
		demande.setClient(clientRepository.findById((long) 1).orElse(null));
		demandeRepository.save(demande);
		
		//Demande 4
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 3).orElse(null));
		demande.setClient(clientRepository.findById((long) 2).orElse(null));
		demandeRepository.save(demande);
		
		//Demande 5
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 1).orElse(null));
		demande.setClient(clientRepository.findById((long) 3).orElse(null));
		demandeRepository.save(demande);
		
		//Demande 6
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 1).orElse(null));
		demande.setClient(clientRepository.findById((long) 4).orElse(null));
		demandeRepository.save(demande);
		
		
		//Demande 7
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 3).orElse(null));
		demande.setClient(clientRepository.findById((long) 1).orElse(null));
		demandeRepository.save(demande);
		
		
		//Demande 8
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 4).orElse(null));
		demande.setClient(clientRepository.findById((long) 4).orElse(null));
		demandeRepository.save(demande);
		
		//Demande 9
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 2).orElse(null));
		demande.setClient(clientRepository.findById((long) 5).orElse(null));
		demandeRepository.save(demande);
		
		
		//Demande 10
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 5).orElse(null));
		demande.setClient(clientRepository.findById((long) 5).orElse(null));
		demandeRepository.save(demande);
		
		//Demande 11
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 1).orElse(null));
		demande.setClient(clientRepository.findById((long) 3).orElse(null));
		demandeRepository.save(demande);
		
		
		//Demande 12
		demande = new Demande(faker.company().profession(), faker.address().streetAddress());
		demande.setDomaine(domaineRepository.findById((long) 2).orElse(null));
		demande.setClient(clientRepository.findById((long) 4).orElse(null));
		demandeRepository.save(demande);
	}


	private void seedClientsTable() {
		
		//Client 1
			Client  client = new Client(faker.address().streetAddress());			
			client.setUtilisateur(utilisateurRepository.findById((long) 1).orElse(null));			
			clientRepository.save(client);
			
		//Client 2
			client = new Client(faker.address().streetAddress());			
			client.setUtilisateur(utilisateurRepository.findById((long) 3).orElse(null));			
			clientRepository.save(client);
			
		//Client 3
			client = new Client(faker.address().streetAddress());			
			client.setUtilisateur(utilisateurRepository.findById((long) 4).orElse(null));			
			clientRepository.save(client);
			
		//client 4
			client = new Client(faker.address().streetAddress());			
			client.setUtilisateur(utilisateurRepository.findById((long) 5).orElse(null));			
			clientRepository.save(client);
		
		//Client 5
			client = new Client(faker.address().streetAddress());			
			client.setUtilisateur(utilisateurRepository.findById((long) 9).orElse(null));			
			clientRepository.save(client);
		
		//Client 6
			client = new Client(faker.address().streetAddress());
			
			client.setUtilisateur(utilisateurRepository.findById((long) 11).orElse(null));
			
			clientRepository.save(client);
			
		
		
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
