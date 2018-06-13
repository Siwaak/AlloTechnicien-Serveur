package com.siwaak.javauml.techniciendemande;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicienDemandeRepository extends JpaRepository<TechnicienDemande, Long> {
	
	public TechnicienDemande findByTechnicienIdAndDemandeId(Long technicienId, Long demandeId);
	
	public void deleteByTechnicienIdAndDemandeId(Long technicienId, Long demandeId);

}
