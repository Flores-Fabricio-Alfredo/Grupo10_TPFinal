package ar.edu.unju.fi.controller;

import java.net.MalformedURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IRecetaService;
import ar.edu.unju.fi.util.UploadFile;



/**
 * El controlador RecetaController gestiona las solicitudes relacionadas con las recetas.
 */
/**
 * @author Naima Farja
 *
 */
@Controller
@RequestMapping("/recetas")
public class RecetaController {

	@Autowired
	private IRecetaService recetaService;
	@Autowired
	private IIngredienteRepository ingredienteRepository;
	@Autowired
	private UploadFile uploadFile;
	@Autowired
	private ICommonService commonService;

	/**
	 * Maneja la solicitud GET a /recetas y muestra la página de categorías de recetas.
	 *
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "categorias"
	 */
	@GetMapping
	public String getCategoriaRecetasPage(Model model) {
		return "categorias";
	}

	/**
	 * Maneja la solicitud GET a /recetas/{categoria} y muestra la página de recetas para una categoría específica.
	 *
	 * @param model     el modelo de la vista
	 * @param categoria el nombre de la categoría de recetas
	 * @return el nombre de la vista "recetas"
	 */
	@GetMapping("/{categoria}")
	public String getRecetasPage(Model model, @PathVariable(value = "categoria") String categoria) {
		model.addAttribute("recetas", recetaService.getListaCategoria(categoria));
		return "recetas";
	}

	/**
	 * Maneja la solicitud GET a /recetas/nuevo y muestra la página para agregar una nueva receta.
	 *
	 * @param model el modelo de la vista
	 * @return el nombre de la vista "receta_nueva"
	 */
	@GetMapping("/nuevo")
	public String getNuevaRecetaPage(Model model) {
		boolean edicion = false;
		List<Ingrediente> listaIngredientes = ingredienteRepository.findByEstado(true);
		model.addAttribute("receta", new Receta());
		model.addAttribute("listaIngredientes", listaIngredientes);
		model.addAttribute("categorias", commonService.getRecetasCategoria());
		model.addAttribute("edicion", edicion);
		return "receta_nueva";
	}

	/**
	 * Maneja la solicitud GET a /recetas/modificar/{id} y muestra la página para modificar una receta existente.
	 *
	 * @param model el modelo de la vista
	 * @param id    el ID de la receta a modificar
	 * @return el nombre de la vista "receta_nueva"
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarRecetaPage(Model model, @PathVariable(value = "id") Long id) {
		boolean edicion = true;
		Receta recetaEncontrada = recetaService.getBy(id);
		List<Ingrediente> listaIngredientes = ingredienteRepository.findByEstado(true);
		model.addAttribute("receta", recetaEncontrada);
		model.addAttribute("categorias", commonService.getRecetasCategoria());
		model.addAttribute("edicion", edicion);
		model.addAttribute("listaIngredientes", listaIngredientes);
		return "receta_nueva";
	}

	/**
	 * Maneja la solicitud POST a /recetas/modificar y procesa la modificación de una receta existente.
	 *
	 * @param receta  el objeto Receta a modificar
	 * @param result  el resultado de la validación
	 * @param imagen  el archivo de imagen de la receta
	 * @return un objeto ModelAndView que redirige a "/gestion_de_datos" si la modificación fue exitosa
	 * @throws Exception si ocurre algún error durante el procesamiento
	 */
	@PostMapping("/modificar")
	public ModelAndView postModificarRecetaPage(@Valid @ModelAttribute("receta") Receta receta,
			BindingResult result, @RequestParam("file") MultipartFile imagen) throws Exception {
		ModelAndView modelView = new ModelAndView("redirect:/gestion_de_datos");
		boolean edicion = true;
		List<Ingrediente> listaIngredientes = ingredienteRepository.findByEstado(true);
		if (result.hasErrors()) {
			modelView.setViewName("receta_nueva");
			modelView.addObject("receta", receta);
			modelView.addObject("categorias", commonService.getRecetasCategoria());
			modelView.addObject("edicion", edicion);
			modelView.addObject("listaIngredientes", listaIngredientes);
			return modelView;
		}
		Receta areceta = recetaService.getBy(receta.getId());
		if (!imagen.isEmpty()) {
			if (areceta.getImagen() != null && areceta.getImagen().length() > 0) {
				uploadFile.delete(areceta.getImagen());
			}
			String uniqueFileName = uploadFile.copy(imagen);
			receta.setImagen(uniqueFileName);
		} else {
			if (areceta.getImagen() != null) {
				receta.setImagen(areceta.getImagen());
			}
		}
		if (areceta.getImagen() != null) {
			receta.setImagen(areceta.getImagen());
		}
		if (!imagen.isEmpty()) {
			String uniqueFileName = uploadFile.copy(imagen);
			receta.setImagen(uniqueFileName);
		}
		recetaService.guardar(receta);
		modelView.addObject("recetas", recetaService.getLista());
		return modelView;
	}

	/**
	 * Maneja la solicitud POST a /recetas/guardar y procesa el guardado de una nueva receta.
	 *
	 * @param receta  el objeto Receta a guardar
	 * @param result  el resultado de la validación
	 * @param imagen  el archivo de imagen de la receta
	 * @return un objeto ModelAndView que redirige a "/gestion_de_datos" si el guardado fue exitoso
	 * @throws Exception si ocurre algún error durante el procesamiento
	 */
	@PostMapping("/guardar")
	public ModelAndView guardarReceta(@Valid @ModelAttribute("receta") Receta receta, BindingResult result,
			@RequestParam("file") MultipartFile imagen) throws Exception {
		ModelAndView modelView = new ModelAndView("redirect:/gestion_de_datos");
		List<Ingrediente> listaIngredientes = ingredienteRepository.findByEstado(true);
		if (result.hasErrors()) {
			modelView.setViewName("receta_nueva");
			modelView.addObject("receta", receta);
			modelView.addObject("listaIngredientes", listaIngredientes);
			modelView.addObject("categorias", commonService.getRecetasCategoria());
			return modelView;
		} else {
			if (receta.getId() != null) {
				Receta areceta = recetaService.getBy(receta.getId());
				if (!imagen.isEmpty()) {
					if (areceta.getImagen() != null && areceta.getImagen().length() > 0) {
						uploadFile.delete(areceta.getImagen());
					}
					String uniqueFileName = uploadFile.copy(imagen);
					receta.setImagen(uniqueFileName);
				} else {
					if (areceta.getImagen() != null) {
						receta.setImagen(areceta.getImagen());
					}
				}
				if (areceta.getImagen() != null) {
					receta.setImagen(areceta.getImagen());
				}
				receta.setId(receta.getId() - 1);
				recetaService.guardar(receta);
			} else {
				if (!imagen.isEmpty()) {
					String uniqueFileName = uploadFile.copy(imagen);
					receta.setImagen(uniqueFileName);
				}
			}
			recetaService.guardar(receta);
			modelView.addObject("recetas", recetaService.getLista());
		}
		return modelView;
	}

	/**
	 * Maneja la solicitud GET a /recetas/eliminar/{id} y elimina una receta existente.
	 *
	 * @param id el ID de la receta a eliminar
	 * @return un objeto ModelAndView que redirige a "/gestion_de_datos"
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarRecetas(@PathVariable(value = "id") Long id) {
		Receta recetaEncontrada = recetaService.getBy(id);
		recetaService.eliminar(recetaEncontrada);
		return "redirect:/gestion_de_datos";
	}

	/**
	 * Maneja la solicitud GET a /recetas/uploads/{filename} y devuelve una respuesta con el recurso de imagen solicitado.
	 *
	 * @param filename el nombre de archivo de la imagen
	 * @return una ResponseEntity que contiene el recurso de imagen
	 */
	@GetMapping("/uploads/{filename}")
	public ResponseEntity<Resource> goImage(@PathVariable String filename) {
		Resource resource = null;
		try {
			resource = uploadFile.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\" ")
				.body(resource);
	}

	/**
	 * Maneja la solicitud GET a /recetas/mostrar/{id} y muestra la página para mostrar los detalles de una receta.
	 *
	 * @param id el ID de la receta a mostrar
	 * @return un objeto ModelAndView que muestra los detalles de la receta
	 */
	@GetMapping("/mostrar/{id}")
	public ModelAndView getPageMostrarReceta(@PathVariable("id") Long id) {
		ModelAndView modelView = new ModelAndView("recetas");
		Receta receta = recetaService.getBy(id);
		modelView.addObject("receta", receta);
		return modelView;
	}
}