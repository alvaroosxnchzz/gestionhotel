package gestionhotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Hotel hotel;

    public static void cargarHotel(String nombreHotel){


        hotel=new Hotel(nombreHotel);
    }

    public static void cu01(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una fecha de entrada");
        LocalDate fechaEntrada = LocalDate.parse(sc.nextLine());
        System.out.println("Introduce una fecha de salida");
        LocalDate fechaSalida = LocalDate.parse(sc.nextLine());
        System.out.println("Introduce el numero de personas");
        int numeroPersonas = sc.nextInt();
        
        BookingService bs = new BookingService(hotel);
        ArrayList<Boolean> habitacionesLibres =  bs.consultarDisponibilidad(fechaEntrada,fechaSalida,numeroPersonas);
        
        for (Habitacion h : hotel.getConjuntoHabitaciones()) {
            if (habitacionesLibres.get(h.getNumHabitacion() - 1)) {
                System.out.println(h.getNumHabitacion());
                System.out.println(h.getPrecio());
            }
        }
    }
    
    public static void cu02(ArrayList<Boolean> habitacionesLibres, LocalDate fechaEntrada, LocalDate fechaSalida, int numeroHabitacion){}
    
   }
