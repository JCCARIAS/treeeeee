package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioBusquedaTest {

    @Test
    void testArbolVacio() {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        assertFalse(arbol.buscar(10));
        assertEquals(0, arbol.profundidad());
        assertEquals("", arbol.inorden());
    }

    @Test
    void testInsertarYBuscar() {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        assertTrue(arbol.buscar(50));
        assertTrue(arbol.buscar(30));
        assertTrue(arbol.buscar(70));
        assertTrue(arbol.buscar(20));
        assertTrue(arbol.buscar(40));
        assertTrue(arbol.buscar(60));
        assertTrue(arbol.buscar(80));
        assertFalse(arbol.buscar(100));
    }

    @Test
    void testProfundidad() {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        assertEquals(0, arbol.profundidad());

        arbol.insertar(50);
        assertEquals(1, arbol.profundidad());

        arbol.insertar(30);
        arbol.insertar(70);
        assertEquals(2, arbol.profundidad());

        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        assertEquals(3, arbol.profundidad());

        arbol.insertar(10);
        assertEquals(4, arbol.profundidad());
    }

    @Test
    void testInorden() {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        assertEquals("20 30 40 50 60 70 80", arbol.inorden());
    }

    @Test
    void testEliminar() {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        arbol.eliminar(20);
        assertEquals("30 40 50 60 70 80", arbol.inorden());

        arbol.eliminar(30);
        assertEquals("40 50 60 70 80", arbol.inorden());

        arbol.eliminar(70);
        assertEquals("40 50 60 80", arbol.inorden());

        arbol.eliminar(50);
        assertEquals("40 60 80", arbol.inorden());
    }
}
