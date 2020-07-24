package portal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class MainPortal {

	private JFrame frame;
	private JPanel display_panel;
	private JPanel menu_panel;
	
	private HomePanel home_panel;
	private ContactPanel contact_panel;
	private EventPanel event_panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPortal window = new MainPortal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPortal() {
		home_panel = new HomePanel();
		contact_panel = new ContactPanel();
		event_panel = new EventPanel();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 816, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		menu_panel = new JPanel();
		menu_panel.setBackground(new Color(102, 205, 170));
		springLayout.putConstraint(SpringLayout.NORTH, menu_panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menu_panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, menu_panel, 441, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, menu_panel, 173, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(menu_panel);
		
		display_panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, display_panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, display_panel, 6, SpringLayout.EAST, menu_panel);
		springLayout.putConstraint(SpringLayout.SOUTH, display_panel, 441, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, display_panel, 802, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(display_panel);
		display_panel.setLayout(null);
		
		
		setHomePanel(display_panel);
		
		JButton search_info = new JButton("Search contact info");
		search_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSearchInfoPanel(display_panel);
			}
		});
		menu_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton home = new JButton("Home");
		home.setFont(new Font("Tahoma", Font.PLAIN, 14));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHomePanel(display_panel);
			}
		});
		menu_panel.add(home);
		menu_panel.add(search_info);
		
		JButton search_event = new JButton("Search seminar");
		search_event.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSearchEventPanel(display_panel);
			}
		});
		search_event.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menu_panel.add(search_event);
		
	}
	
	private void setHomePanel(JPanel panel) {
		panel.removeAll();
		this.home_panel.display(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	private void setSearchInfoPanel(JPanel panel) {
		panel.removeAll();
		this.contact_panel.display(panel);
		panel.revalidate();
		panel.repaint();
	}
	
	private void setSearchEventPanel(JPanel panel) {
		panel.removeAll();
		this.event_panel.display(panel);
		panel.revalidate();
		panel.repaint();
	}
}
