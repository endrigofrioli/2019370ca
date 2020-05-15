package ie.cct.ca;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

	/**
	 * Not Found Exception configurations
	 * 
	 */
	private static final long serialVersionUID = -5886261412400146080L;

	public NotFoundException(String msg) {
		super(msg);
		
	}

}
