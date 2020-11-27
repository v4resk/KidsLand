package View;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private Controller controller;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	public Login(Controller controller) {
		this.controller = controller;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton.setBounds(80, 275, 250, 35);
		btnNewButton.addActionListener(new LoginCheckListener());
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(50, 130, 150, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(50, 210, 150, 16);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Not yet registered, register now");
		btnNewButton_1.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setBounds(80, 325, 250, 35);
		btnNewButton_1.addActionListener(new LoginListener());
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("X");
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.setBounds(645, 2,50,50);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.addActionListener(new LoginListener());
		contentPane.add(btnNewButton_2);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(50, 230, 350, 25);
		contentPane.add(textField_1);
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Passwrd.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img1));
		lblNewLabel_3.setBounds(20, 228, 24, 24);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(50, 150, 350, 25);
		contentPane.add(textField_2);
		
		lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(423, 63, 250, 297);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Pers.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img2));
		lblNewLabel_5.setBounds(20, 150, 24, 24);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/CloudLogin.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img3));
		lblNewLabel_6.setBounds(-35, 2, 735, 398);
		contentPane.add(lblNewLabel_6);
		
		
		setUndecorated(true);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	
	private class LoginListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e) {
			Object button =e.getSource();
			Object buttonClose = e.getSource();
			
			if(button == btnNewButton_1) {
				dispose();
				GuestOrSignUp frame = new GuestOrSignUp(controller);
			} 
			
			if (buttonClose == btnNewButton_2) {
				dispose();
			}
			
			
			
		}
	}

	private class LoginCheckListener implements ActionListener{

		
		public void actionPerformed(ActionEvent actionEvent) {
				if(controller.signIn_check(textField_2.getText(),String.valueOf(textField_1.getPassword()))) {
				if (controller.isAnEmployee(textField_2.getText()))
				{
					JOptionPane.showMessageDialog(null,"LogIn as Employee");
					new Calendar();
				}
				else {
					JOptionPane.showMessageDialog(null,"LogIn as Member");
					new Calendar();
				}
					
				
			}
				else
					JOptionPane.showMessageDialog(null,"LOGIN FAIL","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
}
