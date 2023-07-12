package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.ITestimonioService;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {
	@Autowired
	ITestimonioService testimonioService;
	@Autowired
	IUsuarioRepository usuarioRepository;
	@Autowired
	Testimonio testimonio;

	
	 /**
     * Maneja las solicitudes GET a la URL "/testimonios".
     * Obtiene la lista de testimonios y la agrega al modelo.
     * Devuelve la plantilla de vista "testimonios".
     *
     * @param model El objeto modelo para pasar datos a la vista.
     * @return El nombre de la vista "testimonios".
     */
	@GetMapping
	public String getTestimonioPage(Model model) {
		model.addAttribute("testimonio", testimonioService.getListaT());
		return "testimonios";
	}
	
	/**
     * Maneja las solicitudes GET a la URL "/testimonios/nuevotest".
     * Agrega un nuevo testimonio vacío al modelo.
     * Devuelve la plantilla de vista "testimonio_nuevo".
     *
     * @param model El objeto modelo para pasar datos a la vista.
     * @return El nombre de la vista "testimonio_nuevo".
     */
	
	@GetMapping("/nuevotest")
	public String nuevoTestimonio(Model model) {
		model.addAttribute("testimonio", testimonio);
		return "testimonio_nuevo";
	}

	/**
     * Maneja las solicitudes POST a la URL "/testimonios/guardar" para guardar un testimonio.
     * Recupera el usuario por su ID desde el repositorio.
     * Si el usuario existe, verifica si ya tiene un testimonio existente y lo actualiza.
     * Si no tiene un testimonio existente, crea un nuevo testimonio y lo guarda.
     * Si el ID del usuario no se encuentra, agrega un mensaje de error al atributo flash del modelo.
     * Redirige a la URL "/testimonios".
     *
     * @param model      El objeto modelo para pasar datos a la vista.
     * @param id         El ID del usuario.
     * @param comentario El comentario del testimonio.
     * @param attributes Atributos para pasar mensajes entre redirecciones.
     * @return La URL de redirección a "/testimonios".
     */
	
    @PostMapping("/guardar")
    public String guardarTestimonio(Model model, @RequestParam(value = "usuid") Long id,
            @RequestParam(value = "comentario") String comentario, RedirectAttributes attributes) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
       
        if (optionalUsuario.isPresent()) {
        	Usuario usuarioEncontrado = optionalUsuario.get();
            Testimonio testimonioExistente = testimonioService.getByUserId(id);
            if (testimonioExistente != null) {
                
                testimonioExistente.setComentario(comentario);
                testimonioService.guardarTestimonio(testimonioExistente);
            } else {
             
                Testimonio nuevoTestimonio = testimonioService.getTestimonio();
                nuevoTestimonio.setUsuario(usuarioEncontrado);
                nuevoTestimonio.setComentario(comentario);
                testimonioService.guardarTestimonio(nuevoTestimonio);
            }
        } else {
        
            attributes.addFlashAttribute("error", "El ID ingresado no pertenece a un usuario existente");
        }
        return "redirect:/testimonios";
    }



    /**
     * Maneja las solicitudes GET a la URL "/testimonios/eliminar/{id}" para eliminar un testimonio.
     * Recupera el testimonio por su ID y lo elimina.
     * Redirige a la URL "/gestion".
     *
     * @param id El ID del testimonio a eliminar.
     * @return La URL de redirección a "/gestion".
     */

	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value = "id") Long id) {
		Testimonio testimonio = testimonioService.getBy(id);
		testimonioService.eliminarTestimonio(testimonio);
		return "redirect:/gestion";
	}
}