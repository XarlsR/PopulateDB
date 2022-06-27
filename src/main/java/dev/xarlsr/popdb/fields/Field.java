package dev.xarlsr.popdb.fields;

/**
 * Interface to create the different field objects by the factory.
 */
public interface Field {

    /**
     * Sets the name of the field.
     * @param fName String with the name of the field.
     */
    void setName(String fName);

    /**
     * Sets the type of the field.
     * @param fType String with the type of the field.
     */
    void setType(String fType);

    /**
     * Sets the name and path of the text file to extract the data from, to fill the field.
     * Only useful for fields generated from a text file.
     * @param pathName Sets the name and path of the source text file.
     */
    void setPathName(String pathName);

    /**
     * Returns the name of the field
     * @return Name of the field
     */
    String getName();

    /**
     * Returns the type of the field
     * @return Type of the field
     */
    String getType();

    /**
     * Returns the full path oft the source file
     * @return Path of the text file. Null if not a FILE type field.
     */
    String getPathName();

    /**
     * Generates and returns the value of the field. The value generation will be different
     * for each type of field.
     * @return Value of the field
     */
    String getValue();

    /**
     * Returns whether or not the field needs a text file to be generated.
     * @return True or false
     */
    Boolean needsFile();
}
