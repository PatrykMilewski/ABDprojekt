package com.abd.Project;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HarmonogramRepo extends CrudRepository<Harmonogram, Long> {

	@Query("select h from Harmonogram h where h.FK_ID_UZYTK = :ID_UZYTK")
	List<Harmonogram> findForUserById(@Param("ID_UZYTK") Long id);

}