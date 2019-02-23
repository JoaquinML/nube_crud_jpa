package mx.uady.jpademo.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;



public class UsuarioRequest{

  @NotNull
  @Min(value=0)
  @Max(value=100)
  private Integer id;

  @NotBlank
  @Size(min=3, max=255)
  private String usuario;

  public UsuarioRequest(){

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
	* Returns value of usuario
	* @return
	*/
	public String getUsuario() {
		return usuario;
	}

	/**
	* Sets new value of usuario
	* @param
	*/
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
