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

import mx.uady.jpademo.model.Equipo;
import mx.uady.jpademo.request.EquipoRequest;
import mx.uady.jpademo.service.EquipoService;

@RestController
public class EquipoResource {
    @Autowired
    private EquipoService equipoService;

    private final Logger LOG = LoggerFactory.getLogger(EquipoResource.class);

    @PostMapping("/equipos")
    public ResponseEntity<Equipo> guardarEquipo(@RequestBody @Valid EquipoRequest request)
     throws URISyntaxException {
       LOG.debug("Llamada a agregar equipo request: {}", request);
        Equipo equipo = equipoService.guardarEquipo(request);
        URI location = new URI("/equipos/" + equipo.getId());
        ResponseEntity<Equipo> response =  ResponseEntity.created(location).body(equipo);
        return response;
    }

    @GetMapping("/equipos")
    public ResponseEntity<List<Equipo>> equipos(){
        LOG.debug("Llamada a obtener una lista de equipos");
        List<Equipo> equipos = equipoService.equipos();
        ResponseEntity<List<Equipo>> response = ResponseEntity.ok().body(equipos);
        return response;
    }

    @GetMapping("/equipos/{id}")
    public ResponseEntity<Equipo> getEquipo(@PathVariable Integer id){
        LOG.debug("Llamada a obtener el equipo id: {}", id);
        Equipo equipo = equipoService.getEquipo(id);
        return ResponseEntity.ok().body(equipo);
    }

    @DeleteMapping("/equipo/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Integer id){
        LOG.debug("Llamada a eliminar equipo id: {}", id);
        Equipo equipo = equipoService.getEquipo(id);
        equipoService.eliminarEquipo(equipo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/equipo")
    public ResponseEntity<Equipo> editarEquipo(@RequestBody @Valid EquipoRequest request){
        LOG.debug("Llamada a editar el equipo request: {}", request);
        Equipo equipo =  equipoService.editarEquipo(request);
        return ResponseEntity.ok().body(equipo);
    }

}
