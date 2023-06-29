package app.service;

import java.util.List;

import app.models.DispositivoAlumbrado;

public interface IDispositivoAlumbradoService {
	
	public DispositivoAlumbrado findById(int idDispositivo);
	
	public boolean insertOrUpdate(DispositivoAlumbrado dispositivoAlumbrado);

	public boolean remove(int idDispositivo);
	
	public List<DispositivoAlumbrado> getAll();
}
