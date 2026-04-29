package org.example;

public class Libro {
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;
    private boolean prestado;

    // Constructor
    public Libro(String titulo, String autor, int anio, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
        this.prestado = false; // Por defecto no está prestado
    }

    // Getters (necesarios para leer los datos al insertar)
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public String getIsbn() { return isbn; }
    public boolean isPrestado() { return prestado; }
}