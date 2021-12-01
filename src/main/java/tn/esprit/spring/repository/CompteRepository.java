package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, String> {
	Compte findByNumCompte(String numCompte);

}
