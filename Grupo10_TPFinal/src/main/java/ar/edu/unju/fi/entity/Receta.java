package ar.edu.unju.fi.entity;

public class Receta {
	private Long id;
	private String categoria;
	private String nombre;
	private String ingrediente;
	private String preparacion;
	private String rutaImagen;
	private String informacion;
	private boolean estado;

	public Receta() {
		// TODO Auto-generated constructor stub
	}

	public Receta(String categoria, String nombre, String ingrediente, String preparacion, String rutaImagen,
			String informacion) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		this.ingrediente = ingrediente;
		this.preparacion = preparacion;
		this.rutaImagen = rutaImagen;
		this.informacion = informacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}