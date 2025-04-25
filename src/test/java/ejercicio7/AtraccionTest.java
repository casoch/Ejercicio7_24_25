package ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ejercicio7.Atraccion.Tipo;

public class AtraccionTest {
	
	/**
	 * Comprueba si se puede crear correctamente una atracción
	 * con capacidad mayor que cero
	 */
	@Test
	void atraccion_inicializacionCorrecta()
	{
		Atraccion a = new Atraccion("Dragon Khan", Tipo.MONTAÑA_RUSA, 100);
		assertEquals(a.getNombre(), "Dragon Khan");
		assertEquals(a.getTipo(), Tipo.MONTAÑA_RUSA);
		assertEquals(a.getCapacidad(), 100);
	}
	
	/**
	 * Comprueba qué ocurre si creo una atracción de capacidad cero.
	 * Cambiará la capacidad a 1.
	 */
	@Test
	void atraccion_capacidadLimite()
	{
		Atraccion a = new Atraccion("Dragon Khan", Tipo.MONTAÑA_RUSA, 0);
		assertEquals(a.getNombre(), "Dragon Khan");
		assertEquals(a.getTipo(), Tipo.MONTAÑA_RUSA);
		assertEquals(a.getCapacidad(), 1);
	}
	
	/**
	 * Comprueba qué ocurre si creo una atracción de capacidad negativa.
	 * Cambiará la capacidad a 1.
	 */
	@Test
	void atraccion_capacidadIncorrecta()
	{
		Atraccion a = new Atraccion("Dragon Khan", Tipo.MONTAÑA_RUSA, -10);
		assertEquals(a.getNombre(), "Dragon Khan");
		assertEquals(a.getTipo(), Tipo.MONTAÑA_RUSA);
		assertEquals(a.getCapacidad(), 1);
	}
	
	/**
	 * Comprueba que dos atracciones son iguales si tienen el mismo id.
	 */
	@Test
	void atraccion_igualesPorId()
	{
		Atraccion a1 = new Atraccion(1, "Dragon Khan", Tipo.MONTAÑA_RUSA, 20);
		Atraccion a2 = new Atraccion(1, "Tiovivo", Tipo.TIOVIVO, 120);
		assertTrue(a1.equals(a2));
	}
	
	/**
	 * Comprueba que dos atracciones no son iguales si no tienen el mismo id.
	 */
	@Test
	void atraccion_diferentesPorId()
	{
		Atraccion a1 = new Atraccion(1, "Dragon Khan", Tipo.MONTAÑA_RUSA, 20);
		Atraccion a2 = new Atraccion(2, "Dragon Khan", Tipo.MONTAÑA_RUSA, 20);
		assertFalse(a1.equals(a2));
	}
}
