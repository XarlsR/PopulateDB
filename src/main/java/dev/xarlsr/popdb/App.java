package dev.xarlsr.popdb;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.rows.Row;
import dev.xarlsr.popdb.userint.GetData;
import dev.xarlsr.utilidades.EntradaTeclado;

import java.util.List;

public class App {

    public static String tableName;
    public static int fieldsCount;
    public List<Field> fields;

    public static void main( String[] args ) {


        tableName=GetData.setTableName();
        fieldsCount=GetData.setFieldsCount();
        System.out.println("Cuantas entradas? ");
        int cuenta = EntradaTeclado.leeEntero(3);
        Row row = new Row();
        row.fieldListComposer(fieldsCount);
        for(int i = 1; i<=cuenta;i++){


            row.composeSql();
        }

    }
}
