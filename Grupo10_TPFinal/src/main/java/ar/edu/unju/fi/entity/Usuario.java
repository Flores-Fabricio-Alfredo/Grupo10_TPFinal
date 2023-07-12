package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private long id;

    @Column(name = "usu_nombre", length = 30, nullable = false)
    @NotEmpty(message = "El nombre no puede quedar vacío.")
    @Size(min = 3, max = 30, message = "El nombre debe tener como mínimo 3 caracteres y como máximo 30 caracteres")
    private String nombre;

    @Column(name = "usu_apellido", length = 30, nullable = false)
    @NotEmpty(message = "El apellido no puede quedar vacío.")
    @Size(min = 3, max = 30, message = "El apellido debe tener como mínimo 3 caracteres y como máximo 30 caracteres")
    private String apellido;

    @Column(name = "usu_email", nullable = false)
    @NotEmpty(message = "Este campo no puede quedar vacío.")
    @Email(message = "Debe ingresar un correo válido")
    private String email;

    @Column(name = "usu_fechaNac", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Este campo no puede quedar sin una fecha.")
    @Past(message = "La fecha debe ser menor a la fecha actual.")
    private LocalDate fechaNac;

    @Column(name = "usu_telefono", nullable = false)
    @NotEmpty(message = "Debe ingresar un número de teléfono.")
    private String telefono;

    @Column(name = "usu_genero", nullable = false)
    @NotBlank(message = "Debe seleccionar una opción.")
    private String genero;

    @Column(name = "usu_estatura", nullable = false)
    @NotNull(message = "Este campo no puede quedar vacío.")
    @Max(value = (2), message = "Estatura fuera de rango")
    private Double estatura;

    @Column(name = "usu_estado")
    private boolean estado;

    @Column(name = "usu_codigoAleatorio")
    private String codigoAleatorio;

    @OneToMany(mappedBy = "usuario")
    private List<IndiceMasaCorporal> imc = new ArrayList<>();
    
    @OneToOne(mappedBy="usuario")
    @JoinColumn(name="test_id")
    private Testimonio testimonio;

    public Usuario() {
        generarCodigoAleatorio();
    }

    public Usuario(long id, String nombre, String apellido, String email, LocalDate fechaNac, String telefono,
            String genero, Double estatura, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.genero = genero;
        this.estatura = estatura;
        this.estado = estado;
        generarCodigoAleatorio();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCodigoAleatorio() {
        return codigoAleatorio;
    }

    public void setCodigoAleatorio(String codigoAleatorio) {
        this.codigoAleatorio = codigoAleatorio;
    }
    public List<IndiceMasaCorporal> getImc() {
		return imc;
	}

	public void setImc(List<IndiceMasaCorporal> imc) {
		this.imc = imc;
	}
	
	public void añadirImc(IndiceMasaCorporal imc) {
		this.imc.add(imc);
	}
    private void generarCodigoAleatorio() {
        Random random = new Random();
        StringBuilder codigoBuilder = new StringBuilder();
        String caracteres = "0123456789";
        int longitud = 6;
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(index);
            codigoBuilder.append(caracter);
        }
        codigoAleatorio = codigoBuilder.toString();
    }
}
