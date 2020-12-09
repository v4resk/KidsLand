package View;


import java.awt.Color;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import javax.swing.border.MatteBorder;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.DebugGraphics;

import java.awt.Font;
import java.sql.Date;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import com.toedter.calendar.JCalendar;


import Controller.*;



import javax.swing.JButton;


public class Calendar extends JFrame {

	private JPanel contentPane;
	private JLabel labelDecor;
	private JSlider slider;
	private JButton btnNewButton_2;
	private Controller controller;
	private Member member;
	private Guest guest;
	private Employee employee;
	private JButton btnNewButton;
	private int id; // 1=membre , 2=guest, 3=employee
	private HashMap<Date, ArrayList<RideAgenda>> agenda;
	private JCalendar calendar;
	private JSlider slider_1;
	private JSlider slider_2;
	private JSlider slider_3;
	private Person person;


	/**
	 * Create the frame.
	 */
	public Calendar(Person person, int id) {

		this.person = person;
		controller = person.getController();
		agenda = controller.getAgenda();
		this.id=id;

		if(this.id==1){
			member = new Member(person.getName(),person.getFirstName(),person.getAge(),person.getEmail());
			member.setController(person.getController());
			guest = null;
			employee = null;

		}
		if(this.id==2){
			guest = new Guest();
			guest.setController(person.getController());
			employee = null;
			member = null;
		}
		if(this.id==3){
			employee = new Employee(person.getName(),person.getFirstName(),person.getAge(),person.getEmail());
			employee.setController(person.getController());
			member = null;
			guest = null;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image theme = new ImageIcon(this.getClass().getResource("/CloudLogin.png")).getImage();
		
		slider = new JSlider();
		slider.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setToolTipText("");
		slider.setValue(0);
		slider.setMaximum(5);
		slider.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider.setOpaque(false);
		slider.setBounds(15, 70, 150, 46);
		contentPane.add(slider);
		
		slider_1 = new JSlider();
		slider_1.setValue(1);
		slider_1.setToolTipText("");
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMaximum(5);
		slider_1.setMajorTickSpacing(1);
		slider_1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider_1.setOpaque(false);
		slider_1.setBounds(365, 70, 150, 46);
		contentPane.add(slider_1);
		
		slider_2 = new JSlider();
		slider_2.setValue(0);
		slider_2.setToolTipText("");
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMaximum(5);
		slider_2.setMajorTickSpacing(1);
		slider_2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider_2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider_2.setOpaque(false);
		slider_2.setBounds(195, 70, 150, 46);
		contentPane.add(slider_2);
		
		slider_3 = new JSlider();
		slider_3.setValue(0);
		slider_3.setToolTipText("");
		slider_3.setSnapToTicks(true);
		slider_3.setPaintTicks(true);
		slider_3.setPaintLabels(true);
		slider_3.setMaximum(5);
		slider_3.setMajorTickSpacing(1);
		slider_3.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider_3.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider_3.setOpaque(false);
		slider_3.setBounds(535, 70, 150, 46);
		contentPane.add(slider_3);
		
		JLabel lblNewLabel = new JLabel("Child (3-11)");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel.setBounds(45, 50, 100, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Young (12-25)");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(215, 50, 120, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Regular");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_2.setBounds(410, 50, 60, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Senior (65+)");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_3.setBounds(565, 50, 100, 16);
		contentPane.add(lblNewLabel_3);
		
		
		calendar = new JCalendar();
		calendar.setBounds(20, 148, 525, 229);
		contentPane.add(calendar);
		

		btnNewButton = new JButton("Availabilities");
		btnNewButton.addActionListener(new CalendarListener());
		btnNewButton.setBounds(554, 150, 117, 225);
		btnNewButton.setFont(new Font("Monaco", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(245, 245, 245));
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Return");
		btnNewButton_2.setBounds(609, 6, 85, 29);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new CalendarListener());
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		contentPane.add(btnNewButton_2);
		
		labelDecor = new JLabel("");
		labelDecor.setIcon(new ImageIcon(theme));
		labelDecor.setBounds(-21, 0, 735, 398);
		contentPane.add(labelDecor);
		
		setUndecorated(true);
		setLocationRelativeTo(null);

		// Disable some Date in agenda
		TimeEvaluator evaluator = new TimeEvaluator();
		for (Date i : agenda.keySet()){
			evaluator.add(i);
		}

		// Select the StartDate and EndDate
		Date minDate = Date.valueOf(LocalDate.now());
		Date maxDate = Collections.max(agenda.keySet());
		evaluator.setStartDate(minDate);
		evaluator.setEndDate(maxDate);
		calendar.getDayChooser().addDateEvaluator(evaluator);

		//Refresh
		calendar.setCalendar(calendar.getCalendar());



		setVisible(true);

		if(this.id==1)
			System.out.println("Register as"+member.getEmail());
		if(this.id==3)
			System.out.println("Register as"+employee.getEmail());

	}
	
	private class CalendarListener implements ActionListener{

		public void actionPerformed (ActionEvent e)
		{
			
			if(e.getSource()==btnNewButton_2)
			{
				new Login(controller);
				dispose();
			}

			else if(e.getSource()==btnNewButton) {
				new RideBook(controller,calendar.getDate(),slider.getValue(),slider_2.getValue(),slider_1.getValue(),slider_3.getValue(),person,id);
			}
		}
		

	}
}
