package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Date;
import java.awt.EventQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.*;

import static java.sql.Date.valueOf;

public class RideBook extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_6;
	private JList <String> list;
	private ArrayList<RideAgenda> ridelist;
	private Controller controller;
	private JButton buttonReturn;

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
		contentPane.setLayout(new BorderLayout());

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
		
		list= new JList<String>(tableau);
		list.setBackground(new Color(224,255,255));;
		
		
		list.setBounds(0, 0, 349, 273);
		contentPane.add(list,BorderLayout.CENTER);


		
		
		/*lblNewLabel_6 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/CloudLogin.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img3));
		lblNewLabel_6.setBounds(-35, 2, 735, 398);
		contentPane.add(lblNewLabel_6);*/

		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
