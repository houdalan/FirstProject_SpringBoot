package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Compte;

public interface CompteService {
	List<Compte> retrieveAllComptes();
	Compte addCompte(Compte c);
	void deleteCompte(String numCompte);
	Compte retrieveCompte(String numCompte);
	public void affectCompteClientBanque(Compte cpt, String cin, int idBq);
	
	
	

}
