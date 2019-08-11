package com.galeas;

import com.galeas.excepciones.ErrorValidacion;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Turistas> turista = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************");
        System.out.println("** Bienvenido **");
        System.out.println("*******************");
        boolean continuar = true;

        while (continuar == true) {
            System.out.println("1. Ingrese los datos del turista");
            System.out.println("2. Mostrar datos turistas");
            System.out.println("3. Salir");
            int opcion = LectorDatos.solicitarEntero("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    int conta = 0;
                    System.out.println("*** Ingresando un turista ***");
                    Turistas nturista = new Turistas();
                    boolean i = true;
                    while (i == true) {
                        System.out.println("Nombre del turista:");
                        String nombreTurista = scanner.nextLine();
                        System.out.println("Numero telefonico:");
                        String telefonoTurista = scanner.nextLine();
                        try {
                            nturista.setNombre(nombreTurista);
                            nturista.setTelefono(telefonoTurista);
                            i = false;
                        } catch (ErrorValidacion e) {
                            System.err.println(e.getMessage());
                            i = true;
                        }
                        for (Turistas c : turista) {
                            if (telefonoTurista.equals(c.telefono)) {
                                c.setContador(1);
                                conta = 1;
                                break;
                            }
                        }
                    }
                    if (conta == 0) {
                        nturista.setContador(0);
                        turista.add(nturista);
                    }
                    break;

                case 2:
                    if (turista.isEmpty()) {
                        System.out.println("*** Ningun turista ingresado aun ***");
                    } else
                    {
                        System.out.println("*** Mostrando ***");
                    }
                    for (Turistas t : turista){
                        System.out.println("Nombre: "+t.getNombre() + " Telefono: " + t.getTelefono() + " - Numero de visitas: " + t.getContador());
                    }
                    break;

                case 3:
                    continuar = false;
                    System.out.println("Gracias por su preferencia");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
