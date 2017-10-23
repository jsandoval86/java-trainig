package persistencia.builder;

import dominio.Registro;
import persistencia.modelos.RegistroEntity;

public class RegistroBuilder {

	public static RegistroEntity convertirAEntity(Registro registro) {
		RegistroEntity registroEntity = new RegistroEntity();
		registroEntity.setParqueadero(
			ParqueaderoBuilder.convertirAEntity(registro.getParqueadero())
		);
		registroEntity.setVehiculo(
			VehiculoBuilder.convertirAEntity(registro.getVehiculo())
		);
		registroEntity.setFechaIngreso(registro.getFechaIngreso());
		registroEntity.setFechaSalida(registro.getFechaSalida());
		
		
		return registroEntity;
	}
	
	public static Registro convertirADominio(RegistroEntity registroEntity) {
		Registro registro = null;
		if(registroEntity != null) {
			registro = new Registro(
				VehiculoBuilder.convertirADominio(registroEntity.getVehiculo()),
				ParqueaderoBuilder.convertirADominio(registroEntity.getParqueadero()),
				registroEntity.getFechaIngreso(),
				registroEntity.getFechaSalida()
			);
		}
		
		return registro;
	}
	
}
