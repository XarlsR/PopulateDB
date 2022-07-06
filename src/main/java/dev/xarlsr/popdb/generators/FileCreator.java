package dev.xarlsr.popdb.generators;

import dev.xarlsr.popdb.rows.Row;
import dev.xarlsr.popdb.rows.RowTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Class for managing the creation and writing the output file of the application,
 * containing the SQL code to populate the table.
 */
public class FileCreator {

    /**
     * The file object to handle.
     */
    static File file;

    /**
     * Creates the file if it doesn't exists and returns an File object.
     * @param fileName Name of the file to create.
     * @return Return a File object.
     */
    public static File createFile(String fileName) {
        file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
                return file;
            } else {

                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Writes the code of the SQL lines of the text file, based on the RowTemplate.
     * Creates each new row and fills them by calling the method composeSql(), then
     * it write the result to the file.
     * @param rowTemplate Cast containing the fields definition to be filled.
     * @param linesCount Number of lines (rows) to populate the table.
     */
    public static void writeFile(RowTemplate rowTemplate, int linesCount){
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 1; i <= linesCount;i++){
                // Instantiates a new row object.
                Row row = new Row(rowTemplate);
                // Calls the filling method that generates the SQL code and writes it to the file.
                writer.write(row.composeSql()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}