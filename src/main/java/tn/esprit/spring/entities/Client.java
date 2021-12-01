package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name="client",uniqueConstraints=@UniqueConstraint(columnNames="cin"))

public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
    private int id;
	@NotBlank(message="champ obligatoire")
	@Size(min=8 , max=8 , message="le numero de carte d'identitè doit avoir 8 chiffre")
	@Column(name="cin")
	private String cin;
	@NotBlank(message="Champ Obligatoire")
	@Column(name="first_name")
	private String firstName;
	@NotBlank(message="champ obligatoire")
	@Column(name="last_name")
	private String laStName;
	@NotBlank(message="champ obligatoire")
	@Column(name="adresse")
	private String adresse;
	@NotBlank(message="Champ obligatoire")
	@Size(min=8,message="entrez un numero valide")
	@Column(name="numtel")
	private int numTel;
	@Enumerated(EnumType.STRING)
	private EType type;
	@Column(name="society_name")
	private String nomSociete;
	
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes;
	
	@OneToOne(mappedBy="client")
	private Credit credit;
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLaStName() {
		return laStName;
	}
	public void setLaStName(String laStName) {
		this.laStName = laStName;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public EType getType() {
		return type;
	}
	public void setType(EType type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	public Client(
			@NotBlank(message = "champ obligatoire") @Size(min = 8, max = 8, message = "le numero de carte d'identitè doit avoir 8 chiffre") String cin,
			@NotBlank(message = "Champ Obligatoire") String firstName,
			@NotBlank(message = "champ obligatoire") String laStName,
			@NotBlank(message = "champ obligatoire") String adresse,
			@NotBlank(message = "Champ obligatoire") @Size(min = 8, message = "entrez un numero valide") int numTel,
			EType type, String nomSociete) {
		super();
		this.cin = cin;
		this.firstName = firstName;
		this.laStName = laStName;
		this.adresse = adresse;
		this.numTel = numTel;
		this.type = type;
		this.nomSociete = nomSociete;
	}
	public Client() {
		super();
	}
	@Override
	public String toString() {
		return "Client [cin=" + cin + ", firstName=" + firstName + ", laStName=" + laStName + ", adresse=" + adresse
				+ ", numTel=" + numTel + ", type=" + type + ", nomSociete=" + nomSociete + "]";
	}
	
	
	
	
}
