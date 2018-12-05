package com.abd.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface ZadanieRepo extends CrudRepository<Zadanie, Long> {

	@Query("select z from Zadanie z where z.id = :id")
	Optional<Zadanie> findById(@Param("id") Long id);
	
//	@Query("select z "
//			+ "from Zadanie z, Harmonogram h, PozycjaHarmonogramu pg, Uzytkownik u \r\n" + 
//			"where h.FK_ID_UZYTK = u.id and h.id = pg.fkIdHarm and pg.fkIdZad = z.id and u.id = :id")
//	List<Zadanie> findForUsr(@Param("id") Long id);
	
	@Query("select z "
			+ "from Zadanie z, Harmonogram h, PozycjaHarmonogramu pg, Uzytkownik u \r\n" + 
			"where h.FK_ID_UZYTK = u.id and h.id = pg.fkIdHarm and pg.fkIdZad = z.id and u.id = :id")
	List<Zadanie> findForUsr(@Param("id") Long id);

}
