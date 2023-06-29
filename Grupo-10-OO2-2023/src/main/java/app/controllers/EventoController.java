package app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.Evento;
import app.service.IEventoService;
import lombok.var;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	 IEventoService services;
	
	@GetMapping("/eventos")
	public String traerTodosEvento(Model model) {

		var listEvento = services.getAll(); // var = Lombok

		// inyeccion Thymeleaf
		model.addAttribute("listEvento", listEvento);

		return "zona/listZona";
	}

	@GetMapping("/{idEvento}")
	public String traerPorId(Model model, @PathVariable int idEvento) {
		model.addAttribute("evento", services.findById(idEvento));

		return "evento/evento";
	}

	@PostMapping("/addEvento")
	public String guardarEvento(@Valid Evento evento, Errors error)
	{
		if (error.hasErrors())
		{
			return "evento/insert";
		}

		services.insertOrUpdate(evento);
		return "redirect:/evento/listEvento";
	}

	@GetMapping("/editEvento") 
	public String editarEventoGet(Evento evento, Model model) {

		model.addAttribute("evento", services.findById(evento.getId()));

		return "evento/modify";
	}

	@PostMapping("/editEvento")
	public String editarEventoPost(@Valid Evento evento, Errors error) 
	{

		if (error.hasErrors()) 
		{
			return "evento/modify"; 
		}

		services.insertOrUpdate(evento);
		return "redirect:/evento/listEvento";
	}

	// Type: Query Parameter
	@GetMapping("/deleteEvento") 
	public String eliminarZona(Evento evento) {

		services.remove(evento.getId()); 

		return "redirect:/evento/listEvento"; 
	}
}
