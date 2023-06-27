package app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.models.Evento;
import app.repositories.IEventoRepository;

public class EventoService {
	@Autowired()
	private IEventoRepository repositorio;
	
	
	public Evento findById(int idEvento) {
		// TODO Auto-generated method stub
		return repositorio.findById(idEvento).orElse(null);
	}

	
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	public boolean insertOrUpdate(Evento evento) {
		// TODO Auto-generated method stub
		return repositorio.save(evento) != null? true:false;
	}

	public boolean remove(int idEvento) {
		// TODO Auto-generated method stub
		try {
			repositorio.deleteById(idEvento);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
