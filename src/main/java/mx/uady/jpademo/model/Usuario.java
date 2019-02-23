package mx.uady.jpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private Integer id;

    @Column
    private String usuario;

    public Usuario() {
    }

    public Usuario(Integer id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario id(Integer id) {
        this.id = id;
        return this;
    }

    public Usuario usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", usuario='" + getUsuario() + "'" +
            "}";
    }


}
