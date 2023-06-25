package app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="DispositivoEstacionamiento")
public class DispositivoEstacionamiento extends Dispositivo{

	@Column(name="nroPlaza",columnDefinition="int")
	private int nroPlaza;
	
	@Column(name="ocupado",columnDefinition="boolean")
	private boolean ocupado;
}
