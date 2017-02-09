package extras;

import com.sun.mail.handlers.multipart_mixed;
import java.sql.ResultSet;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ger
 */
public class cMail {

    public String _error = "";
    private String _para = "";
    private String _cuerpoMsj = "";
    String _de = "loyolafundacion@gmail.com";
    private String _titulo = "";
    String identificador="";

    public cMail() {

    }

    public boolean mandaMAil(String Para, String Titulo, String Msj) {
        boolean envio = false;
        this._titulo = Titulo;
        this._para = Para;
        this._cuerpoMsj = Msj;

        try {

            // Configuracion de la cuenta de envio de mail
            Properties confMail = new Properties();
            confMail.setProperty("mail.smtp.host", "smtp.gmail.com");
            confMail.setProperty("mail.smtp.starttls.enable", "true");
            confMail.setProperty("mail.smtp.port", "587");
            confMail.setProperty("mail.smtp.user", "loyolafundacion@gmail.com");
            confMail.setProperty("mail.smtp.auth", "true");
            // Sesion
            Session session = Session.getDefaultInstance(confMail);
            // Creamos el MAil
            MimeMessage correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress(this._de));
            correo.addRecipient(Message.RecipientType.TO, new InternetAddress(this._para));
            correo.setSubject(this._titulo);

            //solo texto plano
            //correo.setText(this._cuerpoMsj);
            //cuerpo html
            //correo.setContent(this._cuerpoMsj, "text/html" );
            //html 2
            DataHandler dh = new DataHandler(this._cuerpoMsj, "text/html");
            correo.setDataHandler(dh);

            // Enviamos MAil .
            Transport t = session.getTransport("smtp");
            t.connect("loyolafundacion@gmail.com", "WEBTECNOLOGY");
            t.sendMessage(correo, correo.getAllRecipients());

            // Cerramos conexion.
            t.close();
            envio = true;
        } catch (Exception e) {

            this._error = e.getMessage();
        }
        return envio;
    }
    
    public void ReenviarCorreo(String correo)
    {
       try {
            BD.cDatos conexionBonita = new BD.cDatos();

            conexionBonita.conectar(); //la variable solo se usa para empezar la conexion

            ResultSet sql = conexionBonita.consulta("call ReenviarCorreo('" + correo + "');");
            
            if (sql.next()) 
            {
                identificador = sql.getString("respuesta");
            }

            conexionBonita.cierraConexion();

        } catch (Exception recibe) {
            
            identificador = recibe.getMessage();
        }
        
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    

}
