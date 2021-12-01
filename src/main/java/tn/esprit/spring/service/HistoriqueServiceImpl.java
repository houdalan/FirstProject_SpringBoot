package tn.esprit.spring.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.entities.Historique;
import tn.esprit.spring.repository.HistoriqueRepository;


@Service
public class HistoriqueServiceImpl implements HistoriqueService{
	
	@Autowired
	private HistoriqueRepository historiqueRepository;

	@Override
	public int addHistorique(Historique c) {
		historiqueRepository.save(c);
		return c.getId();
	}

	@Override
	public void deleteHistorique(int id) {
		Historique histo = historiqueRepository.findById(id).get();
		historiqueRepository.delete(histo);
		
	}

	@Override
	public Historique consulterHistorique(int id) {
		Historique histo =historiqueRepository.findById(id).get();
		return histo;
	}

	@Override
	public List<Historique> getAllHistoriqueByDate(String dateHistorique) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = dateFormat.parse(dateHistorique);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return historiqueRepository.getHistoriqueByDate(d);
	}
	

}
