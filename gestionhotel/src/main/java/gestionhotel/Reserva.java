package gestionhotel;

import java.time.LocalDate;

public class Reserva {
	
	private String codigoReserva;
	
	private String cliente;
	
	private double importe;
	
	private int numHabitacion;
	
	private LocalDate fechaEntrada;
	
	private LocalDate fechaSalida;
	
	private int numPersonas;
    private String tipoHabitacion;

	

	    public Reserva(String codigoReserva, int numHabitacion, int numPersonas, String tipoHabitacion,double importe, LocalDate fechaEntrada, LocalDate fechaSalida)
	{
	    	this.numHabitacion = numHabitacion;
	    	this.numPersonas = numPersonas;
	    	this.codigoReserva = codigoReserva;
	    	this.tipoHabitacion = tipoHabitacion;
	    	this.importe = importe;
	    	this.fechaEntrada = fechaEntrada;
	    	this.fechaSalida = fechaSalida;
	}

	public Reserva() {
		super();
		// TODO Esbozo de constructor generado automáticamente
	}

	public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
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

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
	
	public int getNumPersonas(){
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getTipoHabitacion(){
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
	
	

	
	
	
	
}