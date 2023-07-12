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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void añadirIngrediente(Ingrediente ingrediente) {
		this.ingredientes.add(ingrediente);
	}
}
