package modelo;

public class Zapato extends Articulo {

		protected String modelo;
		
		public Zapato(int precio, String nombre, String codigo, float talla, String marca) {
			super(precio, nombre, codigo, talla, marca);
		}
		
		public Zapato(int precio, String nombre, String codigo, float talla, String marca, String modelo) {
			super(precio, nombre, codigo, talla, marca);
			this.modelo = modelo;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}



}
