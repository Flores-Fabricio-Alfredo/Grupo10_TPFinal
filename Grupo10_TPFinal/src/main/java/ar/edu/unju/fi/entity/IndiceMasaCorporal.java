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
	
	/**
	 * Clase que representa el modelo de datos para el Índice de Masa Corporal (IMC).
	 * 
	 * - @Id: Anotación que indica que el campo 'id' es la clave primaria de la entidad.
	 * - @GeneratedValue: Anotación que especifica la estrategia de generación de valores para el campo 'id'.
	 * - @Column: Anotación que mapea el campo a una columna de la base de datos.
	 * - @ManyToOne: Anotación que indica una relación de muchos a uno con la entidad 'Usuario'.
	 * - @JoinColumn: Anotación que especifica la columna utilizada para la relación con la entidad 'Usuario'.
	 */
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
	
	/**
	 * Constructor vacío de la clase IndiceMasaCorporal.
	 * 
	 * Este constructor no recibe ningún parámetro y se utiliza para crear una instancia de la clase IndiceMasaCorporal sin inicializar sus campos.
	 * 
	 */
	public IndiceMasaCorporal() {
	}

	/**
	 * Constructor de la clase IndiceMasaCorporal con parámetros.
	 *
	 * @param id          El ID del Índice de Masa Corporal.
	 * @param fecha       La fecha del Índice de Masa Corporal.
	 * @param imc         El valor del Índice de Masa Corporal.
	 * @param usuarioImc  El nombre del usuario asociado al Índice de Masa Corporal.
	 */
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