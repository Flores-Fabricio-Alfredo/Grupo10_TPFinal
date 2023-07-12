package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Maneja las solicitudes GET a la URL "/inicio".
 * Devuelve la plantilla de vista "index".
 *
 * @param model El objeto modelo para pasar datos a la vista.
 * @return El nombre de la vista "index".
 */
@Controller
@RequestMapping("/")
public class IndexController {
		@GetMapping("/inicio")
		public String getIndexController(Model model) {
			return "index";
		}
}
