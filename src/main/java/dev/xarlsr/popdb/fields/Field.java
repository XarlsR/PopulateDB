package dev.xarlsr.popdb.fields;

/**
 * <b>Interface to implement the different field objects by the factory.</b><br>
 * The following methods are available:
 * @see #setName(String)
 * @see #getName()
 * @see #setPathName(String)
 * @see #getPathName()
 * @see #setGenerateParameters()
 * @see #getType()
 * @see #getValue()
 * @see #needsFile()
 *
 * @author XarlsR 2022
 */
public interface Field {

    /**
     * <b>Sets the name of the field.</b>
     * @param fName {@code String} with the name of the field.
     */
    void setName(String fName);

    /**
     * <b>Sets the name and path of the source text file to extract the data from.</b><br>
     * Only useful for fields generated from a text file.
     * @param pathName Name and path of the source text file.
     */
    void setPathName(String pathName);

    /**
     * <b>Gets from the user the parameters needed to generate the value of the field.</b><br>
     * Generate Parameters are the field specific pieces of information that will be
     * needed to generate the field values and will be asked the user to enter them.<br>
     * By default it also gets the name of the field.
     */
    void setGenerateParameters();

    /**
     * <b>Returns the name of the field</b>
     * @return {@code String} with the name of the field
     */
    String getName();

    /**
     * <b>Returns the type of the field</b>
     * @return {@code String} with the type of the field
     */
    String getType();

    /**
     * <b>Returns the full path oft the source file</b>
     * @return {@code String} with the path of the text file. Should return NULL if a source
     * file is not required for the field.
     */
    String getPathName();

    /**
     * <b>Generates and returns the value of the field in {@code String} form</b> <br>
     * The value generation will be different for each type of field, implementing its own
     * methods or calling external ones.
     * @return {@String} with the value of the field
     */
    String getValue();

    /**
     * <b>Returns whether or not the field needs a text file to be generated.</b>
     * @return True or false
     */
    Boolean needsFile();
}
