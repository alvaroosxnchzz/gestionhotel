package gestionhotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaHabitacionTest {
	
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
	
	assertEquals(1, h1.getNumHabitacion());
	assertEquals("Doble", h1.getNumeroCamas());
	assertEquals("Business", h1.getCategoria());
	assertEquals(110, h1.getPrecio());
	assertEquals("Libre", h1.getEstado());

	
	assertEquals(2, h2.getNumHabitacion());
	assertEquals("Individual", h2.getNumeroCamas());
	assertEquals("Normal", h2.getCategoria());
	assertEquals(35, h2.getPrecio());
	assertEquals("Ocupado", h2.getEstado());

	
	assertEquals(3, h3.getNumHabitacion());
	assertEquals("Triple", h3.getNumeroCamas());
	assertEquals("Superior", h3.getCategoria());
	assertEquals(235, h3.getPrecio());
	assertEquals("No disponible", h3.getEstado());
	
	}

}
