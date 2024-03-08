package gestionhotel;

import javax.persistence.*;

@Entity
@Table(name = "Habitacion")
public class Habitacion {
	
	@Column(length=50)
	@Id
    private int id;
	public int numeroCamas;
	// Categoria == Tipo
	public String categoria;
	public double precio;
	public String estado;
	
	public Habitacion(int numHabitacion, int numeroCamas, String categoria, double precio, String estado) {
		this.id = numHabitacion;
		this.numeroCamas = numeroCamas;
		this.categoria = categoria;
		this.precio = precio;
		this.estado = estado;
	}

	public int getNumHabitacion() {
		return id;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.id = numHabitacion;
	}

	public Habitacion() {
		super();
		// TODO Esbozo de constructor generado automáticamente
	}

	public int getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
