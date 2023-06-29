package app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.DispositivoEstacionamiento;
import app.repositories.IDispositivoEstacionamientoRepository;
import app.service.IDispositivoEstacionamientoService;

@Service
public class DispositivoEstacionamientoService implements IDispositivoEstacionamientoService {

	@Autowired
	IDispositivoEstacionamientoRepository repositorio;
	
	
	@Override
	public DispositivoEstacionamiento findById(int idDispositivo) {
		DispositivoEstacionamiento estacionamiento = repositorio.findDispositivoEstacionamientoById(idDispositivo);
		if(estacionamiento == null) {
			return null;
		}
		return estacionamiento;
	}
	
	@Override
	public boolean insertOrUpdate(DispositivoEstacionamiento dispositivoEstacionamiento) {
		return repositorio.save(dispositivoEstacionamiento) != null? true:false;
	}

	@Override
	public boolean remove(int idDispositivo) {
		try {
			repositorio.deleteById(idDispositivo);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<DispositivoEstacionamiento> getAll() {
		return repositorio.findAll();
	}
}

