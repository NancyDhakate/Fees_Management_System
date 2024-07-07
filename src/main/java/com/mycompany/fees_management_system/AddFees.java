/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fees_management_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author nancy
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public void displayCashFirst() {
        lbl_cheque_num.setVisible(false);
        lbl_dd_num.setVisible(false);
        txt_dd_num.setVisible(false);
        txt_cheque_num.setVisible(false);
        lbl_bankname.setVisible(false);
        txt_bankname.setVisible(false);
    }
    
    public String insertData()
    {
        int receiptno=Integer.parseInt(txt_receipt_num.getText());
        String sname=txt_receiver_name.getText();
        String rollno=txt_rollno.getText();
        String paymentmode=combo_modeof_payment.getSelectedItem().toString();
        String chequeno=txt_cheque_num.getText();
        String bankname=txt_bankname.getText();
        String ddno=txt_dd_num.getText();
        String coursename=combo_course.getSelectedItem().toString();
        String gst=txt_gst.getText();
        float total=Float.parseFloat(txt_total.getText());
        float amount=Float.parseFloat(txt_amount.getText());
        float cgst=Float.parseFloat(txt_cgst.getText());
        float sgst=Float.parseFloat(txt_sgst.getText());
        String totalinwords=txt_total_in_words.getText();
        String remark=txt_remark.getText();
        int year1=Integer.parseInt(fromyear.getText());
        int year2=Integer.parseInt(toyear.getText());
        String status="";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/fmsdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
             Connection con= java.sql.DriverManager.getConnection(url,"root","12345678");
             String sql = "INSERT INTO fees_details values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement st = con.prepareStatement(sql);
             st.setInt(1, receiptno);
             st.setString(2, sname);
             st.setString(3, rollno);
             st.setString(4, paymentmode);
             st.setString(5, chequeno);
             st.setString(6, bankname);
             st.setString(7, ddno);
             st.setString(8, coursename);
             st.setString(9, gst);
             st.setFloat(10, total);
             st.setFloat(11, amount);
             st.setFloat(12, cgst);
             st.setFloat(13, sgst);
             st.setString(14, totalinwords);
             st.setString(15, remark);
             st.setInt(16, year1);
             st.setInt(17, year2);
             int c=st.executeUpdate();
             
             if(c==1)
             {
                 status="success";
                 
             }
             else{
                 status="failed";
             }
             
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        
        return status;
        
    }

    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int r=getRnum();
        r++;
        txt_receipt_num.setText(Integer.toString(r));
    }
    
    public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	public static String convert(final int n) {
		if (n < 0) 
                {
			return "Minus " + convert(-n);
		}

		if (n < 20) 
                {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	public static void main(final String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Amount : ");
		int n=sc.nextInt();

		
		System.out.println( convert(n)+ " Only");

	
	}
}
    
    boolean validation()
    {
        if(txt_receiver_name.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please enter receiver's name ");
            return false;
        }
        if(txt_amount.getText().equals("")|| txt_amount.getText().matches("[0-9]+")==false)
        {
            JOptionPane.showMessageDialog(this,"Please enter amount(in numbers) ");
            return false;
        }
        if(combo_modeof_payment.getSelectedItem().toString().equalsIgnoreCase("cheque"))
        {
            if(txt_cheque_num.getText().equals(""))
                {
                        JOptionPane.showMessageDialog(this,"Please Enter Cheque Number ");
                        return false;
                } 
            
             if(txt_bankname.getText().equals(""))
                {
                        JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
                        return false;
                } 
            
        }
        if(combo_modeof_payment.getSelectedItem().toString().equalsIgnoreCase("dd"))
        {
            if(txt_dd_num.getText().equals(""))
                {
                        JOptionPane.showMessageDialog(this,"Please Enter DD Number ");
                        return false;
                } 
            
             if(txt_bankname.getText().equals(""))
                {
                        JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
                        return false;
                } 
            
        }
        return true;
    }
    
    public void fillComboBox()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/fmsdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
             Connection con= java.sql.DriverManager.getConnection(url,"root","12345678");
             String sql="Select cname from course";
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs=st.executeQuery(sql);
             while(rs.next())
             {
                 combo_course.addItem(rs.getString("cname"));
             }
             
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public int getRnum()
    {
        int rno=0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/fmsdatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
             Connection con= java.sql.DriverManager.getConnection(url,"root","12345678");
             String sql="Select max(reciept_no) from fees_details";
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs=st.executeQuery(sql);
             
             if(rs.next()==true)
             {
                 rno=rs.getInt(1);
             }
             
             
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rno;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_dd_num = new javax.swing.JLabel();
        lbl_mode_payment = new javax.swing.JLabel();
        lbl_cheque_num = new javax.swing.JLabel();
        txt_receipt_num = new javax.swing.JTextField();
        lbl_receipt_num = new javax.swing.JLabel();
        txt_cheque_num = new javax.swing.JTextField();
        txt_gst = new javax.swing.JLabel();
        lbl_gstin = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_rollno = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField9 = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_total_in_words = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_receiver_name = new javax.swing.JLabel();
        txt_receiver_name = new javax.swing.JTextField();
        txt_rollno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        toyear = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fromyear = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        combo_modeof_payment = new javax.swing.JComboBox<>();
        txt_dd_num = new javax.swing.JTextField();
        lbl_bankname = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JTextField();
        lbl_course = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton1.setText("Course List");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton2.setText("Search Record");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton3.setText("Edit Course");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton4.setText("Back");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton5.setText("Home");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton6.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton6.setText("View All Record");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton7.setText("LogOut");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButton9.setText("Add Course");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 720));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dd_num.setText("DD Num");
        jPanel2.add(lbl_dd_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        lbl_mode_payment.setText(" Mode of payment  :");
        jPanel2.add(lbl_mode_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        lbl_cheque_num.setText("Cheque Num :");
        jPanel2.add(lbl_cheque_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        txt_receipt_num.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_receipt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receipt_numActionPerformed(evt);
            }
        });
        jPanel2.add(txt_receipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 160, 30));

        lbl_receipt_num.setText("Receipt Number :");
        jPanel2.add(lbl_receipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txt_cheque_num.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_cheque_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheque_numActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cheque_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 160, 30));

        txt_gst.setText("ACV5644GRS");
        jPanel2.add(txt_gst, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        lbl_gstin.setText("GSTIN :");
        jPanel2.add(lbl_gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        lbl_rollno.setText("RollNo :");

        jLabel14.setText("Head");

        jLabel15.setText("SNo");

        jLabel16.setText("Amount");

        jTextField9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        txt_total.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        txt_amount.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });

        jLabel17.setText("CGST   7%");

        jLabel18.setText(" SGST  7%");

        txt_cgst.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });

        txt_sgst.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });

        jLabel19.setText("TOTAL");

        jLabel20.setText("Remark :");

        txt_total_in_words.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_total_in_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_in_wordsActionPerformed(evt);
            }
        });

        jLabel21.setText("Total in words :");

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        jLabel22.setText("Receiver's Signature");

        lbl_receiver_name.setText("Receiver's Name :");

        txt_receiver_name.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_receiver_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiver_nameActionPerformed(evt);
            }
        });

        jLabel1.setText("From Year ");

        toyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toyearActionPerformed(evt);
            }
        });

        jLabel2.setText("to");

        fromyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromyearActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 153, 153));
        jButton8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton8.setText("Print");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(31, 31, 31)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_in_words)))
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel15)
                .addGap(173, 173, 173)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(71, 71, 71))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_receiver_name)
                    .addComponent(lbl_rollno))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_rollno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(fromyear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toyear, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_receiver_name, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txt_sgst, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txt_cgst, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_receiver_name)
                    .addComponent(txt_receiver_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(toyear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(fromyear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_rollno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rollno, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total_in_words, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(45, 45, 45)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addGap(38, 38, 38))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 570, 500));

        combo_modeof_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CASH", "PHONEPAY", "CHEQUE" }));
        combo_modeof_payment.setSelectedIndex(1);
        combo_modeof_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_modeof_paymentActionPerformed(evt);
            }
        });
        jPanel2.add(combo_modeof_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 160, 30));

        txt_dd_num.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_dd_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dd_numActionPerformed(evt);
            }
        });
        jPanel2.add(txt_dd_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 160, 30));

        lbl_bankname.setText("Bank Name :");
        jPanel2.add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        txt_bankname.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        txt_bankname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_banknameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 160, 30));

        lbl_course.setText("Course:");
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        jPanel2.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 143, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, -30, 600, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_receipt_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receipt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receipt_numActionPerformed

    private void txt_cheque_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheque_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheque_numActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void txt_receiver_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiver_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiver_nameActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
       
        String s1=txt_amount.getText();
        float amt=Float.parseFloat(s1);
        
        float cgst=amt*0.07f;
        float sgst=amt*0.07f;
        
        txt_cgst.setText(Float.toString(cgst));
        txt_sgst.setText(Float.toString(sgst));
        
        float t= amt+cgst+sgst;
        
        txt_total.setText(Float.toString(t));
        
        txt_total_in_words.setText(NumberToWordsConverter.convert((int)t));
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_total_in_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_in_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_in_wordsActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

      if(validation()==true)
      {
          String s=insertData();
          if(s.equals("success"))
          {
              JOptionPane.showMessageDialog(this, "Record inserted successully");
          }
          else{
              JOptionPane.showMessageDialog(this, "Record not inserted");
          }
      }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_dd_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dd_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dd_numActionPerformed

    private void combo_modeof_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_modeof_paymentActionPerformed
        // TODO add your handling code here:
        if (combo_modeof_payment.getSelectedIndex() == 0) {
            lbl_dd_num.setVisible(true);
            txt_dd_num.setVisible(true);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);
            lbl_cheque_num.setVisible(false);
            txt_cheque_num.setVisible(false);
            lbl_receiver_name.setVisible(true);
            txt_receiver_name.setVisible(true);
        }
        if (combo_modeof_payment.getSelectedIndex() == 1) {
            lbl_cheque_num.setVisible(false);
            lbl_dd_num.setVisible(false);
            txt_dd_num.setVisible(false);
            txt_cheque_num.setVisible(false);
            lbl_bankname.setVisible(false);
            txt_bankname.setVisible(false);
            lbl_receiver_name.setVisible(true);
            txt_receiver_name.setVisible(true);

        }
        if (combo_modeof_payment.getSelectedIndex() == 3) {
            lbl_cheque_num.setVisible(true);
            lbl_dd_num.setVisible(false);
            txt_dd_num.setVisible(false);
            txt_cheque_num.setVisible(true);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);
            lbl_receiver_name.setVisible(true);
            txt_receiver_name.setVisible(true);

        }


    }//GEN-LAST:event_combo_modeof_paymentActionPerformed

    private void txt_banknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_banknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_banknameActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed

     String s1=combo_course.getSelectedItem().toString();
             jTextField9.setText(s1);


        // TODO add your handling code here:
    }//GEN-LAST:event_combo_courseActionPerformed

    private void toyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toyearActionPerformed

    private void fromyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromyearActionPerformed

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_modeof_payment;
    private javax.swing.JTextField fromyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_cheque_num;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_dd_num;
    private javax.swing.JLabel lbl_gstin;
    private javax.swing.JLabel lbl_mode_payment;
    private javax.swing.JLabel lbl_receipt_num;
    private javax.swing.JLabel lbl_receiver_name;
    private javax.swing.JLabel lbl_rollno;
    private javax.swing.JTextField toyear;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque_num;
    private javax.swing.JTextField txt_dd_num;
    private javax.swing.JLabel txt_gst;
    private javax.swing.JTextField txt_receipt_num;
    private javax.swing.JTextField txt_receiver_name;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_in_words;
    // End of variables declaration//GEN-END:variables
}
