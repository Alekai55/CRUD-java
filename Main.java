package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ============================================================
        // EJERCICIO 1: BIBLIOTECA (MySQL - INSERT)
        // Para usarlo, borra el "/*" de arriba y el "*/" de abajo
        // ============================================================
        /*
        Biblioteca miBiblioteca = new Biblioteca();
        Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, "978-0007136599");
        Libro libro2 = new Libro("1984", "George Orwell", 1949, "978-0451524935");

        System.out.println("--- EJERCICIO 1: BIBLIOTECA ---");
        System.out.println("Insertando libros...");
        miBiblioteca.insertarLibro(libro1);
        miBiblioteca.insertarLibro(libro2);
        */


        // ============================================================
        // EJERCICIO 2: GIMNASIO (MySQL - UPDATE / DELETE)
        // Para usarlo, borra el "/*" de arriba y el "*/" de abajo
        // ============================================================
        /*
        Gimnasio miGimnasio = new Gimnasio();
        Socio daniela = new Socio("Daniela", 55.0);

        System.out.println("\n--- EJERCICIO 2: GIMNASIO ---");
        System.out.println("Añadiendo a Daniela al sistema...");
        miGimnasio.insertarSocio(daniela);
        System.out.println("Iniciando revisión de morosos...");
        miGimnasio.borrarMorosos();
        */


        // ============================================================
        // EJERCICIO 3: VETERINARIA (MySQL - SELECT)
        // Actualmente activo
        // ============================================================
        Veterinaria miVeterinaria = new Veterinaria();

        System.out.println("\n--- EJERCICIO 3: VETERINARIA ---");
        System.out.println("Buscando perros en la clínica...");
        
        List<Paciente> listaPerros = miVeterinaria.buscarPorEspecie("Perro");

        // Recorremos la lista para imprimirlos por pantalla
        if (listaPerros.isEmpty()) {
            System.out.println("No se han encontrado perros.");
        } else {
            for (Paciente p : listaPerros) {
                System.out.println(p.toString());
            }
        }

    } // Cierre del método main
} // Cierre de la clase Main