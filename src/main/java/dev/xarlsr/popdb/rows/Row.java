package dev.xarlsr.popdb.rows;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.userint.GetData;
import java.util.ArrayList;
import java.util.List;

public class Row {

    static final String BEG = "INSERT INTO ";
    static final String VAL = " VALUES(";
    static final String END = ");";
    public String codeLine;
    public List<Field> fields;

    public Row(){
        fields = new ArrayList<>();
    }

    public void addField(Field field){
        fields.add(field);
    }

    public Field getField(int i){
        return fields.get(i);
    }

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
        return codeLine;

    }
}
