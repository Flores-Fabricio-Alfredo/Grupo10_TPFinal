package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

/**
 * @author Naima Farja
 * Implementación del servicio para la entidad Ingrediente que utiliza MySQL como fuente de datos.
 */
@Service("ingredienteServiceMysqlImp")
public class IngredienteServiceMysqlImp implements IIngredienteService {
    @Autowired
    Ingrediente ingrediente;
    @Autowired
    IIngredienteRepository ingredienteRepository;
    
    /**
     * Obtiene la lista de ingredientes activos.
     * 
     * @return una lista de ingredientes que están activos
     */
    @Override
    public List<Ingrediente> getListaingrediente() {
        return ingredienteRepository.findByEstado(true);
    }

    /**
     * Guarda un ingrediente.
     * 
     * @param ingrediente el ingrediente a guardar
     */
    @Override
    public void guardar(Ingrediente ingrediente) {
        ingrediente.setEstado(true);
        ingredienteRepository.save(ingrediente);
    }

    /**
     * Obtiene un ingrediente por su ID.
     * 
     * @param id el ID del ingrediente
     * @return el ingrediente encontrado o null si no se encuentra ningún ingrediente con el ID dado
     */
    @Override
    public Ingrediente getBy(Long id) {
        return ingredienteRepository.findById(id).get();
    }

    /**
     * Elimina un ingrediente.
     * 
     * @param ingredienteEncontrado el ingrediente a eliminar
     */
    @Override
    public void eliminar(Ingrediente ingredienteEncontrado) {
        ingredienteEncontrado.setEstado(false);
        ingredienteRepository.save(ingredienteEncontrado);
    }

    /**
     * Obtiene una instancia de ingrediente.
     * 
     * @return una instancia de la entidad Ingrediente
     */
    @Override
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
}