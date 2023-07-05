package ar.edu.unju.fi.entity;

public class Login {
	private String usuarioLogin;
	private String passwordLogin;
	
	public Login(){
		
	}

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
