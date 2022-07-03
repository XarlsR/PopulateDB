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

    /**
     * List of fields of the row.
     */
    public List<Field> fields;

    /**
     * The constructor creates a new fresh list of fields each time a RowTemplate object
     * is instantiated.
     */
    public RowTemplate(){
        fields = new ArrayList<>();
    }

    /**
     * Generates the list of n fields of the templete row, that will be passed to
     * the Row object.
     * @param fieldsCount Number of fields to be added to the template.
     * @return List of fields.
     */
    public List<Field> fieldListComposer(int fieldsCount){
        FieldFactory fieldFactory = new FieldFactory();
        for (int i = 1; i<=fieldsCount;i++) {
            String fType = GetData.readFieldType();
            // Gets a field of the type selected.
            Field field = fieldFactory.getField(fType);
            // Calls the method that will ask for the parameters needed to generate
            // each type of field.
            field.setGenerateParameters();
            // Adds the field to the list.
            fields.add(field);
        }
        return fields;
    }


}
