package dev.xarlsr.popdb.fields;

/**
 * Factory class to generate the different fields to be filled based on Field interface.
 */
public class FieldFactory {

    public Field getField(String fieldType){

        if(fieldType==null){
            return null;
        }
        switch (fieldType){
            case "APELLIDOS" -> {return new ApellidosField();}
            case "STRING" -> {return new StringField();}
            case "DNI" -> {return new DniField();}
            default -> {return null;}
        }
    }
}
