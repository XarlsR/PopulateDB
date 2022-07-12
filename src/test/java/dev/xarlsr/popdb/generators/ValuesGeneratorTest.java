package dev.xarlsr.popdb.generators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static dev.xarlsr.popdb.generators.ValuesGenerator.*;


class ValuesGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStringFromFileTest() {
        String file1 = "C:\\Java\\Proyectos\\populatedb\\src\\main\\resources\\dummy\\es\\Apellidos.txt";
        String text;
        text = getRandStringFromFile(file1);
        System.out.println(text);
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
    }

    @Test
    void genPatternString() {
    }

    @Test
    void genRandomDate() {
    }
}