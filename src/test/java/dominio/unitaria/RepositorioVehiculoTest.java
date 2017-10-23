package dominio.unitaria;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;

import dominio.Vehiculo;
import dominio.repositorio.IRepositorioVehiculo;
import junit.framework.Assert;
import persistencia.modelos.VehiculoEntity;
import persistencia.repositorio.RepositorioVehiculo;
import testdatabuilder.VehiculoTestDataBuilder;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioVehiculoTest {

	
	
	
	@Test
	public void buscarVehiculoCuandoPlacaExiste() {
		// arrange
		String placa = "ABC-123";
		//Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(placa).build();
		
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(placa);
		
		List<VehiculoEntity> vehiculoEntityLista = new ArrayList<VehiculoEntity>();
		vehiculoEntityLista.add(0, vehiculoEntity);
		
		EntityManager entityManager = mock(EntityManager.class);
		TypedQuery<VehiculoEntity> query = mock(TypedQuery.class);
		when(entityManager.createQuery(anyString())).thenReturn(query);
		when(query.setParameter(anyString(), eq(placa))).thenReturn(query);
		when(query.getResultList()).thenReturn(vehiculoEntityLista);		
		IRepositorioVehiculo repositorioVehiculo = new RepositorioVehiculo(entityManager);
		// act
		Vehiculo vehiculo = repositorioVehiculo.obtenerPorPlaca(placa);
		
		// assert
		Assert.assertNotNull(vehiculo);
		
	}
}
