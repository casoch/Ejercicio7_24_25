package ejercicio7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionAtraccionesTest {

    private GestionAtracciones gestion;
    private Atraccion atraccion1;
    private Atraccion atraccion2;

    @BeforeEach
    public void setUp() {
        gestion = new GestionAtracciones();
        atraccion1 = new Atraccion(1, "Dragon Khan", Atraccion.Tipo.MONTAÑA_RUSA, 120);
        atraccion2 = new Atraccion(2, "Gran Teatro", Atraccion.Tipo.ESPECTACULO, 300);
        gestion.add(atraccion1);
        gestion.add(atraccion2);
    }

    @Test
    public void testGet_ValidPosition() {
        assertEquals(atraccion1, gestion.get(0));
        assertEquals(atraccion2, gestion.get(1));
    }

    @Test
    public void testGet_InvalidPosition() {
        assertNull(gestion.get(-1));
        assertNull(gestion.get(2));  
    }

    @Test
    public void testGetById_ExistingId() {
        assertEquals(atraccion1, gestion.getById(1));
        assertEquals(atraccion2, gestion.getById(2));
    }

    @Test
    public void testGetById_NonExistingId() {
        assertNull(gestion.getById(99));
    }

    @Test
    public void testAdd_NewAtraccion() {
        Atraccion atraccion3 = new Atraccion(3, "Carrusel Mágico", Atraccion.Tipo.TIOVIVO, 50);
        assertTrue(gestion.add(atraccion3));
        assertEquals(atraccion3, gestion.getById(3));
    }

    @Test
    public void testAdd_DuplicateAtraccion() {
        Atraccion duplicada = new Atraccion(1, "Otra Montaña Rusa", Atraccion.Tipo.MONTAÑA_RUSA, 100);
        assertFalse(gestion.add(duplicada));
    }

    @Test
    public void testReplace_ExistingAtraccion() {
        Atraccion nueva = new Atraccion(1, "Dragon Khan Reloaded", Atraccion.Tipo.MONTAÑA_RUSA, 150);
        assertTrue(gestion.replace(nueva));
        assertEquals("Dragon Khan Reloaded", gestion.getById(1).getNombre());
        assertEquals(150, gestion.getById(1).getCapacidad());
    }

    @Test
    public void testReplace_NonExistingAtraccion() {
        Atraccion inexistente = new Atraccion(99, "Fantasma", Atraccion.Tipo.ESPECTACULO, 100);
        assertFalse(gestion.replace(inexistente));
    }

    @Test
    public void testRemove_ByAtraccion_Existing() {
        assertTrue(gestion.remove(atraccion1));
        assertNull(gestion.getById(1));
    }

    @Test
    public void testRemove_ByAtraccion_NonExisting() {
        Atraccion inexistente = new Atraccion(99, "Inexistente", Atraccion.Tipo.TIOVIVO, 30);
        assertFalse(gestion.remove(inexistente));
    }

    @Test
    public void testRemove_ById_Existing() {
        assertTrue(gestion.remove(2));
        assertNull(gestion.getById(2));
    }

    @Test
    public void testRemove_ById_NonExisting() {
        assertFalse(gestion.remove(99));
    }
}

