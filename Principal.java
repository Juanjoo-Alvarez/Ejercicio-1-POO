/*
 * 
 * @autor Juan Jose Rivas Alvarez
 * @date 2024-07-2024
 * 
 */

import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Localidad balcon2 = new Localidad("Balcón 2", 100, 300);
        Localidad platea = new Localidad("Platea", 100, 600);
        Localidad balcon1 = new Localidad("Balcón 1", 100, 1800);

        Localidad[] localidades = { balcon2, platea, balcon1 };

        Date fechaVenta = new Date();
        Evento evento = new Evento("Concierto", 300, localidades, fechaVenta);

        SistemaVenta sistema = new SistemaVenta(evento);
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("Sistema de Venta de Boletos");
            System.out.println("1. Comprar Boletos");
            System.out.println("2. Consultar Disponibilidad Total");
            System.out.println("3. Consultar Disponibilidad Individual");
            System.out.println("4. Generar Reporte de Caja");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese su email: ");
                    String email = scanner.nextLine();
                    System.out.print("Cantidad de boletos a comprar: ");
                    int cantidadBoletos = scanner.nextInt();
                    System.out.print("Presupuesto máximo: ");
                    int presupuesto = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nombre de la localidad (Balcón 2, Platea, Balcón 1): ");
                    String nombreLocalidad = scanner.nextLine();

                    Comprador comprador = new Comprador(nombre, email, cantidadBoletos, presupuesto);
                    sistema.agregarComprador(comprador, nombreLocalidad);
                    break;
                case 2:
                    Localidad[] locs = evento.getLocalidades();
                    for (Localidad loc : locs) {
                        System.out.println("Localidad: " + loc.getNombre() + ", Boletos Disponibles: " + loc.getBoletosDisponibles());
                    }
                    break;
                case 3:
                    System.out.print("Nombre de la localidad: ");
                    String locNombre = scanner.nextLine();
                    Localidad loc = sistema.buscarLocalidad(locNombre);
                    if (loc != null) {
                        System.out.println("Localidad: " + loc.getNombre() + ", Boletos Disponibles: " + loc.getBoletosDisponibles());
                    } else {
                        System.out.println("Localidad no encontrada.");
                    }
                    break;
                case 4:
                    sistema.generarReporteDeCaja();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
    
}
