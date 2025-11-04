/*
UNIVERSIDAD ESTATAL A DISTANCIA
Estudiante: Jimena Velásquez Gómez.
Identificación: 1-1919-0417.
Docente: Gabriela Cervantes Jimenez.
Proyecto #1.
Temas 1 y 2.
Tercer cuatrimestre, 2025.

Descripción: 
Huellas Felices es un refugio de mascotas. Se solicita crear una aplicación 
llamada Gestor de Reporte de Mascotas. Esta aplicación tendrá múltiples opciones 
dentro del menú, permitiendo al usuario realizar uno o varios registros, consultar 
el reporte general y agrupado, visualizar si hay coincidencias y si fuera necesario,
modificar algún dato o bien, reingresar todos los campos. De esta manera, el 
programa se convertirá en una herramienta muy importante para llevar un registro
más ordenado de las mascotas perdidas o encontradas en el refugio.


Referencias:
Canal de Promamación ATS: https://www.youtube.com/playlist?list=PLWtYZ2ejMVJkjOuTCzIk61j7XKfpIR74K
Presentación Programación Intermedia Tema I: https://aprende.uned.ac.cr/pluginfile.php/2014599/mod_resource/content/1/Presentacio%CC%81n%20Tema%201_824_2023.pdf
Presentación Progrmación intermedia Tema II: https://aprende.uned.ac.cr/pluginfile.php/2014610/mod_resource/content/1/Presentacio%CC%81n%20Tema%202_824_2023.pdf
Canal de YouTube: https://www.youtube.com/watch?v=TDc2u-3EP3Q&ab_channel=%D0%A4%D0%B5%D0%B4%D0%BE%D1%82%D0%A8%D0%BC%D0%B0%D0%BA%D0%BE%D0%B2 
Página web: https://www.ibm.com/docs/es/i/7.4.0?topic=java-code-examples
Página web: https://www.ionos.com/es-us/digitalguide/paginas-web/desarrollo-web/java-variables/ 
Página web: https://www-javahandbook-com.translate.goog/java-strings/string-formatting-in-java-s-d-f/?_x_tr_sl=en&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=rq
Páhina web: https://www.w3schools.com/java/java_try_catch.asp

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gestorreportemascotas;

// Librerías necesarias para el desarrollo óptimo del programa.
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jimena
 */
public class GestorReporteMascotas {

    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8)); // Estrucutra necesaria para los carácteres.
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int option;
        option = 0;
        boolean OrderExcecute = false; // Permite el orden de ejecución del programa.

        List<Pet> pets = new ArrayList<>(); // Lista llamada Pet. Es importante ya que ésta almacena todos los registros.

        do {
            menu.SeeMenu(); // Muestra el menú.
            boolean Validate = false;
            while (!Validate) {
                try {
                    System.out.print("Seleccione una opción:");
                    option = Integer.parseInt(sc.nextLine());
                    Validate = true;
                } catch (NumberFormatException e) {
                    System.out.println("No debe ingresar letras. Por favor, vuelva a digitar una opción");
                }
            }

            switch (option) { // Manejo de las opciones.

                case 1 -> {

                    Pet AA = new Pet();

                    AA.setIdentificationReport(Validation.IdentReport(pets));
                    AA.setIdentificationReporter(Validation.IdentReporter());
                    AA.setFullName(Validation.Name());
                    AA.setTypeReport(Validation.Report());
                    AA.setReportDate(Validation.Date());
                    AA.setZone(Validation.Place());
                    AA.setSpecies(Validation.Animal());
                    AA.setColor(Validation.Aspect());
                    AA.setParticularSigns(Validation.Signs());
                    AA.setTelephoneNumber(Validation.Phone());
                    AA.setMicrochip(Validation.Micro());

                    pets.add(AA);
                    OrderExcecute = true;

                    System.out.println("Registro completado con éxito");
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                    break;
                }

                case 2 -> {

                    if (OrderExcecute) {
                        Query.listOfQueries(pets);
                    } else {
                        System.out.println("Para continuar, primero debe completar el registro.");
                    }
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                }

                case 3 -> {

                    if (OrderExcecute) {
                        GeneralReport.General(pets);
                    } else {
                        System.out.println("Para continuar, primero debe completar el registro.");
                    }
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                }

                case 4 -> {

                    if (OrderExcecute) {
                        GroupedReport.Grouped(pets);
                    } else {
                        System.out.println("Para continuar, primero debe completar el registro.");
                    }
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                }

                case 5 -> {

                    if (OrderExcecute) {
                        MatchFound.Coincidences(pets);
                    } else {
                        System.out.println("Para continuar, primero debe completar el registro.");
                    }
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                }

                case 6 -> {

                    if (OrderExcecute) {
                        UpdateReport.Update(pets);
                    } else {
                        System.out.println("Para continuar, primero debe completar el registro.");
                    }
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                }

                case 7 -> {
                    System.out.println("Le agradecemos su aporte.");
                    System.out.println("\n");
                    System.out.println("Presione la tecla Enter para continuar con el programa.");
                    sc.nextLine();
                }
                default -> {
                    System.out.println("Opción inválida, por favor vuelva a intentarlo.");
                }
            }
        } while (option != 7);

    }
}
