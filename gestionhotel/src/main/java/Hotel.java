import java.util.ArrayList;

public class Hotel {
	
	public String nombre;
	public ArrayList<String> conjuntoHabitaciones = new ArrayList<String>();
	public String categoria;
	

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hotel(String nombre, ArrayList<String> conjuntoHabitaciones, String categoria) {
		super();
		this.nombre = nombre;
		this.conjuntoHabitaciones = conjuntoHabitaciones;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<String> getConjuntoHabitaciones() {
		return conjuntoHabitaciones;
	}


	public void setConjuntoHabitaciones(ArrayList<String> conjuntoHabitaciones) {
		this.conjuntoHabitaciones = conjuntoHabitaciones;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}
