package gestionhotel;

import java.time.LocalDate;
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
                    cu02();
                    break;

                case 3:
                    cu03();
                    break;

                case 4:
                    cu04();
                    break;

                default:



            }


        }while(opcion != 5);
    }

    public static void cu01(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una fecha de entrada");
        LocalDate fechaEntrada = LocalDate.parse(sc.nextLine());
        System.out.println("Introduce una fecha de salida");
        LocalDate fechaSalida = LocalDate.parse(sc.nextLine());
        System.out.println("Introduce el numero de personas");
        int numeroPersonas = sc.nextInt();
        
        //DEBE DEVOLVER LAS HABITACIONES DISPONIBLES DE CADA TIPO Y AHI ELIGO UNA DE ESAS
        //CUANDO ELJO UN TIPO DE HABITACION SE RESTA UNA DE ESE TIPO SI ESTA DENTRO DE LA FECHA
        //LA CLASE REEERVA DEBE INDICAR EL NUM DE CAMAS Y LA CATEOGIRA
        //DESPUES INTRODUZCO LOS DATOS DEL CLIENT Y CONFRMO LA RESERVA Y ME DEVUELVE EL CODIGO DE LA RESERVA
        //EL NUMERO DE HABITACION TE LO DA DESPUES EN EL CHECKIN, QUE INTRODUCES EL NUMERO DE RESERVA.
        BookingService bs = new BookingService(hotel);
        ArrayList<Boolean> habitacionesLibres =  bs.consultarDisponibilidad(fechaEntrada,fechaSalida,numeroPersonas);
        
        for (Habitacion h : hotel.getConjuntoHabitaciones()) {
            if (habitacionesLibres.get(h.getNumHabitacion() - 1)) {
                System.out.println(h.getNumHabitacion());
                System.out.println(h.getPrecio());
            }
        }
        
        System.out.println("¿Deseas reservar la habitación? S/N");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("¿Qué habitación desea reservar?");
            int numeroHabitacion = sc.nextInt();
            sc.nextLine();

            if (habitacionesLibres.get(numeroHabitacion - 1)) {
                cu02(habitacionesLibres, fechaEntrada, fechaSalida, numeroHabitacion);
            } else {
                System.out.println("Esta habitación no está disponible");
            }
        }

    }
    
    public static void cu02(ArrayList<Boolean> habitacionesLibres, LocalDate fechaEntrada, LocalDate fechaSalida, int numeroHabitacion){
    	Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el DNI");
        String dni = sc.nextLine();
        
        boolean clienteNoExiste = !Clientes.comprobarCliente(dni);



        if(clienteNoExiste){
            Clientes.registrarNuevoCliente(dni);
        }
        
        System.out.println("El coste del alojamiento es:" + "150€");
        System.out.println("¿Deseas reservar la habitación? S/N");
        String respuesta = sc.nextLine();
        if(respuesta.equalsIgnoreCase("S")){
            Reserva r = new Reserva(-1,dni, 150, numeroHabitacion, fechaEntrada, fechaSalida);
            Hotel.addReserva(r);
            System.out.println(r.getCodigoReserva());
        }

    }
    
   }