package ar.edu.unju.fi.service;



import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;
import jakarta.validation.Valid;

public interface ITestimonioService {
	
    List<Testimonio> getLista();


    public void guardar (@Valid Testimonio testimonio);

    public Testimonio getBy(Long Id);

    public void modificar (@Valid Testimonio testimonio);

    public void eliminar (Testimonio testimonioEncontado);

    public Testimonio getTestimonio();

}