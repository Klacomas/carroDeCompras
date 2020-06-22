package modelo;

public class TarjetadeCredito implements MedioDePago {

	protected int cuotas;
	
	public TarjetadeCredito() {
	}

	
	public TarjetadeCredito(int cuotas) {
		super();
		this.cuotas = cuotas;
	}


	public int getCuotas() {
		return cuotas;
	}


	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}


	@Override
	public boolean generarPago() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String toString() {
		return "TarjetadeCredito [cuotas=" + cuotas + "]";
	}

	
	
	
}
