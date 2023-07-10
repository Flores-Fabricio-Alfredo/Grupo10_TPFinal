package ar.edu.unju.fi.service;

import java.util.List;


import ar.edu.unju.fi.entity.Usuario;
import jakarta.validation.Valid;


public interface IUsuarioService {

	List<Usuario>getLista();
	
	void guardar (@Valid Usuario usuario);
	
	Usuario getBy(Long id);

	
}
