package dev.xarlsr.popdb.generators;

import dev.xarlsr.utilities.DateUtils;
import org.apache.commons.validator.GenericValidator;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static dev.xarlsr.popdb.generators.ValuesGenerator.*;


class ValuesGeneratorTest {


    @Test
    void getStringFromFileTest() {
        String file1 = "C:\\Java\\Proyectos\\populatedb\\src\\main\\resources\\dummy\\es\\Apellidos.txt";
        String text;
        text = getRandStringFromFile(file1);
        System.out.println("getStringFromFileTest(): "+text);
        assertNotNull(text);
    }

    @Test
    void getProbStringFromFileTest(){
        String file2 = "C:\\Java\\Proyectos\\populatedb\\src\\main\\resources\\dummy\\es\\Apellidos_Prob_ES_1000.txt";
        String text = getProbStringFromFile(file2);
        System.out.println("getProbStringFromFileTest(): "+text);
        assertNotNull(text);
    }

    /*@Test
    public void getStringFromFileException(){
        FileNotFoundException thrown = Assertions.assertThrows(FileNotFoundException.class, () ->{
            String file2 = "Doritos.txt";
            getStringFromFile(file2,100);
            },"File Not Found Exception");
        Assertions.assertEquals("File 'Doritos.txt throws ",thrown.getMessage());
    }*/

    @Test
    void genDniTest() {
        String dni = genDni();
        assertEquals(9, dni.length());
        String dniNumbers = dni.substring(0,8);
        String dniLetter = dni.substring(8,9);
        assertEquals(Character.toString(getDniLetter(dniNumbers)), dniLetter);
        System.out.println("genDniTest(): "+dni+" "+Character.toString(getDniLetter(dniNumbers)));
    }

    @Test
    void genPatternString() {
    }

    @Test
    void genRandomDateTest() {
        LocalDate d1 = DateUtils.stringToDate("19500101","yyyyMMdd","yyyyMMdd");
        LocalDate d2 = DateUtils.stringToDate("20220301","yyyyMMdd","yyyyMMdd");
        for (int i = 1; i<=1000;i++) {
            LocalDate lDate = genRandomDate(d1, d2);
            String strDate = DateUtils.dateToString(lDate);
            assertTrue((lDate.isEqual(d1) || lDate.isAfter(d1)));
            assertTrue(lDate.isBefore(d2));
            assertTrue(GenericValidator.isDate(strDate, "yyyyMMdd", true));
            System.out.println("genRandomDateTest() [commons-validator]: " + strDate + " ok");
        }
    }
}