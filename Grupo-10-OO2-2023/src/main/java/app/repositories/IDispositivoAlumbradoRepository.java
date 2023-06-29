package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.DispositivoAlumbrado;

@Repository
public interface IDispositivoAlumbradoRepository extends JpaRepository <DispositivoAlumbrado,Integer>{
	
	 public DispositivoAlumbrado findDispositivoAlumbradoById(int id);

}
