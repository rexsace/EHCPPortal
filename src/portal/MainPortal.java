package portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainPortal {

	private JFrame frame;
	private JTextField fname_in;
	private JTextField lname_in;
	private JTextField church_in;
	private JTable table;
	private JPanel display;
	private JPanel contents;

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
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 816, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 441, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 173, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		display = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, display, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, display, 6, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, display, 441, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, display, 802, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(display);
		display.setLayout(null);
		
		
		setHomePanel(display);
		
		JButton search_info = new JButton("Search contact info");
		search_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSearchInfoPanel(display);
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton home = new JButton("Home");
		home.setFont(new Font("Tahoma", Font.PLAIN, 14));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHomePanel(display);
			}
		});
		panel.add(home);
		panel.add(search_info);
		
		JButton search_event = new JButton("Search seminar");
		search_event.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSearchEventPanel(display);
			}
		});
		search_event.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(search_event);
		
	}
	
	private void setHomePanel(JPanel panel) {
		panel.removeAll();

		JLabel display = new JLabel("Hi! This is the EHCP Portal.");
		display.setBounds(150, 10, 300, 30);
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(display);
		
		panel.revalidate();
		panel.repaint();
	}
	
	private void setSearchInfoPanel(JPanel panel) {
		panel.removeAll();
		
		JLabel fname = new JLabel("First Name:");
		fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fname.setBounds(10, 30, 100, 20);
		panel.add(fname);
		
		fname_in = new JTextField();
		fname_in.setBounds(10, 50, 200, 30);
		panel.add(fname_in);
		fname_in.setColumns(10);
		
		JLabel lname = new JLabel("Last Name:");
		lname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lname.setBounds(250, 30, 100, 20);
		panel.add(lname);
		
		lname_in = new JTextField();
		lname_in.setBounds(250, 50, 200, 30);
		panel.add(lname_in);
		lname_in.setColumns(10);
		
		JLabel church = new JLabel("Church:");
		church.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church.setBounds(10, 90, 100, 20);
		panel.add(church);
		
		church_in = new JTextField();
		church_in.setBounds(10, 110, 300, 30);
		panel.add(church_in);
		church_in.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(10, 150, 100, 30);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data[][] = {
						{"John", "Doe", "AAAA"},
						{"John", "da", "AAAA"},
						{"John", "Doe", "AAAA"},
						{"John", "da", "AAAA"},
						{"John", "Doe", "AAAA"},
						{"John", "da", "AAAA"},
						{"John", "Doe", "AAAA"},
						{"John", "da", "AAAA"},
						{"John", "Doe", "AAAA"},
						{"John", "da", "AAAA"},
						{"John", "DEX", "AAAA"},
						{"John", "da", "AAAA"},
						{"John", "de", "AAAA"}
				};
				
				String header[] = {"FIRST NAME", "LAST NAME", "CHURCH"};
				updateTableContents(contents, data, header);
				display.revalidate();
				display.repaint();
			}
		});
		panel.add(search);

		contents = new JPanel();
		contents.setBounds(0, 190, 500, 200);
		panel.add(contents);
		
		String data[][] = {};
		String header[] = {"FIRST NAME", "LAST NAME", "CHURCH"};
		updateTableContents(contents, data, header);
		
		panel.revalidate();
		panel.repaint();
	}
	
	private void updateTableContents(JPanel panel, String[][] data, String[] header) {
		panel.removeAll();
		
		table = new JTable(data, header);
		JScrollPane scrollpane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	    //scrollpane.setBounds(0, 0, 500, 100);
		panel.add(scrollpane);
		
		panel.revalidate();
		panel.repaint();
	}
	
	private void setSearchEventPanel(JPanel panel) {
		panel.removeAll();
		
		JLabel fname = new JLabel("Event:");
		fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fname.setBounds(10, 30, 100, 20);
		panel.add(fname);
		
		fname_in = new JTextField();
		fname_in.setBounds(10, 50, 200, 30);
		panel.add(fname_in);
		fname_in.setColumns(10);
		
		JLabel lname = new JLabel("Date:");
		lname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lname.setBounds(250, 30, 100, 20);
		panel.add(lname);
		
		lname_in = new JTextField();
		lname_in.setBounds(250, 50, 200, 30);
		panel.add(lname_in);
		lname_in.setColumns(10);
		
		JLabel church = new JLabel("Location:");
		church.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church.setBounds(10, 90, 100, 20);
		panel.add(church);
		
		church_in = new JTextField();
		church_in.setBounds(10, 110, 300, 30);
		panel.add(church_in);
		church_in.setColumns(10);
		
		/*
		table = new JTable();
		table.setBounds(10, 185, 603, 252);
		panel.add(table);
		*/
		
		String data[][] = {
				{"John", "Doe", "AAAA"},
				{"John", "da", "AAAA"},
				{"John", "Doe", "AAAA"},
				{"John", "da", "AAAA"},
				{"John", "Doe", "AAAA"},
				{"John", "da", "AAAA"},
				{"John", "Doe", "AAAA"},
				{"John", "da", "AAAA"},
				{"John", "Doe", "AAAA"},
				{"John", "da", "AAAA"},
				{"John", "DEX", "AAAA"},
				{"John", "da", "AAAA"},
				{"John", "de", "AAAA"}
		};
		String header[] = {"FIRST NAME", "LAST NAME", "CHURCH"};

		table = new JTable(data, header);
		JScrollPane scrollpane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	    scrollpane.setBounds(10, 190, 500, 200);
		panel.add(scrollpane);
		
		
		JButton search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(10, 150, 100, 30);
		panel.add(search);
		
		panel.revalidate();
		panel.repaint();
	}
}
