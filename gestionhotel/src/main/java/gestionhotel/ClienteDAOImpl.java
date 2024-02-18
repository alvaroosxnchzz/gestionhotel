package gestionhotel;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteDAOImpl implements ClienteDAO {
	
	private Session conexion;
	
	public ClienteDAOImpl() {

		SessionFactory session = new Configuration()
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Habitacion.class)
                .addAnnotatedClass(Reserva.class)
                .configure().buildSessionFactory();
		
		conexion = session.openSession();
	}

	@Override
	public Cliente obtenerPorDNI(String DNI) {
		return conexion.get(Cliente.class, DNI);
	}

	@Override
	public void guardar(Cliente c) {
		Transaction tx = conexion.beginTransaction();
		conexion.save(c);
		tx.commit();
	}

	@Override
	public void eliminar(Cliente c) {
		Transaction tx = conexion.beginTransaction();
		conexion.delete(c);
		tx.commit();
	}

	@Override
	public List<Cliente> obtenerTodo() {
		return conexion.createQuery("SELECT c FROM Cliente c").getResultList();
	}

}

