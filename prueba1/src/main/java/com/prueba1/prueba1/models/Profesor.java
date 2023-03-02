package com.prueba1.prueba1.models;

public class Profesor {
    
    public String nombre;


// constructors    
    public Profesor() {
    }

    public Profesor(String nombre) {
        this.nombre = nombre;
    }


// getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Profesor [nombre=" + nombre + "]";
    }

    

}
