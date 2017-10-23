package persistencia.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parqueadero")
public class ParqueaderoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="num_carros_permitidos", nullable=false)
	private int numeroCarrosPermitidos;
	
	@Column(name="num_motos_permitidos", nullable=false)
	private int numeroMotosPermitidos;

	public ParqueaderoEntity() {
	}

	public Long getId() {
		return id;
	}

	public int getNumeroCarrosPermitidos() {
		return numeroCarrosPermitidos;
	}

	public int getNumeroMotosPermitidos() {
		return numeroMotosPermitidos;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNumeroCarrosPermitidos(int numeroCarrosPermitidos) {
		this.numeroCarrosPermitidos = numeroCarrosPermitidos;
	}

	public void setNumeroMotosPermitidos(int numeroMotosPermitidos) {
		this.numeroMotosPermitidos = numeroMotosPermitidos;
	}

}
