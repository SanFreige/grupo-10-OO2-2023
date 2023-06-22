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
@Table(name="zona")
public class Zona {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZona;
	
	@Column(name="nombre",columnDefinition="varchar(45)")
	private String nombre;
	
	
}
