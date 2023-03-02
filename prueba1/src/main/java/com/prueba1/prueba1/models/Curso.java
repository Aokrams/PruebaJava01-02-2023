package com.prueba1.prueba1.models;

public class Curso extends Profesor{

    public String nombreCurso;
    public Integer cantAlumnosCurso;


    // constructors
    public Curso() {
        super();
    }

    public Curso(String nombre, String nombreCurso, Integer cantAlumnosCurso) {
        super(nombre);
        this.nombreCurso = nombreCurso;
        this.cantAlumnosCurso = cantAlumnosCurso;
    }


    // getters and setters
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getCantAlumnosCurso() {
        return cantAlumnosCurso;
    }

    public void setCantAlumnosCurso(Integer cantAlumnosCurso) {
        this.cantAlumnosCurso = cantAlumnosCurso;
    }

    @Override
    public String toString() {
        return super.toString() + "Curso [nombreCurso=" + nombreCurso + ", cantAlumnosCurso=" + cantAlumnosCurso + "]";
    }
    
    
}
