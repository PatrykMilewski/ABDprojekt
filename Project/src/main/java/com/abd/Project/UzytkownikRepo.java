package com.abd.Project;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UzytkownikRepo extends CrudRepository<Uzytkownik, Long> {

	@Query("select z from Uzytkownik z where z.id = :id")
	Optional<Uzytkownik> findById(@Param("id") Long id);


}