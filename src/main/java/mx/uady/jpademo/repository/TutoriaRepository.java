package mx.uady.jpademo.repository;

import mx.uady.jpademo.model.Tutoria.TutoriaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.jpademo.model.Tutoria;;

@Repository
public interface TutoriaRepository extends CrudRepository<Tutoria, TutoriaId> {

}
