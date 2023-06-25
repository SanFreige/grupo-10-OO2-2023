package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Dispositivo;

public interface IDispositivoRepository extends JpaRepository <Dispositivo,Integer>{

}
