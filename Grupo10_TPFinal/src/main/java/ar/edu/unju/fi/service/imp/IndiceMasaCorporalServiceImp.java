package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.repository.IIndiceMasaCorporalRepository;
import ar.edu.unju.fi.service.*;

@Service("IndiceMasaCorporalServiceImp")
public class IndiceMasaCorporalServiceImp implements IIndiceMasaCorporalService {
	/**
	 * Inyección de dependencias utilizando la anotación @Autowired.
	 * 
	 * - imcRepository: Repositorio para acceder a los datos de los Índices de Masa Corporal (IMC).
	 * - imc: Instancia de la clase IndiceMasaCorporal.
	 */
	@Autowired
	IIndiceMasaCorporalRepository imcRepository;
	@Autowired 
	IndiceMasaCorporal imc;
	
	/**
	 * Implementación del método para obtener la lista de Índices de Masa Corporal (IMC).
	 *
	 * @return Una lista de Índices de Masa Corporal activos.
	 * @Override Indica que este método es una implementación de un método de la clase padre o una interfaz.
	 */
	@Override
	public List<IndiceMasaCorporal> getLista() {
		return imcRepository.findByEstado(true);
	}
	
	/**
	 * Implementación del método para guardar un Índice de Masa Corporal (IMC).
	 *
	 * @param imc El Índice de Masa Corporal a guardar.
	 * @Override Indica que este método es una implementación de un método de la clase padre o una interfaz.
	 */
	@Override
	public void guardarIMC(IndiceMasaCorporal imc) {
		imc.setEstado(true);
		imcRepository.save(imc);
		
	}

	/**
	 * Implementación del método para obtener un Índice de Masa Corporal (IMC) por su ID.
	 *
	 */
	@Override
	public IndiceMasaCorporal getBy(Long id) {
		return imcRepository.findById(id).get();
	}

	/**
	 * Implementación del método para eliminar un Índice de Masa Corporal (IMC).
	 *
	 * @param imcEncontrado El Índice de Masa Corporal a eliminar.
	 * @Override Indica que este método es una implementación de un método de la clase padre o una interfaz.
	 */
	@Override
	public void eliminarIMC(IndiceMasaCorporal imcEncontrado) {
		imcEncontrado.setEstado(false);
		imcRepository.save(imcEncontrado);
		
	}

	/**
	 * Implementación del método para obtener un nuevo Índice de Masa Corporal (IMC) vacío.
	 *
	 * @return Un nuevo Índice de Masa Corporal con la fecha actual.
	 * @Override Indica que este método es una implementación de un método de la clase padre o una interfaz.
	 */
	@Override
	public IndiceMasaCorporal getIMC() {
		LocalDate fechaActual = LocalDate.now();
		imc.setFecha(fechaActual);
		return imc;
	}
	
	/**
	 * Implementación del método para calcular el Índice de Masa Corporal (IMC) en función del peso y la altura proporcionados.
	 *
	 * @param peso   El peso del individuo en kilogramos.
	 * @param altura La altura del individuo en metros.
	 * @return El resultado del cálculo del IMC y un mensaje descriptivo correspondiente.
	 * @Override Indica que este método es una implementación de un método de la clase padre o una interfaz.
	 */
	@Override
	public String calcularIMC(Double peso, Double altura) {
		Double imc = peso/Math.pow(altura, 2);
		String resultado;
		 if (imc < 18.5) {
		        resultado = "Su IMC es " + imc + " Está por debajo del peso ideal.";
		    } else if (imc >= 18.5 && imc <= 25) {
		        resultado = "Su IMC es " + imc + " Está en su peso ideal.";
		    } else {
		        resultado = "Su IMC es " + imc + " Está por encima del peso ideal.";
		    }

		    return resultado;
	}

}
