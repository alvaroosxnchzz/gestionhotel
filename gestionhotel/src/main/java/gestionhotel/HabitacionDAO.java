package gestionhotel;

import java.util.HashMap;
import java.util.List;


public interface HabitacionDAO{

    public Habitacion obtenerId(int id);
	public void guardar(Habitacion h);
	public void eliminar(Habitacion h);
	public List<Habitacion> obtenerTodo();

}
