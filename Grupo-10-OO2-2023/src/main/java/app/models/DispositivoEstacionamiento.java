package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name = "dispositivoEstacionamiento")
public class DispositivoEstacionamiento extends Dispositivo {

	@Column(name = "nro_plaza")
	private int nroPlaza;

	@Column(name = "ocupado")
	private boolean ocupado;
}
