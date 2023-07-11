//sss
package ar.edu.unju.fi.entity;
import java.text.DecimalFormat;
import java.time.LocalDate;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import jakarta.persistence.Entity;

@Component
@Entity
public class IndiceMasaCorporal {
	private Long id;
	 private LocalDate fecha;
	 private float peso;
	 private Usuario usuario;
	 private boolean estado;
	 
	 public IndiceMasaCorporal() {
		 
	 }

	public IndiceMasaCorporal(Long id, LocalDate fecha, float peso, Usuario usuario, boolean estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.peso = peso;
		this.usuario = usuario;
		this.estado = estado;
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

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	 
	 public IndiceMasaCorporal id(Long id) {
	        setId(id);
	        return this;
	    }

	    public IndiceMasaCorporal fecha(LocalDate fecha) {
	        setFecha(fecha);
	        return this;
	    }

	    public IndiceMasaCorporal estado(boolean estado) {
	        setEstado(estado);
	        return this;
	    }

	    public IndiceMasaCorporal peso(float peso) {
	        setPeso(peso);
	        return this;
	    }

	    public IndiceMasaCorporal usuario(Usuario usuario) {
	        setUsuario(usuario);
	        return this;
	    }

	 
	 
	   public String calcularIMC(){
	        DecimalFormat df = new DecimalFormat("#.#");
	        return df.format((this.peso/(Math.pow((this.usuario.getEstatura()/100),2))));
	    }

	    public String estadoImc(){
	        String mensaje;
	        if((this.peso/(Math.pow((this.usuario.getEstatura()/100),2)))<18.5){
	            mensaje="Esta por debajo de su peso ideal";
	        }else{
	            if((this.peso/(Math.pow((this.usuario.getEstatura()/100),2)))>=18.5 && (this.peso/(Math.pow((this.usuario.getEstatura()/100),2)))<=25.0){
	                mensaje="Esta en su peso ideal";
	            }else{
	                mensaje="Esta por encima de su peso ideal";
	            }
	        }
	        return mensaje;
	    }
	    
	 
}

