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
import app.service.IDispositivoService;
import lombok.var;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	@Autowired()
	private IDispositivoService services;
	
	@GetMapping("/menu")
	public String menu() {
		return "dispositivos/menu";
	}
}
