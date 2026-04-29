package org.example;

import java.sql.Connection; // ¡Faltaba importar esto!
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
    
    private Connection connection; // ¡Faltaba declarar el atributo de la clase!

    private void openConnection() {
        // Ojo: ahora apuntamos a la base de datos "veterinaria"
        String url = "jdbc:mysql://127.0.0.1:3308/veterinaria";
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
    public List<Paciente> buscarPorEspecie(String especie) {
        // 1. Preparamos una lista vacía para guardar los pacientes que encontremos
        List<Paciente> lista = new ArrayList<>();
        
        openConnection(); 

        // 2. Preparamos la consulta SQL
        String sql = String.format(
                "SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_PACIENTE, SchemaDB.COL_ESPECIE
        );

        try {
            // 3. Montamos el PreparedStatement y rellenamos la "?"
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, especie);
            
            // 4. ¡OJO AQUÍ! Usamos executeQuery(), que nos devuelve un ResultSet
            ResultSet rs = ps.executeQuery();
            
            // 5. Recorremos la "tabla temporal" fila por fila
            while (rs.next()) {
                // 6. Construimos un objeto Paciente leyendo los datos de esa fila
                Paciente p = new Paciente(
                        rs.getInt(SchemaDB.COL_ID),
                        rs.getString(SchemaDB.COL_NOMBRE),
                        rs.getString(SchemaDB.COL_ESPECIE),
                        rs.getInt(SchemaDB.COL_EDAD),
                        rs.getDouble(SchemaDB.COL_PESO),
                        rs.getString(SchemaDB.COL_DUENO)
                );
                
                // 7. Lo añadimos a nuestra lista
                lista.add(p);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al buscar pacientes: " + e.getMessage());
        } finally {

            
            closeConnection(); 
        }
        
        // 8. Devolvemos la lista llena (o vacía si no encontró ninguno)
        return lista;
    }
}