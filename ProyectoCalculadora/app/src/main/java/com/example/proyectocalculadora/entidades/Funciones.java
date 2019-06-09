package com.example.proyectocalculadora.entidades;


import java.io.Serializable;

public class Funciones implements Serializable {

    private int id;
    private String titulo;
    private String expresion;



    public Funciones(){}

    public Funciones(String titulo, String expresion) {
        this.titulo = titulo;
        this.expresion = expresion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }



    @Override
    public String toString() {
        return "Funciones{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", expresion='" + expresion + '\'' +
                +'}';
    }
}
