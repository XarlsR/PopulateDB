package dev.xarlsr.popdb;

import dev.xarlsr.popdb.fields.Field;
import dev.xarlsr.popdb.fields.FieldComposer;
import dev.xarlsr.popdb.fields.FieldFactory;
import dev.xarlsr.popdb.rows.Row;
import dev.xarlsr.popdb.userint.GetData;

import java.util.List;

public class App {

    public static String tableName;
    public static int fieldsCount;
    public List<Field> fields;

    public static void main( String[] args ) {


        tableName=GetData.setTableName();
        fieldsCount=GetData.setFieldsCount();
        Row row = new Row();
        FieldFactory ff = new FieldFactory();
        for (int i = 1; i<=GetData.getFieldsCount();i++) {
            String fType = GetData.getFieldType();
            Field field = ff.getField(fType);
            field.setType(fType);
            field.setName(GetData.getFieldName());
            field.setPathName(GetData.getPathName());
            row.addField(field);
        }
        for (int i = 0; i<fieldsCount;i++) {
            Field field = row.getField(i);
            System.out.println(field.getName()+" - "+field.getValue());
        }

    }
}
