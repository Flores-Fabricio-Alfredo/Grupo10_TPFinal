package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.service.IIngredienteService;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/recetas/ingredientes")
public class IngredienteController {
	@Autowired
	IIngredienteService ingredienteService;

	@GetMapping("/listado")
	public String getIngredientesPage(Model model) {
		model.addAttribute("ingredientes", ingredienteService.getListaingrediente());
		return "ingredientes";
	}

	@GetMapping("/nuevo")
	public String getNuevoIngredientePage(Model model) {
		boolean edicion = false;
		model.addAttribute("ingrediente", ingredienteService.getIngrediente());
		model.addAttribute("edicion", edicion);
		return "ingrediente_nuevo";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarIngredientePage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Ingrediente ingredienteEncontrado = ingredienteService.getBy(id);
		model.addAttribute("ingrediente", ingredienteEncontrado);
		model.addAttribute("edicion", edicion);

		return "nuevo_ingrediente";
	}

	@PostMapping("/modificar")
	public ModelAndView postModificarIngredientePage(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("ingredientes");
		boolean edicion = true;
		if (result.hasErrors()) {
			modelView.setViewName("ingrediente_nuevo");
			modelView.addObject("ingrediente", ingrediente);
			modelView.addObject("edicion", edicion);
			return modelView;
		}
		ingredienteService.guardar(ingrediente);
		modelView.addObject("ingredientes", ingredienteService.getListaingrediente());
		return modelView;
	}

	@PostMapping("/guardar")
	public ModelAndView getGuardarIngredientePage(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("redirect:/gestion_de_datos");
		if (result.hasErrors()) {
			modelView.setViewName("ingrediente_nuevo");
			modelView.addObject("ingrediente", ingrediente);
			return modelView;
		}
		ingredienteService.guardar(ingrediente);
		modelView.addObject("ingredientes", ingredienteService.getListaingrediente());
		return modelView;
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarIngrediente(@PathVariable(value = "id") Long id) {
		Ingrediente ingredienteEncontrado = ingredienteService.getBy(id);
		ingredienteService.eliminar(ingredienteEncontrado);

		return "redirect:/gestion_de_datos";
	}
}
