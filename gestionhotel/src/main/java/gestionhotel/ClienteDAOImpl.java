package gestionhotel;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteDAOImpl implements ClienteDAO {
	
	private Session conexion;
	
	public ClienteDAOImpl() {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        conexion = factory.openSession();
	}

	
	public Cliente obtenerPorDNI(String DNI) {
		return conexion.get(Cliente.class, DNI);
	}

	
	public void guardar(Cliente c) {
		Transaction tx = conexion.beginTransaction();
		conexion.save(c);
		tx.commit();
	}

	
	public void eliminar(Cliente c) {
		Transaction tx = conexion.beginTransaction();
		conexion.delete(c);
		tx.commit();
	}

	
	public List<Cliente> obtenerTodo() {
		return conexion.createQuery("SELECT c FROM Cliente c").getResultList();
	}

}

