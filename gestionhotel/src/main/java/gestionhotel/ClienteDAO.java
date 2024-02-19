package gestionhotel;

import java.util.List;

public interface ClienteDAO{
    public Cliente obtenerPorDNI(String DNI);
	public void guardar(Cliente c);
	public void eliminar(Cliente c);
	public List<Cliente> obtenerTodo();
}
