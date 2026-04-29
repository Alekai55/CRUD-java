package org.example;


public class Paciente {
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private String dueno;

    public Paciente(int id, String nombre, String especie, int edad, double peso, String dueno) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.dueno = dueno;
    }

    // Este método nos servirá para que Java sepa cómo imprimir este objeto por consola después
    @Override
    public String toString() {
        return nombre + " (" + especie + ") - " + edad + " años. Dueño: " + dueno;
    }
}