package app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.DispositivoEstacionamiento;
import app.service.IDispositivoEstacionamientoService;

@Controller
@RequestMapping("/")
public class DispositivoEstacionamientoController {
	@Autowired()
	private IDispositivoEstacionamientoService services;
	
	@GetMapping("/addDispositivo")
	public String guardarDispositivo(@Valid DispositivoEstacionamiento dispositivoEstacionamiento) {
		return "dispositivos/abmDispositivo";
	}
	
	@PostMapping("/addDispositivo")
	public String guardarDispositivo(@Valid DispositivoEstacionamiento dispositivoEstacionamiento, Errors error)
	{

		if (error.hasErrors())
		{
			return "dispositivo/insert";
		}

		services.insertOrUpdate(dispositivoEstacionamiento);
		return "redirect:/dispositivo/listDispositivo";
	}

	@GetMapping("/editDispositivo")
	public String editarDispositivo(DispositivoEstacionamiento dispositivoEstacionamiento, Model model) {

		model.addAttribute("dispositivo", services.findById(dispositivoEstacionamiento.getIdDispositivo()));

		return "dispositivo/modify";
	}

	@PostMapping("/editDispositivo")
	public String editarDispositivo(@Valid DispositivoEstacionamiento dispositivoEstacionamiento, Errors error)
	{

		if (error.hasErrors())
		{
			return "dispositivo/modify";
		}

		services.insertOrUpdate(dispositivoEstacionamiento);
		return "redirect:/dispositivo/listDispositivo";
	}

	@GetMapping("/deleteDispositivo") 
	public String eliminarDispositivo(DispositivoEstacionamiento dispositivoEstacionamiento) {

		services.remove(dispositivoEstacionamiento.getIdDispositivo());

		return "redirect:/dispositivo/listDispositivo";
	}
}
