package modelo;

public class Articulo {
	protected int precio ;
	protected String nombre;
	protected String codigo;
	protected float talla;
	protected String Marca;

	
	public Articulo(int precio, String nombre, String codigo, float talla, String marca) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.codigo = codigo;
		this.talla = talla;
		Marca = marca;
	}


	public double getPrecio() {
		return precio;
	}

	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getTalla() {
		return talla;
	}
	public void setTalla(int talla) {
		this.talla = talla;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	@Override
	public String toString() {
		return  " [precio=" + precio + ", nombre=" + nombre + ", codigo=" + codigo + ", talla=" + talla
				+ ", Marca=" + Marca + "]";
	}
	

}
