package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.Dispositivo;
import app.models.Zona;
import app.service.IDispositivoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class DispositivoController {
	@Autowired()
	private IDispositivoService services;
	
	@GetMapping("/dispositivos")
	public String traerTodosDispositivos(Model model) {
		// log.info("CONTROLLER [BUILDING]"); // info console: Para no perder la pista
		// del controlador (opcional)
		// log.debug("METHOD [Buildings]"); // details console: Para saber que metodo se
		// esta ejecutando (opcional)

		var listDispositivos = services.getAll(); // var = Lombok

		// inyeccion Thymeleaf
		model.addAttribute("listDispositivos", listDispositivos);

		return "zona/listDispositivos";
	}

	@GetMapping("/{idDispositivo}")
	public String traerPorId(Model model, @PathVariable int idDispositivo) { // Relaciona el Id con el parametro

		// log.info("CONTROLLER [BUILDING]"); // info console
		// log.debug("METHOD [bringBuilding]"); // details console

		model.addAttribute("dispositivo", services.findById(idDispositivo));

		return "dispositivo/dispositivo";
	}
}
