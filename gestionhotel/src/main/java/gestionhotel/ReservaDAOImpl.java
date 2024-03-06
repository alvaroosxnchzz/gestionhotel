package gestionhotel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReservaDAOImpl implements ReservaDAO {
	
	private Session conexion;
	
	public ReservaDAOImpl() {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        conexion = factory.openSession();
	}

	
	public Reserva obtenerPorCodigo(String codigoReserva) {
		return conexion.get(Reserva.class, codigoReserva);
	}

	
	public void guardar(Reserva r) {
		Transaction tx = conexion.beginTransaction();
		conexion.save(r);
		tx.commit();
	}

	
	public void eliminar(Reserva r) {
		Transaction tx = conexion.beginTransaction();
		conexion.delete(r);
		tx.commit();
	}

	
	public List<Reserva> obtenerTodo() {
		return conexion.createQuery("SELECT r FROM Reserva r").getResultList();
	}
}
