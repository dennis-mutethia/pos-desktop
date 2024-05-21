package mobiclick.application.form;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import net.miginfocom.swing.MigLayout;
import mobiclick.application.Application;
import static mobiclick.application.Application.DB_URL;
import static mobiclick.application.Application.LOGGER;
import mobiclick.application.db.models.User;
import mobiclick.application.db.models.UserRole;
import raven.toast.Notifications;

/**
 *
 * @author mobiclick
 */
public class LoginForm extends javax.swing.JPanel {

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
        loadUsernames();
        
        
        setLayout(new MigLayout("al center center"));

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        txtPass.requestFocus();
    }
   
    private void loadUsernames() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String query = "SELECT username FROM users WHERE status=1";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        jcbUser.addItem(rs.getString("username"));
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "{0}", e);
        }
    }
    
    private void login(){
        String username = jcbUser.getSelectedItem().toString();      
        String password = new String(txtPass.getPassword());
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String query = ""
                    + "SELECT users.id, users.username, users.name, "
                    + "user_roles.id AS role_id, user_roles.name AS role_name "
                    + "FROM users "
                    + "JOIN user_roles ON user_roles.id=users.role_id "
                    + "WHERE users.username = ? AND users.password=? ";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        UserRole userRole = new UserRole();
                        userRole.setId(rs.getInt("role_id"));
                        userRole.setName(rs.getString("name"));

                        User user = new User();
                        user.setId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setName(rs.getString("name"));
                        user.setUserRole(userRole);

                        Application.LOGGED_IN_USER = user;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "{0}", e);
        }

        if (Application.LOGGED_IN_USER != null) {
            txtPass.setText(null);
            Application.login();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Invalid Password!! Try again...");
            txtPass.setText(null);
        }

        
        //Application.login();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new mobiclick.application.form.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jcbUser = new javax.swing.JComboBox<>();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login");
        panelLogin1.add(lbTitle);

        lbUser.setText("User Name");
        panelLogin1.add(lbUser);

        panelLogin1.add(jcbUser);

        lbPass.setText("Password");
        panelLogin1.add(lbPass);

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        panelLogin1.add(txtPass);

        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        panelLogin1.add(cmdLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        this.login();
    }//GEN-LAST:event_cmdLoginActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        this.login();
    }//GEN-LAST:event_txtPassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogin;
    private javax.swing.JComboBox<String> jcbUser;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private mobiclick.application.form.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
