package gestionhotel;
import java.util.ArrayList;

public class Hotel {
	
	public String nombre;
	public ArrayList<Habitacion> conjuntoHabitaciones = new ArrayList<Habitacion>();
	public String categoria;
	

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hotel(String nombre, ArrayList<Habitacion> conjuntoHabitaciones, String categoria) {
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
	
	public void addHabitacion(Habitacion h) {
		conjuntoHabitaciones.add(h);
	}


	public ArrayList<Habitacion> getConjuntoHabitaciones() {
		return conjuntoHabitaciones;
	}


	public void setConjuntoHabitaciones(ArrayList<Habitacion> conjuntoHabitaciones) {
		this.conjuntoHabitaciones = conjuntoHabitaciones;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
}
