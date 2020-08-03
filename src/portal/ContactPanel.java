package portal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import jdbc.ContactInfo;
import jdbc.JDBCExecutor;

public class ContactPanel {
	private JLabel first_name;
	private JLabel last_name;
	private JLabel church;
	private JTextField first_name_input;
	private JTextField last_name_input;
	private JTextField church_input;
	private JButton search;
	private JButton view;
	private JPanel contents;
	private final String[] header = {"FIRST NAME", "LAST NAME", "CHURCH", ""};
	
	private InfoPanel info;
	
	public ContactPanel() {
		first_name = new JLabel("First Name:");
		first_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		first_name.setBounds(10, 30, 100, 20);
		
		first_name_input = new JTextField();
		first_name_input.setBounds(10, 50, 200, 30);
		first_name_input.setColumns(10);
		
		last_name = new JLabel("Last Name:");
		last_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		last_name.setBounds(250, 30, 100, 20);
		
		last_name_input = new JTextField();
		last_name_input.setBounds(250, 50, 200, 30);
		last_name_input.setColumns(10);
		
		church = new JLabel("Church:");
		church.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church.setBounds(10, 90, 100, 20);
		
		church_input = new JTextField();
		church_input.setBounds(10, 110, 300, 30);
		church_input.setColumns(10);
		
		search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.setBounds(10, 150, 100, 30);

		view = new JButton("View");
		view.setFont(new Font("Tahoma", Font.PLAIN, 14));
		view.setBounds(120, 150, 100, 30);
		
		contents = new JPanel();
		contents.setBounds(0, 190, 500, 200);
		
		String data[][] = {};
		updateTableContents(contents, data);
		
		info = new InfoPanel();
	}
	
	public void display(JPanel panel){
		panel.add(first_name);
		panel.add(last_name);
		panel.add(church);
		panel.add(first_name_input);
		panel.add(last_name_input);
		panel.add(church_input);
		panel.add(search);
		panel.add(contents);
		

		panel.add(view);
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 info.display(new String[] {"Frank", "Sinatra"});
			}
		});
		
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBCExecutor jdbc = JDBCExecutor.getInstance();
				List<ContactInfo> infos = jdbc.getContactInfo("Frank", "Sinatra");
				String data[][] = new String[infos.size()][4];
				
				for(int i = 0; i < infos.size(); i++) {
					ContactInfo n = infos.get(i);
					data[i][0] = n.getFirstName();
					data[i][1] = n.getLastName();
					data[i][2] = n.getMobileNumber();
					data[i][3] = "";
				}
				
				updateTableContents(contents, data);
				panel.revalidate();
				panel.repaint();
			}
		});
	}
	
	private void updateTableContents(JPanel panel, String[][] data) {
		panel.removeAll();
		
		JTable table = new JTable(data, header);
		JScrollPane scrollpane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	    //scrollpane.setBounds(0, 0, 500, 100);
		panel.add(scrollpane);
		
		panel.revalidate();
		panel.repaint();
		/*
		try {
			data[0][2] = "123"; 
			Thread.sleep(3000);
			table.fireTalbe
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
	}
	
}
