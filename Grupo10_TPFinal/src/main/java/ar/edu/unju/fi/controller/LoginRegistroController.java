package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import  ar.edu.unju.fi.entity.Registro;
@Controller
public class LoginRegistroController {
     @GetMapping("/registro")
     public String registrar(Model model) {
    	 Registro registro = new Registro();
    	 model.addAttribute("registro", registro);
 		return "login_Registro";
     }
     
     @PostMapping("/registro")
     public ModelAndView postRegistro(Model model, @ModelAttribute(value = "registro") Registro registro) {
     	ModelAndView modelAndView = new ModelAndView("inicio");
     	 model.addAttribute( "registro", registro); //Se envia un nuevo objeto para que se reinicie el formulario. 
          model.addAttribute("datos", "Datos enviados Correctamente");
          System.out.println(registro.toString()); //Muestro por consola los atributos de contacto.
          return modelAndView;
     }
}
