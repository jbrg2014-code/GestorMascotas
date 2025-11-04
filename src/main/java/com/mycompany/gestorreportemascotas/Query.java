/*

Descripción:

En esta clase primeramente se solicita seleecionar un criterio de búsqueda que
contiene únicamente tres opciones a elegir. En caso de que el usuario digite una
opción diferente a las determinadas, se deberá mostrar en pantalla un mensaje de 
error. Se deberá mostrar en pantalla un reporte en caso de que el criterio de 
búsqueda seleecionado y su respectivo formato sea el correcto.

-Try Catch con el fin de no permitir el ingreso de carácteres dentro de la selección
del criterio de búsqueda.

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorreportemascotas;

import java.util.InputMismatchException; // Librería para utilizar de manera exitosa el try catch.
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jimena
 */
public class Query {

    public static void listOfQueries(List<Pet> pets) {
        Scanner sc = new Scanner(System.in);
        boolean Criteries = false;
        int Selection = 0;

        do {

            System.out.println("\n"); // Salto de línea.
            System.out.println(" -------------------------------------------------------------------------- ");
            System.out.println("                       CONSULTA DE REPORTES POR CRITERIOS                   ");
            System.out.println(" -------------------------------------------------------------------------- ");
            System.out.println("Seleccione criterio de búsqueda:");
            System.out.println(" 1. ID del reportante ");
            System.out.println(" 2. Especie ");
            System.out.println(" 3. Zona ");
            System.out.print(" Seleccione un criterio de búsqueda:");

            try {
                Selection = sc.nextInt();
                sc.nextLine();
                if (Selection < 1 || Selection > 3) {
                    System.out.println("Número seleccionado fuera del rango. Por favor, vuelva a intentarlo.");
                    Criteries = false;
                } else {
                    System.out.println(" Criterio de búsqueda válido.");
                    Criteries = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("No debe ingresar carácteres.");
                sc.nextLine();
                Criteries = false;
            }

        } while (!Criteries);

        String Word = "";

        switch (Selection) {
            case 1 -> {
                System.out.println("\n");
                System.out.print("Digite el ID del reportante:");
                Word = sc.nextLine().trim();
            }
            case 2 -> {
                System.out.println("\n");
                System.out.print("Digie la especie (DOG/CAT:");
                Word = sc.nextLine().trim().toUpperCase();
            }
            case 3 -> {
                System.out.println("\n");
                System.out.print("Digite la zona:");
                Word = sc.nextLine().trim();
            }
            default -> {
                System.out.println("\n");
                System.out.println("Opción inválida.");
                return;
            }
        }

        boolean found = false;
        for (Pet p : pets) {
            boolean Match = false;

            if (Selection == 1 && p.getIdentificationReporter().equals(Word)) {
                Match = true;
            } else if (Selection == 2 && p.getSpecies().toUpperCase().equals(Word)) {
                Match = true;
            } else if (Selection == 3 && p.getZone().equals(Word)) {
                Match = true;
            }

            if (Match) {
                if (!found) {

                    System.out.println("\n");
                    System.out.println(" Resultados encontrados:");
                    System.out.printf("  %-11s   |  %-15s  |  %-6s  | %-6s | %-4s%n  ", // %s define el ancho por cada campo.
                            "ID Reportante", "Nombre Completo", "Fecha", "Zona", "Tipo");
                    System.out.println(" ------------------------------------------------------------ ");
                }

                found = true;
                System.out.printf(" %-11s | %-18s | %-10s | %-10s | %-3s%n",
                        p.getIdentificationReporter(), p.getFullName(), p.getReportDate(),
                        p.getZone(), p.getTypeReport());
            }
        }

        if (!found) {

            switch (Selection) {
                case 1 ->
                    System.out.print("Cédula no encontrada.");
                case 2 ->
                    System.out.print("Especie no encontrada.");
                case 3 ->
                    System.out.print("Zona no encontrada.");
                default -> {
                }
            }
        }
    }

}
