package View;

import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.ldap.StartTlsResponse;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Controller.Controller;
import Controller.Person;
import Controller.Ride;
import Controller.RideAgenda;

import java.awt.Font;

public class EmployeeDesign extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private String email;
	private JButton memberGestionBtn;
	private JButton rideGestionBtn;
	private JButton agendaGestionBtn;
	private JButton statBtn;
	private JButton returnBtn;
	private JLabel lblNewLabel_1;
	private JPanel memberpanel;
	private Controller controller;
	private JPanel statpanel;
	private JPanel agendapanel;
	private JPanel ridepanel;
	private JList <String> list;
	private ArrayList<Person> personList;
	private JList <String> list1;
	private ArrayList <Ride> rideList;
	private JLabel title;
	private JButton addBtn;
	private JButton removeBtn;
	private JTextField nametxt;
	private JTextField capacitytxt;
	private JTextField pricetxt;
	private JButton removeuser;
	private DefaultListModel<String> model;
	private JLabel title1;



	public EmployeeDesign(String email, Controller controller) {
		this.email=email;
		this.controller=controller;
		personList=controller.getPersonList();
		rideList=controller.getRideList();
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		int size = personList.size();
		String[] tableau = new String[size];
		model = new DefaultListModel();
		for (int i = 0; i < size; i++) {
			if(!personList.get(i).getEmail().equals("Guest"))
			tableau[i] = personList.get(i).getEmail();
			model.addElement(tableau[i]);
		}
		
		int size1 = rideList.size();
		String[] tableauRide = new String[size];
		for (int i = 0; i < size1; i++) {
			tableauRide[i] = rideList.get(i).getName();
		}
		
		

		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(2, 2, 200, 396);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 39, 160, 160);
		Image img = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		panel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel);
		
		
		memberGestionBtn = new JButton("Member Gestion");
		memberGestionBtn.setBounds(10, 180, 180, 40);
		memberGestionBtn.addActionListener(new EmployeeDesignListener());
		panel.add(memberGestionBtn);

		rideGestionBtn = new JButton("Ride Gestion");
		rideGestionBtn.setBounds(10, 222, 180, 40);
		rideGestionBtn.addActionListener(new EmployeeDesignListener());
		panel.add(rideGestionBtn);
		
		agendaGestionBtn = new JButton("Agenda Gestion");
		agendaGestionBtn.setBounds(10, 264, 180, 40);
		agendaGestionBtn.addActionListener(new EmployeeDesignListener());
		panel.add(agendaGestionBtn);
		
		statBtn = new JButton("Statistics");
		statBtn.setBounds(10, 306, 180, 40);
		statBtn.addActionListener(new EmployeeDesignListener());
		panel.add(statBtn);
		
		returnBtn = new JButton("Return");
		returnBtn.setBounds(10, 348, 180, 40);
		returnBtn.addActionListener(new EmployeeDesignListener());
		panel.add(returnBtn);
		
		
		//---------------Member Panel---------------------------------------------
		
		memberpanel = new JPanel();
		memberpanel.setBounds(201, 2, 498, 396);
		contentPane.add(memberpanel);
		memberpanel.setVisible(false);
		memberpanel.setLayout(null);
		
		list = new JList<String>(tableau);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 261, 384);
		scrollPane.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		memberpanel.add(scrollPane);
		
		removeuser = new JButton("Remove this user");
		removeuser.setBounds(310, 186, 150, 29);
		memberpanel.add(removeuser);
		removeuser.addActionListener(new EmployeeUserManaList());
		
		
		//---------------Stat Panel-----------------------------------------------
		
		statpanel = new JPanel();
		statpanel.setBounds(201, 2, 498, 396);
		contentPane.add(statpanel);
		statpanel.setVisible(false);
		
		//---------------Agenda Panel---------------------------------------------
		
		agendapanel = new JPanel();
		agendapanel.setBounds(201, 2, 498, 396);
		contentPane.add(agendapanel);
		agendapanel.setVisible(false);
		agendapanel.setLayout(null);
		
		list1= new JList<String>(tableauRide);
		list1.setBounds(188, 69, 153, 153);
		agendapanel.add(list1);
		
		title1 = new JLabel("Agenda Management");
		title1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		title1.setBounds(171, 5, 165, 20);
		agendapanel.add(title1);
		
		
		
		
		//---------------Ride Panel------------------------------------------------
		
		ridepanel = new JPanel();
		ridepanel.setBounds(201, 2, 498, 396);
		contentPane.add(ridepanel);
		ridepanel.setVisible(false);
		ridepanel.setLayout(null);
		
		title = new JLabel("Ride Management");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		title.setBounds(175, 26, 148, 25);
		ridepanel.add(title);
		
		addBtn = new JButton("Add new ride");
		addBtn.setBounds(50, 343, 150, 29);
		ridepanel.add(addBtn);
		addBtn.addActionListener(new EmployeeRideManaList());
		
		removeBtn = new JButton("Remove this ride");
		removeBtn.setBounds(311, 343, 150, 29);
		ridepanel.add(removeBtn);
		removeBtn.addActionListener(new EmployeeRideManaList());
		
		nametxt = new JTextField();
		nametxt.setBounds(50, 120, 170, 30);
		ridepanel.add(nametxt);
		nametxt.setColumns(10);
		
		capacitytxt = new JTextField();
		capacitytxt.setColumns(10);
		capacitytxt.setBounds(50, 200, 170, 30);
		ridepanel.add(capacitytxt);
		
		pricetxt = new JTextField();
		pricetxt.setColumns(10);
		pricetxt.setBounds(50, 280, 170, 30);
		ridepanel.add(pricetxt);
		
		JLabel lblNewLabel_3 = new JLabel("Name of the ride");
		lblNewLabel_3.setBounds(50, 90, 150, 20);
		ridepanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Capacity of the new ride");
		lblNewLabel_3_1.setBounds(50, 177, 170, 20);
		ridepanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Price of the new ride");
		lblNewLabel_3_2.setBounds(50, 258, 150, 20);
		ridepanel.add(lblNewLabel_3_2);


		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(291, 75, 183, 259);
		ridepanel.add(scrollPane1);
		

		
		
		
		//---------------Panel Welcome(Content Panel)---------------------------------------------
		
		lblNewLabel_2 = new JLabel("Welcome  " + this.email);
		lblNewLabel_2.setFont(new Font("Skia", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(214, 6, 412, 105);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("Loged in as employee");
		lblNewLabel_1.setFont(new Font("Skia", Font.BOLD, 19));
		lblNewLabel_1.setBounds(214, 78, 234, 105);
		contentPane.add(lblNewLabel_1);
		
		
	
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	private class EmployeeUserManaList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if(actionEvent.getSource()==removeuser){
				controller.db_DeleteMember(list.getSelectedValue());


				int index = list.getSelectedIndex();
				model.removeElementAt(index);
				list.setModel(model);

			}
		}
	}

	private class EmployeeRideManaList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if(actionEvent.getSource() == removeBtn){

			}else if(actionEvent.getSource() == addBtn){

			}
		}
	}
	
	private class EmployeeDesignListener implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==memberGestionBtn)
			{
				
				memberpanel.setVisible(true);
				agendapanel.setVisible(false);
				ridepanel.setVisible(false);
				statpanel.setVisible(false);
				
				
			}
			
			if(e.getSource()==agendaGestionBtn)
			{
				
				//memberpanel.setVisible(false);
				agendapanel.setVisible(true);
				ridepanel.setVisible(false);
				//statpanel.setVisible(false);
				
			}
			
			if(e.getSource()==rideGestionBtn)
			{
				memberpanel.setVisible(false);
				agendapanel.setVisible(false);
				ridepanel.setVisible(true);
				statpanel.setVisible(false);
			}
			
			if(e.getSource()==statBtn)
			{
				memberpanel.setVisible(false);
				agendapanel.setVisible(false);
				ridepanel.setVisible(false);
				statpanel.setVisible(true);
			}
			
			if(e.getSource()==returnBtn)
			{
				dispose();
				new Login(controller);
			}
			
		}
		
	}
}
