package gestionhotel;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import gestionhotel2.Reserva;

import java.time.temporal.ChronoUnit;



public class Menu {

    

    private Hotel hotel;
    private Scanner sc = new Scanner(System.in);


    public void cargarHotel(){
        hotel=new Hotel();
        
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
        
        var habitacionesLibres =  hotel.consultarDisponibilidad(fechaEntrada,fechaSalida,numeroPersonas);

        
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
        int importe = numeroPersonas * precio * (int)Duration.between(fechaEntrada,fechaSalida).toDays();
        System.out.println("Coste del alojamiento: " + importe);
        System.out.println("¿Desea confirmar la reserva? (Y/N):");
        String respuestaReserva = sc.nextLine();

        
        if(respuestaReserva.equalsIgnoreCase("Y")){
            // 1. Comprobar que el cliente existe o no.
                // 1.1. Si no existe pedir la edad.
                // 1.2. Si es mayor de 18, resgistrarlo.
        	Cliente c = hotel.obtenerCliente(dni);
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
                
                hotel.addCliente(c);
            }
            
            String codReserva = cu02(numeroPersonas, tipo, c, importe, fechaEntrada, fechaSalida);
            System.out.println("Reserva realizada con exito");

            
            System.out.println("El codigo de reserva es: " + codReserva);
    
         
         

    }
    
        public String cu02(int numPersonas, String tipoHab, Cliente cliente, 
                int importe, LocalDate fechaEntrada, LocalDate fechaSalida){
    
    // Genera un número de reserva que no exista en la BBDD.
    
    String numReserva;
    do{
        numReserva = generarCodigoAleatorio(8) + "-" + 
                    generarCodigoAleatorio(4) + "-" + 
                    generarCodigoAleatorio(4) + "-" + 
                    generarCodigoAleatorio(4) + "-" +
                    generarCodigoAleatorio(12); 
    }while(hotel.obtenerReserva(numReserva) != null);

    // Genera la reserva
    Reserva r = new Reserva(numReserva, -1, numPersonas, tipoHab, cliente, 
                            importe, fechaEntrada, fechaSalida);
    // Guardar la reserva en la BBDD
    bs.realizarReserva(r);
    // Guardar la reserva en el PC
    hotel.addReserva(r);
}
        
        public void cu03(){
            System.out.println("Introduzca el código de reserva:");
            String codReserva = sc.nextLine();

            
            // Buscamos la reserva en la BBDD.
            Reserva r = hotel.obtenerReserva(codReserva);

            // Comprueba que la reseva exista. Si no existe muestra un mensaje de error
            if(r == null){
                System.out.println("La reserva no existe");

                // Para finalizar la función
                return;
            }
            // Comprueba que el día de entrada es hoy
            if(r.getFechaEntrada() != LocalDate.now()){
                System.out.println("La fecha de entrada no es hoy");

                // Para finalizar la función
                return;
            }

            // Comprobar las habitaciones que cumplan:
            //      1. Mismo tipo que esté especificado en la reserva.
            //      2. Que la cantidad de personas en la habitación sea al 
            //          menos el número de personas de la reserva.
            //      3. Que la habitación esté disponible.
            // Devolver la primera que cumpla estas condiciones.
            for(Habitacion hab : hotel.getConjuntoHabitaciones()){
                if(hab.getCategoria() == r.getTipoHabitacion() 
                    && hab.getNumeroCamas() >= r.getNumPersonas()
                    && hab.getEstado() == "disponible")
                {
                    r.setNumHabitacion(hab.getNumHabitacion());
                    break;
                }
            }

            if(r.getNumHabitacion() == -1){
                System.out.println("No hay habitaciones disponibles");
            }else{
                System.out.println("Estancia confirmada. Número de habitación: " + r.getNumHabitacion());
                // Actualizar la reserva en la BBDD y en el programa.
            }
        }
        
        public void cu04(){
            System.out.println("Introduzca el código de reserva:");
            String codReserva = sc.nextLine();

            
            // Buscamos la reserva en la BBDD.
            Reserva r = hotel.obtenerReserva(codReserva);

            // Comprueba que la reseva exista. Si no existe muestra un mensaje de error
            if(r == null){
                System.out.println("La reserva no existe");

                // Para finalizar la función
                return;
            }

            for(Habitacion hab : hotel.getConjuntoHabitaciones()){
                if(hab.getNumHabitacion() == r.getNumHabitacion()){
                    hab.setEstado("libre");
                }
            }

            System.out.println("Importe de la estancia: " + r.getImporte());
        }
        
        public void cu05(){
            System.out.println("Introduzca el código de reserva:");
            String codReserva = sc.nextLine();

            
            // Buscamos la reserva en la BBDD.
            Reserva r = hotel.obtenerReserva(codReserva);

            // Comprueba que la reseva exista. Si no existe muestra un mensaje de error
            if(r == null){
                System.out.println("La reserva no existe");

                // Para finalizar la función
                return;
            }

            // Eliminada la reserva de la BBDD.
            hotel.eliminarReserva(codReserva);

            // Eliminar la reserva del PC.

            System.out.println("Reserva cancelada");
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