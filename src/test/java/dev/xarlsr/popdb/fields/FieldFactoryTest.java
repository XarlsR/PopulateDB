package dev.xarlsr.popdb.fields;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldFactoryTest {



    @Test
    void testGetField() {
        Field field1 = new FieldFactory().getField("FSTRING");
        assertEquals("FSTRING",field1.getType());
        Field field2 = new FieldFactory().getField("DNI");
        assertEquals("DNI",field2.getType());
    }
}