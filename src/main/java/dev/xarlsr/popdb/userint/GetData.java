package dev.xarlsr.popdb.userint;

import dev.xarlsr.utilidades.DateUtils;
import dev.xarlsr.utilidades.EntradaTeclado;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GetData {

    public static List<String> typesList;
    public static String tableName;
    public static int fieldsCount;

    public GetData(){
        typesList=initTypesList();
    }

    /**
     * Initialize the list of available field types to be handled by
     * the FieldFactory class.
     * @return A List<String> with the names of the field types available.
     */
    private static List<String> initTypesList(){
        typesList = new ArrayList<>();
        typesList.add("|STRING   |: Value is generated from a string read from a text file.");
        typesList.add("|APELLIDOS|: Value is generated like in STRING but reading 2 random values from the text file.");
        typesList.add("|DNI      |: Value is auto generated corresponding to an spanish DNI -8 numbers + 1 control character.");
        return typesList;
    }

    /**
     * Prints by console a helpful list of available field types, got from the
     * list 'typeList' generated by the initTypesList() method.
     */
    public static void printTypesList(){
        initTypesList();
        for (String s : typesList) {
            System.out.println(s);
        }
    }

    /**
     * Gets the name of the table from the user and sets to tableName variable.
     * @return String with the name of the table.
     */
    public static String readTableName(){
        EntradaTeclado.borrarPantalla();
        System.out.print("Nombre de la tabla: ");
        return tableName = EntradaTeclado.leeCadena();
    }

    /**
     * Returns the name of the table stored in tableName.
     * @return String with the name of the table.
     */
    public static String getTableName(){
        return tableName;
    }

    /**
     * Sets the number of fields that will build the rows.
     * @return Number of fields stored in fieldsCount integer variable.
     */
    public static int readFieldsCount(){
        //EntradaTeclado.borrarPantalla();
        System.out.print("Número de campos a rellenar: ");
        return fieldsCount=EntradaTeclado.leeEntero();
    }

    /**
     * Returns the number of fields that will build the row.
     * @return Integer number of fields.
     */
    public static int getFieldsCount(){
        return fieldsCount;
    }

    /**
     * Asks the user for the name of field and reads it form console.
     * @return String with the name of the field.
     */
    public static String readFieldName(){
        System.out.print("Nombre del campo: ");
        return EntradaTeclado.leeCadena();
    }

    /**
     * Asks the user for the type of the field to compose. It prints hints via
     * the call to printTypesList() method.
     * @return String with the type entered by user.
     */
    public static String readFieldType(){
        System.out.println("TIPOS DE CAMPOS DISPONIBLES:");
        System.out.println("----------------------------");
        printTypesList();
        System.out.println("----------------------------");
        System.out.print("INTRODUZCA EL TIPO DE CAMPO (puede introducirse en MAY/min indistintamente): ");
        return EntradaTeclado.leeCadena().toUpperCase();
    }

    /**
     * Asks the user for the pathname of the text file to read.
     * @return String with the path entered by user.
     */
    public static String readPathName(){
        System.out.print("Path del fichero del campo: ");
        return EntradaTeclado.leeCadena();
    }

    /**
     * Asks the user to enter a date and returns it to the calling method.
     * @return String with the entered date. The format is "yyyyMMdd".
     */
    public static String readDate() {

        boolean valid;
        String date;

        do {
            System.out.println("Introduzca una fecha en formato AAAAmmDD;");
            date = EntradaTeclado.leeCadena(8);
            valid = DateUtils.isValidDate(date);
            if (valid) {
                return date;
            } else {
                System.out.println("La fecha introducida no es válida");
            }
        }
        while (!valid);
        return date;
    }



}
