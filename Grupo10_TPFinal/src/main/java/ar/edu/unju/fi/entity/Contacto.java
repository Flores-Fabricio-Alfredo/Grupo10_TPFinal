package ar.edu.unju.fi.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Contacto {

	@NotEmpty(message="El nombre no puede permanecer vacio")
	@Size(min=5, max=50, message="El nombre debe contener entre 5 y 50 caracteres ")
	private String nombre;
	
	@NotEmpty(message="El e-mail no puede estar vacio ")
	@Email(message="El e-mail debe tener un formato valido por ejemplo:  ejemplo@gmail.com")
	private String email;
	
	
	@NotEmpty(message="El mensaje no puede permanecer vacio")
	@Size(min=30, max=140, message="El mensaje debe contener entre 30 y 140 caracteres ")
	private String mensaje;
	
	public Contacto() {
		
	}
	
	public Contacto(String nombre, String email, String mensaje) {
		this.nombre = nombre;
		this.email = email;
		this.mensaje = mensaje;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
}
