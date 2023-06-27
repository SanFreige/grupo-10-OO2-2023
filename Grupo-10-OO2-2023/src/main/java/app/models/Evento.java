package app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;

	@Column(name = "descripcion", columnDefinition = "varchar(45)")
	private String descripcion;

	@Column(name = "fechaHoraRegistro", columnDefinition = "Time")
	private String zona;
	
	@ManyToOne(fetch = FetchType.LAZY) //trae un solo aula
	@JoinColumn(name = "dispositivoId")
	private Dispositivo dispositivo;
}
