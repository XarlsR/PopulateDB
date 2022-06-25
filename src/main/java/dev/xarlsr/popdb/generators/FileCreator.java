package dev.xarlsr.popdb.generators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    public static void createFile(String fileName) {
        File file = new File(fileName);

        //Create the file
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
            } else {
                System.out.println("File already exists.");
            }
            //Write Content
            FileWriter writer = new FileWriter(file);
            writer.write("Test data");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}