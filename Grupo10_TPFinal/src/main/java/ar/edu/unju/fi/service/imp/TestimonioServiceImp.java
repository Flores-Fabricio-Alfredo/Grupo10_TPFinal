package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;

@Service
public class TestimonioServiceImp implements ITestimonioService {

	@Autowired
	private ITestimonioRepository testimonioRepository;

	@Autowired
	private Testimonio testimonio;

	/**
	 * Obtiene la lista de testimonios activos.
	 *
	 * @return Lista de testimonios activos.
	 */
	@Override
	public List<Testimonio> getListaT() {
		return testimonioRepository.findByEstado(true);
	}

	/**
	 * Guarda un testimonio.
	 *
	 * @param testimonio Testimonio a guardar.
	 */
	@Override
	public void guardarTestimonio(Testimonio testimonio) {
		testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
	}

	/**
	 * Obtiene un testimonio por su código.
	 *
	 * @param id Código del testimonio.
	 * @return Testimonio encontrado.
	 */
	@Override
	public Testimonio getBy(Long id) {
		return testimonioRepository.findById(id).get();
	}

	/**
	 * Elimina un testimonio cambiando su estado a inactivo.
	 *
	 * @param testimonioEncontrado Testimonio a eliminar.
	 */
	@Override
	public void eliminarTestimonio(Testimonio testimonioEncontrado) {
		testimonioEncontrado.setEstado(false);
		testimonioRepository.save(testimonioEncontrado);
	}

	/**
	 * Obtiene un testimonio nuevo con la fecha actual.
	 *
	 * @return Testimonio nuevo.
	 */
	@Override
	public Testimonio getTestimonio() {
		LocalDate fechaActual = LocalDate.now();
		testimonio.setFecha(fechaActual);
		return testimonio;
	}

	/**
	 * Obtiene un testimonio por el ID de usuario.
	 *
	 * @param userId ID del usuario asociado al testimonio.
	 * @return Testimonio encontrado.
	 */
	@Override
	public Testimonio getByUserId(Long userId) {
		return testimonioRepository.findByUsuarioId(userId);
	}
}


