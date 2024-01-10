
public class Habitacion {
	
	public int numeroCamas;
	public String categoria;
	public String tipo;
	public double precio;
	public String estado;
	
	public Habitacion(int numeroCamas, String categoria, String tipo, double precio, String estado) {
		this.numeroCamas = numeroCamas;
		this.categoria = categoria;
		this.tipo = tipo;
		this.precio = precio;
		this.estado = estado;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
