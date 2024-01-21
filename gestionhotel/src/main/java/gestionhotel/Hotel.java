package gestionhotel;
import java.util.ArrayList;

public class Hotel {
	
	public String nombre;
	public ArrayList<Habitacion> conjuntoHabitaciones = new ArrayList<Habitacion>();
	public ArrayList<Reservas> totalReservas = new ArrayList<Reservas>();
	public String categoria;
	

	





	public Hotel(String nombre) {
		this.nombre = nombre;
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
	
	public void addReserva(Reservas r){
        totalReservas.add(r);
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


	public ArrayList<Reservas> getTotalReservas() {
		return totalReservas;
	}


	public void setTotalReservas(ArrayList<Reservas> totalReservas) {
		this.totalReservas = totalReservas;
	}
	
	
	
	
	
	
}
