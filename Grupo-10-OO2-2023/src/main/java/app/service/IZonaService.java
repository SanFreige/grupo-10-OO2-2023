package app.service;

import java.util.List;

import app.models.Zona;

public interface IZonaService {
	public Zona findById(int idZona);

	public List<Zona> getAll();

	public boolean insertOrUpdate(Zona zona);

	public boolean remove(int idZona);
	
}
