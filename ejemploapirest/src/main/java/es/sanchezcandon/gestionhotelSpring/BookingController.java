package es.sanchezcandon.gestionhotelSpring;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import gestionhotel.Hotel;
import gestionhotel.Reserva;


@RestController
public class BookingController {
	
	
	private Hotel h = new Hotel();
	
	
	@GetMapping("/disponibilidad")
	public ResponseEntity<HashMap<String, HashMap<String, Integer>>> disponibilidad(
            @RequestParam(value = "fechaEntrada", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaEntrada,
            @RequestParam(value = "fechaSalida", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaSalida,
            @RequestParam(value = "numPersonas", required = true) int numPersonas) {

        
        HashMap<String, HashMap<String, Integer>> habitacionesDisponibles = h.consultarDisponibilidad(fechaEntrada, fechaSalida, numPersonas);
        System.out.println(habitacionesDisponibles);
        

        return new ResponseEntity<>(habitacionesDisponibles, HttpStatus.OK);
	}
	
	@PostMapping("/reserva")
    public ResponseEntity<?> reservarHabitacion(
            @RequestParam(value = "habitacionId", required = true) String habitacionId,
            @RequestParam(value = "fechaEntrada", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaEntrada,
            @RequestParam(value = "fechaSalida", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaSalida,
            @RequestParam(value = "numPersonas", required = true) int numPersonas) {

        
        Reserva reserva = new Reserva();  
        h.addReserva(reserva);

        // Devuelve el código de reserva en la respuesta
        return new ResponseEntity<>(reserva.getCodigoReserva(), HttpStatus.OK);
    }

	@GetMapping("/cancelar")
    public ResponseEntity<?> cancelar(
            @RequestParam(value = "codReserva", required = true) String codReserva) {

        
        h.eliminarReserva(codReserva);

       
        return new ResponseEntity<>("Reserva cancelada correctamente", HttpStatus.OK);
    }
}

