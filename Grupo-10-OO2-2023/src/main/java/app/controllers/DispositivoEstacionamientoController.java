package app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.DispositivoEstacionamiento;
import app.models.Evento;
import app.models.Dispositivo;
import app.service.IDispositivoEstacionamientoService;
import app.service.IEventoService;

@Controller
@RequestMapping("/estacionamiento")
public class DispositivoEstacionamientoController {
	
	@Autowired
	 IEventoService servicesEvento;
	
	@Autowired
	 IDispositivoEstacionamientoService services;
	
	@GetMapping("/agregar/formnuevo")
	public String guardarDispositivo(Model model) {
		DispositivoEstacionamiento estacionamiento = new DispositivoEstacionamiento();
		model.addAttribute("estacionamiento", estacionamiento);
		return "dispositivos/form-estacionamiento-nuevo";
	}
	
	@PostMapping("/agregar/formnuevo")
	public String guardarDispositivo(@Valid @ModelAttribute("estacionamiento") DispositivoEstacionamiento estacionamiento, Errors error, ModelMap model){

		if (error.hasErrors()){
			return "dispositivos/form-estacionamiento-nuevo";
		}
		services.insertOrUpdate(estacionamiento);
		List<DispositivoEstacionamiento> estacionamientoList = services.getAll();
		model.addAttribute("estacionamientoList", estacionamientoList);
		return "dispositivos/lista-estacionamiento";
	}

	@GetMapping("/formestacionamiento/{id}")
	public String editarDispositivo(@PathVariable(name="id")int id, Model model) {
		
		DispositivoEstacionamiento dispositivoEstacionamiento = services.findById(id);
		model.addAttribute("estacionamiento", dispositivoEstacionamiento);

		return "dispositivos/form-estacionamiento";
	}

	@PostMapping("/formestacionamiento/{id}")
	public String editarDispositivo(@Valid @ModelAttribute("estacionamiento")DispositivoEstacionamiento estacionamiento, Errors error,  ModelMap model)
	{

		if (error.hasErrors()){
			return "dispositivos/form-estacionamiento";
		}else {

		services.insertOrUpdate(estacionamiento);
		List<DispositivoEstacionamiento> estacionamientoList = services.getAll();
		 model.addAttribute("estacionamientoList", estacionamientoList);
		}
		return "dispositivos/lista-estacionamiento";
	}

	@GetMapping("/delete-dispositivo/{id}") 
	public String eliminarDispositivo(@PathVariable(name="id")int id, ModelMap model) {

		services.remove(id);
		List<DispositivoEstacionamiento> estacionamientoList = services.getAll();
		model.addAttribute("estacionamientoList", estacionamientoList);
		return "dispositivos/lista-estacionamiento";
	}
	
	
	@GetMapping("/lista")
    public String traerEstacionamientos(Model model) {

        List<DispositivoEstacionamiento> estacionamientoList = services.getAll();

        model.addAttribute("estacionamientoList", estacionamientoList);

        return "dispositivos/lista-estacionamiento";
    }
	
	@GetMapping("/eventos/{id}") 
	public String eventosDispositivo(@PathVariable(name="id")int id, ModelMap model) {
		Dispositivo dispositivo = services.findById(id);
		List<Evento> eventoList =  servicesEvento.eventosByDispositivo(id);
		
		model.addAttribute("eventoList", eventoList);
		model.addAttribute("estacionamiento", dispositivo);
		return "dispositivos/lista-eventos";
	}
	
}
