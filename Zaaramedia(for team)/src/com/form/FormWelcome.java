package com.form;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;


public class FormWelcome extends javax.swing.JPanel {

    public FormWelcome() {
        initComponents();
        setLayoutForm();
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.add(panel);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.setSize(frame.getSize());
                panel.revalidate();
                panel.repaint();
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnWelcome = new javax.swing.JPanel();
        lbChoose = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        pnWelcome.setPreferredSize(new java.awt.Dimension(845, 677));

        lbChoose.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbChoose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbChoose.setText("Please select one of these");

        btnLogIn.setText("Login");
        btnLogIn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        btnSignUp.setText("Sign Up");
        btnSignUp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        jLabel1.setText("WELCOME TO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/logo_welcome.png"))); // NOI18N

        jLabel3.setText("Z A A R A M E D I A");

        jLabel4.setText("AL-QUR'AN DAN BUKU ISLAM");

        javax.swing.GroupLayout pnWelcomeLayout = new javax.swing.GroupLayout(pnWelcome);
        pnWelcome.setLayout(pnWelcomeLayout);
        pnWelcomeLayout.setHorizontalGroup(
            pnWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnWelcomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
            .addGroup(pnWelcomeLayout.createSequentialGroup()
                .addGroup(pnWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnWelcomeLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(lbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnWelcomeLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel4))
                    .addGroup(pnWelcomeLayout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel3))
                    .addGroup(pnWelcomeLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel2))
                    .addGroup(pnWelcomeLayout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        pnWelcomeLayout.setVerticalGroup(
            pnWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnWelcomeLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addComponent(lbChoose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(FormWelcome.this);
        parent.setContentPane(new FormLogin());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(FormWelcome.this);
        parent.setContentPane(new FormSignUp());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_btnSignUpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbChoose;
    private javax.swing.JPanel pnWelcome;
    // End of variables declaration//GEN-END:variables

    public void setLayoutForm() {
        setLayout(new BorderLayout());

        pnWelcome.setLayout(new GridBagLayout());
        pnWelcome.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        jLabel1.setFont(new Font("Arial", Font.BOLD, 50));
        pnWelcome.add(jLabel1, gbc);

        gbc.gridy++;
        pnWelcome.add(jLabel2, gbc);

        gbc.gridy++;
        jLabel3.setFont(new Font("Arial", Font.BOLD, 25));
        pnWelcome.add(jLabel3, gbc);

        gbc.gridy++;
        jLabel4.setFont(new Font("Arial", Font.PLAIN, 28));
        pnWelcome.add(jLabel4, gbc);

        gbc.gridy++;
        lbChoose.setFont(new Font("Arial", Font.PLAIN, 20));
        pnWelcome.add(lbChoose, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER; 

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        styleButton(btnLogIn);
        styleButton(btnSignUp);
        buttonPanel.add(btnLogIn);
        buttonPanel.add(btnSignUp);

        pnWelcome.add(buttonPanel, gbc);

        add(pnWelcome, BorderLayout.CENTER);
        btnLogIn.setVisible(true);
        btnSignUp.setVisible(true);
        pnWelcome.revalidate();
        pnWelcome.repaint();
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setPreferredSize(new Dimension(120, 40));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(20),  
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        button.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(0, 120, 220)); 
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);

                super.paint(g, c);
            }
        });
    }

    private static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(0, 120, 220)); 
            g2.setStroke(new BasicStroke(2)); 
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
