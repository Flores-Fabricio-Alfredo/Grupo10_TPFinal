package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

@Service("ingredienteServiceMysqlImp")
public class IngredienteServiceMysqlImp implements IIngredienteService {
	@Autowired
	Ingrediente ingrediente;
	@Autowired
	IIngredienteRepository ingredienteRepository;
	
	@Override
	public List<Ingrediente> getListaingrediente() {
		return ingredienteRepository.findByEstado(true);
	}

	@Override
	public void guardar(Ingrediente ingrediente) {
		ingrediente.setEstado(true);
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public Ingrediente getBy(Long id) {
		return ingredienteRepository.findById(id).get();
	}

	@Override
	public void eliminar(Ingrediente ingredienteEncontrado) {
		ingredienteEncontrado.setEstado(false);
		ingredienteRepository.save(ingredienteEncontrado);
		
	}

	@Override
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
}