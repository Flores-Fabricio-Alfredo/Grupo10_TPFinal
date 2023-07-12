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

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IIndiceMasaCorporalService;
import ar.edu.unju.fi.service.IUsuarioService;
@Controller
@RequestMapping("/")
public class CalcularImcController {

	/**
	 * Inyección de dependencias utilizando la anotación @Autowired.
	 * Se inyectan las siguientes dependencias:
	 * - IIndiceMasaCorporalService: Servicio para el cálculo del Índice de Masa Corporal (IMC).
	 * - IUsuarioRepository: Repositorio para acceder a los datos de los usuarios.
	 * - IUsuarioService: Servicio para operaciones relacionadas con los usuarios.
	 */
	@Autowired
	private IIndiceMasaCorporalService indiceMasaCorporalService;
	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private IUsuarioService usuarioService;

	/**
	 * Método controlador para obtener la página de cálculo del Índice de Masa Corporal (IMC).
	 * 
	 * @param model El modelo utilizado para pasar datos a la vista.
	 * @return El nombre de la vista para mostrar la calculadora.
	 */
	@GetMapping("/calcular")
	
	public String getCalcularImcPage(Model model) {
		model.addAttribute("mostrarBotonVolver", true);
		model.addAttribute("imc", indiceMasaCorporalService.getIMC());
		return "calculadora_imc";
	}

	/**
	 * Método controlador para calcular el Índice de Masa Corporal (IMC) de un usuario.
	 * 
	 * @param id     El ID del usuario para el cálculo del IMC.
	 * @param peso   El peso del usuario en kilogramos.
	 * @param model  El modelo utilizado para pasar datos a la vista.
	 * @return       El nombre de la vista para mostrar el resultado del cálculo del IMC.
	 */
	@PostMapping("/calcular/calculo")
	public String calcularIMC(@RequestParam(value = "id") Long id, @RequestParam(value = "peso") Double peso,
			Model model) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		
		if (optionalUsuario.isPresent()) {
			Usuario usuarioEncontrado = optionalUsuario.get();
			Double altura = usuarioEncontrado.getEstatura();
			IndiceMasaCorporal imc = indiceMasaCorporalService.getIMC();
			
			imc.setImc(indiceMasaCorporalService.calcularIMC(peso, altura));
			imc.setUsuarioImc(usuarioEncontrado.getNombre() + " " + usuarioEncontrado.getApellido());
			imc.setUsuario(usuarioEncontrado);
			
			if (imc.getId() != null) {
				imc.setId(imc.getId() + 1);
			}
		
			indiceMasaCorporalService.guardarIMC(imc);
			usuarioEncontrado.añadirImc(imc);
			usuarioService.guardar(usuarioEncontrado);

			model.addAttribute("resultadoIMC", imc.getImc());
			model.addAttribute("usuario", usuarioEncontrado);
		}
		
		if (optionalUsuario.isEmpty()) {
			model.addAttribute("mensaje", "El codigo ingresado no pertenece a un usuario");
			return "calculadora_imc";
		}
		return "imc_tabla";
	}
	
	/**
	 * Método controlador para eliminar un usuario y su correspondiente Índice de Masa Corporal (IMC) por su ID.
	 *
	 * @param id El ID del usuario a eliminar.
	 * @return Redirecciona a la página de gestión de datos después de eliminar el usuario.
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(value = "id") Long id) {
		IndiceMasaCorporal imc = indiceMasaCorporalService.getBy(id);
		indiceMasaCorporalService.eliminarIMC(imc);
		return "redirect:/gestion_de_datos";
	}

}
