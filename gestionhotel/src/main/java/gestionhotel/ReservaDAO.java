package gestionhotel;

import java.util.List;


public interface ReservaDAO{
    public Reserva obtenerPorCodigo(String codigoReserva);
    public void guardar(Reserva r);
    public void eliminar(Reserva r);
    public List<Reserva> obtenerTodo();
}
