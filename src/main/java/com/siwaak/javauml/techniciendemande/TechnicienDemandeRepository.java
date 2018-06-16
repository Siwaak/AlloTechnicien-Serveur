package com.siwaak.javauml.techniciendemande;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicienDemandeRepository extends JpaRepository<TechnicienDemande, Long> {
	
	public TechnicienDemande findByTechnicienId(Long technicienId);
	
	public TechnicienDemande findByTechnicienIdAndDemandeId(Long technicienId, Long demandeId);
	
	public void deleteByTechnicienIdAndDemandeId(Long technicienId, Long demandeId);
	
	public Set<TechnicienDemande> findAllByTechnicienId(long technicienId);
	
	public Set<TechnicienDemande> findAllByDemandeId(long demandeId);

}
