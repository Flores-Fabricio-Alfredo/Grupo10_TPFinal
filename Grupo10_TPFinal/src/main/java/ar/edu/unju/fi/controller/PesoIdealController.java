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
 
	  /**
	     * Maneja las solicitudes GET a la URL "/pesoideal".
	     * Devuelve la plantilla de vista "pesoideal".
	     *
	     * @return El nombre de la vista "pesoideal".
	     */
	    
	@GetMapping
	public String getPesoIdealPage() {
		return "pesoideal";
	}
	
	/**
     * Maneja las solicitudes POST a la URL "/pesoideal/calculo" para calcular el peso ideal.
     * Recupera el usuario por su ID desde el repositorio y calcula el peso ideal basado en la altura y la edad del usuario.
     * Agrega el peso ideal calculado al modelo.
     * Si el ID del usuario no se encuentra, agrega un mensaje de error al modelo.
     * Devuelve la plantilla de vista "pesoideal".
     *
     * @param id    El ID del usuario.
     * @param model El objeto modelo para pasar datos a la vista.
     * @return El nombre de la vista "pesoideal".
     */
	
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