package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.Zona;
import app.repositories.IZonaRepository;
import app.service.IZonaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")

public class ZonaController {
	@Autowired()
	private IZonaService services;

	@GetMapping("/zonas")
	public String traerTodasZonas(Model model) {
		// log.info("CONTROLLER [BUILDING]"); // info console: Para no perder la pista
		// del controlador (opcional)
		// log.debug("METHOD [Buildings]"); // details console: Para saber que metodo se
		// esta ejecutando (opcional)

		var listZona = services.getAll(); // var = Lombok

		// inyeccion Thymeleaf
		model.addAttribute("listZona", listZona);

		return "zona/listZona";
	}

	@GetMapping("/{idZona}")
	public String traerPorId(Model model, @PathVariable int idZona) { // Relaciona el Id con el parametro

		// log.info("CONTROLLER [BUILDING]"); // info console
		// log.debug("METHOD [bringBuilding]"); // details console

		model.addAttribute("zona", services.findById(idZona));

		return "zona/zona";
	}

	@PostMapping("/addZona")
	public String guardarZona(@Valid Zona zona, Errors error) // Inyecta automaticamente al ser metodo <post> busca en:
																// th:action="@{/addBuilding}" method="post"
	{
		// log.info("CONTROLLER [Building]"); // info console
		// log.debug("METHOD [saveBuilding]"); // details console

		if (error.hasErrors()) // En caso de un error en las validaciones
		{
			return "zona/insert"; // Se queda en la pagina y muestra los errores
		}

		services.insertOrUpdate(zona);
		return "redirect:/zona/listZona";
	}

	@GetMapping("/editZona") // Al pasarle el parametro {idBuilding} lo relaciona con el parametro de
								// Building
	public String editarZona(Zona zona, Model model) {

		model.addAttribute("zona", services.findById(zona.getIdZona())); // Necesario "instanciar" el objeto para ser
																			// mostrado en Thymeleaf

		return "zona/modify"; // go to: pagina de ins
	}

	@PostMapping("/editZona")
	public String editarZona(@Valid Zona zona, Errors error) // Inyecta automaticamente al ser metodo <post> busca en:
																// th:action="@{/addBuilding}" method="post"
	{

		if (error.hasErrors()) // En caso de un error en las validaciones
		{
			return "zona/modify"; // Se queda en la pagina y muestra los errores
		}

		services.insertOrUpdate(zona);
		return "redirect:/zona/listZona";
	}

	// Type: Query Parameter
	@GetMapping("/deleteZona") // Relaciona el IdRole en el HTML con el controlador para "apuntar" al correcto
	public String eliminarZona(Zona zona) {

		services.remove(zona.getIdZona()); // remueve el rol

		return "redirect:/zona/listZona"; // go to: home page
	}
}
