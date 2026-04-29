package org.example;

public class Socio {
    private String nombre;
    private double cuota;
    private boolean moroso;

    // Constructor
    public Socio(String nombre, double cuota) {
        this.nombre = nombre;
        this.cuota = cuota;
        this.moroso = false; // Por lógica, cuando alguien se inscribe, no es moroso por defecto
    }

    // Getters para sacar los datos luego
    public String getNombre() { return nombre; }
    public double getCuota() { return cuota; }
    public boolean isMoroso() { return moroso; }
}