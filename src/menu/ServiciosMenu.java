package menu;

import java.util.ArrayList;

import modelo.Servicio;

public class ServiciosMenu {

	public static ArrayList<Opcion> obtenerOpciones(String nombreMenu) {
		ArrayList<Opcion> lstOpciones=new ArrayList<Opcion>();
		Opcion opcion;
		if(nombreMenu.equals("Menu Principal")) {
			opcion=new Opcion("Ver productos disponibles",1,1);
			lstOpciones.add(opcion);
			opcion=new Opcion("Agregar productos al carrito",2,2);
			lstOpciones.add(opcion);
			opcion=new Opcion("Pagar",3,3);
			lstOpciones.add(opcion);
			opcion=new Opcion("Salir",4,4);
			lstOpciones.add(opcion);

		} 
		if(nombreMenu.equals("Medio de Pago")) {
			opcion=new Opcion("Crédito",1,1);
			lstOpciones.add(opcion);
			opcion=new Opcion("Débito",2,2);
			lstOpciones.add(opcion);
			opcion=new Opcion("Cancelar",3,3);
			lstOpciones.add(opcion);

		} 
		return lstOpciones;
	}

	public static String obtenerTitulo(String nombreMenu) {
		String strTitulo=new String();
		if(nombreMenu.equals("Menu Principal")) {
			strTitulo="Menu Principal";
		}
		strTitulo="---" + strTitulo + "---";
		return strTitulo;
	}

	public static void ejecutarAccion(int intOpcion, String strMenu) {
		if (strMenu.equals("Menu Principal")) {
			switch (intOpcion) {
			case 1:
				Servicio.mostrarDisponibles();
				break;
			case 2:
				Servicio.agregarArticulos();
				break;
			case 3:
				Servicio.pagar();
				break;
			case 4:
				Servicio.salir();
				break;

			}	
		}
		if (strMenu.equals("Medio de Pago")) {
			switch (intOpcion) {
			case 1:
				Servicio.pagarConCredito();
				break;
			case 2:
				Servicio.pagarConDebito();
				break;
			case 3:
				Servicio.pagar();
				break;
			case 4:
				Servicio.salir();
				break;

			}	
		}
	}

	public static void desplegarMenu(String strMenu) {
		
		Menu menu=new Menu(strMenu,0,ServiciosMenu.obtenerOpciones(strMenu));
		menu.desplegar();
		int intOpcion=menu.leerOpcion();
		ServiciosMenu.ejecutarAccion(intOpcion,strMenu);
		desplegarMenu("Menu Principal");
	}

	
}
