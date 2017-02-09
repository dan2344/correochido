/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class actualiza {

    public String CambiaEstado(int numr) {

        String mensaje = "";

        BD.cDatos lol = new BD.cDatos();
        try {
            lol.conectar();
            ResultSet valida = lol.consulta("call cambia('" + numr + "');");
            mensaje = "actualizado";

            lol.cierraConexion();
        } catch (Exception e) {

            mensaje = e.getMessage();
        }
        return mensaje;

    }

}
