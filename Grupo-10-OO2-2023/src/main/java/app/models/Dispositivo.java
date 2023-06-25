package app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Dispositivo")
public class Dispositivo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDispositivo;
	
	@Column(name="nombre",columnDefinition="varchar(45)")
	private String nombre;
	
	@Column(name="zona",columnDefinition="varchar(45)")
	private String zona;
	
	@Column(name="fechaHora",columnDefinition="LocalDateTime")
	private String fechaHora;
	
	@Column(name="baja",columnDefinition="boolean")
	private boolean baja;
}
