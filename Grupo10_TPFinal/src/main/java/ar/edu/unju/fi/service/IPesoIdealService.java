package ar.edu.unju.fi.service;

import java.time.LocalDate;

public interface IPesoIdealService {
	
	/**
     * Calcula el peso ideal basado en la estatura y la edad.
     *
     * @param estatura La estatura del individuo.
     * @param edad     La edad del individuo.
     * @return El peso ideal calculado.
     */
	Double calcularPesoIdeal(Double estatura, int edad);
	
	/**
     * Calcula la edad en años a partir de la fecha de nacimiento.
     *
     * @param fechaNacimiento La fecha de nacimiento del individuo.
     * @return La edad calculada en años.
     */
	int calcularEdad(LocalDate fechaNacimiento);
}
