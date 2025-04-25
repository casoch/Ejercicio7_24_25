package ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class GestionAtracciones {
	private List<Atraccion> atracciones;
	
	public GestionAtracciones()
	{
		atracciones = new ArrayList<Atraccion>();
	}
	
	/**
	 * Devuelve la atracción que hay en la posición indicada.
	 * @param posicion Posicion que queremos
	 * @return La atracción en esa posición. 
	 *   Null si la posición está fuera de rango.
	 */
	public Atraccion get(int posicion)
	{
		if (posicion<0 || posicion>=atracciones.size()) return null;
		return atracciones.get(posicion);
	}
	
	/**
	 * Devuelve todos los datos de la atracción que tiene el id indicado
	 * @param id Id de la atracción que se está buscando
	 * @return La atracción que tiene ese id. 
	 *    Retorna null si no existe una atracción con ese id.
	 */
	public Atraccion getById(int id)
	{
		Atraccion a = new Atraccion(id, null, null, 100);
		int posicion = atracciones.indexOf(a);
		if (posicion == -1) return null;
		return atracciones.get(posicion);
	}
	
	/**
	 * Añade la atracción a la lista de atracciones.
	 * Si el id de la atracción ya existe, no se añade de nuevo y se retorna false
	 * @param atraccion Atracción a añadir
	 * @return True si la atraccion se ha podido añadir; false, en caso 
 	 * contrario.
	 */
	public boolean add(Atraccion atraccion)
	{
		boolean existe = atracciones.contains(atraccion);
		if (existe) return false;
		atracciones.add(atraccion);
		return true;
	}
	
	/**
	 * Busca la atracción que tiene el mismo id que la atracción que se pasa  
	 * como parámetro.
	 * Si se encuentra, se sustituye por el parámetro y se retorna true. 
	 * Si no se encuentra no se hace nada y se retorna false.
	 * @param atraccion Atracción a sustituir
	 * @return True si se ha podido sustituir; False en caso contrario.
	 */
	public boolean replace(Atraccion atraccion)
	{
		int posicion = atracciones.indexOf(atraccion);
		if (posicion == -1) return false;
		atracciones.set(posicion, atraccion);
		return true;
	}
	
	/**
	 * Elimina esta atracción de la lista
	 * @param atraccion Atracción a eliminar
	 * @return True si se ha encontrado y eliminado; False en caso contrario.
	 */
	public boolean remove(Atraccion atraccion)
	{
		return atracciones.remove(atraccion);
	}
	
	/**
	 * Elimina la atracción con el id indicado de la lista
	 * @param id Id de la atracción a eliminar
	 * @return True si se ha encontrado y eliminado; False en caso contrario.
	 */
	public boolean remove(int id)
	{
		Atraccion a = new Atraccion(id, null, null, 100);
		int posicion = atracciones.indexOf(a);
		if (posicion == -1) return false;
		atracciones.remove(posicion);
		return true;
	}
}

