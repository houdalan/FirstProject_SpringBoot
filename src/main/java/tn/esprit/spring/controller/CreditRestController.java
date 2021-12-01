package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Credit;
import tn.esprit.spring.service.CreditService;

@RestController
public class CreditRestController {
	@Autowired
    CreditService creditService;
	
	// URL : http://localhost:8081/SpringMVC/servlet/getAllCredits
    @GetMapping("/getAllCredits")
    public List<Credit> getCredits() {			
		return creditService.retrieveAllCredit();
	}
	
	
		
	// URL : http://localhost:8081/SpringMVC/servlet/affectCreditClient/{idc}/{cin}
		@PostMapping("/affectCreditClient/{idc}/{cin}")
		public void affectCreditClient(@PathVariable("cin") String cin, @PathVariable("idc") Long CreditId,
				@RequestBody Credit c){
			creditService.affectCreditClient(CreditId, cin);
			}
		
	// URL : http://localhost:8081/SpringMVC/servlet/getCreditById/{creditId}
		   @GetMapping("/getCreditById/{creditId}")
		   public Credit getCompteById(@PathVariable("creditId")Long refCredit) {
				return creditService.retrieveCredit(refCredit);
			}
		   
	// URL : http://localhost:8081/SpringMVC/servlet/deleteCreditById/1
		    @DeleteMapping("/deleteCreditById/{creditId}")  
			public void deleteUserById(@PathVariable("creditId")Long refCredit) {
		    	creditService.deleteCredit(refCredit);
			}
			
			
	// URL : http://localhost:8081/SpringMVC/servlet/simulationc/{capital}/{duree}/{taux}
			 @PostMapping("/simulationc/{capital}/{duree}/{taux}") 
			 public double simulationc(@RequestBody Credit c, @PathVariable("capital") double capital ,@PathVariable("duree") int duree, @PathVariable("taux") double taux){
			 double res=creditService.calculeMensualite(c, capital, duree, taux);
			 return res;
			 
           }
}

