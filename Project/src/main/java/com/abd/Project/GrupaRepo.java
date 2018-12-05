package com.abd.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GrupaRepo extends CrudRepository<Grupa, Long> {

	@Query("select g from Uzytkownik u, Grupa g, PozycjaGrupy pg where pg.fkIdGrupa = g.id and u.id = pg.fkIdUzytk and u.id = :id")
	List<Grupa> findGroupsForUser(@Param("id") Long id);
	
	@Query("select g.nazwa, count(u.nazwisko) as liczba from Grupa g, Uzytkownik u, PozycjaGrupy pg where pg.fkIdUzytk = u.id " + 
			"and pg.fkIdGrupa = g.id group by g.nazwa")
	 List<Object> countMembers();

}

