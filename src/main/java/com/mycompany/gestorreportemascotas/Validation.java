/*

Descripción:

En la clase Pet, se declararon los atributos necesarios para dar continuidad
al programa. Para un mejor control y orden, es necesario realizar las validaciones
necesarias por cada campo o atributo. En caso de haber un error o no cumplir con 
lo solicitado, el usuario deberá ingresar nuevamente el dato.

-ToUpperCase() = Transforma un texto de minúscula a mayúscula.
- Trim() = Elimina espacios al inicio o final de un texto.
-sc.nextLine()= Toma toda la línea de texto ingresada por el usuario, incluyendo si hay espacios entre palabras.
-Boolean = Es un dato lógico.

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorreportemascotas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // Librería para el manejo de la fecha.
import java.time.format.DateTimeParseException; // Librería importante para poder utilizar el try Catch en el método de la fecha.
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jimena
 */
public class Validation {

    // Métodos.
    // Validaciones para el ID de Reporte.
    public static String IdentReport(List<Pet> pets) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("--------------------------------------------------");
        System.out.println("             REGISTRAR NUEVO REPORTE              ");
        System.out.println("--------------------------------------------------");

        String IdReport;
        boolean One;

        do {

            One = true;
            System.out.print("Ingrese ID de reporte (ejemplo REP-0001):");
            IdReport = sc.nextLine().trim().toUpperCase();

            if (IdReport.length() != 8) {
                System.out.println("Formato inválido. Por favor, vuelva a intentarlo.");
                One = false;
            } else if (!IdReport.startsWith("REP-")) {
                System.out.println("Se incluir primero el prefijo (REP-).Por favor, vuelva a intentarlo. ");
                One = false;
            } else if (!IdReport.substring(4).matches("\\d{4}")) {
                System.out.println("No puede ingresar carácteres posterior al prefijo (REP-). Por favor, vuelva a intentarlo.");
                One = false;
            }

            for (Pet p : pets) {
                if (p.getIdentificationReport().equals(IdReport)) {
                    System.out.println("El ID de reporte debe ser único.Por favor, ingrese uno nuevo. ");
                    One = false;
                }
            }
        } while (!One);
        return IdReport;
    }

    // Validaciones para el ID del Reportante.
    public static String IdentReporter() {
        Scanner sc = new Scanner(System.in);
        String IdReporter;
        boolean Two;

        do {

            Two = true;
            System.out.print("Ingrese ID del reportante (1-1111-1111):");
            IdReporter = sc.nextLine().trim();

            if (IdReporter.isEmpty()) {
                System.out.println("No puede dejar en vacío el número de cédula. Por favor, intente de nuevo.");
                Two = false;
            }

            if (IdReporter.length() != 11) {
                System.out.println("Formato inválido.Por favor, vuelva a intentarlo.");
                Two = false;
            }

            if (!IdReporter.matches("\\d-\\d{4}-\\d{4}")) {
                System.out.println("La cédula debe de contener únicamente números, no carácteres.Por favor, vuelva a intentarlo.");
                Two = false;
            }

        } while (!Two);
        return IdReporter;
    }

    // Validaciones para el Nombre.
    public static String Name() {
        Scanner sc = new Scanner(System.in);
        String Name;
        boolean Three;

        do {

            Three = true;
            System.out.print("Ingrese el nombre completo:");
            Name = sc.nextLine().trim();

            if (Name.isEmpty()) {
                System.out.println("No puede dejar vacío el nombre completo. Por favor, complete el espacio.");
                Three = false;
            }

            if (Name.length() >= 7) {
                Three = true;
            } else {
                System.out.println("El nombre debe de contener como mínimo 7 carácteres. Por favor, vuelva a intentarlo.");
                Three = false;
            }
            boolean Numbers = false;
            for (int i = 0; i < Name.length(); i++) {
                char c = Name.charAt(i);
                if (Character.isDigit(c)) {
                    Numbers = true;
                    break;
                }
            }
            if (Numbers) {
                System.out.println("El nombre no debe contener números, solo carácteres.Por favor, vuelba a intentarlo.");
                Three = false;
            }
        } while (!Three);

        return Name;

    }

    // Tipo de Reporte.
    public static String Report() {
        Scanner sc = new Scanner(System.in);
        String TypeReport = "PDR";
        System.out.println("Ingrese el tipo de reporte (PDR/ENC)[Por defecto PDR]:" + TypeReport);
        return TypeReport;
    }

    // Validaciones por el tipo de Reporte.
    public static String ModifyReport() {
        Scanner sc = new Scanner(System.in);
        String TypeReport;
        String Modify;
        boolean Four;

        do {
            Four = true;
            System.out.print("Tipo de reporte (PDR/ENC):");
            Modify = sc.nextLine().toUpperCase();
            if (Modify.equals("PDR") || Modify.equals("ENC")) {
                TypeReport = Modify;
                Four = true;
            } else {
                System.out.println("Solo puede ingresar una de esas dos opciones.");
                Four = false;
            }
            if (Modify.isEmpty()) {
                System.out.println("No puede dejar el campo vacío. Por favor, intente de nuevo.");
                Four = false;
            }
        } while (!Four);

        return Modify;

    }

    // Validaciones para la Fecha.
    public static String Date() {
        Scanner sc = new Scanner(System.in);
        String RepDate;
        boolean Five = true;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.print("Ingrese la fecha del reporte(dd/MM/yyyy):");
            RepDate = sc.nextLine().trim().toUpperCase();

            if (RepDate.isEmpty()) {
                RepDate = LocalDate.now().format(formato);
            }

            try {
                LocalDate.parse(RepDate, formato);
                Five = true;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, vuelva a intentarlo");
                Five = false;
            }

        } while (!Five);

        return RepDate;

    }

    // Validaciones para la Zona.
    public static String Place() {
        Scanner sc = new Scanner(System.in);
        String Residence;
        boolean Six;

        do {

            Six = true;
            System.out.print("Ingrese la zona:");
            Residence = sc.nextLine().trim();

            if (Residence.length() <= 30) {
                Six = true;
            } else {
                System.out.println("El texto debe contener como máximo 30 carácteres. Por favor, vuelva a intentarlo.");
                Six = false;
            }

            if (Residence.matches("\\d+")) {
                System.out.println("La zona no puede tener solo números");
                Six = false;
            }

            if (Residence.isEmpty()) {
                System.out.println("No puede dejar vacío la zona. Por favor, complete el espacio.");
                Six = false;
            }

        } while (!Six);

        return Residence;
    }

    // Validaciones tipo de Especie.
    public static String Animal() {
        Scanner sc = new Scanner(System.in);
        String Specie;
        boolean Seven;

        do {
            Seven = true;
            System.out.print("Ingrese especie (DOG/CAT):");
            Specie = sc.nextLine().trim().toUpperCase();

            if (Specie.equals("DOG") || Specie.equals("CAT")) {
                Seven = true;
            } else {
                System.out.println("Debe ingresar una de las dos opciones mencionadas anteriormente.");
                Seven = false;
            }

            if (Specie.isEmpty()) {
                System.out.println("No puede dejar vacío el tipo de especie. Por favor, intente de nuevo.");
                Seven = false;
            }

        } while (!Seven);

        return Specie;

    }

    // Validaciones por el Color.
    public static String Aspect() {
        Scanner sc = new Scanner(System.in);
        String Aparience;
        boolean Eight;
        do {

            Eight = true;
            System.out.print("Ingrese color principal:");
            Aparience = sc.nextLine().trim();

            if (Aparience.isEmpty()) {
                System.out.println("No puede dejar vacío el color. Por favor, complete el espacio.");
                Eight = false;
            }

            boolean Characters = false;
            for (int i = 0; i < Aparience.length(); i++) {
                char Letter = Aparience.charAt(i);
                if (Character.isDigit(Letter)) {
                    Characters = true;
                    break;
                }
            }

            if (Characters) {
                System.out.println("El color no debería de presentar números. Por favor, vuelva a intentarlo.");
                Eight = false;
            }

        } while (!Eight);

        return Aparience;

    }

    // Validaciones de las Señas.
    public static String Signs() {
        Scanner sc = new Scanner(System.in);
        String PartSings;
        boolean Nine;

        do {
            Nine = true;
            System.out.print("Ingrese señas particulares (mínimo 10 carácteres):");
            PartSings = sc.nextLine().trim();

            if (PartSings.length() >= 10) {
                Nine = true;
            } else {
                System.out.println("Debe tener mínimo 10 carácteres. Por favor, vuelva a intentarlo.");
                Nine = false;
            }

            if (PartSings.isEmpty()) {
                System.out.println("No puede dejar vacío las señas particulares de la mascota. Por favor, intente de nuevo.");
                Nine = false;
            }

            if (PartSings.matches("\\d+")) {
                System.out.println("Las señas no pueden tener solo números. Por favor, vuelva a intentarlo.");
                Nine = false;
            }

        } while (!Nine);

        return PartSings;

    }

    // Validaciones Teléfono.
    public static String Phone() {
        Scanner sc = new Scanner(System.in);
        String Telephone;
        boolean Ten;

        do {

            Ten = true;
            System.out.print("Ingrese teléfono de contacto (####-####):");
            Telephone = sc.nextLine().trim();

            if (Telephone.isEmpty()) {
                System.out.println("No puede dejar el campo vacío.Por favor, complete el espacio.");
                Ten = false;
            }

            if (Telephone.length() != 9) {
                System.out.println(" Formato inválido. Por favor, vuelva a intentarlo.");
                Ten = false;
            }

            if (!Telephone.matches("\\d{4}-\\d{4}")) {
                System.out.println("El número de teléfono no puede contener carácteres a excepción del guión (-). Por favor, vuelva a intentarlo.");
                Ten = false;
            }

        } while (!Ten);

        return Telephone;

    }

    public static String Micro() {
        Scanner sc = new Scanner(System.in);
        String Chip;
        boolean Eleven;

        do {

            Eleven = true;
            System.out.print("Ingrese microchip (opcional, deje en blanco si no tiene): ");
            Chip = sc.nextLine().trim();

        } while (!Eleven);

        return Chip;

    }

}
