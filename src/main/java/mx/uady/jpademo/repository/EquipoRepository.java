package mx.uady.jpademo.repository;

import mx.uady.jpademo.model.Equipo;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer> {

}
