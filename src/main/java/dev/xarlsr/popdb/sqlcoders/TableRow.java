package dev.xarlsr.popdb.sqlcoders;

import dev.xarlsr.popdb.userint.EnterData;

import java.util.List;

public class TableRow {

    static final String BEG = "INSERT INTO ";
    static final String VAL = " VALUES(";
    static final String END = ");";
    public String codeLine;
    public List<TableField> fieldList;

    public TableRow(){}

    public String makeCode(List<TableField> listFd){
        FieldsFiller ff = new FieldsFiller();
        fieldList = ff.filledField(listFd);
        String nString = " (";
        String vString = "";
        for (int i = 0; i<fieldList.size(); i++){
            if (i < fieldList.size()-1) {
                nString = nString + fieldList.get(i).getName() + ",";
                vString = vString + "'"+fieldList.get(i).getValue()+"'" + ",";
            }
            else{
                nString = nString + fieldList.get(i).getName()+")";
                vString = vString + "'"+fieldList.get(i).getValue()+"'";
            }
        }
        codeLine = BEG+EnterData.tableName+nString+VAL+vString+END;
        return codeLine;
    }


}
