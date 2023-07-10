package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid; 

@Service 
public class TestimonioServiceImp implements ITestimonioService {
	/*sale del controller*/
	@Autowired
    private ITestimonioRepository testimonioRepository;
	@Autowired
	private Testimonio testimonio;
	
    @Override
    public List<Testimonio> getLista() {
    
        return testimonioRepository.findByEstado(true);
    }
    @Override
	public void guardar (@Valid Testimonio testimonio) {
		testimonioRepository.save(testimonio);
	}
    @Override
	public Testimonio getBy(Long Id){
		return testimonioRepository.findById(Id).get();
	}
    @Override	
	public void modificar(@Valid Testimonio testimonio) {
    	testimonio.setEstado(true);
		testimonioRepository.save(testimonio);
				
	}
    @Override	
	public void eliminar(@Valid Testimonio testimonio) {
    	testimonio.setEstado(false);
		testimonioRepository.save(testimonio);
				
	}
    @Override
    public Testimonio getTestimonio() {
    	return testimonio;
    }

}
