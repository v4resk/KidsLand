package View;

import Controller.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private Controller controller;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Register(Controller controller) {
		this.controller = controller;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(175, 95, 350, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel lblNewLabel1 = new JLabel("First Name");
		
		textField1 = new JTextField();
		textField1.setBorder(null);
		textField1.setBounds(175, 195, 350, 20);
		textField1.setColumns(10);
		contentPane.add(textField1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(175, 145, 350, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(175, 245, 350, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JPasswordField();
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(175, 295, 350, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(300, 35, 100, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("REGISTER NOW");
		btnNewButton.setBounds(250, 350, 200, 30);
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new RegisterListener());
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(175, 75, 100, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(175, 125, 100, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date of Birth (AAAA-MM-DD)");
		lblNewLabel_1_1_1.setBounds(175, 175, 209, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email Adress");
		lblNewLabel_1_1_1_1.setBounds(175, 225, 100, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Password");
		lblNewLabel_1_1_1_2.setBounds(175, 277, 100, 20);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		btnNewButton_2 = new JButton("Return");
		btnNewButton_2.setBounds(609, 6, 85, 29);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new RegisterListener());
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/CloudLogin.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(0, 0, 711, 413);
		contentPane.add(lblNewLabel_3);

		
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);

		
	}
	
	
private class RegisterListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e) {

			Object buttonClose = e.getSource();

			if(buttonClose== btnNewButton_2)
			{
				new GuestOrSignUp(controller);
				dispose();
				
			}
			else if(e.getSource()==btnNewButton){
				if(!(textField.getText().isEmpty() || textField1.getText().isEmpty()
						|| textField_1.getText().isEmpty()
				|| textField_2 .getText().isEmpty() || String.valueOf(textField_3.getPassword()).isEmpty())){


					controller.db_addMember(textField_1.getText(),textField.getText(), Date.valueOf(textField1.getText()),textField_2.getText(),String.valueOf(textField_3.getPassword()));
					JOptionPane.showMessageDialog(null,"sign up successfully");
					Person member = controller.getPerson(textField_2.getText());
					new Calendar(member,1);
				}else{
					JOptionPane.showMessageDialog(null,"All fields need to be fill","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			
		}
	}
}
