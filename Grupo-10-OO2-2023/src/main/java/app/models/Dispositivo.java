package app.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dispositivos")
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDispositivo;

	@Column(name = "nombre", columnDefinition = "varchar(45)")
	private String nombre;

	@Column(name = "zona", columnDefinition = "varchar(45)")
	private String zona;

	@Column(name = "fechaHora", columnDefinition = "Time")
	private String fechaHora;

	@Column(name = "baja", columnDefinition = "Bit")
	private boolean baja;
	
	@ManyToOne(fetch = FetchType.LAZY) //trae un solo aula
	@JoinColumn(name = "dispositivoEstacionamientoId")
	private DispositivoEstacionamiento dispositivoEstacionamiento;
}
