package dev.xarlsr.popdb.rows;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.fields.FieldFactory;
import dev.xarlsr.popdb.userint.GetData;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with the rows to generate.
 */
public class Row {

    static final String BEG = "INSERT INTO ";
    static final String VAL = " VALUES(";
    static final String END = ");";
    // Line of SQL code to pass to the file.
    public String codeLine;
    // List of fields of the row
    public List<Field> fields;

    /**
     * The constructor creates a new clear fields list each time a Row object
     * is instantiated.
     */
    public Row(){
        fields = new ArrayList<>();
    }


    /**
     * Generates the list of n fields of the cast row, that will be passed to
     * the SQL code composer.
     * @param fieldsCount Number of fields to be generated.
     * @return List of fields.
     */
    public List<Field> fieldListComposer(int fieldsCount){
        FieldFactory ff = new FieldFactory();
        for (int i = 1; i<=fieldsCount;i++) {
            String fType = GetData.getFieldType();
            Field field = ff.getField(fType);
            field.setType(fType);
            field.setName(GetData.getFieldName());
            field.setPathName(GetData.getPathName());
            fields.add(field);
        }
        return fields;
    }

    /**
     * Generates the SQL code of the row which will be passed th the .SQL file.
     * @return A line of text with the code to fill a row.
     */
    public String composeSql(){
        String nString = " (";
        String vString = "";
        for (int i = 0; i<fields.size(); i++){
            if (i < fields.size()-1) {
                nString = nString + fields.get(i).getName() + ",";
                vString = vString + "'"+fields.get(i).getValue()+"'" + ",";
            }
            else{
                nString = nString + fields.get(i).getName()+")";
                vString = vString + "'"+fields.get(i).getValue()+"'";
            }
        }
        codeLine = BEG+ GetData.getTableName()+nString+VAL+vString+END;
        System.out.println(codeLine);
        return codeLine;

    }
}
