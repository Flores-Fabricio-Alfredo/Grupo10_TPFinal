package ar.edu.unju.fi.entity;

public class Registro {
	private String usuario;
	private String password;
	private String gmail;

	public Registro() {
		
	}

	public Registro(String usuario, String password, String gmail) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.gmail = gmail;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	@Override
	public String toString() {
		return "Contactos [usuario=" + usuario + ", gmail=" + gmail + ", password=" + password
				+ "]";
	}
	
}