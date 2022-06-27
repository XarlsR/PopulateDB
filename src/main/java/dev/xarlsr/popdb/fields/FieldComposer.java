package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.userint.GetData;

public class FieldComposer {


    public static Field composeField(int fieldNr){
        FieldFactory ff = new FieldFactory();
        String fieldType = GetData.getFieldType();
        Field field = ff.getField(fieldType);
        field.setType(fieldType);
        field.setName(GetData.getFieldName());
        if (field.needsFile()) {
            field.setPathName(GetData.getPathName());
        }
        return field;
    }

}
