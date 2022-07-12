package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;
import dev.xarlsr.utilities.DateUtils;

import java.time.LocalDate;

/**
 * Class for fields containing date values.
 */
public class DateField implements Field{

    /**
     * Sets the FTYPE constant (for field type).
     */
    private static final String FTYPE = "DATE";

    /**
     * Sets the constant for a text file is needed or not.
     */
    private static final Boolean FILE_NEEDED = false;

    /**
     * Name of the field
     */
    String fName;

    /**
     * First (included) date of the interval.
     */
    String firstDate;

    /**
     * Last (excluded) date of the interval.
     */
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
     * Useless for this field type
     * @param pathName Sets the name and path of the source text file.
     */
    @Override
    public void setPathName(String pathName) {}

    /**
     * Gets from the user the parameters needed to generate the value of the field.
     * It also gets the name of the field.
     */
    @Override
    public void setGenerateParameters() {
        setName(GetData.readFieldName());
        setFirstDate(GetData.readDate("starting"));
        setLastDate(GetData.readDate("ending"));
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
     * Useless in this field type.
     * @return Null
     */
    @Override
    public String getPathName() {
        return null;
    }

    /**
     * Returns a random generated data between firstDate and lastDate values.
     * <p>At first the firstDate and lastDate Strings are parsed to LocalDate type,
     * then passed to the {@code genRandomDate()} method to get the random
     * generated date and finally the result is parsed to String.</p>
     *
     * @return String with a random date.
     */
    @Override
    public String getValue() {
        LocalDate ldF = DateUtils.stringToDate(firstDate, "yyyyMMdd", "yyyyMMdd");
        LocalDate ldL = DateUtils.stringToDate(lastDate, "yyyyMMdd", "yyyyMMdd");
        LocalDate ldG = ValuesGenerator.genRandomDate(ldF,ldL);
        return DateUtils.dateToString(ldG);
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
