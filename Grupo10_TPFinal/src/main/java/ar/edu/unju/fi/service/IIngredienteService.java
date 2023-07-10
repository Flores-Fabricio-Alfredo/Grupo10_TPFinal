package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Ingrediente;
import jakarta.validation.Valid;

public interface IIngredienteService{
	
	public void guardar (@Valid Ingrediente ingrediente);
	
	Ingrediente getBy(Long id);
	
	public Ingrediente getIngrediente();

	List<Ingrediente> getAllIgredientes();

}