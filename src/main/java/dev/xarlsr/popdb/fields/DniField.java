package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;

/**
 * This class is intended to support the spanish DNI identification document.
 */
public class DniField implements Field{

    private static final String FTYPE = "DNI";
    private static final Boolean FILE_NEEDED = false;
    String fName;
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

    @Override
    public void setGenerateParameters() {
        setName(GetData.readFieldName());
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
     * Generates and returns the value of the field. The generator method genDni()
     * will be called for this field.
     * @return Value of the field
     */
    @Override
    public String getValue() {
        return ValuesGenerator.genDni();
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
