package gestionhotel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class Hotel{
	
	BookingService bs = new BookingService();

    private List<Habitacion> conjuntoHabitaciones;
    private List<Cliente> conjuntoClientes;
    private List<Reserva> conjuntoReservas;

    

    public Hotel() {
    	conjuntoHabitaciones = bs.obtenerHabitaciones();
        conjuntoClientes = bs.obtenerClientes();
        conjuntoReservas = bs.obtenerReservas();
    }

    public void addHabitacion(Habitacion h) {
    	conjuntoHabitaciones.add(h);
    	bs.annadirHabitacion(h);
    }

    
    public void addReserva(Reserva r){
        conjuntoReservas.add(r);
        bs.realizarReserva(r);
    }
    
    public Reserva obtenerReserva(String codReserva) {
    	return bs.buscarReserva(codReserva);
    }
    
    public void eliminarReserva(String codReserva) {
    	Reserva reserv = null;
    	
    	for(Reserva r : conjuntoReservas) {
    		// Si encontramos el objeto que representa a la reserva con ese código
    		if(r.getCodigoReserva().equals(codReserva)) {
    			reserv = r;
    		}
    	}
    	
    	// Con el objeto reserv, que es la reserva con el codigo deseado:
    	// Primero se elimina de la BBDD y después del conjunto de datos del pc
    	if(reserv != null) {
    		bs.borrarReserva(reserv);
    		conjuntoReservas.remove(reserv);	
    	}
    }

    public void addCliente(Cliente c){
        conjuntoClientes.add(c);
        bs.registrarCliente(c);
    }
    
    public Cliente obtenerCliente(String dni) {
    	return bs.buscarCliente(dni);
    }

    public List<Habitacion> getConjuntoHabitaciones(){
        return conjuntoHabitaciones;
    }

    public List<Reserva> getConjuntoReservas(){
        return conjuntoReservas;
    }

    public List<Cliente> getConjuntoClientes(){
        return conjuntoClientes;
    }
	
	public HashMap<String, Integer> contarHabitaciones(int numPersonas){
		
		HashMap<String, Integer> tiposHabitaciones = new HashMap<>();
		
		tiposHabitaciones.put("normal", 0);
        tiposHabitaciones.put("business", 0);
        tiposHabitaciones.put("superior", 0);
        
        for(Habitacion hab : conjuntoHabitaciones) {
        
        	int n = tiposHabitaciones.get(hab.getCategoria());
        	tiposHabitaciones.replace(hab.getCategoria(), n+1);
        }
        
        return tiposHabitaciones; 
    }
	
	public HashMap<String, HashMap<String, Integer>> consultarDisponibilidad(
    		LocalDate fechaEntrada, LocalDate fechaSalida, int numPersonas){
		return bs.consultarDisponibilidad(fechaEntrada, fechaSalida, numPersonas, this.conjuntoReservas);
    	
    }
	
	
	
	
	
}
