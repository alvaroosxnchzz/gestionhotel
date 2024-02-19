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
         
         

    }
    
    public static void cu02() {
    	
    }
    
   }