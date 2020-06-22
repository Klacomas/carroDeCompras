package modelo;

import java.util.ArrayList;

public class CarroDeCompras {
	protected String cliente;
	protected ArrayList<Articulo> listaArticulos;
	protected int totalPago;
	public CarroDeCompras() {

	}

	public CarroDeCompras(String cliente, ArrayList<Articulo> listaArticulos, int totalPago) {
		super();
		this.cliente = cliente;
		this.listaArticulos = listaArticulos;
		this.totalPago = totalPago;
	}

	public boolean pagar() {
		return false;
		
	}

	public int getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(int totalPago) {
		this.totalPago = totalPago;
	}

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Articulo> getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	@Override
	public String toString() {
		return "CarroDeCompras [cliente=" + cliente + ", listaArticulos=" + listaArticulos + "]";
	}

	public ArrayList<String> getCodigos() {
		ArrayList <String> listaCodigos = new ArrayList<String>();
		for(Articulo articulo:this.getListaArticulos()) {
			listaCodigos.add(articulo.getCodigo());
		}
		System.out.println(listaCodigos);
		return listaCodigos;
	}

}
