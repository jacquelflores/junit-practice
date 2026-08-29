package org.stolen.junitapp.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testNombreCuenta() {
        Cliente cliente = new Cliente("Julia", "Hurtado", 100);
        assertTrue(cliente.getNombre().startsWith("Ju"));
        assertEquals("Julia", cliente.getNombre());
    }
}