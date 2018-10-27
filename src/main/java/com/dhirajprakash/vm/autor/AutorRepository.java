package com.dhirajprakash.vm.autor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AutorRepository extends CrudRepository<Autor, Integer> {

	@Query("select max(autor.id) from Autor autor")
	Integer findMaxId();

}
