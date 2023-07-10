package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;

@Service("recetaServiceMysqlImp")
public class RecetaServiceMysqlImp implements IRecetaService{
	
	@Autowired
	private IRecetaRepository recetaRepository;
	
	@Autowired
	private Receta receta;
	
	@Override
	public List<Receta>getLista(){
		return recetaRepository.findByEstado(true);
	}
	
	@Override
	public void guardar (@Valid Receta receta) {
		recetaRepository.save(receta);
	}
	
	@Override
	public Receta getBy(Long id) {
		return recetaRepository.findById(id).get();
	}
	@Override
	public void Modificar (@Valid Receta receta) {
		receta.setEstado(true);
		recetaRepository.save(receta);	
	}
	@Override
	public void Eliminar (Receta recetaEncontrada) {
		recetaEncontrada.setEstado(false);
		recetaRepository.save(receta);
	}
	@Override
	public Receta getReceta() {
		return receta;
	}
}