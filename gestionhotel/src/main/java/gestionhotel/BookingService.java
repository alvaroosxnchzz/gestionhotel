package gestionhotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gestionhotel2.Reserva;



public class BookingService {
	
	Hotel h;
	
	private HabitacionDAOImpl hdao = new HabitacionDAOImpl();
    private ClienteDAOImpl cdao = new ClienteDAOImpl();
    private ReservaDAOImpl rdao = new ReservaDAOImpl();
	
	public BookingService() {
		
	}
	
	public List<Habitacion> obtenerHabitaciones(){
    	return hdao.obtenerTodo();
    }
    
    public List<Reserva> obtenerReservas(){
    	return rdao.obtenerTodo();
    }
    
    public List<Cliente> obtenerClientes(){
    	return cdao.obtenerTodo();
    }

	public HashMap<String, HashMap<String, Integer>> consultarDisponibilidad(LocalDate fechaEntrada,
            LocalDate fechaSalida, int numPersonas, List<Reserva> conjuntoReservas) {

        HashMap<String, HashMap<String, Integer>> infoHabitaciones = new HashMap<>();
        infoHabitaciones.put("normal", new HashMap<>());
        infoHabitaciones.put("business", new HashMap<>());
        infoHabitaciones.put("superior", new HashMap<>());

        var numHabitaciones = h.contarHabitaciones(numPersonas);

        // Info para las habitaciones de tipo normal
        HashMap<String, Integer> info = new HashMap<>();
        info.put("cantidad", numHabitaciones.get("normal"));
        info.put("precio", 0); // El que sea
        infoHabitaciones.replace("normal", info);

        // Info para las habitaciones de tipo business
        info = new HashMap<>();
        info.put("cantidad", numHabitaciones.get("business"));
        info.put("precio", 0); // El que sea
        infoHabitaciones.replace("business", info);

        // Info para las habitaciones de tipo superior
        info = new HashMap<>();
        info.put("cantidad", numHabitaciones.get("superior"));
        info.put("precio", 0); // El que sea
        infoHabitaciones.replace("superior", info);

        // Para cada reserva se comprueba:
        //    1. Que la nueva fecha de entrada no sea posterior a la fecha de salida de la reserva.
        //    2. Que la nueva fecha de salida no sea anterior a la fecha de entrada de la reserva.
        // Si se cumplen (1) y (2), entonces el nuevo intervalo se solapa de alguna forma con el intervalo
        // de la reserva y la habitación asociada no puede ser tomada en cuenta.
        for (Reserva r : conjuntoReservas) {
            if (!fechaEntrada.isAfter(r.getFechaSalida()) && !fechaSalida.isBefore(r.getFechaEntrada())
                    && r.getNumPersonas() <= numPersonas) {
                // Tomamos el número de habitaciones que hay disponibles hasta el momento y le restamos uno.
                int n = infoHabitaciones.get(r.getTipoHabitacion()).get("cantidad") - 1;

                // Actualizamos la cantidad de habitaciones disponibles.
                infoHabitaciones.get(r.getTipoHabitacion()).replace("cantidad", n);
            }

        }

        return infoHabitaciones;
    }
	
	public void realizarReserva(Reserva r) {
        rdao.guardar(r);
    }
	
	public Reserva buscarReserva(String codReserva) {
    	return rdao.obtenerPorCodigo(codReserva);
    }
	
	public void registrarCliente(Cliente c) {
        
        cdao.guardar(c);
    }
	
	public void annadirHabitacion(Habitacion h) {
        hdao.guardar(h);
    }
	
	public Cliente buscarCliente(String dni) {
    	return cdao.obtenerPorDNI(dni);
    }
		
	
	
	
}
