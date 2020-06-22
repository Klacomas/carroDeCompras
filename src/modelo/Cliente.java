package modelo;

public class Cliente {
	protected String nombre;
	protected String contraseña;
	protected String direccionDespacho;

	public Cliente() {
	}
	
	public boolean ingresar(){
		return false;
		
	}

	public Cliente(String nombre, String contraseña, String direccionDespacho) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.direccionDespacho = direccionDespacho;
	}

	public String getDireccionDespacho() {
		return direccionDespacho;
	}

	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}

	public Cliente(String nombre, String contraseña) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", contraseña=" + contraseña + ", direccionDespacho=" + direccionDespacho
				+ "]";
	}
	
	
}
