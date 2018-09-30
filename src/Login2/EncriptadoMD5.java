package Login2;

import View.JDialog_Errores;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gomez
 */
public class EncriptadoMD5 {
    private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f'};
    
    public static String encriptaEnMD5(String stringAEncriptar){
        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
            StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
            
            for(int i = 0; i < bytes.length; i++){
                int bajo = (int)((bytes[i] & 0x0f));
                int alto = (int)((bytes[i] & 0x0f) >> 4);
                strbCadenaMD5.append(CONSTS_HEX[alto]);
                strbCadenaMD5.append(CONSTS_HEX[bajo]);
            }
            return strbCadenaMD5.toString();
        } catch (NoSuchAlgorithmException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error en la encriptacion MD5", errors.toString());
            err.setVisible(true);
            return null;
        }
    }
}
