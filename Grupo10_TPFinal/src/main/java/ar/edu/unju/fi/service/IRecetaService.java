package ar.edu.unju.fi.service;
import java.util.List;

import ar.edu.unju.fi.entity.Receta;

/**
 * @author Naima Farja
 * Interfaz de servicio para la entidad Receta.
 */
public interface IRecetaService {

    /**
     * Obtiene la lista de todas las recetas.
     * 
     * @return una lista de todas las recetas
     */
    List<Receta> getLista();

    /**
     * Guarda una receta.
     * 
     * @param receta la receta a guardar
     */
    void guardar(Receta receta);

    /**
     * Obtiene una receta por su ID.
     * 
     * @param id el ID de la receta
     * @return la receta encontrada o null si no se encuentra ninguna receta con el ID dado
     */
    Receta getBy(Long id);

    /**
     * Obtiene la lista de recetas por categoría.
     * 
     * @param categoria la categoría de las recetas
     * @return una lista de recetas que pertenecen a la categoría especificada
     */
    List<Receta> getListaCategoria(String categoria);

    /**
     * Elimina una receta.
     * 
     * @param recetaEncontrada la receta a eliminar
     */
    void eliminar(Receta recetaEncontrada);

    /**
     * Obtiene una instancia vacía de la entidad Receta.
     * 
     * @return una nueva instancia de Receta sin inicializar sus propiedades
     */
    Receta getReceta();
}