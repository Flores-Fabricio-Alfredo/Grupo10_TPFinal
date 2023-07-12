package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="imc")
public class IndiceMasaCorporal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imc_id")
	private Long id;
	
	@Column(name="imc_fecha")
	private LocalDate fecha;
	
	@Column(name="imc_num_imc")
	private String imc;
	
	@Column(name="imc_usuario")
	private String usuarioImc;
	
	@Column(name="imc_estado")
	private boolean estado;

	@ManyToOne(cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
	
	public IndiceMasaCorporal() {
	}

	public IndiceMasaCorporal(Long id, LocalDate fecha, String imc, String usuarioImc) {
		this.fecha = fecha;
		this.imc = imc;
		this.usuarioImc = usuarioImc;
	}


	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public String getImc() {
		return imc;
	}



	public void setImc(String imc) {
		this.imc = imc;
	}





	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getUsuarioImc() {
		return usuarioImc;
	}

	public void setUsuarioImc(String usuarioImc) {
		this.usuarioImc = usuarioImc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	


}