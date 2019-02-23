package mx.uady.jpademo.service;

import mx.uady.jpademo.exception.RecursoNoEncontradoException;
import java.util.LinkedList;
import java.util.List;
import mx.uady.jpademo.model.Profesor;
import mx.uady.jpademo.model.Alumno;
import mx.uady.jpademo.exception.RecursoExistenteException;
import mx.uady.jpademo.request.TutoriaRequest;
import mx.uady.jpademo.model.Tutoria;
import mx.uady.jpademo.repository.TutoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutoriaService{

  @Autowired
  private TutoriaRepository tutoriaRepository;
  @Autowired
  private AlumnoService alumnoService;
  @Autowired
  private ProfesorService profesorService;

  public List<Tutoria> getTutorias(){
    List<Tutoria> tutorias = new LinkedList<>();
    tutoriaRepository.findAll().iterator().forEachRemaining(tutorias::add);
    return tutorias;
  }

  public Tutoria guardarTutoria(TutoriaRequest request){
    boolean existeTutoria = tutoriaRepository.existsById(request.getId());

    if (existeTutoria) {
      throw new RecursoExistenteException("tutoria");
    }

    alumnoService.getAlumno(request.getId().getAlumnoId());
    profesorService.getProfesor(request.getId().getProfesorId());

    Tutoria tutoria = new Tutoria();
    tutoria.setId(request.getId());
    tutoria.setHoras(request.getHoras());

    return tutoriaRepository.save(tutoria);
  }

  public Tutoria editarTutoria(TutoriaRequest request){
    boolean existeTutoria = tutoriaRepository.existsById(request.getId());

    if (!existeTutoria) {
      throw new RecursoNoEncontradoException("tutoria");
    }

    Tutoria changedTutoria = tutoriaRepository.findById(request.getId()).get();

    changedTutoria.setHoras(request.getHoras());

    return tutoriaRepository.save(changedTutoria);


  }

  public void eliminarTutoria(Tutoria tutoria){
    tutoriaRepository.delete(tutoria);
  }

}
