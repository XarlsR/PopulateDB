package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;

public class GenStringField implements Field{


    /**
     * Sets file type constant.
     */
    private static final String FTYPE = "GSTRING";

    /**
     * Sets a text file is needed.
     */
    private static final boolean FILE_NEEDED = false;

    /**
     * Name of the field
     */
    private String fName;

    /**
     * Stores the pattern of the string to generate
     */
    private String sPattern;



    /**
     * Sets the name of the field.
     * @param fName String with the name of the field.
     */
    @Override
    public void setName(String fName) {
        this.fName = fName;
    }

    /**
     * Useless in this Field type.
     */
    @Override
    public void setPathName(String pathName) {

    }

    public void setsPattern(String sPattern){
        this.sPattern = sPattern;
    }

    /**
     * Gets from the user the parameters needed to generate the value of the field.
     * It also gets the name of the field.
     */
    @Override
    public void setGenerateParameters() {
        setName(GetData.readFieldName());
        setsPattern(GetData.readSPattern());
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
     * Useless in this field type
     */
    @Override
    public String getPathName() {
        return null;
    }

    /**
     * Calls the method {@code genPatterString()} to generate a pattern String.
     * @return String with the value generated
     */
    @Override
    public String getValue() {
        return ValuesGenerator.genPatternString(sPattern);
    }

    /**
     * Returns whether or not the field needs a text file to be generated.
     * @return True or false
     */
    @Override
    public Boolean needsFile() {
        return null;
    }
}
