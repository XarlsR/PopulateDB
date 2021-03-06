package dev.xarlsr.popdb.userint;

import dev.xarlsr.utilities.ConsoleInput;
import java.util.List;
import static dev.xarlsr.popdb.Parameters.*;


/**
 * Class with the different interface methods to get the needed user inputs.
 */
public class GetData {

    /**
     * List with the type of data fields that can be managed by the app
     */
    public static List<String> typesList;

    /**
     * Name of the table
     */
    public static String tableName;

    /**
     * NUmber of fields that the SQL rows will have
     */
    public static int fieldsCount;

    /**
     * Name of the file to be created and written.
     */
    static String fileName;

    /**
     * Default constructor
     */
    public GetData(){}

    /**
     * Prints by console a helpful list of available field types, got from the
     * list 'typeList' generated by the initTypesList() method.
     */
    public static void printTypesList(){
        for (int i = 0; i<FIELD_TYPES.size();i++) {
            //System.out.println(FIELD_TYPES.get(i)+":  "+FIELD_DESC.get(i));
            System.out.printf("%-9s %s %s %n", FIELD_TYPES.get(i), ": ",FIELD_DESC.get(i));
        }
    }

    /**
     * Gets the name of the table from the user and sets to tableName variable.
     * @return String with the name of the table.
     */
    public static String readTableName(){
        ConsoleInput.clearConsole();
        System.out.print("Table name: ");
        return tableName = ConsoleInput.readString();
    }

    /**
     * Returns the name of the table stored in tableName.
     * @return String with the name of the table.
     */
    public static String getTableName(){
        return tableName;
    }

    /**
     * Sets the number of fields that will build the rows.
     * @return Number of fields stored in fieldsCount integer variable.
     */
    public static int readFieldsCount(){
        System.out.print("Number of fields to fill: ");
        return fieldsCount=ConsoleInput.readInteger();
    }

    /**
     * Returns the number of fields that will build the row.
     * @return Integer number of fields.
     */
    public static int getFieldsCount(){
        return fieldsCount;
    }

    /**
     * Asks the user for the name of field and reads it form console.
     * @return String with the name of the field.
     */
    public static String readFieldName(){
        System.out.print("Name of the field: ");
        return ConsoleInput.readString();
    }

    /**
     * Asks the user for the type of the field to compose. It prints hints via
     * the call to printTypesList() method.
     * @return String with the type entered by user.
     */
    public static String readFieldType(){
        System.out.println("AVAILABLE FIELD TYPES:");
        System.out.println("----------------------------");
        printTypesList();
        System.out.println("----------------------------");
        System.out.print("ENTER THE FIELD TYPE (UPPER/lower case not sensitive): ");
        return ConsoleInput.readString().toUpperCase();
    }

    /**
     * Asks the user for the pathname of the text file to read.
     * @return String with the path entered by user.
     */
    public static String readPathName(){
        System.out.print("Path and name of the source file: ");
        return ConsoleInput.readString();
    }

    /**
     * Asks the user to enter a date and returns it to the calling method.
     * @return String with the entered date. The format is "yyyyMMdd".
     */
    public static String readDate(String startEnd) {
        boolean valid;
        String date;
        do {
            System.out.println("Enter a "+startEnd+" date with format 'AAAAmmDD'");
            date = ConsoleInput.readString(8);
            //valid = DateUtils.isValidDate(date);
            valid = true;
            if (valid) {
                return date;
            } else {
                System.out.println("The entered date is not valid");
            }
        }
        while (!valid);
        return date;
    }

    /**
     * Asks the user to enter the number of SQL table filling rows to be generated.
     * Checks if the qty. entered by user is under the maximum. If it fits the parameter
     * MAX_ROWS then proceed. If not, the user is required to enter other qty.
     * @return int Number of data rows to generate.
     */
    public static int readRowsCount() {
        boolean ok = false;
        do {
            System.out.print("How many rows to generate? (Max "+MAX_ROWS+"): ");
            int rc = ConsoleInput.readInteger();
            if (rc > MAX_ROWS){
                System.out.println("The entered quantity is over max. Please, enter other value under "+MAX_ROWS+": ");
            }
            else {
                ok = true;
                return rc;
            }
        } while (!ok);
        return 0;
    }

    /**
     * Asks the user for the name of the file and returns it as String.
     * @return String with the name of the file.
     */
    public static String readFileName(){
        System.out.print("Name of the SQL output file: ");
        return fileName = ConsoleInput.readString();
    }

    /**
     * Reads from the user the pattern to generate a random string.
     * @return
     */
    public static String readSPattern() {
        System.out.println("Enter the patter of the string to generate.");
        System.out.println("'a' alphabetical characters, 'n' para digits.");
        System.out.println("Any other character will be passed as part of the pattern.");
        System.out.print("Pattern to generate: ");
        return ConsoleInput.readString();
    }
}
