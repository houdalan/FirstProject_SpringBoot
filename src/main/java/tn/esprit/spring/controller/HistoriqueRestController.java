package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Historique;
import tn.esprit.spring.service.HistoriqueService;

@RestController
public class HistoriqueRestController {
	@Autowired
    HistoriqueService historiqueService;
	
	// URL : http://localhost:8081/SpringMVC/servlet/addHistorique
	   @PostMapping("/addHistorique")
	   public Historique addHistorique(@RequestBody Historique histo){
		   historiqueService.addHistorique(histo);
		   return histo;
		}
	
	// http://localhost:8081/SpringMVC/servlet/getAllHistoriqueByDate/{dateHistorique}
		@GetMapping("/getAllHistoriqueByDate/{dateHistorique}")
		public List<Historique> getAllMouvementByDate(@PathVariable("dateHistorique") String dateHistorique) {
			return historiqueService.getAllHistoriqueByDate(dateHistorique);
		}

}
