package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ar.edu.unju.fi.entity.Login;

import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private Login login;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/**
     * Maneja las solicitudes GET a la URL "/login".
     * Agrega un nuevo objeto Login al modelo y devuelve la plantilla de vista "login".
     *
     * @param model El objeto modelo para pasar datos a la vista.
     * @return El nombre de la vista "login".
     */
	
	@GetMapping({"/login"})
	public String login(Model model) {
	//Login login = new Login();
	model.addAttribute("login", login);
		return "login";
	}
	
	/**
     * Maneja las solicitudes POST a la URL "/login" para validar las credenciales de inicio de sesión.
     * Verifica si las credenciales de inicio de sesión coinciden con el usuario "admin" y la contraseña "123".
     * Si las credenciales son válidas, agrega la lista de usuarios al modelo y redirige a la URL "/gestion_de_datos".
     * Si las credenciales no son válidas, agrega un mensaje de error al modelo y devuelve la plantilla de vista "login".
     *
     * @param model El objeto modelo para pasar datos a la vista.
     * @param login El objeto Login que contiene las credenciales de inicio de sesión.
     * @return El nombre de la vista "login" si las credenciales son incorrectas, o la URL de redirección a "/gestion_de_datos" si las credenciales son correctas.
     */
	
	@PostMapping("/login")
	public String validar(Model model, Login login) {
		if(login.getUsuarioLogin().equals("admin") && login.getPasswordLogin().equals("123")) {
			//ModelAndView modelView = new ModelAndView("gestion_de_datos");
			//modelView.setViewName("gestion_de_datos");
			model.addAttribute("usuario", usuarioService.getLista());
			return "gestion_de_datos";
		}
		model.addAttribute("error", "Acceso incorrecto");
		return "login";
	}
}