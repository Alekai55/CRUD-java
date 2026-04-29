package org.example;

public interface SchemaDB {
    // ---------- TABLA LIBROS (Ejercicio 1) ----------
    String TAB_LIBRO = "libro";
    String COL_ID = "id"; // Esta la puedes reutilizar si ambas tablas usan "id"
    String COL_TITULO = "titulo";
    String COL_AUTOR = "autor";
    String COL_ANIO = "anio";
    String COL_ISBN = "isbn";
    String COL_PRESTADO = "prestado";

    // ---------- TABLA SOCIOS GIMNASIO (Ejercicio 2) ----------
    String TAB_SOCIO = "socio";
    String COL_NOMBRE = "nombre";
    String COL_CUOTA = "cuota";
    String COL_MOROSO = "moroso";
    String COL_FECHA_ALTA = "fecha_alta";

    // ---------- TABLA PACIENTE VETERINARIA (Ejercicio 3) ----------
    String TAB_PACIENTE = "paciente";
    String COL_ESPECIE = "especie";
    String COL_EDAD = "edad";
    String COL_PESO = "peso";
    String COL_DUENO = "dueno";
}