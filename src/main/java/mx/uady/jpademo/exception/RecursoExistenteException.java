package mx.uady.jpademo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecursoExistenteException extends RuntimeException{
	
	private static final long serialVersionUID = -5672720626654386590L;

	public RecursoExistenteException(String recurso) {
		super("El recurso " + recurso + " ya existe en el sistema.");
	}
}
