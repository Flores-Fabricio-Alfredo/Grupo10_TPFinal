package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.service.IPesoIdealService;

@Service("PesoIdealService")
public class PesoIdealServiceImp implements IPesoIdealService {
	
	 /**
     * Calcula el peso ideal basado en la estatura y la edad.
     *
     * @param estatura La estatura del individuo.
     * @param edad     La edad del individuo.
     * @return El peso ideal calculado.
     */
	 @Override
	    public Double calcularPesoIdeal(Double estatura, int edad) {
	        return (estatura*100) - 100 + (edad / 10) * 0.9;
	    }
	 
	 /**
	     * Calcula la edad en años a partir de la fecha de nacimiento.
	     *
	     * @param fechaNacimiento La fecha de nacimiento del individuo.
	     * @return La edad calculada en años.
	     */
	 @Override
	 public int calcularEdad(LocalDate fechaNacimiento) {
		    LocalDate fechaActual = LocalDate.now();
		    Period periodo = Period.between(fechaNacimiento, fechaActual);
		    return periodo.getYears();
		}
	 

}