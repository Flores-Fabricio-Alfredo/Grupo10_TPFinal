package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;

/**
 * @author Naima Farja
 * La interfaz IIngredienteService define los métodos para el servicio relacionado con los ingredientes.
 * Proporciona métodos para obtener la lista de ingredientes, guardar un ingrediente, buscar un ingrediente por su ID,
 * eliminar un ingrediente y obtener un ingrediente.
 */
public interface IIngredienteService {
	
    /**
     * Obtiene la lista de ingredientes.
     *
     * @return una lista de ingredientes
     */
	List<Ingrediente> getListaingrediente();
	 /**
     * Guarda un ingrediente.
     *
     * @param ingred el ingrediente a guardar
     */
    
	void guardar(Ingrediente ingred);
	   /**
     * Busca un ingrediente por su ID.
     *
     * @param id el ID del ingrediente a buscar
     * @return el ingrediente encontrado, o null si no se encuentra ningún ingrediente con el ID especificado
     */
	Ingrediente getBy(Long id);
    /**
     * Elimina un ingrediente.
     *
     * @param ingredienteEncontrado el ingrediente a eliminar
     */
	void eliminar(Ingrediente ingredienteEncontrado);

	Ingrediente getIngrediente();
}