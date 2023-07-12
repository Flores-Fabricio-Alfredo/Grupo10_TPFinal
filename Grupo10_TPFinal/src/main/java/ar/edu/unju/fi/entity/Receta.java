package ar.edu.unju.fi.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="receta_id")
	private Long id;
	@Column(name="receta_nombre", nullable=false)
	@NotEmpty(message="Ingrese el nombre de la receta")
	@Size(max=50, message="¡NO! debe pasar los 50 caracteres")
	private String nombre;
	@Column(name="receta_categoria", nullable=false)
	@NotBlank(message="¡Elija una categoria!")
	private String categoria;
	@Column(name="receta_preparacion",columnDefinition = "text" ,nullable=false)
	@NotEmpty(message="Debe ingresar como realizó su receta")
	private String preparacion;
	@Column(name="receta_imagen", nullable=false)
	private String imagen;
	@Column(name="receta_estado", nullable=false)
	private boolean estado;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="receta_ingrediente",
				joinColumns= {@JoinColumn(name="rec_id")},
				inverseJoinColumns= {@JoinColumn (name="ingr_id")})
	@NotEmpty(message="Debe agregar ingredientes")
	private List<Ingrediente> ingredientes = new ArrayList<>();
	
	public Receta() {
		
	}
	
	public Receta(Long id,String nombre,String categoria, String ingrediente, String preparacion, String imagen) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.preparacion = preparacion;
		this.imagen = imagen;
		this.id = id;
	}
	
	 /**
     * Obtiene el ID de la receta.
     *
     * @return El ID de la receta.
     */
	
	public Long getId() {
		return id;
	}
	
	/**
     * Establece el ID de la receta.
     *
     * @param id El ID de la receta.
     */
	
	public void setId(Long id) {
		this.id = id;
	}
	
	 /**
     * Obtiene el nombre de la receta.
     *
     * @return El nombre de la receta.
     */
	
	public String getNombre() {
		return nombre;
	}
	
	 /**
     * Establece el nombre de la receta.
     *
     * @param nombre El nombre de la receta.
     */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
     * Obtiene la categoría de la receta.
     *
     * @return La categoría de la receta.
     */
	
	public String getCategoria() {
		return categoria;
	}
	
	 /**
     * Establece la categoría de la receta.
     *
     * @param categoria La categoría de la receta.
     */
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	 /**
     * Obtiene la preparación de la receta.
     *
     * @return La preparación de la receta.
     */
	
	public String getPreparacion() {
		return preparacion;
	}
	
	/**
     * Establece la preparación de la receta.
     *
     * @param preparacion La preparación de la receta.
     */
	
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	
	/**
     * Obtiene la imagen de la receta.
     *
     * @return La imagen de la receta.
     */
	
	public String getImagen() {
		return imagen;
	}
	
	/**
     * Establece la imagen de la receta.
     *
     * @param imagen La imagen de la receta.
     */
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	 /**
     * Obtiene el estado de la receta.
     *
     * @return El estado de la receta.
     */
	
	public boolean getEstado() {
		return estado;
	}
	
	 /**
     * Establece el estado de la receta.
     *
     * @param estado El estado de la receta.
     */
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	/**
     * Obtiene la lista de ingredientes de la receta.
     *
     * @return La lista de ingredientes de la receta.
     */
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	/**
     * Establece la lista de ingredientes de la receta.
     *
     * @param ingredientes La lista de ingredientes de la receta.
     */
	
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	 /**
     * Añade un ingrediente a la lista de ingredientes de la receta.
     *
     * @param ingrediente El ingrediente a añadir.
     */
	
	public void añadirIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}
}
