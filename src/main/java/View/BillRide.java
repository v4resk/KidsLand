package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Controller.Guest;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BillRide extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;

	

	/**
	 * Create the frame.
	 */
	public BillRide(double pricetotal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("You have booked now now you have to pay");
		message.setBounds(87, 20, 275, 40);
		contentPane.add(message);
		
		JLabel lblNewLabel = new JLabel("Total : "+pricetotal+" €");
		lblNewLabel.setBounds(175, 250, 100, 16);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Pay and return ");
		btnNewButton.setBounds(159, 280, 117, 60);
		btnNewButton.addActionListener(new BillRideListener());
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/mastercard.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(138, 50, 53, 60);
		contentPane.add(lblNewLabel);
		
		lblNewLabel1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/visa.png")).getImage();
		lblNewLabel1.setIcon(new ImageIcon(img1));
		lblNewLabel1.setBounds(237, 50, 100, 60);
		contentPane.add(lblNewLabel1);
		
		textField = new JTextField();
		textField.setBounds(175, 121, 202, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(247, 159, 130, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(247, 197, 130, 26);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Card number");
		lblNewLabel_1.setBounds(50, 126, 100, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Expiration date");
		lblNewLabel_2.setBounds(50, 164, 100, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Cryptogram");
		lblNewLabel_3.setBounds(50, 202, 100, 16);
		contentPane.add(lblNewLabel_3);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
private class BillRideListener implements ActionListener {
		
		
		public void actionPerformed (ActionEvent e)
		{

			if(e.getSource()==btnNewButton)
			{
				dispose();

			}
			
			
			
		}
	}
}
