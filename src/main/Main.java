package main;

import menu.ServiciosMenu;
import modelo.Cliente;
import modelo.Servicio;

public class Main {

	public static void main(String[] args) {
		Cliente cliente = Servicio.ingresoCliente();
		if(cliente!=null) {
			ServiciosMenu.desplegarMenu("Menu Principal");
		}
	}
}
