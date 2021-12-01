package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Banque;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.Type;
import tn.esprit.spring.repository.BanqueRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BanqueRepository banqueRepository;

	@Override
	public List<Compte> retrieveAllComptes() {
		List<Compte> comptes=(List<Compte>) compteRepository.findAll();
		return comptes;
	}

	@Override
	public Compte addCompte(Compte c) {
		compteRepository.save(c);
		return c;

	}

	@Override
	public void deleteCompte(String numCompte) {
		Compte c= compteRepository.findByNumCompte(numCompte);
		compteRepository.delete(c);
		
	}


	@Override
	public Compte retrieveCompte(String numCompte) {
		Compte c=compteRepository.findById(numCompte).get();
		return c;
	}


	@Override
	public void affectCompteClientBanque(Compte cpt, String cin, int idBq) {
		Client c = clientRepository.findByCin(cin);
		Banque bq = banqueRepository.findById(idBq).get();
		cpt.setBanque(bq);
		cpt.setClient(c);
		compteRepository.save(cpt);
		
	}

	

}
