package implementaciones;


import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExportadorExcel {

	public void exportar(ArrayList<String> ordenCompra){
		
		File fichero = new File("Orden_Despacho_Carro_Compra.xls");
		if (fichero.exists()) {
			try {
				InputStream excelStream = new FileInputStream("Orden_Despacho_Carro_Compra.xls");
				HSSFWorkbook libro = new HSSFWorkbook(excelStream);
				HSSFSheet hoja = libro.getSheetAt(0);
				int rows = hoja.getLastRowNum();
				HSSFRow fila = hoja.createRow(rows + 1);
				
				for (int i = 0; i < ordenCompra.size(); i++) {
					HSSFCell celda = fila.createCell((short) i);
					celda.setCellValue(ordenCompra.get(i));
				}
				
					try {
						FileOutputStream elFichero = new FileOutputStream("Orden_Despacho_Carro_Compra.xls");
						libro.write(elFichero);
						elFichero.close();
						libro.close();
					} catch (Exception e) {
					} 				
				} catch (FileNotFoundException fileNotFoundException) {
		        } catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		else {
			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet();
			HSSFRow filaNom = hoja.createRow(0);
			ArrayList<String> encabezado = new ArrayList<String>(Arrays.asList("Direccion", "NombreCliente", "Codigos", "MontoTotal", "FechaCompra"));
			for (int i = 0; i < encabezado.size(); i++) {
				HSSFCell celda = filaNom.createCell((short) i);
				celda.setCellValue(encabezado.get(i));
			}
			HSSFRow fila = hoja.createRow(1);
			for (int i = 0; i < ordenCompra.size(); i++) {
				HSSFCell celda = fila.createCell((short) i);
				celda.setCellValue(ordenCompra.get(i));
			}
			try {
				FileOutputStream elFichero = new FileOutputStream("Orden_Despacho_Carro_Compra.xls");
				libro.write(elFichero);
				elFichero.close();
				libro.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}