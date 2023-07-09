package ar.edu.unju.fi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	private Usuario usuario;
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/registrarme")
	public String getFormularioPage(Model model) {
		model.addAttribute("usuario", usuario);
		return "registrarme";
		
	}
	
	
	@PostMapping("/registrarme/guardar")
	public ModelAndView getGuardarUsuarioPage( @Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result) {
		
		ModelAndView modelView = new ModelAndView("registrarme");
		if (result.hasErrors()){
			modelView.setViewName("registrarme");
			modelView.addObject("usuario", usuario);
			return modelView;
		}
		usuarioService.guardar(usuario);
		modelView.addObject("usuario", usuarioService.getLista());
		return modelView;
	}
}

