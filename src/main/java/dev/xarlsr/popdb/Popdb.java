package dev.xarlsr.popdb;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.generators.FileCreator;
import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.rows.RowTemplate;
import dev.xarlsr.popdb.userint.GetData;

import java.util.List;

public class Popdb {

    /**
     * Name of the table to be filled
     */
    public static String tableName;

    /**
     * Number of fields the table will have
     */
    public static int fieldsCount;

    /**
     * List of the fields of the table
     */
    public static List<Field> fields;

    /**
     * Number of SQL rows to be generated with the RowTemplate object.
     */
    public static int rowsCount;

    /**
     * Popdb is an application intended to populate SQL tables with customized fields.<br>
     *
     * It asks the user via the GetData class methods tho enter the name of the table,
     * the number of fields that table will have and the number of rows with SQL data
     * to be generated.
     * Then it creates a new RowTemplate object and generates the list of fields by
     * calling the method fieldListComposer() of the object RowTemplate.
     * After that it calls the CreateFile() and writeFile() methods of the FileCreator
     * class to create and fill the text file containing the SQL code to populate the table.
     */
    public static void main( String[] args ) {

        System.out.println(ValuesGenerator.getProbStringFromFile("C:\\Java\\Proyectos\\populatedb\\Apellidos_Prob_ES_1000.txt"));
        /*tableName=GetData.readTableName();
        fieldsCount=GetData.readFieldsCount();
        rowsCount = GetData.readRowsCount();
        RowTemplate rowTemplate = new RowTemplate();
        fields = rowTemplate.fieldListComposer(fieldsCount);
        FileCreator.createFile(GetData.readFileName());
        FileCreator.writeFile(rowTemplate, rowsCount);*/
    }
}
