package dev.xarlsr.popdb.rows;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.fields.FieldFactory;
import dev.xarlsr.popdb.userint.GetData;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Class with the cast or schema of the rows to generate.</b><br>
 * A RowTemplate object contains the list of fields that will be
 * generated for every line of SQL code (rows).
 */
public class RowTemplate {

    /**
     * List of fields of the row.
     */
    public List<Field> fields;

    /**
     * <b>The constructor creates a new fresh list of fields each time a RowTemplate object
     * is instantiated.</b>
     */
    public RowTemplate(){
        fields = new ArrayList<>();
    }

    /**
     * <b>Generates the <code>List</code> of n fields of the <code>RowTemplate</code> object, that will be passed to
     * the <code>Row</code> object.</b><br>
     * The method instantiates a new <code>FieldFactory</code> object to create the fields.
     * Then asks the user to define every field type via <code>readFieldType()</code> method,
     * passes the type to the <code>FieldFactory</code> to generate the field and finally
     * the user is asked to enter the values of the Generate Parameters
     * required for the typeof field being generated.
     * @param fieldsCount Number of fields to be added to the template.
     * @return List of fields.
     * @see FieldFactory
     * @see GetData#readFieldType()
     * @see Field
     * @see Field#setGenerateParameters()
     */
    public List<Field> fieldListComposer(int fieldsCount){
        FieldFactory fieldFactory = new FieldFactory();
        for (int i = 1; i<=fieldsCount;i++) {
            // Reads the type of field to generate
            String fType = GetData.readFieldType();
            // Gets a field of the type selected.
            Field field = fieldFactory.getField(fType);
            // Calls the method that will ask for the values of the parameters needed to generate each type of field.
            field.setGenerateParameters();
            // Adds the field to the list.
            fields.add(field);
        }
        return fields;
    }


}
