package gestionhotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaClienteTest {
	
	public void getterSettersTest() {
		
		Clientes c = new Clientes();
		c.setNombre("Alvaro");
		c.setApellido1("Sanchez");
		c.setApellido2("Ortega");
		c.setEdad(20);
		c.setDNI("48761426L");
		
		assertEquals(c.getNombre(), "Alvaro");
		assertEquals(c.getApellido1(), "Sanchez");
		assertEquals(c.getApellido2(), "Ortega");
		assertEquals(c.getEdad(), "20");
		assertEquals(c.getDNI(), "48761426L");
		
		
	}

}
