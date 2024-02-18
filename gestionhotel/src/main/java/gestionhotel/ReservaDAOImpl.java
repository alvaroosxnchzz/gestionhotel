package gestionhotel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReservaDAOImpl implements ReservaDAO {
	
	private Session conexion;
	
	public ReservaDAOImpl() {
		SessionFactory session = new Configuration()
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Habitacion.class)
                .addAnnotatedClass(Reserva.class)
                .configure().buildSessionFactory();
		
		conexion = session.openSession();
	}

	@Override
	public Reserva obtenerPorCodigo(String codigoReserva) {
		return conexion.get(Reserva.class, codigoReserva);
	}

	@Override
	public void guardar(Reserva r) {
		Transaction tx = conexion.beginTransaction();
		conexion.save(r);
		tx.commit();
	}

	@Override
	public void eliminar(Reserva r) {
		Transaction tx = conexion.beginTransaction();
		conexion.delete(r);
		tx.commit();
	}

	@Override
	public List<Reserva> obtenerTodo() {
		return conexion.createQuery("SELECT r FROM Reserva r").getResultList();
	}
}
