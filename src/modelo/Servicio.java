package modelo;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import menu.ServiciosMenu;

public class Servicio {
	private static CarroDeCompras carro = new CarroDeCompras();
	private static Cliente cliente = new Cliente();
	private static Date date = new Date();
	public boolean agregarArticuloAlCarro(Articulo articuloAgregar) {
		return false;
		
	}

	public static void mostrarDisponibles() {
		ArrayList<Articulo> lstArticulo = obtenerArticulosDisponibles();
		for(Articulo articulo:lstArticulo) {
			System.out.println(articulo.getClass().getSimpleName()+articulo.toString());
		}
	}

	private static ArrayList<Articulo> obtenerArticulosDisponibles() {
		ArrayList <Articulo> lstArticulos = new ArrayList<Articulo>();
		Pantalon pantalon=new Pantalon(15000,"Variant Caqui corto","1000",30, "Variant","Caqui",2);
		lstArticulos.add(pantalon);
		pantalon=new Pantalon(15000,"Variant Caqui corto","1000",30, "Variant","Caqui",2);
		lstArticulos.add(pantalon);
		pantalon=new Pantalon(19000,"Variant Caqui largo","1001",30, "Variant","Negro",2);
		lstArticulos.add(pantalon);
		Polera polera=new Polera(9000,"Variant Rojo","2002",29, "Variant","Rojo");
		lstArticulos.add(polera);
		Zapato zapato=new Zapato(25000,"Mega CZ50","3003",34, "Mega","CZ50");
		lstArticulos.add(zapato);
		zapato=new Zapato(20000,"Mega CX50","3004",40, "Mega","CX50");
		lstArticulos.add(zapato); 
		return lstArticulos;
	}

	public static CarroDeCompras agregarArticulos() {

		Scanner sc = new Scanner(System.in);
		String seguirIngresando="",strArticulo="", strRespuesta="";
		int totalPago = 0;
//		CarroDeCompras carro = new CarroDeCompras();
		ArrayList <Articulo> lstArticulos=new ArrayList <Articulo>();

		do {
			System.out.println("Ingrese el codigo del articulo que desea agregar");
			strArticulo=sc.nextLine();
			Articulo articulo=buscarArticulo(strArticulo);
			if(articulo!=null) {
				System.out.println("Esta seguro de agregar " + articulo.getNombre() + " al carrito por " + articulo.getPrecio());
				System.out.println("Ingrese Y para si o N para no");
				strRespuesta=sc.nextLine();
			
				if(strRespuesta.equals("Y")) {
					lstArticulos.add(articulo);
					totalPago+=articulo.getPrecio();
				}
			}else {
				System.out.println("Artículo no encontrado");			
			}
			
			System.out.println("¿Desea agregar otro artículo?");
			System.out.println("Ingrese Y para si o N para no");
			seguirIngresando=sc.nextLine();
		}while (seguirIngresando.contentEquals("Y"));
		
		carro.setListaArticulos(lstArticulos);
		carro.setTotalPago(totalPago);
		mostrarCarro();
		return carro;
		
	}

	private static Articulo buscarArticulo(String strArticulo) {
		ArrayList<Articulo> lstArticulo=obtenerArticulosDisponibles();
		for(Articulo articulo:lstArticulo) {
			if(articulo.getCodigo().equals(strArticulo)) {
				return articulo;
			}
		}
		return null;
	}

	public static void pagar() {
		ServiciosMenu.desplegarMenu("Medio de Pago");
	}

	public static void salir() {
		// TODO Auto-generated method stub
		
	}

	public static Cliente ingresoCliente() {
		Scanner sc = new Scanner(System.in);
		String strNombreCliente="";
		String strDireccionDespacho="";
		System.out.println("Nombre cliente");
		strNombreCliente=sc.nextLine();
		System.out.println("Dirección de despacho");
		strDireccionDespacho=sc.nextLine();
		cliente.setNombre(strNombreCliente);
		cliente.setDireccionDespacho(strDireccionDespacho);
		
		return cliente;
	}

	public static void mostrarCarro() {
		ArrayList <Articulo> lstArticulo = carro.getListaArticulos();
		for(Articulo articulo:lstArticulo) {
			System.out.println(articulo.toString());
		}
		
	}

	public static void pagarConCredito() {
		Scanner sc = new Scanner(System.in);
		OrdenDeDespacho od=new OrdenDeDespacho();
		od=llenarDatosPago("crédito");
		if(od.generar()) {
			System.out.println("Orden de despacho generada correctamente");
		}
		
	}

	public static void pagarConDebito() {
		Scanner sc = new Scanner(System.in);
		OrdenDeDespacho od=new OrdenDeDespacho();
		od=llenarDatosPago("débito");

		if(od.generar()) {
			System.out.println("Orden de despacho generada correctamente");
		}
	}

	private static OrdenDeDespacho llenarDatosPago(String strTipoPago) {
		OrdenDeDespacho od = new OrdenDeDespacho();
		Scanner sc = new Scanner(System.in);
		String strRespuesta="", strDireccionDespacho="", strReceptor="", strCuotas="";
		String strNombreCliente=cliente.getNombre();
		if(strTipoPago.equals("débito")) {
			System.out.println("Está seguro que desea pagar con débito el total de " + carro.getTotalPago());
			System.out.println("Ingrese Y para si o N para no ");
			strRespuesta=sc.nextLine();
			if(strRespuesta.equals("Y")) {
				System.out.println("Cual es la dirección de despacho");
				strDireccionDespacho=sc.nextLine();
				System.out.println("¿Cuál es el nombre de quien recibe el producto?");
				strReceptor=sc.nextLine();
				
				od.setCliente(strNombreCliente);
				od.setDireccionDespacho(strDireccionDespacho);
				od.setFechaCompra(date);
				od.setListaArticulos(carro.getCodigos());
				od.setMontoTotal(carro.getTotalPago());
				od.setReceptor(strReceptor);
			}
		}
		if(strTipoPago.equals("crédito")) {
			System.out.println("Está seguro que desea pagar con crédito el total de " + carro.getTotalPago());
			System.out.println("Ingrese Y para si o N para no ");
			strRespuesta=sc.nextLine();
			if(strRespuesta.equals("Y")) {
				
				System.out.println("¿Con cuantas cuotas desea pagar ? (0-24)");
				strCuotas=sc.nextLine();
				System.out.println("¿Está seguro que desea pagar con "+ strCuotas +" cuotas?");
				System.out.println("Ingrese Y para si o N para no ");
				strRespuesta=sc.nextLine();
				if(strRespuesta.equals("Y")) {
				
					System.out.println("Cual es la dirección de despacho");
					strDireccionDespacho=sc.nextLine();
					System.out.println("¿Cuál es el nombre de quien recibe el producto?");
					strReceptor=sc.nextLine();
					
					od.setCliente(strNombreCliente);
					od.setDireccionDespacho(strDireccionDespacho);
					od.setFechaCompra(date);
					od.setListaArticulos(carro.getCodigos());
					od.setMontoTotal(carro.getTotalPago());
					od.setReceptor(strReceptor);
				}
			}
		}
		return od;
	}

}
