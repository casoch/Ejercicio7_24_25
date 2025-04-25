package ejercicio7;

public class Atraccion {
	enum Tipo {MONTAÑA_RUSA, ESPECTACULO, TIOVIVO};
	private int id;
	private String nombre;
	private Tipo tipo;
	private int capacidad;
	
	
	public Atraccion(int id, String nombre, Tipo tipo, int capacidad) {
		this(nombre, tipo, capacidad);
		this.id = id;
	}
	
	public Atraccion(String nombre, Tipo tipo, int capacidad) {
		this.nombre = nombre;
		this.tipo = tipo;
		if (capacidad<=0) capacidad = 1;
		this.capacidad = capacidad;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	@Override
	public String toString() {
		return "Atraccion [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", capacidad=" + capacidad + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return id == other.id;
	}
	
	
	
}
