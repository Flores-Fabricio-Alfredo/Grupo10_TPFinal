package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.entity.*;

/**
 * Interfaz que define el repositorio para la entidad IndiceMasaCorporal.
 * Extiende la interfaz CrudRepository proporcionada por Spring Data JPA.
 * Proporciona métodos para realizar operaciones CRUD en la tabla 'IndiceMasaCorporal' en la base de datos.
 */
public interface IIndiceMasaCorporalRepository extends CrudRepository<IndiceMasaCorporal, Long>{

	 /**
     * Método para buscar Índices de Masa Corporal por estado.
     *
     * @param estado El estado a buscar.
     * @return Una lista de Índices de Masa Corporal con el estado especificado.
     */
	public List<IndiceMasaCorporal> findByEstado(boolean estado);
}

