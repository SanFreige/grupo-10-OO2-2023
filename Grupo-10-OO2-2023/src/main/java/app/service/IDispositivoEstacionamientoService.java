package app.service;

import app.models.DispositivoEstacionamiento;

public interface IDispositivoEstacionamientoService {
	
	public DispositivoEstacionamiento findById(int idDispositivo);
	
	public boolean insertOrUpdate(DispositivoEstacionamiento dispositivoEstacionamiento);

	public boolean remove(int idDispositivo);
}
