package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;
import jakarta.validation.Valid;

public interface IRecetaService {
	
	List<Receta> getLista();
	
	public void guardar (@Valid Receta receta);
	
	public Receta getBy(Long id);
	
	public void Modificar (@Valid Receta receta);
	
	public void Eliminar (Receta recetaEncontrada);
	
	public Receta getReceta();
	

}