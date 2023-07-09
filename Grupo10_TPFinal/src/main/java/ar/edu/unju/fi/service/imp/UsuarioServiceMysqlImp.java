package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;


@Service("UsuarioServiceMysqlImp")
public class UsuarioServiceMysqlImp implements IUsuarioService{
	
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	
	@Override
	public List<Usuario> getLista() {
		return usuarioRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Usuario usuario) {
		usuario.setEstado(true);
		usuarioRepository.save(usuario);
		
	}

	@Override
	public Usuario getBy(Long id) {
		return usuarioRepository.findById(id).get();
	}



	
	

}
