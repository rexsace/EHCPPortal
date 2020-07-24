package portal;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class EventPanel {
	private JLabel name;
	private JLabel date;
	private JLabel venue;
	private JTextField name_input;
	private JTextField date_input;
	private JTextField venue_input;
	private JButton search;
	private JScrollPane scrollpane;
	
	public EventPanel() {
		name = new JLabel("Event:");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(10, 30, 100, 20);
		
		name_input = new JTextField();
		name_input.setBounds(10, 50, 200, 30);
		name_input.setColumns(10);
		
		date = new JLabel("Date:");
		date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date.setBounds(250, 30, 100, 20);
		
		date_input = new JTextField();
		date_input.setBounds(250, 50, 200, 30);
		date_input.setColumns(10);
		
		venue = new JLabel("Location:");
		venue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		venue.setBounds(10, 90, 100, 20);
		
		venue_input = new JTextField();
		venue_input.setBounds(10, 110, 300, 30);
		venue_input.setColumns(10);
		
		
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

		JTable table = new JTable(data, header);
		scrollpane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	    scrollpane.setBounds(10, 190, 500, 200);
		
		
		search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(10, 150, 100, 30);
	}
	
	public void display(JPanel panel) {
		panel.add(name);
		panel.add(date);
		panel.add(venue);
		panel.add(name_input);
		panel.add(date_input);
		panel.add(venue_input);
		panel.add(search);
		panel.add(scrollpane);
	}
}
