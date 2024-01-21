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
		habitacionesLibres.replaceAll(true);
		
		for(Reservas r : h.getTotalReservas()){
            if( !fechaEntrada.isAfter(r.getFechaSalida()) && !fechaSalida.isBefore(r.getFechaEntrada()) ){
                habitacionesLibres.set(r.getNumHabitacion() - 1, false);
            }
        }
		
		for(Habitacion hab : h.getConjuntoHabitaciones()){
            if( habitacionesLibres.get(hab.getNumHabitacion()-1) && (hab.getEstado().equals("No disponible") || hab.getNumeroCamas() < numPersonas) ){
                habitacionesLibres.set(hab.getNumHabitacion()-1, false);
            }
        }

        
        return habitacionesLibres;
		
		
	
		
	}
	
	public static void realizarReserva() {}
}
