package ar.edu.unju.fi.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.entity.Testimonio;

/**
 * Repositorio para la entidad Testimonio.
 * Extiende CrudRepository para realizar operaciones de CRUD en la base de datos.
 */
public interface ITestimonioRepository extends CrudRepository<Testimonio, Long> {

    /**
     * Busca testimonios por estado.
     *
     * @param estado Estado para filtrar los testimonios.
     * @return Lista de testimonios encontrados.
     */
    public List<Testimonio> findByEstado(boolean estado);

    /**
     * Busca un testimonio por ID de usuario.
     *
     * @param userId ID del usuario asociado al testimonio.
     * @return Testimonio encontrado o null si no se encuentra.
     */
    Testimonio findByUsuarioId(Long userId);
}
