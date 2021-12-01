package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Banque;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.Historique;
import tn.esprit.spring.entities.OType;
import tn.esprit.spring.entities.Operation;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.HistoriqueRepository;
import tn.esprit.spring.repository.OperationRepository;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private HistoriqueRepository historiqueRepository;
	
	@Override
	public void deleteOperation(Long numOp) {
		Operation o= operationRepository.findById(numOp).get();
		operationRepository.delete(o);
		
	}

	@Override
	public Operation consulterOperation(Long numOp) {
		Operation o=operationRepository.findById(numOp).get();
		return o;
	}


	@Override
	public void versement(Operation o, String numCompte, int idhisto, double montant ) {
		Compte c=compteRepository.findByNumCompte(numCompte);
		Historique h = historiqueRepository.findById(idhisto).get();
		o.setCompte(c);
		o.setHistorique(h);
		o.setMontant(montant);
		operationRepository.save(o);
		c.setSolde(c.getSolde() + montant);
		compteRepository.save(c);
		
	}

	@Override
	public void retrait(Operation o, String numCompte,int idhisto, double montant) {
		Compte c=compteRepository.findByNumCompte(numCompte);
		Historique h = historiqueRepository.findById(idhisto).get();
		if ( c.getSolde() < montant ){
            throw new RuntimeException( "Solde insuffisant !" );
		}
		o.setCompte(c);
		o.setHistorique(h);
		o.setMontant(montant);
		operationRepository.save(o);
		c.setSolde(c.getSolde() - montant);
		compteRepository.save(c);
		
	}

	@Override
	public void virement(Operation o, String numCompte1, String numCompte2,int idhisto, double montant) {
		Compte c=compteRepository.findByNumCompte(numCompte1);
		Historique h = historiqueRepository.findById(idhisto).get();
		retrait(o, numCompte1,idhisto, montant);
		versement(o, numCompte2, idhisto, montant);
		o.setHistorique(h);
		operationRepository.save(o);
		compteRepository.save(c);
		
	}

	@Override
	public List<Operation> getOperations(String numCompte) {
		return operationRepository.listOperation(numCompte);
		
		 
	}

	@Override
	public void affectOperationToHistorique(Operation o, int idHisto) {
		Historique histo = historiqueRepository.findById(idHisto).get();
		o.setHistorique(histo);
		operationRepository.save(o);
		
	}

	

	


}
