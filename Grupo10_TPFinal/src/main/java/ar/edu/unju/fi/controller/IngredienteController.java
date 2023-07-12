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

/**
 * Controlador para la gestión de ingredientes de recetas.
 * @author Naima Farja
 */
@Controller
@RequestMapping("/recetas/ingredientes")
public class IngredienteController {
    @Autowired
    IIngredienteService ingredienteService;

    /**
     * Maneja la solicitud GET para la página de listado de ingredientes.
     * 
     * @param model el modelo utilizado para pasar datos a la vista
     * @return la vista "ingredientes" con la lista de ingredientes
     */
    @GetMapping("/listado")
    public String getIngredientesPage(Model model) {
        model.addAttribute("ingredientes", ingredienteService.getListaingrediente());
        return "ingredientes";
    }

    /**
     * Maneja la solicitud GET para la página de creación de un nuevo ingrediente.
     * 
     * @param model el modelo utilizado para pasar datos a la vista
     * @return la vista "ingrediente_nuevo" con el formulario para crear un nuevo ingrediente
     */
    @GetMapping("/nuevo")
    public String getNuevoIngredientePage(Model model) {
        boolean edicion = false;
        model.addAttribute("ingrediente", ingredienteService.getIngrediente());
        model.addAttribute("edicion", edicion);
        return "ingrediente_nuevo";
    }

    /**
     * Maneja la solicitud GET para la página de modificación de un ingrediente existente.
     * 
     * @param model el modelo utilizado para pasar datos a la vista
     * @param id el ID del ingrediente a modificar
     * @return la vista "nuevo_ingrediente" con el formulario para modificar el ingrediente
     */
    @GetMapping("/modificar/{id}")
    public String getModificarIngredientePage(Model model, @PathVariable(value = "id") Long id) {
        boolean edicion = true;
        Ingrediente ingredienteEncontrado = ingredienteService.getBy(id);
        model.addAttribute("ingrediente", ingredienteEncontrado);
        model.addAttribute("edicion", edicion);
        return "nuevo_ingrediente";
    }

    /**
     * Maneja la solicitud POST para la página de modificación de un ingrediente existente.
     * 
     * @param ingrediente el objeto Ingrediente modificado
     * @param result los resultados de la validación del formulario
     * @return la vista "ingredientes" con la lista de ingredientes actualizada si no hay errores de validación,
     *         de lo contrario, vuelve a la vista "ingrediente_nuevo" con los datos del formulario y los mensajes de error
     */
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

    /**
     * Maneja la solicitud POST para la página de creación de un nuevo ingrediente.
     * 
     * @param ingrediente el objeto Ingrediente a guardar
     * @param result los resultados de la validación del formulario
     * @return la vista "redirect:/gestion_de_datos" si no hay errores de validación,
     *         de lo contrario, vuelve a la vista "ingrediente_nuevo" con los datos del formulario y los mensajes de error
     */
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

    /**
     * Maneja la solicitud GET para eliminar un ingrediente.
     * 
     * @param id el ID del ingrediente a eliminar
     * @return la vista "redirect:/gestion_de_datos" para redirigir a la página de gestión de datos
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarIngrediente(@PathVariable(value = "id") Long id) {
        Ingrediente ingredienteEncontrado = ingredienteService.getBy(id);
        ingredienteService.eliminar(ingredienteEncontrado);

        return "redirect:/gestion_de_datos";
    }
}