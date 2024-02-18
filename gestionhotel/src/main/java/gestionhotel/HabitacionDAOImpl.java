package gestionhotel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

	@Override
	public Habitacion obtenerId(int id) {
		return conexion.get(Habitacion.class, id);
	}

	@Override
	public void guardar(Habitacion h) {
		Transaction tx = conexion.beginTransaction();
		conexion.save(h);
		tx.commit();
	}

	@Override
	public void eliminar(Habitacion h) {
		Transaction tx = conexion.beginTransaction();
		conexion.delete(h);
		tx.commit();
		
	}

	@Override
	public List<Habitacion> obtenerTodo() {
		return conexion.createQuery("SELECT h FROM Habitacion h").getResultList();
	}
}