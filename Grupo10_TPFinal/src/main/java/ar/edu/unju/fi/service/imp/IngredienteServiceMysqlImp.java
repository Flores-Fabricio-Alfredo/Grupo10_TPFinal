package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

import jakarta.validation.Valid;

@Service("ingredienteServiceMysqlImp")
public class IngredienteServiceMysqlImp implements IIngredienteService{
	
	@Autowired
	private IIngredienteRepository ingredienteRepository;
	
	@Autowired
	private Ingrediente ingrediente;
	
	@Override
	public List<Ingrediente>getAllIgredientes(){
		List<Ingrediente> ingredientes = (List<Ingrediente>) ingredienteRepository.findAll();
		return ingredientes;
	}
	
	@Override
	public void guardar (@Valid Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}
	
	@Override
	public Ingrediente getBy(Long id) {
		ingrediente =  ingredienteRepository.findById(id).get();
		return ingrediente;
	}
	@Override
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
}