package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Credit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refCredit;
	private double montant;
    private int duree;
    private double taux;
    private double mensualite;
    
    
   
    @OneToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;


	public Credit(double montant, int duree, double taux, double mensualite, Date dateDebut, Date dateFin) {
		super();
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.mensualite = mensualite;
		
		
	}

	public Credit() {
		super();
	}


	public Long getRefCredit() {
		return refCredit;
	}

	public void setRefCredit(Long refCredit) {
		this.refCredit = refCredit;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
}
