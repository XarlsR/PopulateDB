package dev.xarlsr.popdb.fields;

import static dev.xarlsr.popdb.fields.FTypes.APELLIDOS;

/**
 * Factory class to generate the different fields to be filled based on TableField interface.
 */
public class FieldFactory {

    public Field getField(String fieldType){

        if(fieldType==null){
            return null;
        }
        switch (fieldType){
            case "APELLIDOS" -> {return new ApellidosField();}
            case "NAME" -> {return new NameField();}
            default -> {return null;}
        }
    }
}
