package modelo;

public class Polera extends Articulo {
	protected String color;
	public Polera(int precio, String nombre, String codigo, float talla, String marca) {
		super(precio, nombre, codigo, talla, marca);
	}
	public Polera(int precio, String nombre, String codigo, float talla, String marca, String color) {
		super(precio, nombre, codigo, talla, marca);
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
