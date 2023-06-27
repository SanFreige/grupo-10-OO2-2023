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
import lombok.var;

@Controller
@RequestMapping("/")
public class DispositivoController {
	@Autowired()
	private IDispositivoService services;
	
	@GetMapping("/dispositivos")
	public String traerTodosDispositivos(Model model) {

		var listDispositivos = services.getAll(); // var = Lombok

		model.addAttribute("listDispositivos", listDispositivos);

		return "dispositivo/listDispositivos";
	}

	@GetMapping("/{idDispositivo}")
	public String traerPorId(Model model, @PathVariable int idDispositivo) { 

		model.addAttribute("dispositivo", services.findById(idDispositivo));

		return "dispositivo/dispositivo";
	}
}
