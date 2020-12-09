package View;



import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Controller.*;
import javax.swing.JList;
import java.awt.Font;

public class RideBook extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_6;
	private JList<String> list;
	private ArrayList<RideAgenda> ridelist;
	private Controller controller;

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private int tChild = 0;
	private int tYoung = 0;
	private int tRegular = 0;
	private int tSenior = 0;
	private java.sql.Date sqlDate;
	private Person person;


	/**
	 * Create the frame.
	 */
	public RideBook(Controller controller, java.util.Date date, int tChild, int tYoung, int tRegular, int tSenior, Person person) {
		this.person = person;
		this.controller = controller;
		this.tChild = tChild;
		this.tRegular = tRegular;
		this.tYoung = tYoung;
		this.tSenior = tSenior;

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Show available ride
		String pattern = "yyyy-MM-dd";
		DateFormat dFormat = new SimpleDateFormat(pattern);
		String strDate = dFormat.format(date);
		System.out.println(strDate);
		ridelist = controller.getAgenda().get(Date.valueOf(strDate));
		sqlDate = Date.valueOf(strDate);


		int size = ridelist.size();
		String[] tableau = new String[size];
		for (int i = 0; i < size; i++) {
			tableau[i] = ridelist.get(i).getRide().getName();
		}

		btnNewButton = new JButton("Return");
		btnNewButton.setBounds(50, 490, 150, 40);
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new RideBookListener());
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Book Now");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(245, 245, 245));
<<<<<<< HEAD
		btnNewButton_1.setBounds(200, 490, 150, 40);
		contentPane.add(btnNewButton_1);
		
		list= new JList<String>(/*tableau*/);
		list.setBackground(new Color(224,255,255));;
		list.setBounds(6, 6, 388, 250);
=======
		btnNewButton_1.setBounds(183, 209, 125, 29);
		btnNewButton_1.addActionListener(new RideBookListener());
		contentPane.add(btnNewButton_1);

		list = new JList<String>(tableau);
		list.setBackground(new Color(224, 255, 255));
		;
		list.setBounds(0, 0, 349, 273);
>>>>>>> caa8230ff3b2ef549a507d674c4e97264f504b17
		contentPane.add(list);
		
		JLabel tickettxt = new JLabel("Ticket");
		tickettxt.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		tickettxt.setBounds(52, 270, 60, 16);
		contentPane.add(tickettxt);
		
		JLabel numbertxt = new JLabel("Number");
		numbertxt.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		numbertxt.setBounds(200, 270, 61, 16);
		contentPane.add(numbertxt);
		
		JLabel pricetxt = new JLabel("Price");
		pricetxt.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		pricetxt.setBounds(312, 270, 51, 16);
		contentPane.add(pricetxt);
		
		JLabel normaltxt = new JLabel("Normal (No Reduce)");
		normaltxt.setBounds(50, 298, 138, 16);
		contentPane.add(normaltxt);
		
		JLabel childtxt = new JLabel("Child (-30%)");
		childtxt.setBounds(50, 326, 125, 16);
		contentPane.add(childtxt);
		
		JLabel youngtxt = new JLabel("Young (-15%)");
		youngtxt.setBounds(50, 354, 125, 16);
		contentPane.add(youngtxt);
		
		JLabel seniortxt = new JLabel("Senior (-10%)");
		seniortxt.setBounds(50, 382, 125, 16);
		contentPane.add(seniortxt);
		
		JLabel linetxt = new JLabel("--------------------------------------");
		linetxt.setBounds(50, 410, 313, 16);
		contentPane.add(linetxt);
		
		JLabel totaltxt = new JLabel("Total");
		totaltxt.setBounds(50, 438, 125, 16);
		contentPane.add(totaltxt);
		
		JLabel normalnumbertxt = new JLabel("0");
		normalnumbertxt.setBounds(200, 298, 61, 16);
		contentPane.add(normalnumbertxt);
		
		JLabel childnumbertxt = new JLabel("0");
		childnumbertxt.setBounds(200, 326, 61, 16);
		contentPane.add(childnumbertxt);
		
		JLabel youngnumbertxt = new JLabel("0");
		youngnumbertxt.setBounds(200, 354, 61, 16);
		contentPane.add(youngnumbertxt);
		
		JLabel seniornumbertxt = new JLabel("0");
		seniornumbertxt.setBounds(200, 382, 61, 16);
		contentPane.add(seniornumbertxt);
		
		JLabel totalnumbertxt = new JLabel("0");
		totalnumbertxt.setBounds(200, 438, 61, 16);
		contentPane.add(totalnumbertxt);
		
		JLabel pricenormaltxt = new JLabel("0 €");
		pricenormaltxt.setBounds(312, 298, 61, 16);
		contentPane.add(pricenormaltxt);
		
		JLabel pricechildtxt = new JLabel("0 €");
		pricechildtxt.setBounds(312, 326, 61, 16);
		contentPane.add(pricechildtxt);
		
		JLabel priceyoungtxt = new JLabel("0 €");
		priceyoungtxt.setBounds(312, 354, 61, 16);
		contentPane.add(priceyoungtxt);
		
		JLabel priceseniortxt = new JLabel("0 €");
		priceseniortxt.setBounds(312, 382, 61, 16);
		contentPane.add(priceseniortxt);
		
		JLabel totalpricetxt = new JLabel("0 €");
		totalpricetxt.setBounds(312, 438, 61, 16);
		contentPane.add(totalpricetxt);

		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);


	}

	private class RideBookListener implements ActionListener {


		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNewButton) {
				dispose();
			}
			if (e.getSource() == btnNewButton_1) {

				String rideTxt = list.getSelectedValue();
				RideAgenda rideAgenda = null;
				for (int i = 0; i < controller.getAgenda().get(sqlDate).size(); i++) {
					if (controller.getAgenda().get(sqlDate).get(i).getRide().getName().equals(rideTxt))
						rideAgenda = controller.getAgenda().get(sqlDate).get(i);
				}


				if (controller.canIBook(tChild + tRegular + tYoung + tSenior, sqlDate, rideAgenda)) {
					if (tChild > 0) {
						if (person.bookARide(sqlDate, rideAgenda, tChild, "Child")) ;
						System.out.println("ChildBooked");

					}
					if (tSenior > 0) {
						person.bookARide(sqlDate, rideAgenda, tSenior, "Senior");
						System.out.println("SeniorBooked");
					}
					if (tYoung > 0) {
						person.bookARide(sqlDate, rideAgenda, tYoung, "Young");
						System.out.println("YoungBooked");
					}
					if (tRegular > 0) {
						person.bookARide(sqlDate, rideAgenda, tRegular, "Normal");
						System.out.println("NormalBooked");
					}
				} else
					JOptionPane.showMessageDialog(null, "Not enough place to book");


				if (e.getSource() == btnNewButton_1) {

				}
			}
		}

	}
<<<<<<< HEAD
}
=======
}
>>>>>>> caa8230ff3b2ef549a507d674c4e97264f504b17
