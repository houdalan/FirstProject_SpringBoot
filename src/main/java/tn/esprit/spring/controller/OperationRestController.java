package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Operation;
import tn.esprit.spring.service.OperationService;

@RestController
public class OperationRestController {

	@Autowired
    OperationService operationService;
	
	// URL : http://localhost:8081/SpringMVC/servlet/versementByNum/{numCompte}/{montant}/{idh}
	  @PostMapping("/versementByNum/{numCompte}/{montant}/{idh}")
	  public void versementByNum(@PathVariable("numCompte")String numCompte,@PathVariable("idh")int HistoId,
			  @PathVariable("montant")double montant, @RequestBody Operation o) {
			operationService.versement(o, numCompte, HistoId, montant);
		}
	  
	// URL : http://localhost:8081/SpringMVC/servlet/retraitByNum/{numCompte}/{montant}/{idh}
		  @PostMapping("/retraitByNum/{numCompte}/{montant}/{idh}")
		  public void retraitByNum(@PathVariable("numCompte")String numCompte, @PathVariable("idh")int HistoId,
				  @PathVariable("montant")double montant, @RequestBody Operation o) {
				operationService.retrait(o, numCompte,HistoId, montant);
			}
		  
	// URL : http://localhost:8081/SpringMVC/servlet/virementByNum/{numCompte1}/{numCompte2}/{montant}/{idh}
		  @PostMapping("/virementByNum/{numCompte1}/{numCompte2}/{montant}/{idh}")
		  public void virementByNum(@PathVariable("numCompte1")String numCompte1,
				  @PathVariable("numCompte2")String numCompte2, 
				  @PathVariable("montant")double montant,@PathVariable("idh")int HistoId, 
				  @RequestBody Operation o) {
				operationService.virement(o, numCompte1, numCompte2,HistoId, montant);
			}

	
	// URL : http://localhost:8081/SpringMVC/servlet/deleteOperationById/1
	    @DeleteMapping("/deleteOperationById/{compteId}")  
		public void deleteOperationById(@PathVariable("compteId")Long numOp) {
	    	operationService.deleteOperation(numOp);
		}
	  
		
	// URL : http://localhost:8081/SpringMVC/servlet/getOperationById/{operationId}
		  @GetMapping("/getOperationById/{operationId}")
		  public Operation getOperationById(@PathVariable("operationId")Long numOp) {
			   return operationService.consulterOperation(numOp);
				 
			}
		  
	// URL : http://localhost:8081/SpringMVC/servlet/getOperations/{numCompte}
		  @GetMapping("/getOperations/{numCompte}")
		  public List<Operation> getOperations(@PathVariable("numCompte") String numCompte) {
			   return operationService.getOperations(numCompte);
				 
			}
		  
	// http://localhost:8081/SpringMVC/servlet/affecterOperationAHistorique/6
		  @PostMapping("/affecterOperationAHistorique/{idhisto}") 
			public void affecterOperationAHistorique(@PathVariable("idhisto")int historiqueId, @RequestBody Operation o ){
			   operationService.affectOperationToHistorique(o, historiqueId);
			}	  
		   
		   
		  
	
}
