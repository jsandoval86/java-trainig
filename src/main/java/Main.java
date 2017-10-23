
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.NoResultException;

import dominio.Parqueadero;
import dominio.Registro;
import dominio.Vehiculo;
import dominio.Vigilante;
import dominio.excepcion.IngresoExcepcion;
import dominio.repositorio.IRepositorioVehiculo;
import persistencia.sistema.SistemaPersistencia;

public class Main {

	public static void main(String[] args) {
		Vehiculo vehiculo = new Vehiculo("DSJ-458", 230, 1);
		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setIdentificador(1);
		parqueadero.setNumeroCarrosPermitidos(20);
		parqueadero.setNumeroMotosPermitidas(10);
		
		List<Integer> diasHabiles = new ArrayList<Integer>();
		diasHabiles.add(new Integer(Calendar.SUNDAY));
		diasHabiles.add(new Integer(Calendar.MONDAY));
	
		parqueadero.setDiasHabiles(diasHabiles);
		
		SistemaPersistencia sistemaPersistencia = new SistemaPersistencia();
		
		Vigilante vigilante = new Vigilante(sistemaPersistencia, parqueadero);
		try {
			vigilante.registrarIngresoVehiculo(vehiculo);
		}
		catch(IngresoExcepcion e) {
			System.out.println("Ocurrio un error: " + e.getMessage());
		}
	
		
		
	}
}

