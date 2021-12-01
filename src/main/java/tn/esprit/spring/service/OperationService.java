package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.entities.OType;
import tn.esprit.spring.entities.Operation;

public interface OperationService {
	void deleteOperation(Long numOp);
	Operation consulterOperation(Long numOp);
	public void versement(Operation o, String numCompte , int idhisto, double montant);
	public void retrait(Operation o, String numCompte,int idhisto, double montant);
	public void virement(Operation o, String numCompte1, String numCompte2,int idhisto, double montant);
	List <Operation> getOperations(String numCompte);
	public void affectOperationToHistorique(Operation o, int idHisto);

	
}
