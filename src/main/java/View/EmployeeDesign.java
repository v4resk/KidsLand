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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;


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
	private JList<String> listRide;
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
	private DefaultListModel<String> modelUser;
	private DefaultListModel<String> modelRide;
	private JLabel title1;
	private JDialog testGraph;
	private JTextField textField;
	private JTextField textField_1;
	private JList<String> listUpdateRemove;
	private JButton addAgendaBtn;



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
		modelUser = new DefaultListModel();
		for (int i = 0; i < size; i++) {
			if(!personList.get(i).getEmail().equals("Guest"))
			tableau[i] = personList.get(i).getEmail();
			modelUser.addElement(tableau[i]);
		}
		
		int size1 = rideList.size();
		String[] tableauRide = new String[size];
		modelRide = new DefaultListModel();
		for (int i = 0; i < size1; i++) {
			tableauRide[i] = rideList.get(i).getName();
			modelRide.addElement(tableauRide[i]);
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

		
		// List of rides who can be book
		list1= new JList<String>(tableauRide);
		JScrollPane rideListScrollPane = new JScrollPane();
		rideListScrollPane.setBounds(261, 89, 211, 191);
		agendapanel.add(rideListScrollPane);
		

		listUpdateRemove = new JList<String>();
		JScrollPane updateAndRemoveScrollPane = new JScrollPane();
		updateAndRemoveScrollPane.setBounds(6, 92, 224, 191);
		updateAndRemoveScrollPane.setViewportView(listUpdateRemove);
		listUpdateRemove.setLayoutOrientation(JList.VERTICAL);
		agendapanel.add(updateAndRemoveScrollPane);
		
		title1 = new JLabel("Agenda Management");
		title1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		title1.setBounds(171, 5, 165, 20);
		agendapanel.add(title1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(6, 62, 224, 26);
		agendapanel.add(dateChooser);
		
		JLabel dateridetxt = new JLabel("Choose a date and a ride");
		dateridetxt.setBounds(7, 42, 165, 16);
		agendapanel.add(dateridetxt);
		
		JButton removeAgendaBtn = new JButton("Delete");
		removeAgendaBtn.setBounds(6, 350, 117, 29);
		agendapanel.add(removeAgendaBtn);
		
		JButton updateAgendPriceBtn = new JButton("Update");
		updateAgendPriceBtn.setBounds(113, 350, 117, 29);
		agendapanel.add(updateAgendPriceBtn);
		
		textField = new JTextField();
		textField.setBounds(6, 312, 224, 26);
		agendapanel.add(textField);
		textField.setColumns(10);
		
		JLabel priceUpdateTxt = new JLabel("Update the price:");
		priceUpdateTxt.setBounds(6, 295, 184, 16);
		agendapanel.add(priceUpdateTxt);
		
		JLabel lblNewLabel_3 = new JLabel("Choose a date and a ride");
		lblNewLabel_3.setBounds(259, 66, 211, 16);
		agendapanel.add(lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(262, 312, 211, 26);
		agendapanel.add(dateChooser_1);
		
		
		list1= new JList<String>(tableauRide);
		list1.setBounds(262, 89, 207, 191);
		agendapanel.add(list1);
		list1.setLayoutOrientation(JList.VERTICAL);
		
		addAgendaBtn = new JButton("Add to agenda");
		addAgendaBtn.setBounds(284, 350, 165, 29);
		agendapanel.add(addAgendaBtn);
		

		
		
		
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
		
		JLabel lblNewLabelRide = new JLabel("Name of the ride");
		lblNewLabelRide.setBounds(50, 90, 150, 20);
		ridepanel.add(lblNewLabelRide);
		
		JLabel lblNewLabel_3_1 = new JLabel("Capacity of the new ride");
		lblNewLabel_3_1.setBounds(50, 177, 170, 20);
		ridepanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Price of the new ride");
		lblNewLabel_3_2.setBounds(50, 258, 150, 20);
		ridepanel.add(lblNewLabel_3_2);

		listRide = new JList<String>(tableauRide);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(291, 75, 183, 259);
		scrollPane1.setViewportView(listRide);
		listRide.setLayoutOrientation(JList.VERTICAL);
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

		
		public void actionPerformed(ActionEvent actionEvent) {
			if(actionEvent.getSource()==removeuser){
				controller.db_DeleteMember(list.getSelectedValue());

				int index = list.getSelectedIndex();
				modelUser.removeElementAt(index);
				list.setModel(modelUser);
				

			}
		}
	}

	private class EmployeeRideManaList implements ActionListener{

	
		public void actionPerformed(ActionEvent actionEvent) {
			if(actionEvent.getSource() == removeBtn){
				controller.db_DeleteRide(listRide.getSelectedValue());

				int index = listRide.getSelectedIndex();
				modelRide.removeElementAt(index);
				listRide.setModel(modelRide);
				list1.setModel(modelRide);
			}else if(actionEvent.getSource() == addBtn){
				if(!(nametxt.getText().isEmpty() || pricetxt.getText().isEmpty() || capacitytxt.getText().isEmpty())){
					controller.db_addRide(nametxt.getText(),Integer.parseInt(capacitytxt.getText()),Double.parseDouble(pricetxt.getText()));
					modelRide.addElement(nametxt.getText());
					listRide.setModel(modelRide);
					list1.setModel(modelRide);
				}else
					JOptionPane.showMessageDialog(null,"All fields need to be fill","ERROR",JOptionPane.ERROR_MESSAGE);

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
				
				memberpanel.setVisible(false);
				agendapanel.setVisible(true);
				ridepanel.setVisible(false);
				statpanel.setVisible(false);
				
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
