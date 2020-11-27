package View;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;

import Controller.Controller;


import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JButton;

public class Calendar extends JFrame {

	private JPanel contentPane;
	private JLabel labelDecor;
	private JSlider slider;
	private JButton btnNewButton_2;
	private Controller controller;
	


	/**
	 * Create the frame.
	 */
	public Calendar() {
	
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
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(1);
		slider_1.setToolTipText("");
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMaximum(5);
		slider_1.setMajorTickSpacing(1);
		slider_1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider_1.setBackground(SystemColor.windowText);
		slider_1.setBounds(365, 70, 150, 46);
		contentPane.add(slider_1);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(0);
		slider_2.setToolTipText("");
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMaximum(5);
		slider_2.setMajorTickSpacing(1);
		slider_2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider_2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider_2.setBackground(SystemColor.windowText);
		slider_2.setBounds(195, 70, 150, 46);
		contentPane.add(slider_2);
		
		JSlider slider_3 = new JSlider();
		slider_3.setValue(0);
		slider_3.setToolTipText("");
		slider_3.setSnapToTicks(true);
		slider_3.setPaintTicks(true);
		slider_3.setPaintLabels(true);
		slider_3.setMaximum(5);
		slider_3.setMajorTickSpacing(1);
		slider_3.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		slider_3.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		slider_3.setBackground(SystemColor.windowText);
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
		lblNewLabel_1.setBounds(225, 50, 106, 16);
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
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(20, 148, 525, 229);
		contentPane.add(calendar);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setBounds(554, 150, 117, 225);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Return");
		btnNewButton_2.setBounds(609, 6, 85, 29);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new CalendarListener());
		btnNewButton_2.setBackground(new Color(245, 245, 245));
		contentPane.add(btnNewButton_2);
		
		labelDecor = new JLabel("");
		labelDecor.setIcon(new ImageIcon(theme));
		labelDecor.setBounds(-21, 0, 735, 398);
		contentPane.add(labelDecor);
		
		setUndecorated(true);
		setLocationRelativeTo(null);

		setVisible(true);
	}
	
	private class CalendarListener implements ActionListener{
		
		public void actionPerformed (ActionEvent e)
		{
			if(e.getSource()==btnNewButton_2)
			{
				new Login(controller);
				dispose();
				
			}
		}
	}
}
