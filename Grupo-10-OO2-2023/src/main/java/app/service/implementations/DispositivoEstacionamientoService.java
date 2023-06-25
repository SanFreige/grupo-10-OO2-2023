package app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import app.models.Dispositivo;
import app.models.DispositivoEstacionamiento;
import app.models.Zona;
import app.repositories.IDispositivoEstacionamientoRepository;
import app.repositories.IZonaRepository;
import app.service.IDispositivoEstacionamientoService;

public class DispositivoEstacionamientoService implements IDispositivoEstacionamientoService{

	@Autowired()
	private IDispositivoEstacionamientoRepository repositorio;
	
	
	@Override
	public DispositivoEstacionamiento findById(int idDispositivo) {
		// TODO Auto-generated method stub
		return repositorio.findById(idDispositivo).orElse(null);
	}
	
	@Override
	public boolean insertOrUpdate(DispositivoEstacionamiento dispositivoEstacionamiento) {
		// TODO Auto-generated method stub
		return repositorio.save(dispositivoEstacionamiento) != null? true:false;
	}

	@Override
	public boolean remove(int idDispositivo) {
		// TODO Auto-generated method stub
		try {
			repositorio.deleteById(idDispositivo);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
