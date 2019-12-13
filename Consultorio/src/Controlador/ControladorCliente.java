/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class ControladorCliente {

    public String esCliente(String cedula, String clave) {
        ControladorPersona cp = new ControladorPersona();
        String existe = null;
        int tamano = 0;
        String id = cp.idPersona(cedula, clave);
        String sql = "select COUNT(*) from paciente where Persona_per_id1=?";
        Connection con = null;
        try {
            con = conectar.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tamano = rs.getInt(1);
                if (tamano > 0) {
                    return existe = "PACIENTE";
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar paciente");
            e.printStackTrace();
        } finally {
            conectar.close(con);
        }
        return existe;
    }
}
