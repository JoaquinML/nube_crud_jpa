package mx.uady.jpademo.service;

import mx.uady.jpademo.model.Equipo;
import mx.uady.jpademo.model.Usuario;
import mx.uady.jpademo.exception.RecursoExistenteException;
import mx.uady.jpademo.exception.RecursoNoEncontradoException;
import mx.uady.jpademo.request.AlumnoRequest;
import java.util.LinkedList;
import mx.uady.jpademo.model.Alumno;
import java.util.List;
import mx.uady.jpademo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService{

  @Autowired
  private AlumnoRepository alumnoRepository;

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private EquipoService equipoService;

  public List<Alumno> getAlumnos(){
    List<Alumno> alumnos = new LinkedList<>();
    alumnoRepository.findAll().iterator().forEachRemaining(alumnos::add);
    return alumnos;
  }

  public Alumno getAlumno(Integer id){
    boolean existeAlumno = alumnoRepository.existsById(id);
    if (!existeAlumno) {
      throw new RecursoNoEncontradoException("alumno");
    }

    return alumnoRepository.findById(id).get();
  }

  public Alumno saveAlumno(AlumnoRequest request){
    boolean existeAlumno = alumnoRepository.existsById(request.getId());

    if (existeAlumno) {
      throw new RecursoExistenteException("alumno");
    }

    Alumno savedAlumno = new Alumno();
    savedAlumno.setId(request.getId());
    savedAlumno.setNombre(request.getNombre());
    savedAlumno.setEquipoId(request.getEquipoId());
    savedAlumno.setTutorias(request.getTutorias());
    savedAlumno.setUsuarioId(request.getUsuarioId());

    Usuario usuario = usuarioService.saveUsuario(savedAlumno);
    savedAlumno.setUsuarioId(usuario);

    return alumnoRepository.save(savedAlumno);
  }

  public void eliminarAlumno(Alumno alumno){
    alumnoRepository.delete(alumno);
  }

  public Alumno editarAlumno(AlumnoRequest request){
    Alumno changedAlumno = getAlumno(request.getId());

    changedAlumno.setNombre(request.getNombre());
    changedAlumno.setEquipoId(request.getEquipoId());
    changedAlumno.setUsuarioId(request.getUsuarioId());
    changedAlumno.setTutorias(request.getTutorias());


    return alumnoRepository.save(changedAlumno);

  }

  public Alumno agregarEquipo(Integer idAlumno, Integer idEquipo){
    Alumno alumno = getAlumno(idAlumno);
    Equipo equipo = equipoService.getEquipo(idEquipo);

    /*
    if (!(alumno.getEquipoId() == null)) {
      throw new RecursoExistenteException("alumno-equipo");
    }
    */
    alumno.setEquipoId(equipo);
    return alumnoRepository.save(alumno);

  }

}
