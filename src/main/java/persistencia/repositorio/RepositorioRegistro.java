package persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Registro;
import dominio.Vehiculo;
import dominio.repositorio.IRepositorioRegistro;
import persistencia.builder.RegistroBuilder;
import persistencia.modelos.RegistroEntity;

public class RepositorioRegistro implements IRepositorioRegistro {
	
	private EntityManager entityManager;

	public RepositorioRegistro(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void agregar(Registro registro) {
		this.entityManager.persist(RegistroBuilder.convertirAEntity(registro));
	}

	public Registro obtenerPorPlaca(String placa) {
		Registro registro = null;
		Query query = this.entityManager
				.createQuery("SELECT registro FROM RegistroEntity registro WHERE registro.vehiculo.placa = :placa")
				.setParameter("placa", placa);
		
		RegistroEntity registroEntity = (RegistroEntity) query.getSingleResult();
		registro = RegistroBuilder.convertirADominio(registroEntity);
		
		return registro;
	}

	public int obtenerCupoPorTipo(Vehiculo vehiculo) {
		int numeroDeVehiculosRegistrados = 0;
		Query query = this.entityManager
				.createQuery("SELECT COUNT(registro) FROM RegistroEntity registro WHERE registro.vehiculo.tipo = :tipo AND registro.fechaSalida IS NULL")
				.setParameter(":tipo", vehiculo.getTipo());
		 
		numeroDeVehiculosRegistrados = (Integer) query.getSingleResult();
		
 		return numeroDeVehiculosRegistrados;
	}
	
	
}
