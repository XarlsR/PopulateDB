package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;

/**
 * This class of field is intended for using with spanish and other latin countries
 * with double surname or family name.
 */
public class DoubleStringField implements Field{

    /**
     * Sets the FTYPE constant (for field type).
     */
    private static final String FTYPE = "DSTRING";

    /**
     * Sets the constant for a text file is needed or not.
     */
    private static final Boolean FILE_NEEDED = true;

    /**
     * RVC states read values count; sets the number of lines to be read from the
     * source text file, if needed.
     */
    private static final int RVC = 100;

    /**
     * Name of the field
     */
    String fName;

    /**
     * Full path and name of the text file to read, if needed.
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
     * Gets from the user the parameters needed to generate the field, via the
     * methods of GetData class.
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
     * Generates and returns a double surname, used in Spain and other latin
     * countries.
     * @return Value of the field
     */
    @Override
    public String getValue() {
        String ape1;
        String ape2;
        String apellidos;
        ape1 = ValuesGenerator.getRandStringFromFile(pathName);
        ape2 = ValuesGenerator.getRandStringFromFile(pathName);
        apellidos = ape1+" "+ape2;
        return apellidos;
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
