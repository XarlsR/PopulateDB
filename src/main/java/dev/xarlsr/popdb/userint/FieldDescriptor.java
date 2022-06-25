package dev.xarlsr.popdb.userint;

/**
 * The field descriptor class is used to define the parameters of each
 * field of a row, except value.<BR>
 * fdName: Name of the field.<BR>
 * fdType: Type of field. 'FILE' for fields read from  file. 'GEN' for generated fields.
 */
public class FieldDescriptor {

    public String fdName;
    public String fdType;
    public String fdPath;

    public FieldDescriptor(){    };

    public FieldDescriptor(String fdName, String fdType, String fdPath){
        this.fdName = fdName;
        this.fdType = fdType;
        this.fdPath = fdPath;
    }
}
