package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CreditRepository;

@Service
public class CreditServiceImpl implements CreditService{

	@Autowired
	private CreditRepository creditRepository;
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void deleteCredit(Long refCredit) {
		Credit c= creditRepository.findById(refCredit).get();
		creditRepository.delete(c);
		
	}

	@Override
	public Credit retrieveCredit(Long refCredit) {
		Credit c=creditRepository.findById(refCredit).get();
		return c;
	}

	@Override
	public List<Credit> retrieveAllCredit() {
		List<Credit> credits=(List<Credit>) creditRepository.findAll();
		return credits;
	}

	@Override
	public double calculeMensualite(Credit c ,double montant, int duree, double taux) {
		double t=taux/100;
		double t1=montant*t/12;
		double t2=1-Math.pow(1+t/12,-1*duree);
		double res = t1/t2;
		c.setMensualite(res);
		c.setMontant(montant);
		c.setDuree(duree);
		c.setTaux(taux);
		creditRepository.save(c);
	    return t1/t2;
		
	}

	@Override
	public Credit affectCreditClient(Long idc, String cin) {
		 Client client = clientRepository.findByCin(cin);
		 Credit credit = creditRepository.findById(idc).get();
		 credit.setClient(client);
		 creditRepository.save(credit);
		 return credit;
		
		
	}

}
