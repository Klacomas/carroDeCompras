package modelo;

public class Pantalon extends Articulo {
	protected String color;
	protected int nroBolsillos;

	public Pantalon(int precio, String nombre, String codigo, float talla, String marca) {
		super(precio, nombre, codigo, talla, marca);
	}

	
	public Pantalon(int precio, String nombre, String codigo, float talla, String marca, String color,
			int nroBolsillos) {
		super(precio, nombre, codigo, talla, marca);
		this.color = color;
		this.nroBolsillos = nroBolsillos;
	}


	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNroBolsillos() {
		return nroBolsillos;
	}
	public void setNroBolsillos(int nroBolsillos) {
		this.nroBolsillos = nroBolsillos;
	}

}
