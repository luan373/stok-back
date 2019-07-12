package br.com.bg.stok.rest.util;

import br.com.bg.stok.orm.model.Usuario;
import br.com.bg.stok.rest.exception.NotFoundException;

public class RestPreconditions {
	public static <T> T checkFound(T resource) throws NotFoundException {
		if (resource == null) {
			throw new NotFoundException();
		}
		return resource;
	}

	public static void checkNotNull(Usuario findById) {
		
	}
}