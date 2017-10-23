package testdatabuilder;

import dominio.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final String PLACA = "BCD-123";
	private static final int CILINDRAJE = 350;
	private static final int TIPO = 1;
	
	private String placa;
	private int cilindraje;
	private int tipo;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.tipo = TIPO;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipo(int tipo) {
		this.tipo = tipo;
		return this;
	}

	public Vehiculo build() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(this.placa);
		vehiculo.setCilindraje(this.cilindraje);
		vehiculo.setTipo(this.tipo);
		
		return vehiculo;
	}
}
