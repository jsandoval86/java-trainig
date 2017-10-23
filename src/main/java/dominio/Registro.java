package dominio;

import java.util.Date;

public class Registro {
	
	private Vehiculo vehiculo;
	private Parqueadero parqueadero;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	
	public Registro() {
	}

	public Registro(Vehiculo vehiculo, Parqueadero parqueadero) {
		this.vehiculo = vehiculo;
		this.parqueadero = parqueadero;
		this.fechaIngreso = new Date();
		this.fechaSalida = null;
	}
	
	public Registro(Vehiculo vehiculo, Parqueadero parqueadero, Date fechaIngreso) {
		this.vehiculo = vehiculo;
		this.parqueadero = parqueadero;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = null;
	}
	
	public Registro(Vehiculo vehiculo, Parqueadero parqueadero, Date fechaIngreso, Date fechaSalida) {
		this.vehiculo = vehiculo;
		this.parqueadero = parqueadero;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Parqueadero getParqueadero() {
		return parqueadero;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
		
}
