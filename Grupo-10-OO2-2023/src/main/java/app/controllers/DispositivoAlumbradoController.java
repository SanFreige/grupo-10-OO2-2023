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

import app.models.Dispositivo;
import app.models.DispositivoAlumbrado;
import app.models.Evento;
import app.service.IDispositivoAlumbradoService;
import app.service.IEventoService;

@Controller
@RequestMapping("/alumbrado")
public class DispositivoAlumbradoController {
	
	@Autowired
	 IEventoService servicesEvento;
	
	@Autowired
	 IDispositivoAlumbradoService services;
	
	@GetMapping("/agregar/formnuevo")
	public String guardarDispositivo(Model model) {
		DispositivoAlumbrado alumbrado = new DispositivoAlumbrado();
		model.addAttribute("alumbrado", alumbrado);
		return "dispositivos/form-alumbrado-nuevo";
	}
	
	@PostMapping("/agregar/formnuevo")
	public String guardarDispositivo(@Valid @ModelAttribute("alumbrado") DispositivoAlumbrado alumbrado, Errors error, ModelMap model){

		if (error.hasErrors()){
			return "dispositivos/form-alumbrado-nuevo";
		}
		services.insertOrUpdate(alumbrado);
		List<DispositivoAlumbrado> alumbradoList = services.getAll();
		model.addAttribute("alumbradoList", alumbradoList);
		return "dispositivos/lista-alumbrado";
	}

	@GetMapping("/formalumbrado/{id}")
	public String editarDispositivo(@PathVariable(name="id")int id, Model model) {
		
		DispositivoAlumbrado dispositivoAlumbrado = services.findById(id);
		model.addAttribute("alumbrado", dispositivoAlumbrado);

		return "dispositivos/form-alumbrado";
	}

	@PostMapping("/formalumbrado/{id}")
	public String editarDispositivo(@Valid @ModelAttribute("alumbrado")DispositivoAlumbrado alumbrado, Errors error,  ModelMap model)
	{

		if (error.hasErrors()){
			return "dispositivos/form-alumbrado";
		}else {

		services.insertOrUpdate(alumbrado);
		List<DispositivoAlumbrado> alumbradoList = services.getAll();
		 model.addAttribute("alumbradoList", alumbradoList);
		}
		return "dispositivos/lista-alumbrado";
	}

	@GetMapping("/delete-dispositivo/{id}") 
	public String eliminarDispositivo(@PathVariable(name="id")int id, ModelMap model) {

		services.remove(id);
		List<DispositivoAlumbrado> alumbradoList = services.getAll();
		model.addAttribute("alumbradoList", alumbradoList);
		return "dispositivos/lista-alumbrado";
	}
	
	
	@GetMapping("/lista")
    public String traerAlumbrado(Model model) {

        List<DispositivoAlumbrado> alumbradoList = services.getAll();

        model.addAttribute("alumbradoList", alumbradoList);

        return "dispositivos/lista-alumbrado";
    }
	
	@GetMapping("/eventos/{id}") 
	public String eventosDispositivo(@PathVariable(name="id")int id, ModelMap model) {
		Dispositivo dispositivo = services.findById(id);
		List<Evento> eventoList =  servicesEvento.eventosByDispositivo(id);
		
		model.addAttribute("eventoList", eventoList);
		model.addAttribute("alumbrado", dispositivo);
		return "dispositivos/lista-evento-alumbrado";
	}
	
}