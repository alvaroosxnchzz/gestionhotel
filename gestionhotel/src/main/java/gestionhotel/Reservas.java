package gestionhotel;

import java.time.LocalDate;

public class Reservas {
	
	private int codigoReserva;
	
	private String cliente;
	
	private double importe;
	
	private LocalDate fechaEntrada;
	
	private LocalDate fechaSalida;

	public Reservas(int codigoReserva, String cliente, double importe, LocalDate fechaEntrada, LocalDate fechaSalida) {
		super();
		this.codigoReserva = codigoReserva;
		this.cliente = cliente;
		this.importe = importe;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public Reservas() {
		super();
		// TODO Esbozo de constructor generado automáticamente
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

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	

	
	
	
	
}
