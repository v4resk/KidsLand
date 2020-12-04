package View;



import java.awt.Color;
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Controller.*;



import javax.swing.JList;


public class RideBook extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_6;
	private JList <String> list;
	private ArrayList<RideAgenda> ridelist;
	private Controller controller;

	private JButton btnNewButton;
	private JButton btnNewButton_1;


	/**
	 * Create the frame.
	 */
	public RideBook(Controller controller, java.util.Date date) {
		this.controller=controller;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 349, 273);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Show available ride
		String pattern = "yyyy-MM-dd";
		DateFormat dFormat= new SimpleDateFormat(pattern);
		String strDate = dFormat.format(date);
		System.out.println(strDate);
		ridelist = controller.getAgenda().get(Date.valueOf(strDate));

		int size = ridelist.size();
		String [] tableau = new String [size];
		for(int i=0;i<size;i++)
		{
			tableau[i]=ridelist.get(i).getRide().getName();
		}
		
		btnNewButton = new JButton("Return");
		btnNewButton.setBounds(46, 209, 125, 29);
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new RideBookListener());
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Book Now");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(new Color(245, 245, 245));
		btnNewButton_1.setBounds(183, 209, 125, 29);
		contentPane.add(btnNewButton_1);
		
		list= new JList<String>(tableau);
		list.setBackground(new Color(224,255,255));;
		list.setBounds(0, 0, 349, 273);
		contentPane.add(list);
		/*lblNewLabel_6 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/CloudLogin.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img3));
		lblNewLabel_6.setBounds(-35, 2, 735, 398);
		contentPane.add(lblNewLabel_6);*/
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		

	}
	private class RideBookListener	implements ActionListener {
		
		
		public void actionPerformed (ActionEvent e)
		{
			if(e.getSource()==btnNewButton)
			{
				dispose();
			}
			
			if(e.getSource()==btnNewButton_1)
			{
				
			}
		}
	}
	
}
