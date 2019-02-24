package mx.uady.jpademo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -6935809960328059065L;

	public RecursoNoEncontradoException(String recurso) {
		super("El recurso "+ recurso +" no se encuentra en el sistema.");
	}

}
