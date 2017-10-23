package dominio;

public class Vehiculo {
	
	private String placa;
	private int cilindraje;
	private long tipo;
	
	public Vehiculo() {
	}

	public Vehiculo(String placa, int cilindraje, long tipo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}
	
	public String getPlaca() {
		return placa;
	}

	public long getTipo() {
		return tipo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void setTipo(long tipo) {
		this.tipo = tipo;
	}
		
}
