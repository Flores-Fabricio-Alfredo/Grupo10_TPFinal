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

	@GetMapping
	public String getTestimonioPage(Model model) {
		model.addAttribute("testimonioLista", testimonioService.getListaT());
		return "testimonios";
	}

    @PostMapping("/guardar")
    public String guardarTestimonio(Model model, @RequestParam(value = "id") Long id,
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




	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value = "id") Long id) {
		Testimonio testimonio = testimonioService.getBy(id);
		testimonioService.eliminarTestimonio(testimonio);
		return "redirect:/gestion";
	}
}
