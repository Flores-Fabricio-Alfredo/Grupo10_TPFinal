package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;

public interface IIngredienteService {
	
	List<Ingrediente> getListaingrediente();

	void guardar(Ingrediente ingred);

	Ingrediente getBy(Long id);

	void eliminar(Ingrediente ingredienteEncontrado);

	Ingrediente getIngrediente();
}