package dominio;

public class CobroFactory {
	
	public ICobroVehiculo crearCobro(Vehiculo vehiculo) {
		if(vehiculo.getTipo() == 1)
			return new CobroCarro();

		if(vehiculo.getTipo() == 2)
			return new CobroMoto();
		
		return null;
	}
}
