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
@Table(name = "dispositivoAlumbrado")
public class DispositivoAlumbrado extends Dispositivo {

	@Column(name="cantLuz")
	private double cantLuz;
	
	@Column(name="hayPersonas")
	private boolean hayPersonas;
}
