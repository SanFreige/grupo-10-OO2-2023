package app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Dispositivo;
import app.repositories.IDispositivoRepository;
import app.service.IDispositivoService;

@Service
public class DispositivoService implements IDispositivoService {
	
	@Autowired()
	 IDispositivoRepository repositorio;
	
	
	@Override
	public Dispositivo findById(int idDispositivo) {
		// TODO Auto-generated method stub
		return repositorio.findDispositivoById(idDispositivo);
	}

	@Override
	public List<Dispositivo> getAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}
}