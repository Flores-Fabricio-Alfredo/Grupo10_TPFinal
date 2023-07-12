package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingrediente_id")
	private Long id;
	@Column(name="ingrediente_nombre", nullable=false)
	@NotBlank(message="Debe ingresar el nombre del ingrediente")
	@Size(max=50,message="¡El rango de cantidad de caracteres en 50")
	private String nombre;
	@Column(name="ingrediente_estado")
	private boolean estado;
	@ManyToMany(mappedBy = "ingredientes")
	private List<Receta> recetas;
	
	
	public Ingrediente() {
		
	}
	
	 /**
     * Crea un objeto Ingrediente con el ID y nombre especificados.
     *
     * @param id     El ID del ingrediente.
     * @param nombre El nombre del ingrediente.
     */
	
	public Ingrediente(Long id,String nombre) {
		this.nombre = nombre;
		this.id=id;
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
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


}