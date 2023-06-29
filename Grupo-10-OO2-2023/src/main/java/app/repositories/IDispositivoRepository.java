package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.Dispositivo;

@Repository
public interface IDispositivoRepository extends JpaRepository <Dispositivo,Integer>{
	 public Dispositivo findDispositivoById(int id);
}
