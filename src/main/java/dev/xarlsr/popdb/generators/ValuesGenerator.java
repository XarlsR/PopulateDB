package dev.xarlsr.popdb.generators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class containing the different methods to generate values for different types of fields.
 */
public class ValuesGenerator {

    public ValuesGenerator(){    }

    /**
     * <b>Reads a text file and returns every text lines in a <code>List</code> of <code>Strings</code>.</b><br>
     * It reads every text lines from the file and
     * loads them into a <code>List<String></String></code> Then returns the List.
     * @param fileName: <code>String</code> with path and name of the source text file.
     * @return <code>List<String></String></code> with every text lines of the source file.
     * @since Version 1.0.3
     */
    public static List<String> getListStringFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        BufferedReader br = null;
        int linesCount = 0;
        try {
            br = new BufferedReader(new FileReader(fileName));
            do {
                stringList.add(br.readLine());
                //System.out.println("Linea "+linesCount+" "+stringList.get(linesCount));
                linesCount++;
            }
            while ((stringList.get(linesCount-1) != null));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                br.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        int returnLine = (int)(Math.random()*linesCount);
        return stringList;
    }

    /**
     * <b>Returns a string randomly extracted from a selected text file.</b><br>
     * It calls the {@link #getListStringFromFile(String) getListStringFromFile(String)} method to read the file,
     * gets the list of lines (strings) and selects one of them randomly.
     * @param fileName: <code>String</code> with path and name of the source text file.
     * @return <code>String</code> with a random text line from the file.
     * @since Version 1.0.3
     */
    public static String getRandStringFromFile(String fileName) {
        List<String> stringList = getListStringFromFile(fileName);
        int returnLine = (int)(Math.random()* (stringList.size()-1));
        return stringList.get(returnLine);
    }

   /**
     * <b>Returns a value from a text file selected by its probability of occurrence.</b><br>
     * The lines of the text file must be in format 'Value,Probability' (i.e "Value1,0.02').
     * Every text lines of the file are read via {@link #getListStringFromFile(String)} method and
     * loaded to a <code>List</code>. Then the list is split into two sublists, one with the values
     * and the other containing the probabilities of each value (after parsing the
     * <code>String</code> to <code>Double</code>). It also generates a third auxiliar <code>List</code> with the
     * accumulative probabilities read.
     * @param fileName <code>String</code> with path and name of the source file
     * @return selected <code>String</code>.
     * @since Version 2.3.0
     */
    public static String getProbStringFromFile(String fileName){
        // List with the read lines from the text file
        List<String> grossList = getListStringFromFile(fileName);
        // List with the values of every line
        List<String> valuesList = new ArrayList<>();
        // List with the probability of every line
        List<Double> probList = new ArrayList<>();
        // Accumulative list with the sum of n-probabilities
        List<Double> accuProbList = new ArrayList<>();
        for (int i = 0; i< grossList.size()-1;i++){
            String[] parts = grossList.get(i).split(",");
            valuesList.add(i, parts[0]);
            probList.add(i, Double.parseDouble(parts[1]));
            // The first entry of the accu list is the probability of the first line.
            if (i<=0){
                accuProbList.add(i, probList.get(i));
            }
            // The rest of the entries are the actual probability plus the previous sum of probabilities.
            else{
                accuProbList.add(i, probList.get(i)+accuProbList.get(i-1));
            }
        }
        double randSel = Math.random();
        // Runs the accu list checking if the actual value is higher than the random number. When it's higher returns the corresponding value of the values list.
        for (int j = 0; j<accuProbList.size();j++){
            //System.out.println("Accu "+j+" "+accuProbList.get(j));
            if (accuProbList.get(j)>=randSel){
                return valuesList.get(j);
            }
        }
        return null;
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
     * <b>Generates an spanish DNI number, including its calculated control character.</b><br>
     * It returns a 9 characters string, the first 8 are numbers and the
     * last one is the alphabetical control number.
     * @return <code>String</code> with a DNI number.
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
        char letra = getDniLetter(dni);
        dni = dni+letra;
        return dni;
    }

    /**
     * <b>Generates a spanish DNI (national identification document) control character.</b><br>
     * @param dni <code>String</code>. Set of digits which the control character is based in.
     * @return <code>char</code> with the control letter.
     * @since version 1.0.3
     */
    public static char getDniLetter(String dni) {
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
        return letra;
    }

    /**
     * <b>Generates a random <code>String</code> with a user defined pattern, which
     * is passed as parameter.</b><br>
     * <p>The random values are generated with the following rules:</p>
     * <ul>
     * <li>'a' character is replaced with a random uppercase alphabetical character in that position.
     * <li>'n' character is replaced with a random number 0-9 in that position.
     * <li>Any other character is passed to the resulting string as part of the pattern.
     * </ul>
     * @param sPattern <code>String</code> with the pattern to generate the string.
     * @return Randomly generated <code>String</code>.
     */
    public static String genPatternString(String sPattern){
        String result = "";
        // Pattern is converted to char array
        char[] chars = sPattern.toCharArray();
        for (int i = 0; i<chars.length; i++){
            // Generates alphabetical characters
            if (chars[i] == 'a'){
                Random r = new Random();
                // Lower and upper limits for ASCII characters A-Z (+1) in decimal notation
                int low = 65;
                int hi = 91;
                int rand = r.nextInt(hi-low)+low;
                result = result + (char)rand;
            }
            // Generates numerical characters
            else if (chars[i] == 'n'){
                Random r = new Random();
                // Lower and upper limits for ASCII characters 0-9 (+1) in decimal notation.
                int low = 48;
                int hi = 58;
                int rand = r.nextInt(hi-low)+low;
                result = result + (char)rand;
            }
            // Passes other characters unmanaged as part of the pattern.
            else {
                result = result + chars[i];
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * <b>Generate a random date between two given dates passed as parameters.</b><br>
     * The starting date is inclusive and the ending date is exclusive. The generated
     * date is returned in {@link LocalDate LocalDate} form.
     * @param startInclusive <code>LocalDate</code> with the starting date (inclusive).
     * @param endExclusive <code>LocalDate</code> with the ending date (exclusive).
     * @return <code>LocalDate</code> with a random date within the given interval.
     * @see ThreadLocalRandom
     */
    public static LocalDate genRandomDate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

}