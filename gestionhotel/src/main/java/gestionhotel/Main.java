package gestionhotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
	
	private static Hotel h = new Hotel();
	
	private static Menu m = new Menu();
	
	public static void main(String[] args) {
		m.deslpegarMenu();
	}
	
	private static void crearHabitaciones() {
		// Creación de habitaciones
		ArrayList<Habitacion> habs = new ArrayList<>();
		
		for(int id = 1; id <= 3; id++) {
			habs.add(new Habitacion(id, 2, "normal", 150, "Libre"));
		}
		
		for(int id = 4; id <= 7; id++) {
			habs.add(new Habitacion(id, 1, "business", 250, "Libre"));
		}
		
		for(int id = 8; id <= 10; id++) {
			habs.add(new Habitacion(id, 3, "superior", 350, "Libre"));
		}
		
		for(var hab : habs) {
			h.addHabitacion(hab);
		}
	}
	
	private static void crearCliente() {
		Cliente c = new Cliente("Manuel", "Suano", "Gallardo", 23, "45454545K");
		
		h.addCliente(c);
	}

	private static void crearReserva() {
		String codReserva = generarCodigoAleatorio(8) + "-" + 
                generarCodigoAleatorio(4) + "-" + 
                generarCodigoAleatorio(4) + "-" + 
                generarCodigoAleatorio(4) + "-" +
                generarCodigoAleatorio(12);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaEntrada = LocalDate.parse("12/03/2024", formatter);
		LocalDate fechaSalida = LocalDate.parse("15/03/2024", formatter);
		
		// fechaEntrada.format(DateTimeFormatter.ISO_LOCAL_DATE);
		// fechaSalida.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		Reserva r = new Reserva(codReserva, 1, 1, "normal",
								h.getConjuntoClientes().get(0), 400, fechaEntrada, fechaSalida);
		
		h.addReserva(r);
	}
	
	private static String generarCodigoAleatorio(int longitud){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                     + "abcdefghijklmnopqrstuvwxyz"
                     + "0123456789";
        String str = new Random().ints(longitud, 0, chars.length())
                                 .mapToObj(i -> "" + chars.charAt(i))
                                 .collect(Collectors.joining());

        return str;
    }

}
