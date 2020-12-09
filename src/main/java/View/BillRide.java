package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class BillRide extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public BillRide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("textHighlight"), 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
