package dev.xarlsr.popdb.generators;

import dev.xarlsr.popdb.rows.Row;
import dev.xarlsr.popdb.rows.RowTemplate;
import dev.xarlsr.utilidades.EntradaTeclado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileCreator {

    static String fileName;
    static File file;

    public static String getFileName(){
        System.out.print("Introduzca nombre del fichero SQL:");
        return fileName = EntradaTeclado.leeCadena();
    }

    public static File createFile(String fileName) {
        file = new File(fileName);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
                return file;
            } else {
                System.out.println("File already exists.");
            }
            //Write Content

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(RowTemplate rowTemplate, int linesCount){
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 1; i <= linesCount;i++){
                Row row = new Row(rowTemplate);
                writer.write(row.composeSql()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}