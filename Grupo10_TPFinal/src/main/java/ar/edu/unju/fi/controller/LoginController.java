package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Login;


@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private Login login;
	
	@GetMapping({"/login"})
	public String login(Model model) {
	//Login login = new Login();
	model.addAttribute("login", login);
		return "login";
	}
	
	@PostMapping("/login")
	public String validar(Model model, Login login) {
		if(login.getUsuarioLogin().equals("admin") && login.getPasswordLogin().equals("123")) {
			return "index";
		}
		model.addAttribute("error", "Acceso incorrecto");
		return "login";
	}
}