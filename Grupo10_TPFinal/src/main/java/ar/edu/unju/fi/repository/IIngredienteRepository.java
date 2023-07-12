package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Ingrediente;

/**
 * Repositorio para la entidad Ingrediente.
 * @author Naima Farja
 */
public interface IIngredienteRepository extends CrudRepository<Ingrediente, Long>{

    /**
     * Recupera una lista de ingredientes por estado.
     * 
     * @param estado el estado del ingrediente
     * @return una lista de ingredientes que coinciden con el estado especificado
     */
    public List<Ingrediente> findByEstado(boolean estado);
}