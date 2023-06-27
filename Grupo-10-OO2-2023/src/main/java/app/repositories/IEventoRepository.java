package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Evento;

public interface IEventoRepository  extends JpaRepository <Evento,Integer>{

}
