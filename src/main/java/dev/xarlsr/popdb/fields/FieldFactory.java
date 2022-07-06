package dev.xarlsr.popdb.fields;

/**
 * Factory class to generate the different fields to be filled based on Field interface.
 */
public class FieldFactory {

    /**
     * Returns an Field object of the selected type
     * @param fieldType Type of object to return.
     * @return Field object of the selected type.
     */
    public Field getField(String fieldType){
        if(fieldType==null){
            return null;
        }
        switch (fieldType){
            case "DATE" -> {return new DateField();}
            case "DNI" -> {return new DniField();}
            case "DSTRING" -> {return new DoubleStringField();}
            case "FSTRING" -> {return new FileStringField();}
            case "GSTRING" -> {return new GenStringField();}
            default -> {return null;}
        }
    }
}
