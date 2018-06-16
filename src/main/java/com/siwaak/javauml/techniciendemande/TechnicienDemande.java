package com.siwaak.javauml.techniciendemande;

import java.util.Date;

import javax.persistence.*;

import com.siwaak.javauml.demande.Demande;
import com.siwaak.javauml.technicien.Technicien;

@Entity
@Table(name = "techniciens_demandes",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"demande_id", "technicien_id"})
	)
public class TechnicienDemande {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;	
	
	    @ManyToOne
	    @JoinColumn(name = "demande_id")
	    private Demande demande;

	    @ManyToOne
	    @JoinColumn(name = "technicien_id")
	    private Technicien technicien;

	    @Column(name = "choisi")
	    private boolean choisi;
	    
	    
	    private Date date;
	    
	    private float note;

	    
	    
	    
		public TechnicienDemande() {
			super();
		}
		
		

		public TechnicienDemande(Demande demande, Technicien technicien) {
			super();
			this.demande = demande;
			this.technicien = technicien;
			this.choisi = false;
			this.note = 0;
			this.date = new Date();
		}



		public TechnicienDemande(Demande demande, Technicien technicien, boolean choisi, Date date, float note) {
			super();
			this.demande = demande;
			this.technicien = technicien;
			this.choisi = choisi;
			this.date = date;
			this.note = note;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Demande getDemande() {
			return demande;
		}

		public void setDemande(Demande demande) {
			this.demande = demande;
		}

		public Technicien getTechnicien() {
			return technicien;
		}

		public void setTechnicien(Technicien technicien) {
			this.technicien = technicien;
		}

		public boolean isChoisi() {
			return choisi;
		}

		public void setChoisi(boolean choisi) {
			this.choisi = choisi;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public float getNote() {
			return note;
		}

		public void setNote(float note) {
			this.note = note;
		}
	    
		
	    
	    
}
