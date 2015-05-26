package com.example.edgardionicio.basededatosdeedgar;

/**
 * Created by Owner on 22/04/2015.
 */
public class estudiantes {
    private  String numero_de_control;
    private String semestre;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private  String actividad;

    public estudiantes(String numero_de_control, String semestre, String nombre, String apellidop, String apellidom, String actividad) {
        this.numero_de_control = numero_de_control;
        this.semestre = semestre;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.actividad = actividad;
    }

    public String getNumero_de_control() {
        return numero_de_control;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public String getActividad() {
        return actividad;
    }

}





