package dev.xarlsr.popdb;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.generators.FileCreator;
import dev.xarlsr.popdb.rows.RowTemplate;
import dev.xarlsr.popdb.userint.GetData;
import dev.xarlsr.utilidades.EntradaTeclado;

import java.util.List;

public class App {

    public static String tableName;
    public static int fieldsCount;
    public static List<Field> fields;
    public static int rowsCount;

    public static void main( String[] args ) {


        tableName=GetData.readTableName();
        fieldsCount=GetData.readFieldsCount();
        System.out.print("Cuantas entradas? ");
        rowsCount = EntradaTeclado.leeEntero(3);
        RowTemplate rowTemplate = new RowTemplate();
        fields = rowTemplate.fieldListComposer(fieldsCount);
        FileCreator.createFile(FileCreator.getFileName());
        FileCreator.writeFile(rowTemplate, rowsCount);




    }
}
