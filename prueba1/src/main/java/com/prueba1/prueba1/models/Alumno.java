package com.prueba1.prueba1.models;

import java.util.ArrayList;

public class Alumno extends Curso{

    public String nombreAlumno;
    public String materia;
    public ArrayList<Double> notas;


    // constructors
    public Alumno() {
        super();
    }

    public Alumno(String nombre, String nombreCurso, Integer cantAlumnosCurso, String nombreAlumno, String materia,
            ArrayList<Double> notas) {
        super(nombre, nombreCurso, cantAlumnosCurso);
        this.nombreAlumno = nombreAlumno;
        this.materia = materia;
        this.notas = notas;
    }


    //getters and setters
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    
    

    @Override
    public String toString() {
        return "Alumno [nombreAlumno=" + nombreAlumno + ", materia=" + materia + ", notas=" + notas + "]";
    }

    

    
    
    
    

    
    
    


    
    
    
    
    
    
}
