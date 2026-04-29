package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Gimnasio {
    private Connection connection;

    private void openConnection() {
        // Ojo: ahora apuntamos a la base de datos "gimnasio"
        String url = "jdbc:mysql://127.0.0.1:3308/gimnasio";
        try {
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    private void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarMoroso(int idSocio) {
        openConnection();

        // 1. Preparamos la consulta con nuestro SchemaDB
        String sql = String.format(
                "UPDATE %s SET %s = ? WHERE %s = ?",
                SchemaDB.TAB_SOCIO, SchemaDB.COL_MOROSO, SchemaDB.COL_ID
        );

        try {
            // 2. Cargamos el PreparedStatement
            PreparedStatement ps = connection.prepareStatement(sql);

            // 3. Rellenamos las interrogaciones (?)
            ps.setBoolean(1, true);   // La primera "?" es el valor de moroso
            ps.setInt(2, idSocio);    // La segunda "?" es el ID del socio a buscar

            // 4. Ejecutamos
            int filasAfectadas = ps.executeUpdate();
            System.out.println("Se ha actualizado el estado moroso de " + filasAfectadas + " socio(s).");

        } catch (SQLException e) {
            System.out.println("Error al actualizar moroso: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
    public void insertarSocio(Socio s) {
        openConnection(); // Siempre abrimos primero

        // Preparamos la consulta con las 3 columnas principales
        String sql = String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, CURDATE())",
                SchemaDB.TAB_SOCIO, SchemaDB.COL_NOMBRE, SchemaDB.COL_CUOTA, SchemaDB.COL_MOROSO, SchemaDB.COL_FECHA_ALTA
        );

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            // Rellenamos las "?" con los datos de Daniela
            ps.setString(1, s.getNombre());
            ps.setDouble(2, s.getCuota());
            ps.setBoolean(3, s.isMoroso());

            int filas = ps.executeUpdate();
            System.out.println("Socio/a inscrito/a correctamente. Filas afectadas: " + filas);

        } catch (SQLException e) {
            System.out.println("Error al insertar el socio: " + e.getMessage());
        } finally {
            closeConnection(); // Siempre cerramos al terminar
        }
    }
    public void borrarMorosos() {
        openConnection();

        // Preparamos el DELETE con nuestro WHERE salvavidas
        String sql = String.format(
                "DELETE FROM %s WHERE %s = ?",
                SchemaDB.TAB_SOCIO, SchemaDB.COL_MOROSO
        );

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            // Le decimos que busque a los que tienen moroso en "true"
            ps.setBoolean(1, true);

            // Ejecutamos el borrado
            int filas = ps.executeUpdate();
            System.out.println("Limpieza completada. Socios morosos borrados: " + filas);

        } catch (SQLException e) {
            System.out.println("Error al borrar morosos: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
}