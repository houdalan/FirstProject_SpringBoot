package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Compte;
import tn.esprit.spring.entities.Type;
import tn.esprit.spring.service.CompteService;


@RestController
public class CompteRestController {
	@Autowired
    CompteService compteService;
	
	// URL : http://localhost:8081/SpringMVC/servlet/getAllComptes
    @GetMapping(value = "getAllComptes")
    public List<Compte> getComptes() {			
		return compteService.retrieveAllComptes();
	}
	
	// URL : http://localhost:8081/SpringMVC/servlet/addCompte
		@PostMapping("/addCompte")
		public Compte addCompte(@RequestBody Compte c){
			compteService.addCompte(c);
			return c;
			}
	
	// URL : http://localhost:8081/SpringMVC/servlet/getCompteById/{compteId}
		   @GetMapping(value = "getCompteById/{compteId}")
		   public Compte getCompteById(@PathVariable("compteId")String numCompte) {
				return compteService.retrieveCompte(numCompte);
			}
		   
	// URL : http://localhost:8081/SpringMVC/servlet/deleteCompteById/1
		    @DeleteMapping("/deleteCompteById/{compteId}")  
			public void deleteCompteById(@PathVariable("compteId")String numCompte) {
		    	compteService.deleteCompte(numCompte);
			}
		    
			
	// URL : http://localhost:8081/SpringMVC/servlet/affectCompteClientBanque/{cin}/{id}
			@PostMapping("/affectCompteClientBanque/{cin}/{id}")
			public void affectCompteClientBanque(@PathVariable("cin") String cin,@PathVariable("id") int bq, @RequestBody Compte c){
				compteService.affectCompteClientBanque(c, cin, bq);
				}
			
			
}

