package gestionhotel;

import org.junit.jupiter.api.Test;

public class PruebaHotelTest {
	@Test
	public void gettersSettersTest() {
		Habitacion h1 = new Habitacion();
		h1.setNumHabitacion(1);
		h1.setNumeroCamas("Doble");
		h1.setCategoria("Business");
		h1.setEstado("Libre");
		h1.setPrecio(110);
		Habitacion h2 = new Habitacion();
		h2.setNumHabitacion(2);
		h2.setNumeroCamas("Individual");
		h2.setCategoria("Normal");
		h2.setEstado("Ocupado");
		h2.setPrecio(35);
		Habitacion h3 = new Habitacion();
		h3.setNumHabitacion(3);
		h3.setNumeroCamas("Triple");
		h3.setCategoria("Superior");
		h3.setEstado("No disponible");
		h3.setPrecio(235);
		Hotel h = new Hotel();
		h.setNombre("Hotel del Sur");
		h.addHabitacion(h1);
		h.addHabitacion(h2);
		h.addHabitacion(h3);
		h.setCategoria("Premium");
	}
}
