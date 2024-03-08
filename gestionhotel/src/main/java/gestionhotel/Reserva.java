package gestionhotel;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {
	
	@Column(length=50)
	@Id
	private String codigoReserva;
	private double importe;
	private int numHabitacion;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private int numPersonas;
    private String tipoHabitacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dniCliente")
	private Cliente cliente;
	
    public Reserva(String codigoReserva, int numHabitacion, int numPersonas, String tipoHabitacion, 
            Cliente cliente, double importe, LocalDate fechaEntrada, LocalDate fechaSalida)
    {
		this.codigoReserva = codigoReserva;
		this.numHabitacion = numHabitacion;
		this.numPersonas = numPersonas;
		this.tipoHabitacion = tipoHabitacion;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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
