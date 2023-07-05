package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Metodo para mostrar la vista
//de la pagina de inicio de la plataforma
@Controller
@RequestMapping("/")
public class IndexController {
		@GetMapping("/inicio")
		public String getIndexController(Model model) {
			return "index";
		}
}
