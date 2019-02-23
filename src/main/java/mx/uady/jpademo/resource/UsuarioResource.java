package mx.uady.jpademo.resource;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import mx.uady.jpademo.request.UsuarioRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import mx.uady.jpademo.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import mx.uady.jpademo.service.UsuarioService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioResource{

  @Autowired
  private UsuarioService usuarioService;

  private final Logger LOG = LoggerFactory.getLogger(UsuarioResource.class);

  @GetMapping("/usuarios")
  public ResponseEntity<List<Usuario>> getUsuarios(){
    LOG.debug("Llamada a obtener la lista de usuarios.");
    List<Usuario> usuarios = usuarioService.getUsuarios();
    ResponseEntity<List<Usuario>> response = ResponseEntity.ok().body(usuarios);
    return response;
  }

  @GetMapping("/usuarios/{id}")
  public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id){
    LOG.debug("Llamada a obtener el usuario, id: {}", id);
    Usuario usuario = usuarioService.getUsuario(id);
    return ResponseEntity.ok().body(usuario);
  }

  @DeleteMapping("/usuarios/{id}")
  public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id){
    LOG.debug("Llamada a eliminar el usuario, id: {}", id);
    Usuario usuario = usuarioService.getUsuario(id);
    usuarioService.eliminarUsuario(usuario);

    return ResponseEntity.ok().build();

  }

  @PutMapping("/usuarios")
  public ResponseEntity<Usuario> editarUsuario(@RequestBody @Valid UsuarioRequest request){
    LOG.debug("Llamada a editaar el usuario, request: {}", request);
    Usuario usuario = usuarioService.editarUsuario(request);
    return ResponseEntity.ok().body(usuario);
  }

}
