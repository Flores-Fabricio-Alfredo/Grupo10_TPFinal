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

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.ITestimonioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/")
public class TestimonioController {
	
	
	@Autowired
	private ITestimonioService testimonioService;

	
	@GetMapping("/testimonios")
	public String getTestimoniosPage() {
		
		return "testimonios";
	}

	@GetMapping ("/nuevoTestimonio")
	public String getNuevoTestimonio (Model model) {
		boolean edicion = false;
    	model.addAttribute("testimonio",testimonioService.getTestimonio());
    	model.addAttribute("edicion" , edicion);
		return "testimonio_nuevo";
		}
	
	@PostMapping("/testimonios/guardar")
	public ModelAndView getGuardarTestimoniosPage(@Valid  @ModelAttribute("testimonio") Testimonio testimonio, BindingResult result) {
		ModelAndView modelView =new ModelAndView("testimonios");
		if (result.hasErrors()){
            modelView.setViewName("testimonio_nuevo");
            modelView.addObject("testimonio", testimonio);
			 return modelView;
		 }
        testimonioService.guardar(testimonio);
        modelView.addObject("testimonio", testimonioService.getLista());
        return modelView;
	}
	
}
