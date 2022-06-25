package dev.xarlsr.popdb.generators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class containing the different methods to generate values for different types of fields.
 */
public class ValuesGenerator {

    public ValuesGenerator(){    }

 /**
  * Returns a string randomly extracted from the selected text file.
  * It reads all the text lines from the file, loads them into an array
  * and extracts a random string from the array. The length of array is set to 100,
  * so the text file must contain 100 text lines or more.
  * @param fileName: Ruta y nombre del fichero que contiene los nombres.
  * @return Devuelve un <tt>String</tt> con el nombre seleccionado.
  */
    // TODO: En una futura versión añadir un parámetro para indicar cuántos valores deben ser leídos antes de realizar la selección aleatoria. En la v1.0 está fijado a 100.
    public static String getStringFromFile(String fileName){

        String[] arrStr = new String[100];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int i = 0;
            do {
               arrStr[i] = br.readLine();
               i++;
            }
            while ((arrStr[i-1] != null) & (i<100));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = (int)(Math.random()*100);
        return arrStr[i];
    }

    /**
     * Returns a random name got from the male and female names files via 
     * the getString() method, with the probability of male or female
     * name set via percentOfMales parameter.
     * 
     * @param percentOfMales: Sets the probability of returning a name from the male
     * names file.
     * @return name: A male or female name.
     */
    /*public static String genNombre(int percentOfMales){
        String name;
        int i = (int)(Math.random()*100);
        if (i <= percentOfMales){
            name = getStringFromFile(mNamesFile).toUpperCase();
        }
        else{
            name = getStringFromFile(fNamesFile).toUpperCase();
        }
        return name;
    }*/

    
}