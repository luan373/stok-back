package br.com.bg.stok.rest.util;

import br.com.bg.stok.orm.model.Usuario;
import br.com.bg.stok.rest.exception.MyResourceNotFoundException;

public class RestPreconditions {
	public static <T> T checkFound(T resource) throws MyResourceNotFoundException {
		if (resource == null) {
			throw new MyResourceNotFoundException();
		}
		return resource;
	}

	public static void checkNotNull(Usuario findById) {
		
	}
}