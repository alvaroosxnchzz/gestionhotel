package gestionhotel;
public class Habitacion {
	
	public int numHabitacion;
	public String numeroCamas;
	public String categoria;
	public double precio;
	public String estado;
	
	public Habitacion(int numHabitacion, String numeroCamas, String categoria, String tipo, double precio, String estado) {
		this.numHabitacion = numHabitacion;
		this.numeroCamas = numeroCamas;
		this.categoria = categoria;
		this.precio = precio;
		this.estado = estado;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public Habitacion() {
		super();
		// TODO Esbozo de constructor generado automáticamente
	}

	public String getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(String numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
