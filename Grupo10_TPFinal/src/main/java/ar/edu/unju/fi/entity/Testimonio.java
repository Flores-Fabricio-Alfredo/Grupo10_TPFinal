package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Component
@Entity
@Table(name = "testimonios")
public class Testimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private LocalDate fechaInicio;
	private String usuario;
	private String comentario;
	private boolean estado;



	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	

	public Testimonio(Long id, LocalDate fechaInicio, String usuario, String comentario, boolean estado) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.usuario = usuario;
		this.comentario = comentario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getfechaInicio() {
		return fechaInicio;
	}

	public void setfechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setNombre(String usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String ingrediente) {
		this.comentario = ingrediente;
	}



	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}