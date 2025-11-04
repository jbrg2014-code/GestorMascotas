/*

Descripción:

En esta clase, el usuario tendrá la oportunidad de modificar algún dato o bien,
reingesar todos los datos, pero primero, deberá ingresar el ID del reporte. En 
caso de que el ID no haya sido previamente ingresado, no podrá continuar con el
proceso. En caso contrario, el usaurio tendrá dos opciones actualizar ya sea un 
uno o todos los datos.

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorreportemascotas;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jimena
 */
public class UpdateReport {

    public static void Update(List<Pet> pets) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("----------------------------------------");
        System.out.println("    ACTUALIZAR ESTADO DE UN REPORTE     ");
        System.out.println("----------------------------------------");
        System.out.print("Ingrese el ID del reporte (No editable):");
        String IdReport = sc.nextLine().trim();

        Pet found = null;
        for (Pet p : pets) {
            if (p.getIdentificationReport().equalsIgnoreCase(IdReport)) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println("El ID de reporte no existe.");
            return;
        }

        if (found != null) {

            System.out.println("\n");
            System.out.println("Reporte encontrado:");
            System.out.println("ID Reporte:" + found.getIdentificationReport());
            System.out.println("ID Reportante:" + found.getIdentificationReporter());
            System.out.println("Nombre:" + found.getFullName());
            System.out.println("Tipo:" + found.getTypeReport());
            System.out.println("Fecha:" + found.getReportDate());
            System.out.println("Zona:" + found.getZone());
            System.out.println("Especie:" + found.getSpecies());
            System.out.println("Color:" + found.getColor());
            System.out.println("Señas:" + found.getParticularSigns());
            System.out.println("Teléfono:" + found.getTelephoneNumber());
            System.out.println("Microchip:" + found.getMicrochip());
        }

        System.out.println("\n");
        System.out.println("Seleccione nueva opción:");
        System.out.println("1. Editar un solo dato");
        System.out.println("2. Reingresar todos los datos");
        System.out.print("Ingrese una opción:");
        int Op = sc.nextInt();
        sc.nextLine();

        switch (Op) {
            case 1 -> {
                System.out.println("\n");
                System.out.println("¿Qué dato desea editar?");
                System.out.println("1.Nombre completo");
                System.out.println("2.Tipo de reporte (PDR/ENC)");
                System.out.println("3.Zona");
                System.out.println("4.Especie (DOG/CAT)");
                System.out.println("5.Color principal");
                System.out.println("6.Señas particulares");
                System.out.println("7.Teléfono de contacto");
                System.out.println("8.Microchip");
                System.out.print("Seleccione una de las opciones:");
                int Edit = sc.nextInt();
                sc.nextLine();

                switch (Edit) {
                    case 1 -> {
                        System.out.print("Nuevo nombre completo:");
                        found.setFullName(sc.nextLine());
                        System.out.println("\n");
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Edición Exitosa: Nombre completo actualizado a: " + found.getFullName());
                    }

                    case 2 -> {
                        found.setTypeReport(Validation.ModifyReport());
                        System.out.println("\n");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("Edición Exitosa: Tipo de reporte actualizado a: " + found.getTypeReport());
                    }

                    case 3 -> {
                        System.out.print("Nueva zona:");
                        found.setZone(sc.nextLine());
                        System.out.println("\n");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("Edición Exitosa: Zona actualizada a: " + found.getZone());
                    }

                    case 4 -> {
                        System.out.print("Nueva especie (DOG/CAT):");
                        found.setSpecies(sc.nextLine());
                        System.out.println("\n");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Edición Exitosa: Eipo de esoecie actualizado a: " + found.getSpecies());
                    }

                    case 5 -> {
                        System.out.print("Nuevo color principal:");
                        found.setColor(sc.nextLine());
                        System.out.println("\n");
                        System.out.println("---------------------------------------------------------");
                        System.out.println("Edición Exitosa: Color actualizado a: " + found.getColor());
                    }

                    case 6 -> {
                        System.out.print("Nuevas señas particulares:");
                        found.setParticularSigns(sc.nextLine());
                        System.out.println("\n");
                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("Edición Exitosa: Señas particulares actualizadas a: " + found.getParticularSigns());
                    }

                    case 7 -> {
                        System.out.print("Nuevo número de teléfono:");
                        found.setTelephoneNumber(sc.nextLine());
                        System.out.println("\n");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("Edición Exitosa: Número de teléfono actualizado a: " + found.getTelephoneNumber());
                    }

                    case 8 -> {
                        System.out.print("Nuevo microchip");
                        System.out.println("\n");
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Edición Exitosa: Microchip actualizado a: " + found.getMicrochip());
                        found.setMicrochip(sc.nextLine());
                    }

                    default ->
                        System.out.println("Opción inválida");
                }
            }
            case 2 -> {
                System.out.println("Reingresar todos los datos");
                System.out.println("\n");
                found.setFullName(Validation.Name());
                found.setTypeReport(Validation.ModifyReport());
                found.setZone(Validation.Place());
                found.setSpecies(Validation.Animal());
                found.setColor(Validation.Aspect());
                found.setParticularSigns(Validation.Signs());
                found.setTelephoneNumber(Validation.Phone());
            }
            default ->
                System.out.println("Opción inválida");
        }
    }
}
