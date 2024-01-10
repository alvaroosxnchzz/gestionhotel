public class Reservas {
	
	public String Cliente;
	
	public String fechas;
	
	public int Importe;
	
	public String estado = "Libre, Ocupado, No disponible";

	public Reservas(String cliente, String fechas, int importe, String estado) {
		super();
		Cliente = cliente;
		this.fechas = fechas;
		Importe = importe;
		this.estado = estado;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public String getFechas() {
		return fechas;
	}

	public void setFechas(String fechas) {
		this.fechas = fechas;
	}

	public int getImporte() {
		return Importe;
	}

	public void setImporte(int importe) {
		Importe = importe;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Reservas() {
		super();
	}
	
}
