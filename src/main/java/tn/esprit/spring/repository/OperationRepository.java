package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {
	@Query("select o from Operation o where o.compte.numCompte =:numCompte order by o.dateOperation desc")
	public List<Operation> listOperation(@Param("numCompte")String numCompte);
	
	

}
