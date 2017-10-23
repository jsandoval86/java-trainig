package testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import dominio.Parqueadero;

public class ParqueaderoTestDataBuilder {

	private static final int NUMERO_CARROS_PERMITIDOS = 20;
	private static final int NUMERO_MOTOS_PERMITIDOS = 10;
	private static final int IDENTIFICADOR = 1;
	
	private int numeroCarrosPermitido;
	private int numeroMotosPermitido;
	private int identificador;
	private List<Integer> diasHabiles;
	
	public ParqueaderoTestDataBuilder() {
		this.numeroCarrosPermitido = NUMERO_CARROS_PERMITIDOS;
		this.numeroMotosPermitido = NUMERO_MOTOS_PERMITIDOS;
		this.identificador = IDENTIFICADOR;
		this.diasHabiles = new ArrayList<Integer>();
	}
	
	public ParqueaderoTestDataBuilder conNumeroCarrosPermitido(int numeroCarrosPermitido) {
		this.numeroCarrosPermitido = numeroCarrosPermitido;
		return this;
	}
	
	public ParqueaderoTestDataBuilder conNumeroMotosPermitido(int numeroMotosPermitido) {
		this.numeroMotosPermitido = numeroMotosPermitido;
		return this;
	}
	
	public ParqueaderoTestDataBuilder conDiasHabiles(List<Integer> diasHabiles) {
		this.diasHabiles = diasHabiles;
		return this;
	}
	
	public Parqueadero build() {
		Parqueadero parqueadero = new Parqueadero();
		parqueadero.setIdentificador(this.identificador);
		parqueadero.setNumeroCarrosPermitidos(this.numeroCarrosPermitido);
		parqueadero.setNumeroMotosPermitidas(this.numeroMotosPermitido);
		parqueadero.setDiasHabiles(this.diasHabiles);
		return parqueadero;
				
	}
}
