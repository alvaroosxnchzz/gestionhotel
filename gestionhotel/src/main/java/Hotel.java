

public class Hotel {
	
	public String peticion;
	
	public String factura;
	
	public int Habitaciones;
	
	public String cliente;

	public String getPeticion() {
		return peticion;
	}

	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public int getHabitaciones() {
		return Habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		Habitaciones = habitaciones;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Hotel(String peticion, String factura, int habitaciones, String cliente) {
		super();
		this.peticion = peticion;
		this.factura = factura;
		Habitaciones = habitaciones;
		this.cliente = cliente;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
