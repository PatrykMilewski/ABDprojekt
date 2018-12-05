package com.abd.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RozmowaRepo extends CrudRepository<Rozmowa, Long> {

	@Query("select r from Rozmowa r where r.id = :id")
	Optional<Rozmowa> findRozmowaById(@Param("id") Long id);
	
	@Query("select r from Rozmowa r")
	List<Rozmowa> findAllRozmowa();
	
	@Query("select r.id as id, r.t as t, r.d as d from Rozmowa r, Uzytkownik u, PozycjaRozmowy pr where pr.fkIdUzytk = u.id "
			+ "AND pr.fkIdRozmowa = r.id AND u.id = :id")
	List<String> findRozmowyForUser(@Param("id") Long id);

}