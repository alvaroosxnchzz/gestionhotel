package gestionhotel;
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
    }

    
    public void addReserva(Reserva r){
        conjuntoReservas.add(r);
    }

    public void addCliente(Cliente c){
        conjuntoClientes.add(c);
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
		//HashMap<String, Integer> habitacion
        return hdao.cantidadTiposHabitacion(numPersonas);
    }
	
	
	
	
	
	
}
