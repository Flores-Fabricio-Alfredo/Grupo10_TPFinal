package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/")
public class RecetaController {
	
	@Autowired
	@Qualifier("recetaServiceMysqlImp")
	private IRecetaService recetaService;
	
	@GetMapping("/recetas")
	public String getRecetasPage() {
		return "recetas";
	}
	
	@GetMapping("/receta/guardar")
	public ModelAndView getGuardarRecetaPage(@Valid @ModelAttribute ("receta") Receta receta, BindingResult result){
		ModelAndView modelView = new ModelAndView("recetas");
			if (result.hasErrors()) {
				modelView.setViewName("receta_nueva");
				modelView.addObject("receta", receta);
				return modelView;
			}
			recetaService.guardar(receta);
			modelView.addObject("receta", recetaService.getLista());
			return modelView;
	}
	
	@GetMapping("/receta/lista")
	public String getListaRecetaPage(Model model) {
		model.addAttribute("recetas", recetaService.getLista());
		return "recetas";		
	}
	
	@GetMapping("/nuevo")
	public String getNuevoReceta(Model model) {
		boolean edicion = false;
		model.addAttribute("receta", recetaService.getReceta());
		model.addAttribute("edicion", edicion);
		return "recetas_nuevo";		
	}
	
	@PostMapping("/receta/modificar")
	public String modificarReceta(@Valid @ModelAttribute("receta")Receta receta, BindingResult result, Model model) {
		if(result.hasErrors()) {
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "receta_nuevo";
		}
		
		recetaService.Modificar(receta);
		return "redirect:/recetas/lista";
	}
	
	@GetMapping("/recetas/modificar/{id}")
	public String getModificarRecetasPage(Model model, @PathVariable(value="id") Long id) {
		Receta recetaEncontrada = recetaService.getBy(id);
		boolean edicion = true;
		model.addAttribute("receta",recetaEncontrada);
		model.addAttribute("edicion", edicion);
		return "recetas_nueva";
		
	}
	
	@GetMapping("/recetas/eliminar/{id}")
	public String eliminarRecetas(@PathVariable(value="id")Long id) {
		Receta recetaEncontrada = recetaService.getBy(id);
		recetaService.Eliminar(recetaEncontrada);
		return "redirect:/recetas/lista";
	}
}
