package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;

/**
 * @author Naima Farja
 * La clase RecetaServiceMysqlImp es una implementación del servicio IRecetaService que se conecta a una base de datos MySQL.
 * Proporciona métodos para obtener la lista de recetas, guardar una receta, buscar una receta por su ID,
 * obtener una lista de recetas por categoría, eliminar una receta y obtener una instancia de Receta.
 */
@Service("recetaServiceMysqlImp")
public class RecetaServiceMysqlImp implements IRecetaService {

    @Autowired
    Receta receta;

    @Autowired
    IRecetaRepository recetaRepository;

    /**
     * Obtiene la lista de recetas activas.
     *
     * @return una lista de recetas activas
     */
    @Override
    public List<Receta> getLista() {
        return recetaRepository.findByEstado(true);
    }

    /**
     * Guarda una receta.
     *
     * @param receta la receta a guardar
     */
    @Override
    public void guardar(Receta receta) {
        receta.setEstado(true);
        recetaRepository.save(receta);
    }

    /**
     * Busca una receta por su ID.
     *
     * @param id el ID de la receta a buscar
     * @return la receta encontrada, o null si no se encuentra ninguna receta con el ID especificado
     */
    @Override
    public Receta getBy(Long id) {
        return recetaRepository.findById(id).get();
    }

    /**
     * Obtiene una lista de recetas por categoría.
     *
     * @param categoria la categoría de las recetas a buscar
     * @return una lista de recetas que pertenecen a la categoría especificada
     */
    @Override
    public List<Receta> getListaCategoria(String categoria) {
        return recetaRepository.findByCategoria(categoria);
    }

    /**
     * Elimina una receta cambiando su estado a inactivo.
     *
     * @param recetaEncontrada la receta a eliminar
     */
    @Override
    public void eliminar(Receta recetaEncontrada) {
        recetaEncontrada.setEstado(false);
        recetaRepository.save(recetaEncontrada);
    }

    /**
     * Obtiene una instancia de Receta.
     *
     * @return una instancia de Receta
     */
    @Override
    public Receta getReceta() {
        return receta;
    }
}