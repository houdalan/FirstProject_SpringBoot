package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	@Temporal(TemporalType.DATE)
	private Date dateOperation;
	private double montant;
	
	@Enumerated(EnumType.STRING)
	private OType type;
	
	@ManyToOne
	@JoinColumn(name="NUM_CPTE")
	private Compte compte;

	@OneToOne
	@JoinColumn(name="ID_HISTORIQUE")
	private Historique historique;
	
	public Operation(Date dateOperation, double montant, OType type, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
		this.compte = compte;
		
	}

	public Operation(Long numero, Date dateOperation, double montant, OType type, Compte compte,
			Historique historique) {
		super();
		this.numero = numero;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
		this.compte = compte;
		this.historique = historique;
	}

	public Operation() {
		super();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public OType getType() {
		return type;
	}

	public void setType(OType type) {
		this.type = type;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}
	

}
