/*

Descripción:

En esta clase se trabaja con el tipo de reporte (PDR/ ENC). Es de suma importancia
debido a que se realiza la respectiva clasificación basado en los registros 
completados.

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorreportemascotas;

import java.util.List;

/**
 *
 * @author Jimena
 */
public class GroupedReport {

    public static void Grouped(List<Pet> pets) {

        System.out.println("\n"); // Salto de línea.
        System.out.println("---------------------------------------");
        System.out.println("       REPORTE AGRUPADO DE MASCOTAS    ");
        System.out.println("---------------------------------------");

        int PDR = 0;
        int ENC = 0;

        for (Pet p : pets) {
            if (p.getTypeReport().equalsIgnoreCase("PDR")) {
                PDR++;
            } else if (p.getTypeReport().equalsIgnoreCase("ENC")) {
                ENC++;
            }
        }
        System.out.println("Conteo por tipo:");
        System.out.println("PDR:" + PDR);
        System.out.println("ENC:" + ENC);

        int Dog = 0;
        int Cat = 0;

        for (Pet p : pets) {
            if (p.getSpecies().equalsIgnoreCase("DOG")) {
                Dog++;
            } else if (p.getSpecies().equalsIgnoreCase("CAT")) {
                Cat++;
            }
        }
        System.out.println("\n");
        System.out.println("Conteo por especie:");
        System.out.println("DOG:" + Dog);
        System.out.println("CAT:" + Cat);
    }
}
