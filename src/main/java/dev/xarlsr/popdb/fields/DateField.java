package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.userint.GetData;
import dev.xarlsr.utilidades.DateUtils;

import java.time.LocalDate;

public class DateField implements Field{

    private static final String FTYPE = "DATE";
    private static final Boolean FILE_NEEDED = false;
    String fName;
    String pathName;
    String firstDate;
    String lastDate;

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
     * Gets from the user the parameters needed to generate the value of the field.
     * It also gets the name of the field.
     */
    @Override
    public void setGenerateParameters() {
        setName(GetData.readFieldName());
        setFirstDate(GetData.readDate());
        setLastDate(GetData.readDate());
    }

    /**
     * Sets the last date of the range of dates.
     * @param date String with the last date of the period. Format "yyyyMMdd".
     */
    private void setLastDate(String date) {
        lastDate = date;
    }

    /**
     * Sets the first date of the range of dates.
     * @param date String with the first date of the period. Format "yyyyMMdd".
     */
    private void setFirstDate(String date) {
        firstDate = date;
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
     *
     * @return Value of the field
     */
    @Override
    public String getValue() {

        LocalDate ldF = DateUtils.stringToDate(firstDate, "yyyyMMdd", "yyyyMMdd");
        LocalDate ldL = DateUtils.stringToDate(lastDate, "yyyyMMdd", "yyyyMMdd");

        return null;
    }

    /**
     * Returns whether or not the field needs a text file to be generated.
     *
     * @return True or false
     */
    @Override
    public Boolean needsFile() {
        return null;
    }
}
