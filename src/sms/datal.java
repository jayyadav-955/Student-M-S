package sms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sms.db.dbConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.IOException;

public class datal {

	JFrame frame;
	private JTable table;
	private JTable table_6;
	private JTextField tf1;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf2;
	JComboBox comboBox;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datal window = new datal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public datal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1069, 789);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBounds(217, 525, 85, 21);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readData();
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(344, 143, 549, 480);
		frame.getContentPane().add(table);
		
		JButton btnNewButton_1 = new JButton("INSERT");
		btnNewButton_1.setBounds(217, 431, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q ="Insert Into student values(?,?,?,?,?)";
				
				try {
					PreparedStatement ps = dbConnection.dbConn().prepareStatement(q);
					ps.setInt(1, Integer.parseInt(tf1.getText()));
					ps.setString(2,tf2.getText());
					ps.setInt(3, Integer.parseInt(tf3.getText()));
					ps.setString(4,tf4.getText());
					ps.setString(5,tf5.getText());
					ps.execute();
					readData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("RollNo");
		lblNewLabel.setBounds(82, 66, 55, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFullname = new JLabel("Full_Name");
		lblFullname.setBounds(82, 133, 55, 35);
		frame.getContentPane().add(lblFullname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(82, 203, 55, 35);
		frame.getContentPane().add(lblAge);
		
		JLabel lblDivision = new JLabel("Division");
		lblDivision.setBounds(82, 264, 55, 35);
		frame.getContentPane().add(lblDivision);
		
		JLabel lblSname = new JLabel("Sname");
		lblSname.setBounds(82, 330, 55, 35);
		frame.getContentPane().add(lblSname);
		
		table_6 = new JTable();
		table_6.setBounds(344, 121, 549, 16);
		table_6.setForeground(Color.WHITE);
		table_6.setBackground(Color.BLUE);
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{"Rollno", "FuLL_Name", "Age", "Division", "Sname"},
			},
			new String[] {
				"Rollno", "FuLL_Name", "Age", "Division", "Sname"
			}
		));
		frame.getContentPane().add(table_6);
		
		tf1 = new JTextField();
		tf1.setBounds(139, 74, 125, 27);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(139, 211, 125, 27);
		tf3.setColumns(10);
		frame.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setBounds(139, 272, 125, 27);
		tf4.setColumns(10);
		frame.getContentPane().add(tf4);
		
		tf5 = new JTextField();
		tf5.setBounds(139, 338, 125, 27);
		tf5.setColumns(10);
		frame.getContentPane().add(tf5);
		
		tf2 = new JTextField();
		tf2.setBounds(139, 137, 125, 27);
		tf2.setColumns(10);
		frame.getContentPane().add(tf2);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DE="Delete  from student where rollno = ?";
				try {
					PreparedStatement ps = dbConnection.dbConn().prepareStatement(DE);
					ps.setInt(1, Integer.parseInt(tf1.getText()));
					ps.execute();
					readData();
					readData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(81, 431, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectItem = (int)comboBox.getSelectedItem();
				
				String q ="Select * from student where rollno =?";
				try {
					PreparedStatement ps = dbConnection.dbConn().prepareStatement(q);
					ps.setInt(1, selectItem);
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
					tf1.setText(String.valueOf(selectItem));
					tf2.setText(rs.getString(2));
					tf3.setText(String.valueOf(3));
					tf4.setText(rs.getString(4));
					tf5.setText(rs.getString(5));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(70, 10, 232, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q ="Update student set full_name=?,age =?,division=?,sname=? where rollno =?";
				try {
					PreparedStatement ps = dbConnection.dbConn().prepareStatement(q);
					ps.setString(1, tf2.getText());
					ps.setInt(2, Integer.parseInt(tf3.getText()));
					ps.setString(3, tf4.getText());
					ps.setString(4, tf5.getText());
					ps.setInt(5, Integer.parseInt(tf1.getText()));
					
					ps.execute();
					readData();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.setBounds(81, 525, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setBounds(431, 71, 64, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String se =textField.getText();
				
				String q ="Select * from student where full_name =?";
				try {
					PreparedStatement ps = dbConnection.dbConn().prepareStatement(q);
					ps.setString(1, se);
					
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField.setBounds(523, 66, 342, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton Print = new JButton("print");
		Print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		Print.setForeground(Color.WHITE);
		Print.setBackground(Color.BLUE);
		Print.setBounds(144, 599, 85, 21);
		frame.getContentPane().add(Print);
		
		JButton btnShutdown = new JButton("Off\r\n");
		btnShutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int timer=Integer.parseInt(JOptionPane.showInputDialog(btnShutdown, "Set Time:"));
				
				try {
					Runtime.getRuntime().exec("Shutdown -s -t "+timer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShutdown.setForeground(Color.WHITE);
		btnShutdown.setBackground(Color.RED);
		btnShutdown.setBounds(796, 682, 85, 21);
		frame.getContentPane().add(btnShutdown);
		fillComboBox();
		
	}
	void fillComboBox() {
		String q="Select * from student";
		try {
			Statement stmt = dbConnection.dbConn().createStatement();
			ResultSet rs =stmt.executeQuery(q);
			
			while(rs.next()) {
				comboBox.addItem(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void readData() {
		String q ="Select * from student";
		Statement stmt;
		try {
			stmt = dbConnection.dbConn().createStatement();
			ResultSet rs=stmt.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
