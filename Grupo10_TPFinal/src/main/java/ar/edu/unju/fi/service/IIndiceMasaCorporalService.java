package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

/**
 * Interfaz que define las operaciones para el servicio de Índice de Masa Corporal (IMC).
 */
public interface IIndiceMasaCorporalService {
    
	 /**
     * Obtiene la lista de todos los Índices de Masa Corporal (IMC).
     *
     * @return Una lista de Índices de Masa Corporal.
     */
    List<IndiceMasaCorporal> getLista();

    /**
     * Guarda un Índice de Masa Corporal (IMC).
     *
     * @param imc El Índice de Masa Corporal a guardar.
     */
    void guardarIMC(IndiceMasaCorporal imc);

    /**
     * Obtiene un Índice de Masa Corporal (IMC) por su ID.
     *
     * @param id El ID del Índice de Masa Corporal a buscar.
     * @return El Índice de Masa Corporal correspondiente al ID proporcionado.
     */
    public IndiceMasaCorporal getBy(Long id);

    /**
     * Elimina un Índice de Masa Corporal (IMC).
     *
     * @param imcEncontrado El Índice de Masa Corporal a eliminar.
     */
    void eliminarIMC(IndiceMasaCorporal imcEncontrado);

    /**
     * Obtiene un nuevo Índice de Masa Corporal (IMC) vacío.
     *
     * @return Un nuevo Índice de Masa Corporal.
     */
    IndiceMasaCorporal getIMC();
    
    /**
     * Calcula el Índice de Masa Corporal (IMC) en función del peso y la altura proporcionados.
     *
     * @param peso   El peso del individuo en kilogramos.
     * @param altura La altura del individuo en metros.
     * @return El valor del Índice de Masa Corporal calculado.
     */
    String calcularIMC(Double peso, Double altura);

}