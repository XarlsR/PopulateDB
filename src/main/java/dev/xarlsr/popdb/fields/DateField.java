package dev.xarlsr.popdb.fields;

import dev.xarlsr.popdb.generators.ValuesGenerator;
import dev.xarlsr.popdb.userint.GetData;
import dev.xarlsr.utilities.DateUtils;
import java.time.LocalDate;

/**
 * <b>Class for fields containing date values</b>.
 * @see Field
 * @author XarlsR 2022
 */
public class DateField implements Field{

    /**
     * Sets the FTYPE constant (for field type) to "DATE".
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
     * Starting date (included) of the interval to generate.
     */
    String firstDate;

    /**
     * Ending date (excluded) of the interval to generate.
     */
    String lastDate;

    /**
     * <b>Sets the name of the field.</b>
     * @param fName String with the name of the field.
     * @see Field#setName(String)
     */
    @Override
    public void setName(String fName) {
        this.fName = fName;
    }

    /**
     * <b>Useless for this field type</b>
     * @see Field#setPathName(String)
     * @param pathName Sets the name and path of the source text file.
     */
    @Override
    public void setPathName(String pathName) {}

    /**
     * <b>Gets from the user the parameters needed to generate the value of the field.</b><br>
     * The required Generate Parameters for this type of field are
     * <ul>
     *     <li>Name</li>
     *     <li>Starting date</li>
     *     <li>Ending date</li>
     * </ul>
     * They are get by calling the {@link GetData GetData} class methods.
     * @see GetData#readFieldName()
     * @see GetData#readDate(String)
     */
    @Override
    public void setGenerateParameters() {
        setName(GetData.readFieldName());
        setFirstDate(GetData.readDate("starting"));
        setLastDate(GetData.readDate("ending"));
    }

    /**
     * <b>Sets the last date of the range of dates</b>.
     * @param date {@code String} with the last date of the period. Format "yyyyMMdd".
     */
    private void setLastDate(String date) {
        lastDate = date;
    }

    /**
     * <b>Sets the first date of the range of dates.</b>
     * @param date {@code String} with the first date of the period. Format "yyyyMMdd".
     */
    private void setFirstDate(String date) {
        firstDate = date;
    }

    /**
     * <b>Returns the name of the field</b>
     * @return Name of the field
     * @see Field#getName()
     */
    @Override
    public String getName() {
        return fName;
    }

    /**
     * <b>Returns the type of the field</b>
     * @return Type of the field
     * @see Field#getType()
     */
    @Override
    public String getType() {
        return FTYPE;
    }

    /**
     * <b>Useless in this field type.</b>
     * @return Null
     * @see Field#getPathName()
     */
    @Override
    public String getPathName() {
        return null;
    }

    /**
     * <b>Returns a random generated data between firstDate and lastDate values.</b>
     * <p>At first the <code>firstDate</code> and <code>lastDate</code> Strings are parsed to <code>LocalDate</code> type,
     * then passed to the {@link ValuesGenerator#genRandomDate(LocalDate, LocalDate) <code>genRandomDate()</code>} method to get the random
     * generated date and finally the result is parsed to <code>String</code>.</p>
     *
     * @return String with a random date.
     * @see DateUtils#stringToDate(String, String)
     * @see LocalDate
     * @see Field#getValue()
     */
    @Override
    public String getValue() {
        LocalDate ldF = DateUtils.stringToDate(firstDate, "yyyyMMdd");
        LocalDate ldL = DateUtils.stringToDate(lastDate, "yyyyMMdd");
        LocalDate ldG = ValuesGenerator.genRandomDate(ldF,ldL);
        return DateUtils.dateToString(ldG);
    }

    /**
     * <b>Returns whether or not the field needs a text file to be generated.</b>
     * @return True or false
     */
    @Override
    public Boolean needsFile() {
        return FILE_NEEDED;
    }
}
