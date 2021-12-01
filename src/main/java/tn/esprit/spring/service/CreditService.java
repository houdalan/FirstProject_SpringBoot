package tn.esprit.spring.service;


import java.util.List;


import tn.esprit.spring.entities.Credit;

public interface CreditService {
	List<Credit> retrieveAllCredit();
	Credit affectCreditClient(Long idc, String cin);
	void deleteCredit(Long refCredite);
	Credit retrieveCredit(Long refCredit);
	double calculeMensualite(Credit c,double montant,int duree, double taux);

}
