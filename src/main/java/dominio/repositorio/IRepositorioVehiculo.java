package dominio.repositorio;

import dominio.Parqueadero;
import dominio.Vehiculo;

public interface IRepositorioVehiculo {

	// Agregar vehiculo
	void agregar(Vehiculo vehiculo);
	
	// Obtener vehiculo por placa
	Vehiculo obtenerPorPlaca(String placa);
	
	// Obtener tarifa por hora
	//double obtenerTarifaPorHora();
	
	// Obtener tarifa por dia
	//double obtenerTarifaPordDia();
}
