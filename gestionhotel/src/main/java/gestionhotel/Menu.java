package gestionhotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class Menu {

    

    private Hotel hotel;
    private BookingService bs;
    private Scanner sc = new Scanner(System.in);


    public void cargarHotel(){
        hotel=new Hotel();
        bs = new BookingService(hotel);
    }

    public void deslpegarMenu(){

        int opcion;

        System.out.println("### Menu Hotel ###");

        do{

            System.out.println("--------------------------");
            System.out.println("1.Consultar disponibilidad y reserva de habitaciones");
            System.out.println("2.Check-in");
            System.out.println("3.Check-out");
            System.out.println("4.Cancelar reserva");
            System.out.println("5.Salir");
            System.out.println("---------------------------");

            System.out.println("Introduzca una opción");
            opcion = sc.nextInt();

            switch(opcion){

                case 1:
                    cu01();
                    break;

                case 2:
                    cu03();
                    break;

                case 3:
                    cu05();
                    break;

                default:



            }


        }while(opcion != 5);
    }

    public void cu01(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("### Consultar disponibilidad y reserva de habitaciones ###");
        

        System.out.println("Introduce una fecha de entrada (formato dd/MM/yyyy)");
        LocalDate fechaEntrada = LocalDate.parse(sc.nextLine(), formatter);
        System.out.println("Introduce una fecha de salida (formato dd/MM/yyyy)");
        LocalDate fechaSalida = LocalDate.parse(sc.nextLine(), formatter);
        System.out.println("Introduce el numero de personas (max. 3)");
        int numeroPersonas = sc.nextInt();
        do{
            if(numeroPersonas>3) {
                System.out.println("El  numero máximo de personas son 3");
                System.out.println("Introduce el numero de personas (max. 3)");
                numeroPersonas = sc.nextInt();
            }
        }while(numeroPersonas>3);
        
        var habitacionesLibres =  bs.consultarDisponibilidad(fechaEntrada,fechaSalida,numeroPersonas);

        
        System.out.println("Resultado de la consulta");
        System.out.println("---------------------------");

        
        for(String clave : habitacionesLibres.keySet()){
            if(habitacionesLibres.get(clave).get("cantidad")>0){
            System.out.println(habitacionesLibres.get(clave).get("cantidad") + " habitaciones " +
                                clave + "(" + habitacionesLibres.get(clave).get("precio") +
                                " euros).");
        }
        }
    
        System.out.println("--------------------------------------");

        
        System.out.println("Opciones de reserva");
        System.out.println("1) Reservar habitación NORMAL");
        System.out.println("2) Reservar habitación BUSINESS");
        System.out.println("3) Reservar habitación SUPERIOR");
        System.out.println("--------------------------------------");
        System.out.println("Introduzca una opción");
        int respuesta = sc.nextInt();
        boolean repetir = true;
        int precio = 0;
        do{
            switch(respuesta){
                case 1: 
                    if(habitacionesLibres.get("normal").get("cantidad") == 0){
                        System.out.println("No hay habitaciones de este tipo");
                        System.out.println("Introduzca opcion:");
                        respuesta = sc.nextInt();
                    }
                    else{
                        precio = habitacionesLibres.get("normal").get("precio");
                        tipo = "normal";
                        repetir = false;
                    }
                    break;
                case 2:
                    if(habitacionesLibres.get("business").get("cantidad") == 0){
                        System.out.println("No hay habitaciones de este tipo");
                        System.out.println("Introduzca opcion:");
                        respuesta = sc.nextInt();
                    }
                    else{
                        precio = habitacionesLibres.get("business").get("precio");
                        tipo = "business";
                        repetir = false;
                    }
                    break;
                case 3:
                    if(habitacionesLibres.get("superior").get("cantidad") == 0){
                        System.out.println("No hay habitaciones de este tipo");
                        System.out.println("Introduzca opcion:");
                        respuesta = sc.nextInt();
                    }
                    else{
                        precio = habitacionesLibres.get("superior").get("precio");
                        tipo = "superior";
                        repetir = false;
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    System.out.println("Introduzca opcion:");
                    respuesta = sc.nextInt();
            }
        }while(repetir);
        System.out.println("Introduzca el DNI");
        String dni = sc.nextLine();
        System.out.println("Introduzca el Nombre");
        String nom = sc.nextLine();
        System.out.println("Introduzca el Apellido 1");
        String ap1 = sc.nextLine();
        System.out.println("Introduzca el Apellido 2");
        String ap2 = sc.nextLine();

        
        // Número de días que se aloja * Número de personas * Precio de la habitación
        int importe = numeroPersonas * precio * DAYS.between(fechaEntrada,fechaSalida);
        System.out.println("Coste del alojamiento: " + importe);
        System.out.println("¿Desea confirmar la reserva? (Y/N):");
        String respuestaReserva = sc.nextLine();

        
        if(respuestaReserva.equalsIgnoreCase("Y")){
            // 1. Comprobar que el cliente existe o no.
                // 1.1. Si no existe pedir la edad.
                // 1.2. Si es mayor de 18, resgistrarlo.
            ClienteDAOImpl cdao = new ClienteDAOImpl();

            // Si devuelve null, no existe.
            var c = cdao.obtenerPorDNI(dni);
            if(c == null){
                System.out.println("Introduzca la edad");
                int edad = sc.nextInt();

                do {
                    if (edad < 18) {
                        System.out.println("No puede ser menor de edad");
                        System.out.println("Introduzca la edad");
                        edad = sc.nextInt();
                    }
                } while (edad < 18);
                
                
                c = new Cliente(nom, ap1, ap2, edad, dni);
                cdao.guardar(c);
                hotel.addCliente(c);
            }
            
            String codReserva = cu02(numeroPersonas, tipo, c, importe, fechaEntrada, fechaSalida);
            System.out.println("Reserva realizada con exito");

            
            System.out.println("El codigo de reserva es: " + codReserva);
    
         
         

    }
    
        public String cu02(int numPersonas, String tipoHab, Cliente cliente, 
                int importe, LocalDate fechaEntrada, LocalDate fechaSalida){
    
    // Genera un número de reserva que no exista en la BBDD.
    ReservaDAOImpl rdao = new ReservaDAOImpl();
    String numReserva;
    do{
        numReserva = generarCodigoAleatorio(8) + "-" + 
                    generarCodigoAleatorio(4) + "-" + 
                    generarCodigoAleatorio(4) + "-" + 
                    generarCodigoAleatorio(4) + "-" +
                    generarCodigoAleatorio(12); 
    }while(rdao.obtenerPorCodigo(numReserva) != null);

    // Genera la reserva
    Reserva r = new Reserva(numReserva, -1, numPersonas, tipoHab, cliente, 
                            importe, fechaEntrada, fechaSalida);
    // Guardar la reserva en la BBDD
    bs.realizarReserva(r);
    // Guardar la reserva en el PC
    hotel.addReserva(r);
}
        
    
    private String generarCodigoAleatorio(int longitud){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                     + "abcdefghijklmnopqrstuvwxyz"
                     + "0123456789";
        String str = new Random().ints(longitud, 0, chars.length())
                                 .mapToObj(i -> "" + chars.charAt(i))
                                 .collect(Collectors.joining());

        return str;
    }

    
   }