package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;

/**
 * Class for fields which value is a text String read from a file.
 */
public class FileStringField implements Field{

    /**
     * Sets file type constant.
     */
    private static final String FTYPE = "FSTRING";

    /**
     * Sets the number of lines to be read from text file. RVC stands for read value count.
     * The number of lines of the file to be read must be equal or greater than RVC.
     */
    private static final int RVC = 100;

    /**
     * Sets a text file is needed.
     */
    private static final boolean FILE_NEEDED = true;

    /**
     * Name of the field.
     */
    String fName;

    /**
     * Full path and name of the text file
     */
    String pathName;


    /**
     * Sets the name of the field.
     * @param fName String with the name of the field.
     */
    @Override
    public void setName(String fName) {
        this.fName = fName;
    }

    /**
     * Sets the name and path of the text file to extract the data from, to fill the field.
     * Only useful for fields generated from a text file.
     * @param pathName Sets the name and path of the source text file.
     */
    @Override
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    /**
     * Sets the user parameters needed to generate the field.
     */
    @Override
    public void setGenerateParameters() {
        setName(GetData.readFieldName());
        setPathName(GetData.readPathName());
    }

    /**
     * Returns the name of the field
     * @return Name of the field
     */
    @Override
    public String getName() {
        return fName;
    }

    /**
     * Returns the type of the field
     * @return Type of the field
     */
    @Override
    public String getType() {
        return FTYPE;
    }

    /**
     * Returns the full path oft the source file
     * @return Path of the text file. Null if not a FILE type field.
     */
    @Override
    public String getPathName() {
        return pathName;
    }

    /**
     * Generates and returns the value of the field. The value generation will be different
     * for each type of field.
     * @return Value of the field
     */
    @Override
    public String getValue() {
        return ValuesGenerator.getStringFromFile(pathName,RVC);
    }

    /**
     * Returns whether or not the field needs a text file to be generated.
     * @return True or false
     */
    @Override
    public Boolean needsFile() {
        return FILE_NEEDED;
    }
}
