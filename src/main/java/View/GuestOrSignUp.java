package View;

import Controller.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;



public class GuestOrSignUp extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private Controller controller;
	

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public GuestOrSignUp(Controller controller) {
		this.controller = controller;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Register");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton.addActionListener(new GuestOrSignUpListener());
		btnNewButton.setBounds(225, 150, 250, 35);
		contentPane.add(btnNewButton);
		
		btnNewButton1 = new JButton("Continue as guest");
		btnNewButton1.setForeground(new Color(0, 0, 0));
		btnNewButton1.setBackground(new Color(245, 245, 245));
		btnNewButton1.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton1.setBounds(225, 275, 250, 35);
		btnNewButton1.addActionListener(new GuestOrSignUpListener());
		contentPane.add(btnNewButton1);
		
		btnNewButton_2 = new JButton("Return");
		btnNewButton_2.setBounds(609, 6, 85, 29);
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new GuestOrSignUpListener());
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Cloud1.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(235, 0, 465, 400);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/Cloud1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(0, 0, 357, 400);
		contentPane.add(lblNewLabel);
		

		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class GuestOrSignUpListener implements ActionListener {
		
		
		public void actionPerformed (ActionEvent e)
		{

			if(e.getSource()== btnNewButton_2)
			{
				dispose();
				new Login(controller);
			}
			else if(e.getSource() == btnNewButton)
			{
				dispose();
				new Register(controller);
			}
			
			else if(e.getSource()==btnNewButton1)
			{
				dispose();
				new Calendar(new Guest(),2);
			}
		}

		
		
	}

}
