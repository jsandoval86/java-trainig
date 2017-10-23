package persistencia.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tarifa", 
	uniqueConstraints={
		@UniqueConstraint(columnNames={"tipo_vehiculo_id", "parqueadero_id"})
	}
)
public class TarifaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tipo_vehiculo_id", referencedColumnName="id", nullable=false)
	private TipoVehiculoEntity tipoVehiculo;
	
	@ManyToOne
	@JoinColumn(name="parqueadero_id", referencedColumnName="id", nullable=false)
	private ParqueaderoEntity parqueadero;
	
	@Column(name="tarifa_dia", nullable=true)
	private double tarifaDia;
	
	@Column(name="tarifa_hora", nullable=true)
	private double tarifaHora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public ParqueaderoEntity getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(ParqueaderoEntity parqueadero) {
		this.parqueadero = parqueadero;
	}

	public double getTarifaDia() {
		return tarifaDia;
	}

	public void setTarifaDia(double tarifaDia) {
		this.tarifaDia = tarifaDia;
	}

	public double getTarifaHora() {
		return tarifaHora;
	}

	public void setTarifaHora(double tarifaHora) {
		this.tarifaHora = tarifaHora;
	}
	
}
