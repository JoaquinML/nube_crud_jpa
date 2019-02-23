package mx.uady.jpademo.resource;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import java.net.URISyntaxException;
import mx.uady.jpademo.request.TutoriaRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import mx.uady.jpademo.service.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import java.net.URI;
import mx.uady.jpademo.model.Tutoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutoriaResource{
  @Autowired
  private TutoriaService tutoriaService;

  private final Logger LOG = LoggerFactory.getLogger(TutoriaResource.class);

  @GetMapping("/tutorias")
  public ResponseEntity<List<Tutoria>> getTutorias(){
    LOG.debug("Llamada a obtener la lista de tutorias.");
    List<Tutoria> tutorias = tutoriaService.getTutorias();
    ResponseEntity<List<Tutoria>> response = ResponseEntity.ok().body(tutorias);
    return response;
  }

  @PostMapping("/tutorias")
  public ResponseEntity<Tutoria> guardarTutoria(@RequestBody @Valid TutoriaRequest request) throws URISyntaxException{
    LOG.debug("Llamada a agregar la tutoria, request: {}", request);
    Tutoria tutoria = tutoriaService.guardarTutoria(request);
    URI location = new URI("/tutorias/"+ tutoria.getId());
    ResponseEntity<Tutoria> response = ResponseEntity.created(location).body(tutoria);
    return response;
  }

  @PutMapping("/tutorias")
  public ResponseEntity<Tutoria> editarTutoria(@RequestBody @Valid TutoriaRequest request){
    LOG.debug("Llamada a editar la tutoria, request: {}", request);
    Tutoria tutoria = tutoriaService.editarTutoria(request);
    return ResponseEntity.ok().body(tutoria);
  }
}
