package app.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "zona")
public class Zona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idZona;

	@Column(name = "nombre", columnDefinition = "varchar(45)")
	private String nombre;

}
