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
	private IUsuarioService usuarioService;

	 /**
     * Maneja las solicitudes GET a la URL "/registrarme".
     * Agrega un nuevo objeto Usuario al modelo y devuelve la plantilla de vista "usuario_nuevo".
     *
     * @param model El objeto modelo para pasar datos a la vista.
     * @return El nombre de la vista "usuario_nuevo".
     */
	
	@GetMapping("/registrarme")
	public String getFormularioPage(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario_nuevo";
	}
	
	 /**
     * Maneja las solicitudes POST a la URL "/index/guardar" para guardar un nuevo usuario.
     * Valida el objeto Usuario utilizando las anotaciones de validación.
     * Si hay errores de validación, devuelve la plantilla de vista "usuario_nuevo" con los errores y el objeto Usuario.
     * Si no hay errores de validación, guarda el usuario en la base de datos, agrega un mensaje exitoso y la lista de usuarios al modelo, y devuelve la plantilla de vista "index".
     *
     * @param usuario El objeto Usuario enviado desde el formulario.
     * @param result  El objeto BindingResult que contiene los resultados de la validación.
     * @return Un objeto ModelAndView que representa la vista y los datos a mostrar.
     */
	
	@PostMapping("/index/guardar")
	public ModelAndView getGuardarUsuarioPage(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		ModelAndView modelView = new ModelAndView("index");
		if (result.hasErrors()) {
			modelView.setViewName("usuario_nuevo");
			modelView.addObject("usuario", usuario);
			return modelView;
		}
		usuarioService.guardar(usuario);
		modelView.addObject("mensajeusuario", "Registro exitoso! Tu nuevo código de usuario es: " + usuario.getId() + ". Guárdalo bien.");
		modelView.addObject("usuario", usuarioService.getLista());
		return modelView;
	}
}
