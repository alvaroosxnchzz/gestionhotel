package gestionhotel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import gestionhotel2.ArrayList;
import gestionhotel2.HashMap;

public class HabitacionDAOImpl implements HabitacionDAO{
	
	private Session conexion;
	
	public HabitacionDAOImpl(){

		SessionFactory session = new Configuration()
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Habitacion.class)
                .addAnnotatedClass(Reserva.class)
                .configure().buildSessionFactory();
		
		conexion = session.openSession();
	}

	
	public Habitacion obtenerId(int id) {
		return conexion.get(Habitacion.class, id);
	}

	
	public void guardar(Habitacion h) {
		Transaction tx = conexion.beginTransaction();
		conexion.save(h);
		tx.commit();
	}

	
	public void eliminar(Habitacion h) {
		Transaction tx = conexion.beginTransaction();
		conexion.delete(h);
		tx.commit();
		
	}

	
	public List<Habitacion> obtenerTodo() {
		return conexion.createQuery("SELECT h FROM Habitacion h").getResultList();
	}
	
	 
	    public HashMap<String, Integer> cantidadTiposHabitacion(){
	        // Para almacenar la cantidad de habitaciones que hay de cada tipo
	        HashMap<String, Integer> cantidadHabitaciones = new HashMap<>();
	        ArrayList<String> resultado = conexion.createQuery("SELECT categoria, COUNT(*) FROM Habitacion WHERE numPersonas>="+ numeroPersonas+ " GROUP BY categoria").getResultList();
	        // Paso al HashMap de la cantidad de estaciones de cada tipo recibida desde la base de datos.
	        for(var fila: resultado){
	           cantidadHabitaciones.put(fila[0], fila[1]);
	        }

	        return cantidadHabitaciones;
	    }
}