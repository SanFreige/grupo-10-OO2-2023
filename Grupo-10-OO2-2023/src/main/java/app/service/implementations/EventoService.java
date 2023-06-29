package app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Evento;
import app.repositories.IEventoRepository;
import app.service.IEventoService;

@Service
public class EventoService implements IEventoService {
	
	@Autowired
   IEventoRepository repositorio;
	
	
	public Evento findById(int idEvento) {
		return repositorio.findById(idEvento).orElse(null);
	}

	
	public List<Evento> getAll() {
		return repositorio.findAll();
	}

	public boolean insertOrUpdate(Evento evento) {
		return repositorio.save(evento) != null? true:false;
	}

	public boolean remove(int idEvento) {
		try {
			repositorio.deleteById(idEvento);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Evento> eventosByDispositivo(int id) {
		return repositorio.findByDispositivoId(id);
	}
	
}

