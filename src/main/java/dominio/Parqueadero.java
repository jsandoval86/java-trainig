package dominio;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

	private static final int NUMERO_DE_CARROS_PERMITIDOS = 20;
	private static final int NUMERO_DE_MOTOS_PERMITIDAS = 10;
	
	private int numeroCarrosPermitidos;
	private int numeroMotosPermitidas;
	private int identificador;
	private List<Integer> diasHabiles;
	
	public Parqueadero() {
		this.numeroCarrosPermitidos = NUMERO_DE_CARROS_PERMITIDOS;
		this.numeroMotosPermitidas = NUMERO_DE_MOTOS_PERMITIDAS;
		this.diasHabiles = new ArrayList<Integer>();
	}
	
	public Parqueadero(int identificador,int numeroCarrosPermitidos, int numeroMotosPermitidas) {
		this.identificador = identificador;
		this.numeroCarrosPermitidos = numeroCarrosPermitidos;
		this.numeroMotosPermitidas = numeroMotosPermitidas;
		this.diasHabiles = new ArrayList<Integer>();
	}

	public int getNumeroCarrosPermitidos() {
		return numeroCarrosPermitidos;
	}

	public void setNumeroCarrosPermitidos(int numeroCarrosPermitidos) {
		this.numeroCarrosPermitidos = numeroCarrosPermitidos;
	}

	public int getNumeroMotosPermitidas() {
		return numeroMotosPermitidas;
	}

	public void setNumeroMotosPermitidas(int numeroMotosPermitidas) {
		this.numeroMotosPermitidas = numeroMotosPermitidas;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public List<Integer> getDiasHabiles() {
		return diasHabiles;
	}

	public void setDiasHabiles(List<Integer> diasHabiles) {
		this.diasHabiles = diasHabiles;
	}

	public int getCapacidadPorTipo(Vehiculo vehiculo) {
		if (vehiculo.getTipo() == 1)
			return this.getNumeroCarrosPermitidos();
		if (vehiculo.getTipo() == 2)
			return this.getNumeroMotosPermitidas();
		return 0;
	}
	
}
