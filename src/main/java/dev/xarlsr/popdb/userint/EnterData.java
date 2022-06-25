package dev.xarlsr.popdb.userint;

import dev.xarlsr.utilidades.EntradaTeclado;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for user entry data methods.
 */
public class EnterData {

	// Number of fields in the row.
	public static int numCampos;
	// Name of the table to populate
	public static String tableName;

	/**
	 * Gets the name of the table from keyboard and returns it via tableName variable.
	 * @return Name of the table to populate.
	 */
	public static String tableName(){
		EntradaTeclado.borrarPantalla();
		System.out.print("Nombre de la tabla: ");
		tableName = EntradaTeclado.leeCadena();
		return tableName;
	}

	/**
	 * Returns the list of FieldDescriptors of a row.
	 * @return List of FieldDescriptor objects.
	 */
	public static List<FieldDescriptor> genRowFieldsList() {
		List<FieldDescriptor> rowFieldDescriptorList =new ArrayList<>();
		// Gets the name of the table
		tableName();
		// Gets the number of fields of the row
		EntradaTeclado.borrarPantalla();
		System.out.print("Introduzca el número de campos: ");
		numCampos = EntradaTeclado.leeEntero();
		// Gets the description attributes for every field
		for (int i =1; i<=numCampos;i++) {
			FieldDescriptor fd = new FieldDescriptor();
			System.out.print("Introduzca el tipo de campo: ");
			fd.fdType = EntradaTeclado.leeCadena();
			System.out.print("Introduzca nombre de campo: ");
			fd.fdName = EntradaTeclado.leeCadena();
			// If the type of field is FILE, it gets the path of the file to read from.
			if (fd.fdType.equalsIgnoreCase("FILE")){
				System.out.print("Introduzca path del archivo origen: ");
				fd.fdPath=EntradaTeclado.leeCadena();
			}
			// Adds the field descriptor to list.
			rowFieldDescriptorList.add(fd);
		}
		return rowFieldDescriptorList;
	}

	public static int rowCount(){
		EntradaTeclado.borrarPantalla();
		System.out.print("¿Cuántas filas desea rellenar? ");
		int rCount = EntradaTeclado.leeEntero();
		return rCount;
	}
}
