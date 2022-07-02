package dev.xarlsr.popdb.rows;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.fields.FieldFactory;
import dev.xarlsr.popdb.userint.GetData;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with the rows to generate.
 */
public class RowTemplate {

    static final String BEG = "INSERT INTO ";
    static final String VAL = " VALUES(";
    static final String END = ");";
    // Line of SQL code to pass to the file.
    public String codeLine;
    // List of fields of the row
    public List<Field> fields;

    /**
     * The constructor creates a new clear fields list each time a RowTemplate object
     * is instantiated.
     */
    public RowTemplate(){
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
            String fType = GetData.readFieldType();
            Field field = ff.getField(fType);
            field.setGenerateParameters();
            fields.add(field);
        }
        return fields;
    }


}
