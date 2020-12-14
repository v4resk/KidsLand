package View;

import java.awt.Color;


import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.ldap.StartTlsResponse;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import Controller.Controller;
import Controller.Person;
import Controller.Ride;
import Controller.RideAgenda;

import java.awt.Font;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;


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
	private DefaultListModel<String> modelAgendaRide;
	private JLabel title1;
	private JDialog testGraph;
	private JTextField textField;
	private JTextField textField_1;
	private JList<String> listUpdateRemove;
	private JButton addAgendaBtn;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private HashMap<Date, ArrayList<RideAgenda>> agenda;
	private JButton setButtonDeletUpdate;
	private JButton setButtonAddAgenda;
	private ArrayList<RideAgenda> ridelistForList;
	private JButton updateAgendPriceBtn;
	private JButton removeAgendaBtn;
	private boolean isListOk;
	private java.sql.Date sqlDate;
	private boolean isInRideList;
	private java.sql.Date sqlDate2;


	public EmployeeDesign(String email, Controller controller) {
		this.email=email;
		this.controller=controller;
		personList=controller.getPersonList();
		rideList=controller.getRideList();
		agenda = controller.getAgenda();
		isListOk = false;
		isInRideList = false;
		modelAgendaRide = new DefaultListModel<String>();
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
		statpanel.setBounds(200, 2, 498, 396);
		contentPane.add(statpanel);
		statpanel.setVisible(false);
		statpanel.setLayout(null);
		

		statpanel.removeAll();
<<<<<<< HEAD
		statpanel.add(createPieChart("Rides Statistics",rideList));
		this.setLocationRelativeTo(null);
		
=======
		statpanel.add(createPieChart("yes"));
		this.setLocationRelativeTo(null);
	
>>>>>>> 3d53c1f43ccb021dcc0766f081e5f0cecfcfc38d
		
		//---------------Agenda Panel---------------------------------------------


		agendapanel = new JPanel();
		agendapanel.setBounds(201, 2, 498, 396);
		contentPane.add(agendapanel);
		agendapanel.setVisible(false);
		agendapanel.setLayout(null);
<<<<<<< HEAD
		
		
=======

		dateChooser = new JDateChooser();
		dateChooser.setBounds(6, 62, 165, 26);
		agendapanel.add(dateChooser);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(262, 312, 138, 26);
		agendapanel.add(dateChooser_1);


		// List of rides who can be book
>>>>>>> 3d53c1f43ccb021dcc0766f081e5f0cecfcfc38d
		list1= new JList<String>(tableauRide);
		JScrollPane rideListScrollPane = new JScrollPane();
		rideListScrollPane.setBounds(261, 89, 211, 191);
		rideListScrollPane.setViewportView(list1);
		list1.setLayoutOrientation(JList.VERTICAL);
		agendapanel.add(rideListScrollPane);


		//----------------------FOR choos a date to update/remove-----------------------------
		// Select date;
		TimeEvaluator evaluator = new TimeEvaluator();
		for (Date i : agenda.keySet()){
			evaluator.add(i);
		}
		// Select the StartDate and EndDate
		Date minDate = Date.valueOf(LocalDate.now());
		Date maxDate = Collections.max(agenda.keySet());
		evaluator.setStartDate(minDate);
		evaluator.setEndDate(maxDate);
		dateChooser.getJCalendar().getDayChooser().addDateEvaluator(evaluator);
		//--------------------------------------------------------------------------------------
		//---------------------choose a date to add ride----------------------------------------
		TimeEvaluator_2 evaluator_add = new TimeEvaluator_2();
		evaluator_add.setStartDate(minDate);
		dateChooser_1.getJCalendar().getDayChooser().addDateEvaluator(evaluator_add);
		//--------------------------------------------------------------------------------------


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
		
		JLabel dateridetxt = new JLabel("Choose a date and a ride");
		dateridetxt.setBounds(7, 42, 165, 16);
		agendapanel.add(dateridetxt);
		
		removeAgendaBtn = new JButton("Delete");
		removeAgendaBtn.setBounds(6, 350, 117, 29);
		agendapanel.add(removeAgendaBtn);
		removeAgendaBtn.addActionListener(new EmployeeAgendaManaList());
		
		updateAgendPriceBtn = new JButton("Update");
		updateAgendPriceBtn.setBounds(113, 350, 117, 29);
		agendapanel.add(updateAgendPriceBtn);
		updateAgendPriceBtn.addActionListener(new EmployeeAgendaManaList());
		
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

		addAgendaBtn = new JButton("Add to agenda");
		addAgendaBtn.setBounds(284, 350, 165, 29);
		agendapanel.add(addAgendaBtn);
		
		setButtonDeletUpdate = new JButton("Set");
		setButtonDeletUpdate.setBounds(171, 62, 59, 29);
		agendapanel.add(setButtonDeletUpdate);
		setButtonDeletUpdate.addActionListener(new EmployeeAgendaManaList());
		
		setButtonAddAgenda = new JButton("Set");
		setButtonAddAgenda.setBounds(397, 313, 75, 26);
		agendapanel.add(setButtonAddAgenda);
		setButtonAddAgenda.addActionListener(new EmployeeAgendaManaList());






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
	private class EmployeeAgendaManaList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==setButtonAddAgenda){
				java.util.Date date = dateChooser_1.getDate();
				String pattern = "yyyy-MM-dd";
				DateFormat dFormat = new SimpleDateFormat(pattern);
				String strDate = dFormat.format(date);
				sqlDate2 = Date.valueOf(strDate);
				double prixDefault=0;
				for(int i=0; i<controller.getRideList().size() ; i++){
					if(controller.getRideList().get(i).getName().equals(list1.getSelectedValue()))
						prixDefault = controller.getRideList().get(i).getPrice();
				}
				controller.db_addAgenda(list1.getSelectedValue(),sqlDate2,prixDefault);
				JOptionPane.showMessageDialog(null,"Succes !");
			}
			if(e.getSource()==setButtonDeletUpdate){
				java.util.Date date = dateChooser.getDate();
				String pattern = "yyyy-MM-dd";
				DateFormat dFormat = new SimpleDateFormat(pattern);
				String strDate = dFormat.format(date);
				ridelistForList = controller.getAgenda().get(Date.valueOf(strDate));
				sqlDate = Date.valueOf(strDate);

				modelAgendaRide.removeAllElements();
				for(int i=0 ; i<ridelistForList.size() ; i++){
					modelAgendaRide.addElement(ridelistForList.get(i).getRide().getName());
				}
				listUpdateRemove.setModel(modelAgendaRide);
				isListOk = true;
			}
			if(e.getSource()==removeAgendaBtn){
				if(isListOk){
					JOptionPane.showMessageDialog(null,"Done");
					int index = listUpdateRemove.getSelectedIndex();
					controller.db_DeleteAgenda(listUpdateRemove.getSelectedValue(),sqlDate);
					modelAgendaRide.removeElementAt(index);
				}else
					JOptionPane.showMessageDialog(null,"Select a date before");
			}
			if(e.getSource()==updateAgendPriceBtn){
				if(isListOk || !textField.getText().isEmpty()){
					controller.db_UpdateRidePrice(listUpdateRemove.getSelectedValue(),sqlDate,Double.parseDouble(textField.getText()));
					JOptionPane.showMessageDialog(null,"Updated !");
				}
				else{
					JOptionPane.showMessageDialog(null,"Select a date before and put a price");
				}
			}
		}
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
					for (int i=0; i<controller.getRideList().size(); i++){
						if(rideList.get(i).getName().equals(nametxt.getText()))
							isInRideList = true;
					}
					if(!isInRideList) {
						controller.db_addRide(nametxt.getText(), Integer.parseInt(capacitytxt.getText()), Double.parseDouble(pricetxt.getText()));
						modelRide.addElement(nametxt.getText());
						listRide.setModel(modelRide);
						list1.setModel(modelRide);
					}
					else{
						JOptionPane.showMessageDialog(null,"Ride Already exist");
					}
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
	
	
	//---------------------------------Methods to create a PieChart with JFreeChart-----------------------
	
	 private ChartPanel createPieChart(String chartTitle, ArrayList <Ride> list) { 
	        PieDataset dataset = createDataset(list);
	        JFreeChart chart = createChart(dataset, chartTitle);
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setLocation(4, 2);
	        chartPanel.setSize(491, 392);
	        return chartPanel;
	    }

	    private PieDataset createDataset(ArrayList <Ride> list) {
	        DefaultPieDataset result = new DefaultPieDataset();
	        
	        for(int i=0;i<list.size();i++)
	        {
	        	result.setValue(list.get(i).getName(), controller.getTotalPlaceUsedRide(list.get(i).getName()));
	        }
	        
	        return result;

	    }

	    private JFreeChart createChart(PieDataset dataset, String title) {
	        JFreeChart chart = ChartFactory.createPieChart3D(
	            title, dataset, true, true, false);
	        PiePlot3D plot = (PiePlot3D) chart.getPlot();
	        plot.setStartAngle(290);
	        plot.setDirection(Rotation.CLOCKWISE);
	        plot.setForegroundAlpha(0.5f);
	        plot.setCircular(true);
	        return chart;

	    }
}
