package persistencia.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="registro")
public class RegistroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="vehiculo_id", referencedColumnName="id", nullable=false)
	private VehiculoEntity vehiculo;
	
	@ManyToOne
	@JoinColumn(name="parqueadero_id", referencedColumnName="id", nullable=false)
	private ParqueaderoEntity parqueadero;
	
	@Column(name="fecha_ingreso", nullable=false)
	private Date fechaIngreso;

	@Column(name="fecha_salida", nullable=false)
	private Date fechaSalida;
	
	public RegistroEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

	public ParqueaderoEntity getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(ParqueaderoEntity parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	

	
	
}
