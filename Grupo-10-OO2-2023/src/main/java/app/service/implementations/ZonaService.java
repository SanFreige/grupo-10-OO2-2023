package app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Zona;
import app.repositories.IZonaRepository;
import app.service.IZonaService;
@Service
public class ZonaService implements IZonaService{
	
	@Autowired()
	private IZonaRepository repositorio;
	
	
	@Override
	public Zona findById(int idZona) {
		// TODO Auto-generated method stub
		return repositorio.findById(idZona).orElse(null);
	}

	@Override
	public List<Zona> getAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public boolean insertOrUpdate(Zona zona) {
		// TODO Auto-generated method stub
		return repositorio.save(zona) != null? true:false;
	}

	@Override
	public boolean remove(int idZona) {
		// TODO Auto-generated method stub
		try {
			repositorio.deleteById(idZona);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}


}
