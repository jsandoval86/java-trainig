package persistencia.builder;

import dominio.Vehiculo;
import persistencia.modelos.TipoVehiculoEntity;
import persistencia.modelos.VehiculoEntity;

public class VehiculoBuilder {

	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {
		// construir vehiculoEntity
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setId(vehiculo.getTipo());
		
		vehiculoEntity.setTipoVehiculo(tipoVehiculoEntity);
		
		return vehiculoEntity;
	}
	
	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculo = null; 
		if(vehiculoEntity != null) {
			vehiculo = new Vehiculo(
				vehiculoEntity.getPlaca(),
				vehiculoEntity.getCilindraje(), 
				vehiculoEntity.getTipoVehiculo().getId()
			);
		}
				
		return vehiculo;
	}
}
