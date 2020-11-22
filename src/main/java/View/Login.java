package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(224, 255, 255)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(175, 150, 350, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(0, 6, 350, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(224, 255, 255)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(175, 220, 350, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBounds(0, 5, 350, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color (0, 0, 255));
		btnNewButton.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton.setBounds(225, 275, 250, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(175, 122, 150, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(175, 200, 150, 16);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Not yet registered, register now");
		btnNewButton_1.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton_1.setBounds(225, 325, 250, 35);
		btnNewButton_1.addActionListener(new LoginListener());
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("X");
		btnNewButton_2.setBounds(660, 6, 34, 29);
		btnNewButton_2.addActionListener(new LoginListener());
		contentPane.add(btnNewButton_2);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	private class LoginListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e) {
			Object button =e.getSource();
			Object buttonClose = e.getSource();
			
			if(button == btnNewButton_1) {
				GuestOrSignUp frame = new GuestOrSignUp();
				frame.setVisible(true);
			}
			
			if (buttonClose == btnNewButton_2) {
				dispose();
			}
			
			
			
		}
		
		
	}
}
