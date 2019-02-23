package mx.uady.jpademo.resource;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import mx.uady.jpademo.service.AlumnoService;
import mx.uady.jpademo.request.AlumnoRequest;
import javax.validation.Valid;
import java.util.List;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import mx.uady.jpademo.model.Alumno;


@RestController
public class AlumnoResource{

    @Autowired
    private AlumnoService alumnoService;

    private final Logger LOG = LoggerFactory.getLogger(AlumnoResource.class);


    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        LOG.debug("Llamada a obtener alumnos");
        List<Alumno> alumnos = alumnoService.getAlumnos();
        ResponseEntity<List<Alumno>> response = ResponseEntity.ok().body(alumnos);
        return response;
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id){
      LOG.debug("Llamada a obtener alumno id: {}", id);
      Alumno alumno = alumnoService.getAlumno(id);
      return ResponseEntity.ok().body(alumno);
    }

    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> saveAlumno(@RequestBody @Valid AlumnoRequest request) throws URISyntaxException{
      LOG.debug("Llamada a agreegar alumno, request: {}", request);
      Alumno alumno = alumnoService.saveAlumno(request);
      URI location = new URI("/alumnos/" + alumno.getId());
      ResponseEntity<Alumno> response = ResponseEntity.created(location).body(alumno);
      return response;
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer id){
      LOG.debug("Llamada a eliminar alumno id: {}", id);
      Alumno alumno = alumnoService.getAlumno(id);
      alumnoService.eliminarAlumno(alumno);

      return ResponseEntity.ok().build();
    }

    @PutMapping("/alumnos")
    public ResponseEntity<Alumno> editarAlumno(@RequestBody @Valid AlumnoRequest request){
      LOG.debug("Llamada a editar alumno request: {}", request);
      Alumno alumno = alumnoService.editarAlumno(request);
      return ResponseEntity.ok().body(alumno);
    }

    @PutMapping("/alumnos/{idAlumno}/agregarEquipo/{idEquipo}")
    public ResponseEntity<Alumno> agregarEquipo(@PathVariable("idAlumno") Integer idAlumno, @PathVariable("idEquipo") Integer idEquipo){
      LOG.debug("Llamada a asignar al alumno id: {} el equipo: {}", idAlumno, idEquipo);
      Alumno alumno = alumnoService.agregarEquipo(idAlumno, idEquipo);

      return ResponseEntity.ok().body(alumno);
    }


}
