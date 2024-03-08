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
    	// Esto lo haces en el constructor del hotel para realizar 
    	// una copia local de los datos que haya hasta el momento en
    	// la BD (usando el BS)
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
    
    // Los datos más actualizados siempre van a estar en la BD. En la copia local
    // solo tienes los datos que había al iniciar el programa junto con los datos 
    // que has creado TÚ desde el programa
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
    
    public void asignarHabitacion(Reserva r, int numHabitacion) {
    	r.setNumHabitacion(numHabitacion);
    	bs.actualizarReserva(r);
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
        	if(hab.getNumeroCamas() >= numPersonas) {
        		int n = tiposHabitaciones.get(hab.getCategoria());
            	tiposHabitaciones.replace(hab.getCategoria(), n+1);
        	}
        }
        
        return tiposHabitaciones; 
    }
	
	public HashMap<String, HashMap<String, Integer>> consultarDisponibilidad(
    		LocalDate fechaEntrada, LocalDate fechaSalida, int numPersonas){
		// Se ha añadido el conteo de habitaciones
		return bs.consultarDisponibilidad(
				fechaEntrada, fechaSalida, numPersonas, this.conjuntoReservas, 
				this.contarHabitaciones(numPersonas));	
    }
	
	public void cambiarEstadoHabitacion(Habitacion hab, String estado) {
		hab.setEstado(estado);
		bs.actualizarHabitacion(hab);
	}
	
	
	
	
}
