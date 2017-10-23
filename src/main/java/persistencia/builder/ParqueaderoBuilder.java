package persistencia.builder;

import dominio.Parqueadero;
import persistencia.modelos.ParqueaderoEntity;

public class ParqueaderoBuilder {
	
	private static long parqueaderoIdProvisional = 1;
	
	public static ParqueaderoEntity convertirAEntity(Parqueadero parqueadero) {
		ParqueaderoEntity parqueaderoEntity = new ParqueaderoEntity();
		parqueaderoEntity.setId(parqueaderoIdProvisional);
		parqueaderoEntity.setNumeroCarrosPermitidos(parqueadero.getNumeroCarrosPermitidos());
		parqueaderoEntity.setNumeroMotosPermitidos(parqueadero.getNumeroMotosPermitidas());
		return parqueaderoEntity;
	}
	
	public static Parqueadero convertirADominio (ParqueaderoEntity parqueaderoEntity) {
		Parqueadero parqueadero = null;
//		if(parqueaderoEntity != null) {
//			parqueadero = new Parqueadero(
//				parqueaderoEntity.getNumeroCarrosPermitidos(),
//				parqueaderoEntity.getNumeroMotosPermitidos()
//			);
//		}
		
		return parqueadero;
	}

}
