
package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Historique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateHistorique;
	
    

	public Historique(Date dateHistorique) {
		this.dateHistorique = dateHistorique;
	}

	public Historique() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateHistorique() {
		return dateHistorique;
	}

	public void setDateHistorique(Date dateHistorique) {
		this.dateHistorique = dateHistorique;
	}

	
	
	

}
