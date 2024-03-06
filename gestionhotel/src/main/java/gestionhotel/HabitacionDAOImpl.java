package gestionhotel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HabitacionDAOImpl implements HabitacionDAO{
	
	private Session conexion;
	
	public HabitacionDAOImpl(){

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        conexion = factory.openSession();
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
	
}