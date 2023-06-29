package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.DispositivoEstacionamiento;

@Repository
public interface IDispositivoEstacionamientoRepository extends JpaRepository <DispositivoEstacionamiento,Integer>{
	
	 public DispositivoEstacionamiento findDispositivoEstacionamientoById(int id);

}
