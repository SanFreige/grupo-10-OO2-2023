package app.models;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dispositivos")
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "zona")
	private String zona;

	@CreationTimestamp
	@Column(name="fecha_hora")
	private LocalDateTime fechaHora;

	@Column(name = "baja")
	private boolean baja;
	
	@OneToMany(mappedBy="id")
	private List<Evento> eventos;

}
