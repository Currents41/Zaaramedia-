package com.form;

import com.dao.KaryawanDAO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import com.model.ModelKaryawan;
import com.service.ServiceKaryawan;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FormSignUp extends javax.swing.JPanel {

    private ServiceKaryawan servis = new KaryawanDAO();
    
    public FormSignUp() {
        initComponents();
        setLayoutForm();
        add(pnGambar);
    }
    private void resetForm(){
        txtUser.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }
    
    private boolean validasiInput(){
        boolean valid = false;
        if(txtUser.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
        }else if(txtEmail.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Email tidak boleh kosong");
        }else if(txtPass.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
        }else{
            valid = true;
        }
        return valid;
    }
    
    private void prosesSignUp() {
    if (!validasiInput()) {
        return; 
    }

    String user = txtUser.getText().trim();
    String email = txtEmail.getText().trim();
    String telepon = txtTelepon.getText().trim();
    String pass = txtPass.getText().trim();
    String confirmPass = txtConPass.getText().trim(); 

    if (!pass.equals(confirmPass)) {
        JOptionPane.showMessageDialog(null, 
                "Konfirmasi password tidak cocok!", "Pesan", 
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    ModelKaryawan model = new ModelKaryawan();
    model.setNamaKaryawan(user);
    model.setEmailKaryawan(email);
    model.setTeleponKaryawan(telepon);
    model.setPasswordKaryawan(pass);

    boolean success = servis.prosesSignUp(model);

    if (success) {
        JOptionPane.showMessageDialog(null, 
                "Registrasi berhasil!", "Pesan", 
                JOptionPane.INFORMATION_MESSAGE);
        
        
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(FormSignUp.this);
        parent.setContentPane(new FormLogin());
        parent.revalidate();
        parent.repaint();
        
        resetForm(); 
    } else {
        JOptionPane.showMessageDialog(null, 
                "Registrasi gagal! Coba lagi.", "Pesan", 
                JOptionPane.ERROR_MESSAGE);
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSignUp = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbTitle2 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        lbPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtAsk = new javax.swing.JLabel();
        pnGambar = new javax.swing.JPanel();
        btnSignUp = new javax.swing.JButton();
        lbLogo = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        txtLogIn = new javax.swing.JButton();
        lbTelepon = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelepon = new javax.swing.JTextField();
        lbConPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtConPass = new javax.swing.JPasswordField();

        pnSignUp.setPreferredSize(new java.awt.Dimension(746, 466));

        lbTitle.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(0, 0, 0));
        lbTitle.setText("Sign Up to");

        lbTitle2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lbTitle2.setForeground(new java.awt.Color(0, 0, 0));
        lbTitle2.setText("Z A A R A  M E D I A");

        lbUser.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        lbUser.setForeground(new java.awt.Color(0, 0, 0));
        lbUser.setText("Username");

        lbPass.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        lbPass.setForeground(new java.awt.Color(0, 0, 0));
        lbPass.setText("Password");

        txtUser.setBackground(new java.awt.Color(195, 238, 240));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtAsk.setBackground(new java.awt.Color(255, 255, 255));
        txtAsk.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        txtAsk.setForeground(new java.awt.Color(0, 74, 173));
        txtAsk.setText("Already have an account?");

        pnGambar.setBackground(new java.awt.Color(195, 238, 240));
        pnGambar.setPreferredSize(new java.awt.Dimension(362, 466));

        javax.swing.GroupLayout pnGambarLayout = new javax.swing.GroupLayout(pnGambar);
        pnGambar.setLayout(pnGambarLayout);
        pnGambarLayout.setHorizontalGroup(
            pnGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        pnGambarLayout.setVerticalGroup(
            pnGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnSignUp.setBackground(new java.awt.Color(255, 176, 181));
        btnSignUp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(0, 0, 0));
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/logo_ZaaraMedia.png"))); // NOI18N

        lbEmail.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(0, 0, 0));
        lbEmail.setText("Email");

        txtLogIn.setForeground(new java.awt.Color(255, 176, 181));
        txtLogIn.setText("Log in");
        txtLogIn.setBorder(null);
        txtLogIn.setBorderPainted(false);
        txtLogIn.setContentAreaFilled(false);
        txtLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLogInMouseClicked(evt);
            }
        });

        lbTelepon.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        lbTelepon.setForeground(new java.awt.Color(0, 0, 0));
        lbTelepon.setText("Telepon");

        txtEmail.setBackground(new java.awt.Color(195, 238, 240));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtTelepon.setBackground(new java.awt.Color(195, 238, 240));
        txtTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeleponActionPerformed(evt);
            }
        });

        lbConPass.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        lbConPass.setForeground(new java.awt.Color(0, 0, 0));
        lbConPass.setText("Confirm password");

        txtPass.setBackground(new java.awt.Color(195, 238, 240));

        txtConPass.setBackground(new java.awt.Color(195, 238, 240));

        javax.swing.GroupLayout pnSignUpLayout = new javax.swing.GroupLayout(pnSignUp);
        pnSignUp.setLayout(pnSignUpLayout);
        pnSignUpLayout.setHorizontalGroup(
            pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSignUpLayout.createSequentialGroup()
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelepon)
                            .addComponent(txtUser)
                            .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnSignUpLayout.createSequentialGroup()
                                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(lbConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConPass)))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtAsk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLogIn)))
                .addGap(18, 18, 18)
                .addComponent(pnGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnSignUpLayout.setVerticalGroup(
            pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnSignUpLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTelepon)
                .addGap(2, 2, 2)
                .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbConPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtConPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addComponent(txtAsk, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addComponent(pnGambar, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 752, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        prosesSignUp();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLogInMouseClicked
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(FormSignUp.this);
        parent.setContentPane(new FormLogin()); 
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_txtLogInMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeleponActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel lbConPass;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTelepon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle2;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel pnGambar;
    private javax.swing.JPanel pnSignUp;
    private javax.swing.JLabel txtAsk;
    private javax.swing.JPasswordField txtConPass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JButton txtLogIn;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private void setLayoutForm() {
        setLayout(new FormSignUpLayout ());
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Masukkan nama lengkap");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Masukkan alamat Email");
        txtTelepon.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Masukkan nomor telepon");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Masukkan password");
        txtConPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, " Masukkan konfirmasi password");
        pnSignUp.setLayout(new SignUpLayout());
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "font:h1.font");
        pnSignUp.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Logn.background;" + "arc:20;" 
                + "border:30,40,50,30;");
        txtPass.putClientProperty(FlatClientProperties.STYLE, "" + "showRevealButton:true;" + "showCapsLock:true");
        txtConPass.putClientProperty(FlatClientProperties.STYLE, "" + "showRevealButton:true;" + "showCapsLock:true");
        btnSignUp.putClientProperty(FlatClientProperties.STYLE, "" + "borderWidth:0;" + "focusWidth:0;");
    }
    
    private class FormSignUpLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0,0);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0,0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            txtLogIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            txtLogIn.setOpaque(true);
            
            synchronized (parent.getTreeLock()) {
                int width = parent.getWidth();
                int height = parent.getHeight();
                int signUpWidth = UIScale.scale(400);
                int signUpHeight = UIScale.scale(450);
                int gambarWidth = UIScale.scale(300); 
            int gap = UIScale.scale(1); 

            int totalWidth = signUpWidth + gambarWidth + gap;
            int startX = (width - totalWidth) / 2; 
            int startY = (height - signUpHeight) / 2;
            
            pnSignUp.setBounds(startX, startY, signUpWidth, signUpHeight);
            pnGambar.setBounds(startX + signUpWidth + gap, startY, gambarWidth, signUpHeight);
            }
        }
        
    }


        private class SignUpLayout implements LayoutManager {
        private final int titleGap = 15;
        private final int textGap = 10;
        private final int labelGap = 5;
        private final int buttonGap = 20;

        @Override
        public void addLayoutComponent(String name, Component comp) {}

        @Override
        public void removeLayoutComponent(Component comp) {}

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int height = insets.top + insets.bottom;

                // Logo
                height += lbLogo.getPreferredSize().height;
                height += UIScale.scale(titleGap);

                // Title
                height += lbTitle.getPreferredSize().height;
                height += UIScale.scale(titleGap * 2);

                // Username field
                height += lbUser.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtUser.getPreferredSize().height;
                height += UIScale.scale(labelGap);

                // Email field
                height += lbEmail.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtEmail.getPreferredSize().height;
                height += UIScale.scale(labelGap);

                // Telepon field
                height += lbTelepon.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtTelepon.getPreferredSize().height;
                height += UIScale.scale(labelGap);

                // Password field
                height += lbPass.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtPass.getPreferredSize().height;
                height += UIScale.scale(labelGap);

                // Password field
                height += lbConPass.getPreferredSize().height;
                height += UIScale.scale(labelGap);
                height += txtConPass.getPreferredSize().height;
                height += UIScale.scale(labelGap);

                // Login button
                height += btnSignUp.getPreferredSize().height;
                height += UIScale.scale(textGap * 2);

                // Signup text
                height += txtLogIn.getPreferredSize().height;

//                return new Dimension(UIScale.scale(300), height);
                return new Dimension(700, 500);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return new Dimension(0, 0);
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);

                // Logo
                lbLogo.setBounds(x, y, width, lbLogo.getPreferredSize().height);
                y += lbLogo.getPreferredSize().height + UIScale.scale(labelGap);

                // Title
                lbTitle.setBounds(x, y, lbTitle.getPreferredSize().width, lbTitle.getPreferredSize().height);
                lbTitle2.setBounds(
                    x + lbTitle.getPreferredSize().width + UIScale.scale(titleGap), 
                    y,
                    lbTitle2.getPreferredSize().width,
                    lbTitle2.getPreferredSize().height
                );
                y += Math.max(lbTitle.getPreferredSize().height, lbTitle2.getPreferredSize().height) + UIScale.scale(titleGap);

                // Username
                lbUser.setBounds(x, y, width, lbUser.getPreferredSize().height);
                y += lbUser.getPreferredSize().height + UIScale.scale(labelGap);
                txtUser.setBounds(x, y, width, txtUser.getPreferredSize().height);
                y += txtUser.getPreferredSize().height + UIScale.scale(labelGap);

                // Email
                lbEmail.setBounds(x, y, width, lbEmail.getPreferredSize().height);
                y += lbEmail.getPreferredSize().height + UIScale.scale(labelGap);
                txtEmail.setBounds(x, y, width, txtEmail.getPreferredSize().height);
                y += txtEmail.getPreferredSize().height + UIScale.scale(labelGap);

                // Telepon
                lbTelepon.setBounds(x, y, width, lbTelepon.getPreferredSize().height);
                y += lbTelepon.getPreferredSize().height + UIScale.scale(labelGap);
                txtTelepon.setBounds(x, y, width, txtTelepon.getPreferredSize().height);
                y += txtTelepon.getPreferredSize().height + UIScale.scale(labelGap);

                // Password
                lbPass.setBounds(x, y, width, lbPass.getPreferredSize().height);
                y += lbPass.getPreferredSize().height + UIScale.scale(labelGap);
                txtPass.setBounds(x, y, width, txtPass.getPreferredSize().height);
                y += txtPass.getPreferredSize().height + UIScale.scale(labelGap);

                // Password
                lbConPass.setBounds(x, y, width, lbConPass.getPreferredSize().height);
                y += lbConPass.getPreferredSize().height + UIScale.scale(labelGap);
                txtConPass.setBounds(x, y, width, txtConPass.getPreferredSize().height);
                y += txtConPass.getPreferredSize().height + UIScale.scale(labelGap);

                // Signup text (kombinasi teks dan link)
                txtAsk.setBounds(x, y, txtAsk.getPreferredSize().width, txtAsk.getPreferredSize().height);
                txtLogIn.setBounds(x + txtAsk.getPreferredSize().width + UIScale.scale(titleGap), 
                    y,
                    txtLogIn.getPreferredSize().width,
                    txtLogIn.getPreferredSize().height
                );

                y += Math.max(txtAsk.getPreferredSize().height, txtLogIn.getPreferredSize().height) + UIScale.scale(buttonGap);
                // Sign Up Button
                btnSignUp.setBounds(x, y, width, btnSignUp.getPreferredSize().height);
            }
        }
    }
}
