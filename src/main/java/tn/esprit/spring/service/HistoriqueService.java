package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.entities.Historique;

public interface HistoriqueService {
	public int addHistorique(Historique c);
	void deleteHistorique(int id);
	Historique consulterHistorique(int id);
	public List<Historique> getAllHistoriqueByDate(String dateHistorique);
	
	
	 

}
