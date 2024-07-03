/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fees_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import static javax.swing.UIManager.getInt;



/**
 *
 * @author nancy
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }

    int id=0;
    int getId() throws ClassNotFoundException
   {
       ResultSet rs=null;
       try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/fmsdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
             Connection con= DriverManager.getConnection(url,"root","12345678");
             String sql="Select max(id) from signup";
             Statement st = con.createStatement();
             rs=st.executeQuery(sql);
             
             while(rs.next()) 
             {
                id = rs.getInt(1);
                id++;// This properly gets the current max id and increments it by 1
             } 
         }  
       catch (SQLException e) 
        {
            e.printStackTrace();
        } 
      
        return id;
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtCPassword = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        txtUname = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblcpassworderror = new javax.swing.JLabel();
        lblpassworderror = new javax.swing.JLabel();
        lblcnumerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setText("SignUp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 80));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("First Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, 20));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Last Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, 20));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, 20));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, 20));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, 20));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Contact Number");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 20));

        txtContact.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });
        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactKeyTyped(evt);
            }
        });
        getContentPane().add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 170, 30));

        txtFname.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 170, 30));

        txtLname.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 170, 30));

        txtCPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        getContentPane().add(txtCPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 170, 30));

        txtPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 170, 30));

        txtUname.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        txtUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 170, 30));

        btnClear.setBackground(new java.awt.Color(153, 204, 255));
        btnClear.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        btnSignUp.setBackground(new java.awt.Color(153, 204, 255));
        btnSignUp.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnSignUp.setText("SignUp");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        btnLogin.setBackground(new java.awt.Color(153, 204, 255));
        btnLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        lblcpassworderror.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblcpassworderror.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblcpassworderror, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 140, 20));

        lblpassworderror.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblpassworderror.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblpassworderror, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 140, 20));

        lblcnumerror.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblcnumerror.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblcnumerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 307, 130, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactActionPerformed

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void txtUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
                 txtFname.setText("");
                 txtLname.setText("");
                 txtUname.setText("");
                 txtPassword.setText("");
                 txtCPassword.setText("");
                 txtContact.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
           // TODO add your handling code here:
           validation();
           
           if(validation())
           {
               insertData();
           }
           else
           {
               JOptionPane.showMessageDialog(this,"Validation Issue");
           }
          
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        passwordCheck();
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        passwordCheck();
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:
        passwordCheck();
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyPressed
        // TODO add your handling code here:
        mobileCheck();
    }//GEN-LAST:event_txtContactKeyPressed

    private void txtContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyReleased
        // TODO add your handling code here:
        mobileCheck();
    }//GEN-LAST:event_txtContactKeyReleased

    private void txtContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyTyped
        // TODO add your handling code here:
        mobileCheck();
    }//GEN-LAST:event_txtContactKeyTyped

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        Login l1=new Login();
        l1.show();
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed
   
     String fname,lname,uname,password,cpassword,contact;
     
     void insertData()
     {
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/fmsdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
             Connection con= DriverManager.getConnection(url,"root","12345678");
             
             String sql="Insert into signup values(?,?,?,?,?,?)";
             PreparedStatement st =con.prepareStatement(sql);
             
             st.setInt(1,getId());
             st.setString(2,fname);
             st.setString(3,lname);
             st.setString(4,uname);
             st.setString(5,password);
             st.setString(6,contact);
             int i=st.executeUpdate();
             if(i>0)
             {
                 JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
             }
             else
             {
                 JOptionPane.showMessageDialog(this,"Record not Inserted Successfully");
             }
             
             
             
             
             
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }
     
     boolean validation()
             {
                 fname=txtFname.getText();
                 lname=txtLname.getText();
                 uname=txtUname.getText();
                 password=txtPassword.getText();
                 cpassword=txtCPassword.getText();
                 contact=txtContact.getText();
                 
                 if(fname.equals(""))
                 {
                    JOptionPane.showMessageDialog(this, "Please enter First Name : ");
                    return false;
                 }
                  if(lname.equals(""))
                 {
                    JOptionPane.showMessageDialog(this, "Please enter Last Name : ");
                    return false;
                 }
                   if(uname.equals(""))
                 {
                    JOptionPane.showMessageDialog(this, "Please enter User Name : ");
                    return false;
                 }
                    if(password.equals(""))
                 {
                    JOptionPane.showMessageDialog(this, "Please enter Password : ");
                    return false;
                 }
                     if(cpassword.equals(""))
                 {
                    JOptionPane.showMessageDialog(this, "Please enter Confirm Password : ");
                    return false;
                 }
                      if(contact.equals(""))
                 {
                    JOptionPane.showMessageDialog(this, "Please enter Contact : ");
                    return false;
                 }
                      return true;
                 
             }
     
     void passwordCheck()
     {
         password=txtPassword.getText();
         if(password.length()>=8)
         {
             lblpassworderror.setText("");
         }
         else
         {
             lblpassworderror.setText("Enter 8 digit number.");
         }
     }
     
     void mobileCheck()
     {
         contact=txtContact.getText();
         if(contact.length()==10)
         {
             lblcnumerror.setText("");
         }
         else
         {
             lblcnumerror.setText("Enter 10 digit phone number");
         }
     }
     
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcnumerror;
    private javax.swing.JLabel lblcpassworderror;
    private javax.swing.JLabel lblpassworderror;
    private javax.swing.JPasswordField txtCPassword;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
