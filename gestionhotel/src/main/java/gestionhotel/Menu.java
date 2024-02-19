package gestionhotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import gestionhotel2.BookingService;
import gestionhotel2.Hotel;

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
	                    cu04();
	                    break;
	                    
	                case 4:
	                	cu05();
	                	break;

	                default:



	            }


	        }while(opcion != 5);
	    }

    public static void cu01(){
        

    }
    
    public static void cu02() {
    	
    }
    
   }