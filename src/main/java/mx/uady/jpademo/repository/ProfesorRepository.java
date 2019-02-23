package mx.uady.jpademo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.jpademo.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {

}
