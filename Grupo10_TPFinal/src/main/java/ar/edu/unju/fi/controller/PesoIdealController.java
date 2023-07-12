package ar.edu.unju.fi.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IPesoIdealService;
/**import ar.edu.unju.fi.service.IUsuarioService;*/

@Controller
@RequestMapping("/pesoideal")
public class PesoIdealController {

	@Autowired 
	private IUsuarioRepository usuarioRepository;
	/**
	@Autowired 
	private IUsuarioService usuarioService;
    */
	  @Autowired
	  private IPesoIdealService pesoIdealService;

	    
	@GetMapping
	public String getPesoIdealPage() {
		return "pesoideal";
	}
	
	@PostMapping("/calculo")
	public String calcularPesoIdeal(@RequestParam(value = "id") Long id, Model model) {
	    Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
	    if (optionalUsuario.isPresent()) {
	        Usuario usuarioEncontrado = optionalUsuario.get();
	        Double altura = usuarioEncontrado.getEstatura();
	        LocalDate fechaNacimiento = usuarioEncontrado.getFechaNac();
	        int edad = pesoIdealService.calcularEdad(fechaNacimiento);
	        Double pesoIdeal = pesoIdealService.calcularPesoIdeal(altura, edad);
	        model.addAttribute("pesoIdeal", pesoIdeal);
	    }
	    if(optionalUsuario.isEmpty()) {
	    model.addAttribute("mensaje", "El id ingresado no pertenece a un usuario");
	    }
	    return "pesoideal";
	}
	
	
	
	
}