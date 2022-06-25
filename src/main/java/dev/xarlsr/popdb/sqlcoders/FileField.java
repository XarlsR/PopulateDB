package dev.xarlsr.popdb.sqlcoders;

/**
 * A field which value will be a String type, filled with a string read from a text file.
 */
public class FileField implements TableField {

    String fieldName;
    String filePath;
    String fieldValue;
    String fieldType;


    public FileField(String fieldName, String filePath){
        this.fieldName = fieldName;
        this.filePath = filePath;
    }

    public FileField(){}

    @Override
    public void setName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public void setType(String fieldType) {
        this.fieldType =  fieldType;
    }

    @Override
    public void setValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    @Override
    public String getValue() {
        return fieldValue;
    }

    @Override
    public String getName() {
        return fieldName;
    }

    @Override
    public String getType() {
        return fieldType;
    }
}
