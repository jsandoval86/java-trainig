package dominio.repositorio;

import dominio.Registro;
import dominio.Vehiculo;

public interface IRepositorioRegistro {

	// agregar un ingreso de vehiculo
	void agregar(Registro registro);
	
	// obtener registro por placa
	Registro obtenerPorPlaca(String placa);
	
	int obtenerCupoPorTipo(Vehiculo vehiculo);
}
