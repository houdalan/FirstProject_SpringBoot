package tn.esprit.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Historique;

@Repository
public interface HistoriqueRepository extends CrudRepository<Historique, Integer>{
	@Query("Select DISTINCT h from Historique h WHERE h.dateHistorique=?1")
	public List<Historique> getHistoriqueByDate(Date dateHistorique);
	

}
