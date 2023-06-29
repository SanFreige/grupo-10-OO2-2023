package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.Evento;

@Repository
public interface IEventoRepository  extends JpaRepository <Evento,Integer>{

	 public List<Evento> findByDispositivoId(int id);
}
