package dominio.unitaria;

import org.junit.Test;
import org.junit.runner.RunWith;

import dominio.Parqueadero;
import dominio.Registro;
import dominio.Vehiculo;
import dominio.Vigilante;
import dominio.excepcion.IngresoExcepcion;
import dominio.repositorio.IRepositorioRegistro;
import dominio.repositorio.IRepositorioVehiculo;
import junit.framework.Assert;
import persistencia.sistema.SistemaPersistencia;
import testdatabuilder.ParqueaderoTestDataBuilder;
import testdatabuilder.RegistroTestDataBuilder;
import testdatabuilder.VehiculoTestDataBuilder;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

public class VigilanteTest {
	
	@Test
	public void DenegarIngresoAVehiculoSiPlacaIniciaConAYDiaNoEsHabil() {
// 		arrange		
		String placa = "ABC-123";
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(placa).build();
		Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
		
		// diciendole al parqueadero sus dias habiles de ingreso de placa
		List<Integer> diasHabiles = new ArrayList<Integer>();
		diasHabiles.add(new Integer(Calendar.SUNDAY));
		diasHabiles.add(new Integer(Calendar.MONDAY));
		parqueadero.setDiasHabiles(diasHabiles);
		
		SistemaPersistencia sistemaPersistencia = mock(SistemaPersistencia.class);
		// construyendo el vigilante y diciendole que dia es hoy
		Vigilante vigilante = new Vigilante(sistemaPersistencia, parqueadero);
		int diaHoy = Calendar.WEDNESDAY;
		vigilante.setDiaHoy(diaHoy);
		
// act
		try {
			vigilante.registrarIngresoVehiculo(vehiculo);
		}
		catch(IngresoExcepcion e) {
// assert
			Assert.assertEquals(Vigilante.MENSAJE_DIA_NO_HABIL, e.getMessage());
		}		
	}
	
	@Test
	public void DenegarIngresoAVehiculoSiCupoParqueaderoLleno() {
// arrange
		
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo(1).build();
		
		int numeroCarrosPermitido = 20;
		Parqueadero parqueadero = new ParqueaderoTestDataBuilder()
				.conNumeroCarrosPermitido(numeroCarrosPermitido)
				.build();
		
		SistemaPersistencia sistemaPersistencia = mock(SistemaPersistencia.class);
		IRepositorioRegistro repositorioRegistro = mock(IRepositorioRegistro.class);
		
		when(sistemaPersistencia.repositorioRegistro()).thenReturn(repositorioRegistro);
		when(repositorioRegistro.obtenerCupoPorTipo(vehiculo)).thenReturn(numeroCarrosPermitido);
		
		Vigilante vigilante = new Vigilante(sistemaPersistencia, parqueadero);
		
// act
		try {
			vigilante.registrarIngresoVehiculo(vehiculo);
		}
		catch(IngresoExcepcion e) {
// assert
			Assert.assertEquals(Vigilante.MENSAJE_CUPO_NO_DISPONIBLE, e.getMessage());
		}
	}
	
	@Test
	public void RegistrarVehiculo() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		Parqueadero parqueadero = new ParqueaderoTestDataBuilder().build();
		Registro registro = new RegistroTestDataBuilder()
				.conVehiculo(vehiculo)
				.conParqueadero(parqueadero)
				.build();
		
		SistemaPersistencia sistemaPersistencia = mock(SistemaPersistencia.class);
		IRepositorioRegistro repositorioRegistro = mock(IRepositorioRegistro.class); 
		IRepositorioVehiculo repositorioVehiculo = mock(IRepositorioVehiculo.class); 
		
		
		when(sistemaPersistencia.repositorioRegistro()).thenReturn(repositorioRegistro);
		when(repositorioRegistro.obtenerCupoPorTipo(vehiculo)).thenReturn(10);
		when(sistemaPersistencia.repositorioVehiculo()).thenReturn(repositorioVehiculo);
		when(repositorioVehiculo.obtenerPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);
			
		
		Vigilante vigilante = new Vigilante(sistemaPersistencia, parqueadero);
		//act
		vigilante.registrarIngresoVehiculo(vehiculo);
		
		
	}
	
	
}
