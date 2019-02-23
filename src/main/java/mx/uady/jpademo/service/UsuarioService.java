package mx.uady.jpademo.service;

import mx.uady.jpademo.request.UsuarioRequest;
import mx.uady.jpademo.exception.RecursoNoEncontradoException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import mx.uady.jpademo.repository.UsuarioRepository;
import mx.uady.jpademo.exception.RecursoExistenteException;
import mx.uady.jpademo.model.Alumno;
import mx.uady.jpademo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService{

  @Autowired
  private UsuarioRepository usuarioRepository;

  public List<Usuario> getUsuarios(){
    List<Usuario> usuarios = new LinkedList<>();

    usuarioRepository.findAll().iterator().forEachRemaining(usuarios::add);
    return usuarios;
  }

  public Usuario getUsuario(Integer id){
    boolean existeUsuario = usuarioRepository.existsById(id);
    if (!existeUsuario) {
      throw new RecursoNoEncontradoException("usuario");
    }

    return usuarioRepository.findById(id).get();
  }

  public Usuario saveUsuario(Alumno usuario){
    boolean existeUsuario = usuarioRepository.existsById(usuario.getId());

    if (existeUsuario) {
      throw new RecursoExistenteException("Usuario");
    }

    Usuario savedUsuario = new Usuario();
    savedUsuario.setId(usuario.getId());
    savedUsuario.setUsuario(usuario.getNombre().toLowerCase() + "@uady.mx");



    return usuarioRepository.save(savedUsuario);
  }

  public void eliminarUsuario(Usuario usuario){
    usuarioRepository.delete(usuario);
  }

  public Usuario editarUsuario(UsuarioRequest request){
    Usuario changedUsuario = getUsuario(request.getId());

    changedUsuario.setUsuario(request.getUsuario());

    return usuarioRepository.save(changedUsuario);
  }
}
