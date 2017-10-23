package persistencia.repositorio;

import javax.persistence.EntityManager;

import dominio.Parqueadero;
import dominio.repositorio.IRepositorioParqueadero;
import persistencia.builder.ParqueaderoBuilder;

public class RepositorioParqueadero implements IRepositorioParqueadero{
	
	/**
	 * Objeto para operaciones de base de datos
	 */
	private EntityManager entityManager;

	public RepositorioParqueadero(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * guardar parqueadero
	 */
	public void agregar(Parqueadero parqueadero) {
		this.entityManager.persist(ParqueaderoBuilder.convertirAEntity(parqueadero));
	}
	
	
}
