package dev.xarlsr.popdb.sqlcoders;

/**
 * Interface for further fields definition by the FieldFactory.
 */
public interface TableField {

    void setName(String fieldName);
    void setType(String fieldType);
    void setValue(String fieldValue);
    void setFilePath(String filePath);
    String getName();
    String getType();
    String getValue();
}
