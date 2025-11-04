/*

Descripción:

En esta clase, se declaran los atributos, los getters y setters. Es un paso muy
importante ya que esos atributos serán claves durante todo el proceso del registro.

-Declaración de los atributos.
-La inicialización de cada uno de los atributos.
-La implementación de los getters y setters.

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorreportemascotas;

/**
 *
 * @author Jimena
 */
public class Pet {

    private String IdentificationReport;
    private String IdentificationReporter;
    private String FullName;
    private String TypeReport;
    private String ReportDate;
    private String Zone;
    private String Species;
    private String Color;
    private String ParticularSigns;
    private String TelephoneNumber;
    private String Microchip;

    public Pet() {

        this.IdentificationReport = "";
        this.IdentificationReporter = "";
        this.FullName = "";
        this.TypeReport = "PDR"; // A diferencia de los demás, este por defecto debe ser PDR.
        this.ReportDate = "";
        this.Zone = "";
        this.Species = "";
        this.Color = "";
        this.ParticularSigns = "";
        this.TelephoneNumber = "";
        this.Microchip = "";

    }

    // Getters y Setters.
    public String getIdentificationReport() {
        return IdentificationReport;
    }

    public void setIdentificationReport(String IdentificationReport) {
        this.IdentificationReport = IdentificationReport;
    }

    public String getIdentificationReporter() {
        return IdentificationReporter;
    }

    public void setIdentificationReporter(String IdentificationReporter) {
        this.IdentificationReporter = IdentificationReporter;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getTypeReport() {
        return TypeReport;
    }

    public void setTypeReport(String TypeReport) {
        this.TypeReport = TypeReport;
    }

    public String getReportDate() {
        return ReportDate;
    }

    public void setReportDate(String ReportDate) {
        this.ReportDate = ReportDate;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String Zone) {
        this.Zone = Zone;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String Species) {
        this.Species = Species;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getParticularSigns() {
        return ParticularSigns;
    }

    public void setParticularSigns(String ParticularSigns) {
        this.ParticularSigns = ParticularSigns;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String TelephoneNumber) {
        this.TelephoneNumber = TelephoneNumber;
    }

    public String getMicrochip() {
        return Microchip;
    }

    public void setMicrochip(String Microchip) {
        this.Microchip = Microchip;
    }
}
