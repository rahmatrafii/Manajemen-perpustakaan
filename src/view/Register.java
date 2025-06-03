package view;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Dimension;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import model.Anggota;
import model.User;
import services.AuthService;
import session.Session;
import utils.JsonUtil;
import validation.AuthValidation;

public class Register extends javax.swing.JFrame {

    public Register() {
        User anggota = Session.getCurrentUser();
        if (anggota != null) {
            if (anggota.getRole().equals("ANGGOTA")) {
                new AnggotaDashboard().setVisible(true);
            } else if (anggota.getRole().equals("ADMIN")) {
                new AnggotaDashboard().setVisible(true);
            }
            this.dispose();
            return;
        }
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        registerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        registerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        registerScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(217, 217, 217); // warna batang
                this.trackColor = new Color(255, 255, 255); // warna jalur
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }

            @Override
            public Dimension getPreferredSize(JComponent c) {
                return new Dimension(5, super.getPreferredSize(c).height);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisKelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        registerScroll = new javax.swing.JScrollPane();
        Right = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fullNameInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkLakiLaki = new javax.swing.JRadioButton();
        checkPerempuan = new javax.swing.JRadioButton();
        passwordInput = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        moveToRegisterPage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(165, 214, 167));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 600));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo-perpus.png"))); // NOI18N

        name.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        name.setForeground(new java.awt.Color(27, 94, 32));
        name.setText("Taman Pustaka");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(logo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(name)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registerScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        registerScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        registerScroll.setPreferredSize(new java.awt.Dimension(450, 600));

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(450, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Register");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Full Name");

        userNameInput.setBackground(new java.awt.Color(217, 217, 217));
        userNameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userNameInput.setForeground(new java.awt.Color(0, 0, 0));
        userNameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8));
        userNameInput.setMargin(new java.awt.Insets(6, 6, 6, 6));
        userNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameInputActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Username");

        fullNameInput.setBackground(new java.awt.Color(217, 217, 217));
        fullNameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fullNameInput.setForeground(new java.awt.Color(0, 0, 0));
        fullNameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8));
        fullNameInput.setMargin(new java.awt.Insets(6, 6, 6, 6));
        fullNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameInputActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Password");

        emailInput.setBackground(new java.awt.Color(217, 217, 217));
        emailInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailInput.setForeground(new java.awt.Color(0, 0, 0));
        emailInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8));
        emailInput.setMargin(new java.awt.Insets(6, 6, 6, 6));
        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Jenis Kelamin");

        checkLakiLaki.setBackground(new java.awt.Color(255, 255, 255));
        jenisKelamin.add(checkLakiLaki);
        checkLakiLaki.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkLakiLaki.setForeground(new java.awt.Color(0, 0, 0));
        checkLakiLaki.setText("Laki-Laki");
        checkLakiLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLakiLakiActionPerformed(evt);
            }
        });

        checkPerempuan.setBackground(new java.awt.Color(255, 255, 255));
        jenisKelamin.add(checkPerempuan);
        checkPerempuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkPerempuan.setForeground(new java.awt.Color(0, 0, 0));
        checkPerempuan.setText("Perempuan");
        checkPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPerempuanActionPerformed(evt);
            }
        });

        passwordInput.setBackground(new java.awt.Color(217, 217, 217));
        passwordInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordInput.setForeground(new java.awt.Color(0, 0, 0));
        passwordInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 8, 5, 8));

        registerBtn.setBackground(new java.awt.Color(102, 187, 106));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("already a member?");

        moveToRegisterPage.setBackground(new java.awt.Color(255, 255, 255));
        moveToRegisterPage.setForeground(new java.awt.Color(102, 102, 255));
        moveToRegisterPage.setText("login now");
        moveToRegisterPage.setBorder(null);
        moveToRegisterPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moveToRegisterPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveToRegisterPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveToRegisterPage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailInput)
                            .addComponent(userNameInput)
                            .addComponent(fullNameInput)
                            .addComponent(passwordInput)
                            .addGroup(RightLayout.createSequentialGroup()
                                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(checkPerempuan)
                                    .addComponent(checkLakiLaki)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(0, 217, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkLakiLaki)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkPerempuan)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moveToRegisterPage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        registerScroll.setViewportView(Right);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameInputActionPerformed

    private void fullNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameInputActionPerformed

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void checkLakiLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLakiLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkLakiLakiActionPerformed

    private void checkPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPerempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPerempuanActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String fullName = this.fullNameInput.getText();
        String userName = this.userNameInput.getText();
        String email = this.emailInput.getText();
        String jenisKelamin;
        if (checkLakiLaki.isSelected()) {
            jenisKelamin = "Laki-Laki";
        } else if (checkPerempuan.isSelected()) {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = null;
        }
        String password = new String(passwordInput.getPassword());

        String err = AuthService.register(fullName, userName, email, jenisKelamin, password);

        if (err != null) {
            JOptionPane.showMessageDialog(null, err, "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Register Success!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_registerBtnActionPerformed

    private void moveToRegisterPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveToRegisterPageActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_moveToRegisterPageActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Right;
    private javax.swing.JRadioButton checkLakiLaki;
    private javax.swing.JRadioButton checkPerempuan;
    private javax.swing.JTextField emailInput;
    private javax.swing.JTextField fullNameInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup jenisKelamin;
    private javax.swing.JLabel logo;
    private javax.swing.JButton moveToRegisterPage;
    private javax.swing.JLabel name;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JButton registerBtn;
    private javax.swing.JScrollPane registerScroll;
    private javax.swing.JTextField userNameInput;
    // End of variables declaration//GEN-END:variables
}
