package persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dominio.Vehiculo;
import dominio.repositorio.IRepositorioVehiculo;
import persistencia.builder.VehiculoBuilder;
import persistencia.modelos.TipoVehiculoEntity;
import persistencia.modelos.VehiculoEntity;

public class RepositorioVehiculo implements IRepositorioVehiculo{
	 
	private EntityManager entityManager;

	public RepositorioVehiculo(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void agregar(Vehiculo vehiculo) {
		this.entityManager.persist(VehiculoBuilder.convertirAEntity(vehiculo));
	}

	public Vehiculo obtenerPorPlaca(String placa) {
		Vehiculo vehiculo = null;
		
		TypedQuery<VehiculoEntity> query = this.entityManager
			.createQuery("SELECT vehiculo FROM VehiculoEntity vehiculo WHERE vehiculo.placa = :placa", VehiculoEntity.class)
			.setParameter("placa", placa);
	
		List<VehiculoEntity> vehiculoEntityLista = query.getResultList();
		if(!vehiculoEntityLista.isEmpty())
			vehiculo = VehiculoBuilder.convertirADominio(vehiculoEntityLista.get(0));
		
		return vehiculo;
	}
	
	
	
	
}
