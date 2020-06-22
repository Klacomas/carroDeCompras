package modelo;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import implementaciones.ExportadorExcel;

public class OrdenDeDespacho implements Documento {
	protected String cliente;
	protected ArrayList<String> listaArticulos;
	protected String direccionDespacho;
	protected int montoTotal;
	protected Date fechaCompra;
	protected String receptor;
	


	public OrdenDeDespacho(String cliente, ArrayList<String> listaArticulos, String direccionDespacho, int montoTotal,
			Date fechaCompra, String receptor) {
		super();
		this.cliente = cliente;
		this.listaArticulos = listaArticulos;
		this.direccionDespacho = direccionDespacho;
		this.montoTotal = montoTotal;
		this.fechaCompra = fechaCompra;
		this.receptor = receptor;
	}


	public OrdenDeDespacho() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean generar() {
		HSSFWorkbook libro = new HSSFWorkbook();
		HSSFSheet hoja = libro.createSheet();
		String fechaHoyString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		ExportadorExcel exportador = new ExportadorExcel();
		exportador.exportar(this.ordenComoArray());
		return true;
	}

	public ArrayList<String> ordenComoArray() {
		ArrayList<String> orden = new ArrayList<String>();
		orden.add(this.getCliente());
		orden.add(this.getDireccionDespacho());
		orden.add(this.getListaArticulos().toString());
		orden.add(Integer.toString(this.getMontoTotal()));
		orden.add(this.getFechaCompra().toString());
		return orden;
	}
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public ArrayList<String> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(ArrayList<String> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}


	public String getDireccionDespacho() {
		return direccionDespacho;
	}


	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}


	public int getMontoTotal() {
		return montoTotal;
	}


	public void setMontoTotal(int montoTotal) {
		this.montoTotal = montoTotal;
	}


	public Date getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public String getReceptor() {
		return receptor;
	}


	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}


	@Override
	public String toString() {
		return "OrdenDeDespacho [cliente=" + cliente + ", listaArticulos=" + listaArticulos + ", direccionDespacho="
				+ direccionDespacho + ", montoTotal=" + montoTotal + ", receptor=" + receptor + "]";
	}

}
