package dev.xarlsr.popdb.rows;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.userint.GetData;
import java.util.List;

/**
 * A row is the object that contains the list of fields and generates the tex line of
 * SQL code to fill a line (row) of the table. It's instantiated with a RowTemplate
 * parameter, which is the container with the definition of each field.
 */
public class Row {

    // SQL texts to add to the SQL code string generated.
    static final String BEG = "INSERT INTO ";
    static final String VAL = " VALUES(";
    static final String END = ");";

    /**
     * Line of SQL code to pass to the file.
     */
    public String codeLine;

    /**
     * List of the fields of the row
     */
    public List<Field> fields;

    /**
     * <b>The constructor initializes the list of fields from the rowTemplate parameter.</b>
     * @param rowTemplate RowTemplate object with the list of fields to handle and fill.
     */
    public Row(RowTemplate rowTemplate){
        fields = rowTemplate.fields;
    }

    /**
     * <b>Generates the SQL code of the row which will be passed to the .SQL file.</b><br>
     * The actual value of each field is filled by calling the method getValue() of
     * each Field object.
     * @return <code>String</code> with a line of text with the SQL code to fill a row.
     * @see Field#getValue()
     * @see Row
     */
    public String composeSql(){
        String nString = " (";
        String vString = "";

        for (int i = 0; i<fields.size(); i++){
            // Generates the substring for each n-1 fields, ending with a ',' to separate fields.
            if (i < fields.size()-1) {
                nString = nString + fields.get(i).getName() + ",";
                vString = vString + "'"+fields.get(i).getValue()+"'" + ",";
            }
            // Generates the last field substring, which doesn't ends with ',' as is the last one.
            else{
                nString = nString + fields.get(i).getName()+")";
                vString = vString + "'"+fields.get(i).getValue()+"'";
            }
        }
        // Generates the final string by adding the fields substrings and the constant SQL texts.
        codeLine = BEG+ GetData.getTableName()+nString+VAL+vString+END;
        System.out.println(codeLine);
        return codeLine;
    }
}
