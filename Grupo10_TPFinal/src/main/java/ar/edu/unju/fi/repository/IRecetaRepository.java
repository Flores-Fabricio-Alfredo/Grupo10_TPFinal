package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Receta;

/**
 * @author Naima Farja
 * IRecetaRepository es una interfaz que extiende CrudRepository para proporcionar métodos de acceso a datos para la entidad Receta.
 * Proporciona métodos para buscar recetas por estado y por categoría.
 */
@Repository
public interface IRecetaRepository extends CrudRepository<Receta, Long> {

    /**
     * Busca recetas por estado.
     *
     * @param estado el estado de las recetas a buscar
     * @return una lista de recetas que cumplen con el estado especificado
     */
    public List<Receta> findByEstado(boolean estado);

    /**
     * Busca recetas por categoría.
     *
     * @param categoria la categoría de las recetas a buscar
     * @return una lista de recetas que pertenecen a la categoría especificada
     */
    public List<Receta> findByCategoria(String categoria);

}