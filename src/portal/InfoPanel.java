package portal;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jdbc.ContactInfo;
import jdbc.JDBCExecutor;

public class InfoPanel {
	private JDialog dialog;
	private JLabel first_name_label;
	private JLabel last_name_label;
	private JLabel church_label;
	private JLabel church_role_label;
	private JLabel email_label;
	private JLabel mobile_number_label;
	private JLabel first_name_value;
	private JLabel last_name_value;
	private JLabel church_value;
	private JLabel church_role_value;
	private JLabel email_value;
	private JLabel mobile_number_value;
	private JLabel end;
	private JButton close;
	private JDBCExecutor jdbc = JDBCExecutor.getInstance();
	
	public InfoPanel() {
		JFrame frame = new JFrame();
		dialog = new JDialog(frame, "Contact Info", true);

		initializeLabels();
		initializeValues();
		close = new JButton("Close");
		close.setFont(new Font("Tahoma", Font.PLAIN, 14));
		close.setBounds(10, 110, 100, 30);
		
		dialog.setSize(400, 400);
	}
	
	private void initializeLabels() {
		first_name_label = new JLabel("First Name:");
		first_name_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		first_name_label.setBounds(10, 30, 100, 20);
		
		last_name_label = new JLabel("Last Name:");
		last_name_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		last_name_label.setBounds(10, 50, 100, 20);

		church_label = new JLabel("Church:");
		church_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church_label.setBounds(10, 70, 100, 20);
		
		church_role_label = new JLabel("Church Role:");
		church_role_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church_role_label.setBounds(10, 90, 100, 20);

		email_label = new JLabel("Email:");
		email_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email_label.setBounds(10, 110, 100, 20);
		
		mobile_number_label = new JLabel("Mobile No.s:");
		mobile_number_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mobile_number_label.setBounds(10, 130, 100, 20);
		
		end = new JLabel();
		end.setFont(new Font("Tahoma", Font.PLAIN, 14));
		end.setBounds(10, 110, 100, 20);

		dialog.add(first_name_label);
		dialog.add(last_name_label);
		dialog.add(church_label);
		dialog.add(church_role_label);
		dialog.add(email_label);
		dialog.add(mobile_number_label);
	}

	private void initializeValues() {
		first_name_value = new JLabel("First Name");
		first_name_value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		first_name_value.setBounds(110, 30, 200, 20);
		
		last_name_value = new JLabel("Last Name");
		last_name_value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		last_name_value.setBounds(110, 50, 200, 20);

		church_value = new JLabel("Church Value");
		church_value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church_value.setBounds(110, 70, 200, 20);

		church_role_value = new JLabel("Church Role");
		church_role_value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		church_role_value.setBounds(110, 90, 200, 20);

		email_value = new JLabel("Email");
		email_value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email_value.setBounds(110, 110, 200, 20);
		
		mobile_number_value = new JLabel("Mobile No.");
		mobile_number_value.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mobile_number_value.setBounds(110, 130, 200, 20);
		
		dialog.add(first_name_value);
		dialog.add(last_name_value);
		dialog.add(church_value);
		dialog.add(church_role_value);
		dialog.add(email_value);
		dialog.add(mobile_number_value);
		dialog.add(end);
	}
	
	public void display(String[] data) {
		ContactInfo info = jdbc.getFullInfo(data[0], data[1]);
		first_name_value.setText(info.getFirstName());
		last_name_value.setText(info.getLastName());
		church_value.setText(info.getChurch());
		church_role_value.setText(info.getChurchRole());
		email_value.setText(info.getEmail());
		mobile_number_value.setText(info.getMobileNumber());
		dialog.setVisible(true);
	}
}
