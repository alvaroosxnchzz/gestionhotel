package gestionhotel;

import java.util.Scanner;


@Entity
@Table(name = "Cliente")
public class Cliente {
	
	public String nombre;
	
	public String apellido1;
	
	public String apellido2;
	
	public int edad = 0;
	
	@Id
	public String DNI;
	
	

	public Cliente(String nombre, String apellido1, String apellido2, int edad, String dNI) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Cliente() {
		super();
	}
	
	public static void registrarNuevoCliente(String dni){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce su nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce su primer appellido");
        String apellido1 = sc.nextLine();
        System.out.println("Introduce su segundo apellido");
        String apellido2 = sc.nextLine();

        //DESPUES HAY QUE INTRODUCIR ESOS DATOS EN LA BBDD
    }

    /*
    public static boolean comprobarCliente(String dni){
        //COMPROBAR SI EL DNI EXISTE O NO EN LA BASE DE DATOS

        return existe;
    }
    *
     */
	
	
}
