package sms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import sms.db.dbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Color;

public class login {

	private JFrame frmLoginPage;
	private JTextField tf;
	private JTextField pf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 909, 528);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(67, 172, 317, 36);
		frmLoginPage.getContentPane().add(tf);
		tf.setColumns(10);
		
		pf = new JTextField();
		pf.setBounds(67, 278, 317, 36);
		frmLoginPage.getContentPane().add(pf);
		pf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Email Id");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(67, 149, 94, 13);
		frmLoginPage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(67, 255, 94, 13);
		frmLoginPage.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q= "Select * from users where username=? and pass =?";
				try {
					PreparedStatement ps=dbConnection.dbConn().prepareStatement(q);
					ps.setString(1,tf.getText());
					ps.setString(2,pf.getText());
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton,"Login Successfull");
						datal window = new datal();
						window.frame.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton,"Not Match usernname and password");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(153, 385, 85, 21);
		frmLoginPage.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(119, 136, 153));
		lblNewLabel_2.setBackground(new Color(240, 248, 255));
		lblNewLabel_2.setLabelFor(frmLoginPage);
		lblNewLabel_2.setBounds(0, 0, 906, 491);
		frmLoginPage.getContentPane().add(lblNewLabel_2);
	}
}
