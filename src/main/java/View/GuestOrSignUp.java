package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;



public class GuestOrSignUp extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestOrSignUp frame = new GuestOrSignUp();
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
	public GuestOrSignUp() {
		
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
		btnNewButton.setBackground(new Color (0, 0, 255));
		btnNewButton.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton.addActionListener(new GuestOrSignUpListener());
		btnNewButton.setBounds(225, 150, 250, 35);
		contentPane.add(btnNewButton);
		
		btnNewButton1 = new JButton("Continue as guest");
		btnNewButton1.setForeground(new Color(0, 0, 0));
		btnNewButton1.setBackground(new Color (0, 0, 255));
		btnNewButton1.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton1.setBounds(225, 275, 250, 35);
		btnNewButton1.addActionListener(new GuestOrSignUpListener());
		contentPane.add(btnNewButton1);
		
		btnNewButton_2 = new JButton("Return");
		btnNewButton_2.setBounds(609, 6, 85, 29);
		btnNewButton_2.addActionListener(new GuestOrSignUpListener());
		contentPane.add(btnNewButton_2);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	private class GuestOrSignUpListener implements ActionListener {
		
		
		public void actionPerformed (ActionEvent e)
		{
			
			Object buttonRegister =e.getSource();
			Object buttonClose = e.getSource();
			
			if(buttonClose== btnNewButton_2)
			{
				dispose();
			}
			
			if(buttonRegister == btnNewButton)
			{
				Register frame = new Register();
				frame.setVisible(true);
			}
		}

		
		
	}

}
