package br.com.bg.stok.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -900213007251793022L;

}
