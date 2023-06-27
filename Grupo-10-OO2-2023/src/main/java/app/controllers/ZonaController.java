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

import app.models.Zona;
import app.repositories.IZonaRepository;
import app.service.IZonaService;
import lombok.var;

@Controller
@RequestMapping("/")

public class ZonaController {
	@Autowired()
	private IZonaService services;

	@GetMapping("/zonas")
	public String traerTodasZonas(Model model) {

		var listZona = services.getAll(); // var = Lombok

		// inyeccion Thymeleaf
		model.addAttribute("listZona", listZona);

		return "zona/listZona";
	}

	@GetMapping("/{idZona}")
	public String traerPorId(Model model, @PathVariable int idZona) {
		model.addAttribute("zona", services.findById(idZona));

		return "zona/zona";
	}

	@PostMapping("/addZona")
	public String guardarZona(@Valid Zona zona, Errors error)
	{
		if (error.hasErrors())
		{
			return "zona/insert";
		}

		services.insertOrUpdate(zona);
		return "redirect:/zona/listZona";
	}

	@GetMapping("/editZona") 
	public String editarZona(Zona zona, Model model) {

		model.addAttribute("zona", services.findById(zona.getIdZona()));

		return "zona/modify";
	}

	@PostMapping("/editZona")
	public String editarZona(@Valid Zona zona, Errors error) 
	{

		if (error.hasErrors()) 
		{
			return "zona/modify"; 
		}

		services.insertOrUpdate(zona);
		return "redirect:/zona/listZona";
	}

	// Type: Query Parameter
	@GetMapping("/deleteZona") 
	public String eliminarZona(Zona zona) {

		services.remove(zona.getIdZona()); 

		return "redirect:/zona/listZona"; 
	}
}
