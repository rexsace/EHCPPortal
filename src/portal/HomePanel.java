package portal;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePanel {
	private JLabel display;
	
	public HomePanel() {
		display = new JLabel("Hi! This is the EHCP Portal.");
		display.setBounds(150, 10, 300, 30);
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
	
	public void display(JPanel panel) {
		panel.add(display);
	}
}
