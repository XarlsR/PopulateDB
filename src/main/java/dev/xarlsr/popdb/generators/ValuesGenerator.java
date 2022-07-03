package dev.xarlsr.popdb.generators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Class containing the different methods to generate values for different types of fields.
 */
public class ValuesGenerator {

    public ValuesGenerator(){    }

 /**
  * Returns a string randomly extracted from a selected text file.
  * It reads the number of text lines set by the value of readValueCount param from the file,
  * loads them into an array and extracts a random string from the array.
  * The length of array is set to readValueCount value, so the text file must contain
  * this number of lines or more.
  * @param fileName: Path and name of the source text file.
  * @param readValueCount: Number of lines to be read from the text file.
  * @return String with a random text line from the file.
  */
    public static String getStringFromFile(String fileName, int readValueCount){
        String[] arrStr = new String[readValueCount];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int i = 0;
            do {
               arrStr[i] = br.readLine();
               i++;
            }
            while ((arrStr[i-1] != null) & (i<readValueCount));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = (int)(Math.random()*readValueCount);
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


    /**
     * Generates an spanish DNI number, including its control character.
     * It returns s 9 characters String, the first 8 are numbers and the
     * last one is the alphabetical control number.
     * @return
     */
    public static String genDni(){

        // Each random integer number generated casted to char type.
        char numsDni;
        int rndm;
        // String with the DNI value.
        String dni;

        String str = "";
        StringBuilder sb = new StringBuilder(str);
        // Generates 8 integer values, cast them to chars and add at the end of
        // sb string builder.
        for (int i = 0; i<8; i++){
            rndm = ((int)(Math.random()*10));
            numsDni = (char)(rndm+'0');
            sb.append(numsDni);
        }
        // Casts the string builder to String
        dni = sb.toString();

        // Generates the control character.
        int num = Integer.parseInt(dni);
        int resto = num%23;
        char letra = '\0';
        switch(resto){
            case 0 : {
                letra = 'T';
                break;
            }
            case 1 : {
                letra = 'R';
                break;
            }
            case 2 : {
                letra = 'W';
                break;
            }
            case 3 : {
                letra = 'A';
                break;
            }
            case 4 : {
                letra = 'G';
                break;
            }
            case 5 : {
                letra = 'M';
                break;
            }
            case 6 : {
                letra = 'Y';
                break;
            }
            case 7 : {
                letra = 'F';
                break;
            }
            case 8 : {
                letra = 'P';
                break;
            }
            case 9 : {
                letra = 'D';
                break;
            }
            case 10 : {
                letra = 'X';
                break;
            }
            case 11 : {
                letra = 'B';
                break;
            }
            case 12 : {
                letra = 'N';
                break;
            }
            case 13 : {
                letra = 'J';
                break;
            }
            case 14 : {
                letra = 'Z';
                break;
            }
            case 15 : {
                letra = 'S';
                break;
            }
            case 16 : {
                letra = 'Q';
                break;
            }
            case 17 : {
                letra = 'V';
                break;
            }
            case 18 : {
                letra = 'H';
                break;
            }
            case 19 : {
                letra = 'L';
                break;
            }
            case 20 : {
                letra = 'C';
                break;
            }
            case 21 : {
                letra = 'K';
                break;
            }
            case 22 : {
                letra = 'E';
                break;
            }
        }
        dni = dni+letra;
        return dni;
    }


    public static LocalDate genRandomDate(){

        return null;
    }
}