package gestionhotel;

public class Reservas {
	
	private int codigoReserva;
	
	private String cliente;
	
	private double importe;
	
	private String fecha;

	public Reservas(int codigoReserva, String cliente, double importe, String fecha) {
		super();
		this.codigoReserva = codigoReserva;
		this.cliente = cliente;
		this.importe = importe;
		this.fecha = fecha;
	}

	public Reservas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
