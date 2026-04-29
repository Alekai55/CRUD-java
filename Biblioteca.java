package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement; // ¡Este import ahora está arriba del todo!

public class Biblioteca {
    private Connection connection;

    private void openConnection() {
        // La URL usa el formato: jdbc:mysql://IP:PUERTO/NOMBRE_BBDD
        String url = "jdbc:mysql://127.0.0.1:3308/biblioteca"; // Ojo, usando el puerto 3308
        try {
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión establecida con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    private void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarLibro(Libro l) {
        openConnection(); // 1. Siempre abrimos la conexión primero

        // 2. Preparamos la consulta SQL usando las constantes de org.example.SchemaDB y los marcadores "?"
        String sql = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
                SchemaDB.TAB_LIBRO, SchemaDB.COL_TITULO,
                SchemaDB.COL_AUTOR, SchemaDB.COL_ANIO,
                SchemaDB.COL_ISBN, SchemaDB.COL_PRESTADO
        );

        try {
            // 3. Inicializamos el PreparedStatement
            PreparedStatement ps = connection.prepareStatement(sql);

            // 4. Sustituimos las "?" por los datos reales del objeto org.example.Libro
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setInt(3, l.getAnio());
            ps.setString(4, l.getIsbn());
            ps.setBoolean(5, l.isPrestado());

            // 5. Ejecutamos la consulta (executeUpdate devuelve el nº de filas afectadas)
            int filas = ps.executeUpdate();
            System.out.println("Libros insertados correctamente: " + filas);

        } catch (SQLException e) {
            System.out.println("Error al insertar el libro: " + e.getMessage());
        } finally {
            closeConnection(); // 6. ¡Pase lo que pase, cerramos la conexión!
        }
    }
}