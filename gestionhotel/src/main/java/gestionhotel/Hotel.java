package gestionhotel;
import java.util.ArrayList;

import gestionhotel2.HashMap;

public class Hotel {
	
	public String nombre;
	public ArrayList<Habitacion> conjuntoHabitaciones = new ArrayList<Habitacion>();
	public ArrayList<Reserva> totalReservas = new ArrayList<Reserva>();
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
	
	public void addReserva(Reserva r){
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


	public ArrayList<Reserva> getTotalReservas() {
		return totalReservas;
	}


	public void setTotalReservas(ArrayList<Reserva> totalReservas) {
		this.totalReservas = totalReservas;
	}
	
	public HashMap<String, Integer> contarHabitaciones(int numPersonas){
        return hdao.cantidadTiposHabitacion(numPersonas);
    }
	
	
	
	
	
	
}
