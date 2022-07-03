package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;

/**
 * This class is intended to support the spanish DNI identification document.
 */
public class DniField implements Field{

    /**
     * Sets the constant with field type
     */
    private static final String FTYPE = "DNI";

    /**
     * Sets no text file is needed for this field type.
     */
    private static final Boolean FILE_NEEDED = false;

    /**
     * Name of the field
     */
    String fName;

    /**
     * Sets the name of the field.
     * @param fName String with the name of the field.
     */
    @Override
    public void setName(String fName) {
       this.fName = fName;
    }

    /**
     * Useless for this field type
     * @param pathName Useless.
     */
    @Override
    public void setPathName(String pathName) { }

    /**
     * Sets the only parameter needed to generate the field.
     */
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
     * Useless for this field type.
     * @return Null if not a FILE type field.
     */
    @Override
    public String getPathName() {
        return null;
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
