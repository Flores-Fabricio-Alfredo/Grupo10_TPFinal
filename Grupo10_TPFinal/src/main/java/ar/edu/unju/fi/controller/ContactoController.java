package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Contacto;
import jakarta.validation.Valid;

@Controller
public class ContactoController {
	
	 /**
     * Maneja las solicitudes GET a la URL "/contacto".
     * Agrega un nuevo objeto Contacto al modelo y devuelve la plantilla de vista "contacto".
     *
     * @param model El objeto modelo para pasar datos a la vista.
     * @return El nombre de la vista "contacto".
     */
	
	@GetMapping("/contacto")
	public String getContactanosController(Model model) {
		model.addAttribute("contacto",new Contacto());
		return "contacto";
	}
	
	 /**
     * Maneja las solicitudes POST a la URL "/contacto" para enviar el formulario de contacto.
     * Valida el objeto Contacto utilizando anotaciones de validación.
     * Si hay errores de validación, vuelve a mostrar la plantilla de vista "contacto".
     * Si no hay errores de validación, crea un objeto ModelAndView con la plantilla de vista "contacto",
     * agrega mensajes de éxito al modelo y devuelve el objeto ModelAndView.
     *
     * @param contacto El objeto Contacto enviado desde el formulario.
     * @param result   El objeto BindingResult para verificar errores de validación.
     * @return El objeto ModelAndView que contiene la vista y los mensajes.
     */
	
	@PostMapping("/contacto")
	public ModelAndView submitContactoFrom(@Valid @ModelAttribute("contacto") Contacto contacto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("contacto");
		}
		ModelAndView modelAndView = new ModelAndView("contacto");
		modelAndView.addObject("mensaje",  "Su mensaje fue enviado");
		modelAndView.addObject("mensaje",  "Gracias por elegirnos");
		return modelAndView;

	}
	
}
