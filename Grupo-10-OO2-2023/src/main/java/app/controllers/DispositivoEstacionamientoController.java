package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.DispositivoEstacionamiento;
import app.service.IDispositivoEstacionamientoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class DispositivoEstacionamientoController {
	@Autowired()
	private IDispositivoEstacionamientoService services;
	
	@PostMapping("/addZona")
	public String guardarDispositivo(@Valid DispositivoEstacionamiento dispositivoEstacionamiento, Errors error) // Inyecta automaticamente al ser metodo <post> busca en:
																// th:action="@{/addBuilding}" method="post"
	{
		// log.info("CONTROLLER [Building]"); // info console
		// log.debug("METHOD [saveBuilding]"); // details console

		if (error.hasErrors()) // En caso de un error en las validaciones
		{
			return "dispositivo/insert"; // Se queda en la pagina y muestra los errores
		}

		services.insertOrUpdate(dispositivoEstacionamiento);
		return "redirect:/dispositivo/listDispositivo";
	}

	@GetMapping("/editDispositivo") // Al pasarle el parametro {idBuilding} lo relaciona con el parametro de
								// Building
	public String editarDispositivo(DispositivoEstacionamiento dispositivoEstacionamiento, Model model) {

		model.addAttribute("dispositivo", services.findById(dispositivoEstacionamiento.getIdDispositivo())); // Necesario "instanciar" el objeto para ser
																			// mostrado en Thymeleaf

		return "dispositivo/modify"; // go to: pagina de ins
	}

	@PostMapping("/editDispositivo")
	public String editarDispositivo(@Valid DispositivoEstacionamiento dispositivoEstacionamiento, Errors error) // Inyecta automaticamente al ser metodo <post> busca en:
																// th:action="@{/addBuilding}" method="post"
	{

		if (error.hasErrors()) // En caso de un error en las validaciones
		{
			return "dispositivo/modify"; // Se queda en la pagina y muestra los errores
		}

		services.insertOrUpdate(dispositivoEstacionamiento);
		return "redirect:/dispositivo/listDispositivo";
	}

	// Type: Query Parameter
	@GetMapping("/deleteZona") // Relaciona el IdRole en el HTML con el controlador para "apuntar" al correcto
	public String eliminarZona(DispositivoEstacionamiento dispositivoEstacionamiento) {

		services.remove(dispositivoEstacionamiento.getIdDispositivo()); // remueve el rol

		return "redirect:/dispositivo/listDispositivo"; // go to: home page
	}
}
