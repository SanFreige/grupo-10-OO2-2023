package app.service;

import java.util.List;

import app.models.Evento;

public interface IEventoService {
	public Evento findById(int idEvento);

	public List<Evento> getAll();

	public boolean insertOrUpdate(Evento evento);

	public boolean remove(int idEvento);
	
	public List<Evento> eventosByDispositivo(int id);
}
