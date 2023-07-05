package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.fi.entity.Login;


@Controller

public class LoginController {
	@GetMapping({"/login"})
	public String login(Model model) {
	Login login = new Login();
	model.addAttribute("login", login);
		return "login";
	}
	
	@PostMapping("/login")
	public String validar(Model model, Login login) {
		if(login.getUsuarioLogin().equals("admin") && login.getPasswordLogin().equals("123")) {
			return "inicio";
		}
		model.addAttribute("error", "Acceso incorrecto");
		return "login";
	}
}