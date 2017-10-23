package dominio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dominio.excepcion.IngresoExcepcion;
import persistencia.sistema.SistemaPersistencia;

public class Vigilante {
	
	private static final char LETRA_INICIAL_PLACA_RESTRICCION = 'A';
	
	public static final String MENSAJE_CUPO_NO_DISPONIBLE = "No puede Ingresar porque no hay cupos disponibles";
	public static final String MENSAJE_DIA_NO_HABIL = "No puede ingresar porque no está en un día hábil";
	
	
	private SistemaPersistencia sistemaPersistencia;
	private Parqueadero parqueadero;
	private int diaHoy;
	private Calendar cal = Calendar.getInstance();
	
	
	public Vigilante(SistemaPersistencia sistemaPersistencia, Parqueadero parqueadero) {
		this.sistemaPersistencia = sistemaPersistencia;
		this.parqueadero = parqueadero;
		this.diaHoy = cal.get(Calendar.DAY_OF_WEEK);
	}

	// registrar vehiculo
	public void registrarIngresoVehiculo(Vehiculo vehiculo) {
		if(placaInicaConA(vehiculo.getPlaca()) && (!esDiaHabil()))
			throw new IngresoExcepcion(MENSAJE_DIA_NO_HABIL);
		
		if(!capacidadParqueaderoDisponible(vehiculo))
			throw new IngresoExcepcion(MENSAJE_CUPO_NO_DISPONIBLE);
		

		sistemaPersistencia.iniciar();
		
		this.ingresarVehiculoSiNoExiste(vehiculo);
		Registro registro = new Registro(vehiculo, this.parqueadero, new Date());
		
		sistemaPersistencia.repositorioRegistro().agregar(registro);
		sistemaPersistencia.terminar();
			
	}
 
	private boolean capacidadParqueaderoDisponible(Vehiculo vehiculo) {
		int numeroDeVehiculosRegistrados = sistemaPersistencia
				.repositorioRegistro().obtenerCupoPorTipo(vehiculo);

		if (this.parqueadero.getCapacidadPorTipo(vehiculo) > 
			numeroDeVehiculosRegistrados) {
			return true;
		}
		
		return false;
	}

	// agregar vehiculo a persistencia si no existe
	private void ingresarVehiculoSiNoExiste(Vehiculo vehiculo) {

		Vehiculo vehiculoBuscado = sistemaPersistencia
				.repositorioVehiculo().obtenerPorPlaca(vehiculo.getPlaca());

		if(vehiculoBuscado == null) {
			sistemaPersistencia.repositorioVehiculo().agregar(vehiculo);
		}
	}

	// saber si dia es habil para ingreso
	private boolean esDiaHabil() {
		for(Integer i : this.parqueadero.getDiasHabiles()) {
			if(this.getDiaHoy() == i.intValue())
				return true;
		}
		
		return false;
	}
	
	// saber si placa inicia con A
	private boolean placaInicaConA(String placa) {
		if(placa == null)
			return false;
		
		if (placa.charAt(0) == LETRA_INICIAL_PLACA_RESTRICCION)
			return true;
		
		return false;
	}

	// registrar salida de un vehiculo
	public void registrarSalidaVehiculo(String placa) {	
	}
	
	public int getDiaHoy() {
		return diaHoy;
	}

	public void setDiaHoy(int diaHoy) {
		this.diaHoy = diaHoy;
	}
	
	
}
