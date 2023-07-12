package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

@Component
public class Login {
	private String usuarioLogin;
	private String passwordLogin;
	
	public Login(){
		
	}

	 /**
     * Crea un objeto Login con el usuario y contraseña especificados.
     *
     * @param usuarioLogin   El nombre de usuario.
     * @param passwordLogin  La contraseña.
     */
	
	public Login(String usuarioLogin, String passwordLogin) {
		super();
		this.usuarioLogin = usuarioLogin;
		this.passwordLogin = passwordLogin;
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	
}
