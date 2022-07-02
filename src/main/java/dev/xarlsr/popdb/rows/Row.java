package dev.xarlsr.popdb.rows;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.userint.GetData;

import java.util.List;

public class Row {

    static final String BEG = "INSERT INTO ";
    static final String VAL = " VALUES(";
    static final String END = ");";
    // Line of SQL code to pass to the file.
    public String codeLine;
    // List of fields of the row
    public List<Field> fields;

    public Row(RowTemplate rowTemplate){
        fields = rowTemplate.fields;
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
