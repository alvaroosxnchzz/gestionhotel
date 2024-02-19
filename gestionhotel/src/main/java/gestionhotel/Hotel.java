package gestionhotel;
import java.util.ArrayList;
import java.util.List;


public class Hotel{

    private ArrayList<Habitacion> conjuntoHabitaciones;
    private ArrayList<Cliente> conjuntoClientes;
    private ArrayList<Reserva> conjuntoReservas;

    
    


    private HabitacionDAOImpl hdao = new HabitacionDAOImpl();
    private ClienteDAOImpl cdao = new ClienteDAOImpl();
    private ReservaDAOImpl rdao = new ReservaDAOImpl();

    public Hotel() {
        // Cargada la info del hotel
        conjuntoHabitaciones = hdao.obtenerTodo();
        conjuntoClientes = cdao.obtenerTodo();
        conjuntoReservas = rdao.obtenerTodo();

    }

    public void addHabitacion(Habitacion h) {
        conjuntoHabtaciones.add(h);
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

    public List<Habitacion> getConjuntoReservas(){
        return conjuntoReservas;
    }

    public List<Habitacion> getConjuntoClientes(){
        return conjuntoClientes;
    }		this.totalReservas = totalReservas;
	}
	
	public HashMap<String, Integer> contarHabitaciones(int numPersonas){
        return hdao.cantidadTiposHabitacion(numPersonas);
    }
	
	
	
	
	
	
}
