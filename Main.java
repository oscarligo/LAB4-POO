import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ClimatizacionClaseB sistemaClimatizacion = new ClimatizacionClaseB();
        Scanner scanner = new Scanner(System.in);

        String opcion = "";
        
        while (!opcion.equals("8")) {

            // Menú de opciones
            System.out.println("\n\n================== Sistema de Climatización ====================\n");
            System.out.println("1. Encender sistema");
            System.out.println("2. Apagar sistema");
            System.out.println("3. Opciones de Temperatura");
            System.out.println("4. Opciones de Ventilación");
            System.out.println("5. Opciones de calefacción");
            System.out.println("6. Opciones de Aire");
            System.out.println("7. Opciones de mantenimiento");

            System.out.print("\nIngrese el número de la opción deseada: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    sistemaClimatizacion.encender();
                    System.out.println("\nSistema encendido\n");
                    break;

                case "2":
                    sistemaClimatizacion.apagar();
                    System.out.println("\nSistema apagado\n");
                    break;

                case "3":
                    if (sistemaClimatizacion.getSistemaEncendido() == true) {
                        System.out.println("\nOpciones de Temperatura\n");
                        System.out.println("1. Ajustar temperatura");
                        System.out.println("2. Activar modo automático");
                        System.out.print("\nIngrese el número de la opción deseada: ");
                        String opcionTemperatura = scanner.nextLine();

                        switch (opcionTemperatura) {
                            case "1":
                                System.out.print("Ingrese la temperatura deseada: ");
                                int temperatura = Integer.parseInt(scanner.nextLine());
                                sistemaClimatizacion.ajustarTemperatura(temperatura);
                            
                                break;
                            case "2":
                                sistemaClimatizacion.activarModoAutomatico();
                                System.out.println("Modo automático activado");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }

                    else {
                        System.out.println("\nEl sistema está apagado, encienda el sistema para usar esta opción\n");
                    }

                break;
                    

                case "4":
                    if (sistemaClimatizacion.getSistemaEncendido() == true) {
                        System.out.println("\nOpciones de Ventilación\n");
                        System.out.println("1. Ajustar nivel de ventilación");
                        System.out.println("2. Ajustar dirección de ventilación");
                        System.out.println("3. Activar modo Eco");
                        System.out.println("4. Desactivar modo Eco");
                        System.out.print("\nIngrese el número de la opción deseada: ");
                        String opcionVentilacion = scanner.nextLine();

                        switch (opcionVentilacion) {
                            case "1":
                                System.out.print("\nIngrese el nivel de ventilación deseado: ");
                                int nivel = Integer.parseInt(scanner.nextLine());
                                sistemaClimatizacion.ajustarNivelVentilacion(nivel);
                                break;
                            case "2":
                                System.out.print("\nIngrese la dirección de ventilación deseada: ");
                                String direccion = scanner.nextLine();
                                sistemaClimatizacion.ajustarDireccionVentilacion(direccion);
                                break;
                            case "3":
                                sistemaClimatizacion.activarModoEco();
                                System.out.println("\nModo Eco activado\n");
                                break;
                            case "4":
                                sistemaClimatizacion.desactivarModoEco();
                                System.out.println("\nModo Eco desactivado\n");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }

                    else {
                        System.out.println("\nEl sistema está apagado, encienda el sistema para usar esta opción\n");
                    }

                    break;


                case "5":
                    if (sistemaClimatizacion.getSistemaEncendido() == true) {
                        System.out.println("\nOpciones de calefacción\n");
                        System.out.println("1. Ajustar calefacción de asientos");
                        System.out.println("2. Activar calefacción rápida");
                        System.out.print("\nIngrese el número de la opción deseada: ");
                        String opcionCalefaccion = scanner.nextLine();

                        switch (opcionCalefaccion) {
                            case "1":
                                System.out.print("\nIngrese el nivel de calefacción de asientos deseado: ");
                                int nivel = Integer.parseInt(scanner.nextLine());
                                sistemaClimatizacion.ajustarCalefaccionAsientos(nivel);
                                break;
                            case "2":
                                sistemaClimatizacion.activarCalefaccionRapida();
                                System.out.println("\nCalefacción rápida activada\n");
                                break;
                            default:
                                System.out.println("\nOpción no válida\n");
                                break;
                        }
                    }

                    else {
                        System.out.println("\nEl sistema está apagado, encienda el sistema para usar esta opción\n");

                    }

                    break;


                case "6":
                    if (sistemaClimatizacion.getSistemaEncendido() == true) {
                        System.out.println("\nOpciones de Aire\n");
                        System.out.println("1. Encender desempañador");
                        System.out.println("2. Apagar desempañador");
                        System.out.println("3. Ajustar distribución del aire");
                        System.out.print("\nIngrese el número de la opción deseada: ");
                        String opcionAire = scanner.nextLine();

                        switch (opcionAire) {
                            case "1":
                                sistemaClimatizacion.encenderDesempaniador();
                                System.out.println("\nDesempañador encendido\n");
                                break;
                            case "2":
                                sistemaClimatizacion.apagarDesempaniador();
                                System.out.println("\nDesempañador apagado\n");
                                break;

                            //PENDIENTE
                            case "3":
                                System.out.print("\nIngrese la distribución del aire deseada: ");
                                String distribucion = scanner.nextLine();
                                
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }

                    else {
                        System.out.println("\nEl sistema está apagado, encienda el sistema para usar esta opción\n");
                    }

                    break;

                
                case "7":
            
                    System.out.println("\nOpciones de mantenimiento\n");

                    System.out.println("1. Programar mantenimiento");
                    System.out.println("2. Ver mantenimientos programados");
                    System.out.println("3. Avisos de mantenimiento");

                    System.out.print("\nIngrese el número de la opción deseada: ");
                    String opcionMant = scanner.nextLine();


                    switch (opcionMant) {
                        
                        case "1":

                            System.out.print("\nIngrese la fecha de mantenimiento: ");
                            String fecha = scanner.nextLine();

                            sistemaClimatizacion.programarMantenimiento(fecha);

                            break;
                        case "2":

                            for (String mantenimiento : sistemaClimatizacion.getHistorialMantenimiento()) {
                                System.out.println( "Hay un mantenimiento programado para: " + mantenimiento);
                            }
                            

                            break;
                        case "3":

                            Date fechaActual = new Date();
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            String fechaActualString = formato.format(fechaActual);

                            System.out.println(sistemaClimatizacion.avisoDeMantenimiento(fechaActualString));

                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }

                    break;

                case "8":
                    
                    break;

                default:
                    System.out.println("Opción no válida");

                    break;
            
            }
        }
    }    
}