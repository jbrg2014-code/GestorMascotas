/*

Descripción:

En esta clase se muestra el reporte general tomando en cuenta algunos campos
específicos del registro. 

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorreportemascotas;

import java.util.List;

/**
 *
 * @author Jimena
 */
public class GeneralReport {

    public static void General(List<Pet> pets) {

        System.out.println("\n");
        System.out.println("---------------------------------------------------------------");
        System.out.println("                   REPORTE GENERAL DE MASCOTAS                 ");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("  %-11s   |  %-15s  |  %-6s  | %-6s | %-4s%n ", // Cantidad de espacios por campo.
                "ID Reportante", "Nombre Completo", "Fecha", "Zona", "Tipo");
        System.out.println("---------------------------------------------------------------");

        int Old = 0;
        for (Pet p : pets) {
            System.out.printf("%-11s | %-18s | %-10s | %-10s | %-3s%n",
                    p.getIdentificationReporter(), p.getFullName(), p.getReportDate(),
                    p.getZone(), p.getTypeReport());
            Old++;
        }

        System.out.println("---------------------------------------------------------------");

        System.out.println("Total de Reportes:" + Old);

    }
}
