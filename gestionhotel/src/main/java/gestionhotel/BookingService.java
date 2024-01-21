package gestionhotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingService {
	
	Hotel h;
	
	public BookingService(Hotel h) {
		this.h = h;
	}

	public ArrayList<Boolean> consultarDisponibilidad(LocalDate fechaEntrada, LocalDate fechaSalida, int numPersonas){
		
		ArrayList<Boolean> habitacionesLibres = new ArrayList<Boolean>(h.getConjuntoHabitaciones().size());
		habitacionesLibres.replaceAll(ignored -> true);
		
		
		
		return habitacionesLibres;
		
	}
	
	public static void realizarReserva() {}
}
