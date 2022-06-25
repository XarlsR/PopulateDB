package dev.xarlsr.popdb.sqlcoders;

/**
 * Factory class to generate the different fields to be filled based on TableField interface.
 */
public class FieldFactory {

    public TableField getField(String fieldType){

        if(fieldType==null){
            return null;
        }
        else if (fieldType.equalsIgnoreCase("FILE")){
            return new FileField();
        }
        return null;
    }
}
