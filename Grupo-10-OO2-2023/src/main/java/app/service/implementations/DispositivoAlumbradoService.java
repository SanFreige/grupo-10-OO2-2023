package app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.DispositivoAlumbrado;
import app.repositories.IDispositivoAlumbradoRepository;
import app.service.IDispositivoAlumbradoService;



@Service
public class DispositivoAlumbradoService implements IDispositivoAlumbradoService {

	@Autowired
	IDispositivoAlumbradoRepository repositorio;
	
	
	@Override
	public DispositivoAlumbrado findById(int idDispositivo) {
		DispositivoAlumbrado alumbrado = repositorio.findDispositivoAlumbradoById(idDispositivo);
		if(alumbrado == null) {
			return null;
		}
		return alumbrado;
	}
	
	@Override
	public boolean insertOrUpdate(DispositivoAlumbrado dispositivoAlumbrado) {
		return repositorio.save(dispositivoAlumbrado) != null? true:false;
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
	public List<DispositivoAlumbrado> getAll() {
		return repositorio.findAll();
	}
}