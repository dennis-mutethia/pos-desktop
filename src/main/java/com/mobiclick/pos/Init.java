package com.mobiclick.pos;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiclick.pos.models.User;
import static com.mobiclick.pos.utils.Logging.LOGGER;
import com.mobiclick.pos.views.LoginFrame;
import com.mobiclick.pos.views.MainFrame;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

/**
 *
 * @author DennisMutethia
 */
public class Init {

    public final static Properties APPLICATION_PROPERTIES = new Properties();
    public final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static User LOGGED_IN_USER = null;

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (FileInputStream fis = new FileInputStream("application.properties")) {
            APPLICATION_PROPERTIES.load(fis);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "{0}", ex);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, "{0}", ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
