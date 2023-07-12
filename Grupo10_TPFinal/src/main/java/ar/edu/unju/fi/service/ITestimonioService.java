package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;

/**
 * Interfaz que define los métodos para el servicio de Testimonio.
 */
public interface ITestimonioService {
	
	/**
	 * Obtiene la lista de testimonios.
	 *
	 * @return Lista de testimonios.
	 */
	List<Testimonio> getListaT();

	/**
	 * Guarda un testimonio.
	 *
	 * @param testimonio Testimonio a guardar.
	 */
	void guardarTestimonio(Testimonio testimonio);

	/**
	 * Obtiene un testimonio por su código.
	 *
	 * @param id Código del testimonio.
	 * @return Testimonio encontrado.
	 */
	public Testimonio getBy(Long id);

	/**
	 * Elimina un testimonio.
	 *
	 * @param testimonioEncontrado Testimonio a eliminar.
	 */
	void eliminarTestimonio(Testimonio testimonioEncontrado);

	/**
	 * Obtiene un testimonio nuevo.
	 *
	 * @return Testimonio nuevo.
	 */
	Testimonio getTestimonio();
	
	/**
	 * Obtiene un testimonio por el ID de usuario.
	 *
	 * @param userId ID del usuario asociado al testimonio.
	 * @return Testimonio encontrado.
	 */
	Testimonio getByUserId(Long userId);
}
