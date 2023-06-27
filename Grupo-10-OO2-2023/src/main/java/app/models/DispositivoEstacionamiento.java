package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivoEstacionamiento")
public class DispositivoEstacionamiento extends Dispositivo {

	@Column(name = "nroPlaza", columnDefinition = "int")
	private int nroPlaza;

	@Column(name = "ocupado", columnDefinition = "bit")
	private boolean ocupado;
}
