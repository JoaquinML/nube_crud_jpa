package mx.uady.jpademo.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import mx.uady.jpademo.model.Equipo;
import mx.uady.jpademo.model.Usuario;
import mx.uady.jpademo.model.Tutoria;
import java.util.Set;

public class AlumnoRequest{
  @NotNull
  @Min(value=0)
  @Max(value=100)
  private Integer id;

  @NotBlank
  @Size(min=3, max=255)
  private String nombre;

  private Equipo equipoId;

  private Usuario usuarioId;

  private Set<Tutoria> tutorias;

  public AlumnoRequest(){

  }


	/**
	* Returns value of id
	* @return
	*/
	public Integer getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	* Returns value of nombre
	* @return
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* Sets new value of nombre
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Returns value of equipoId
	* @return
	*/
	public Equipo getEquipoId() {
		return equipoId;
	}

	/**
	* Sets new value of equipoId
	* @param
	*/
	public void setEquipoId(Equipo equipoId) {
		this.equipoId = equipoId;
	}

	/**
	* Returns value of usuarioId
	* @return
	*/
	public Usuario getUsuarioId() {
		return usuarioId;
	}

	/**
	* Sets new value of usuarioId
	* @param
	*/
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	* Returns value of tutorias
	* @return
	*/
	public Set<Tutoria> getTutorias() {
		return tutorias;
	}

	/**
	* Sets new value of tutorias
	* @param
	*/
	public void setTutorias(Set<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}
}
