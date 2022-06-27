package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;

/**
 * This class of field is intended for using with spanish and other latin countries
 * with double surname or family name.
 */
public class ApellidosField implements Field{

    private static final int RVC = 100;
    private static final Boolean FILE_NEEDED = true;
    String fName;
    String fType;
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
     * Sets the type of the field.
     * @param fType String with the type of the field.
     */
    @Override
    public void setType(String fType) {
        this.fType = fType;
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
        return fType;
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
        ape1 = ValuesGenerator.getStringFromFile(pathName, RVC);
        ape2 = ValuesGenerator.getStringFromFile(pathName, RVC);
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
