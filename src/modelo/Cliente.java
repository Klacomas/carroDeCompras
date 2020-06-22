package modelo;

public class Cliente {
	protected String nombre;
	protected String contrase�a;
	protected String direccionDespacho;

	public Cliente() {
	}
	
	public boolean ingresar(){
		return false;
		
	}

	public Cliente(String nombre, String contrase�a, String direccionDespacho) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.direccionDespacho = direccionDespacho;
	}

	public String getDireccionDespacho() {
		return direccionDespacho;
	}

	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}

	public Cliente(String nombre, String contrase�a) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", contrase�a=" + contrase�a + ", direccionDespacho=" + direccionDespacho
				+ "]";
	}
	
	
}
