package app.service;

import java.util.List;

import app.models.Dispositivo;

public interface IDispositivoService {
	
	public Dispositivo findById(int idDispositivo);

	public List<Dispositivo> getAll();
}
