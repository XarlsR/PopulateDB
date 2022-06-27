package dev.xarlsr.popdb.userint;

import dev.xarlsr.utilidades.EntradaTeclado;

public class GetData {

    public static String tableName;
    public static int fieldsCount;

    public static String  setTableName(){
        EntradaTeclado.borrarPantalla();
        System.out.print("Nombre de la tabla: ");
        return tableName = EntradaTeclado.leeCadena();
    }

    public static String getTableName(){
        return tableName;
    }

    public static int setFieldsCount(){
        //EntradaTeclado.borrarPantalla();
        System.out.print("Número de campos a rellenar: ");
        return fieldsCount=EntradaTeclado.leeEntero();
    }

    public static int getFieldsCount(){
        return fieldsCount;
    }

    public static String getFieldName(){
        System.out.print("Nombre del campo: ");
        return EntradaTeclado.leeCadena();
    }

    public static String getFieldType(){
        System.out.print("Tipo del campo: ");
        return EntradaTeclado.leeCadena().toUpperCase();
    }

    public static String getPathName(){
        System.out.print("Path del fichero del campo: ");
        return EntradaTeclado.leeCadena();
    }
}
