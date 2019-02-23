package mx.uady.jpademo.resource;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.jpademo.model.Profesor;
import mx.uady.jpademo.request.ProfesorRequest;
import mx.uady.jpademo.service.ProfesorService;

@RestController
public class ProfesorResource {

    @Autowired
    private ProfesorService profesorService;

    private final Logger LOG = LoggerFactory.getLogger(ProfesorResource.class);

    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> getProfesores() {
        LOG.debug("Llamada a obtener la lista de profesores.");
        List<Profesor> profesores = profesorService.getProfesores();
        ResponseEntity<List<Profesor>> response = ResponseEntity.ok().body(profesores);
        return response;
    }

    @GetMapping("/profesores/{id}")
    public ResponseEntity<Profesor> getProfesor(@PathVariable Integer id) {
        LOG.debug("Llamada a obtener el profesor id: {}", id);
        Profesor profesor = profesorService.getProfesor(id);
        return ResponseEntity.ok().body(profesor);
    }

    @PostMapping("/profesores")
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody @Valid ProfesorRequest request)
            throws URISyntaxException {

        LOG.debug("Llamada a agregar el profesor request: {}", request);
        Profesor profesor  = profesorService.guardarProfesor(request);
        URI location = new URI("/profesores/" + profesor.getId());
        ResponseEntity<Profesor> response = ResponseEntity.created(location).body(profesor);
        return response;
    }

    @DeleteMapping("/profesores/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id){
        LOG.debug("Llamada a eliminar profesor id: {}", id);
        Profesor profesor = profesorService.getProfesor(id);
        profesorService.eliminarProfesor(profesor);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/proesores")
    public ResponseEntity<Profesor> editarProfesor(@RequestBody @Valid ProfesorRequest request){
        LOG.debug("Llamada a editar el profesor, request: {}", request);
        Profesor profesor = profesorService.editarProfesor(request);
        return ResponseEntity.ok().body(profesor);
    }

}
