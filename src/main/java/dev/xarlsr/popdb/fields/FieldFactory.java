package dev.xarlsr.popdb.fields;

/**
 * Factory class to generate the different fields to be filled based on Field interface.
 */
public class FieldFactory {

    /**
     * <b>Returns an Field object of the selected type</b>
     * @param fieldType <code>String</code> with the type of object to return.
     * @return <code>Field</code> object of the selected type.
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
            case "PSTRING" -> {return new ProbStringField();}
            // TODO: Implementar el field probabilistico
            default -> {return null;}
        }
    }
}
