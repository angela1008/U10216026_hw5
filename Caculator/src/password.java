import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// Create a class extends JFrame
public class password extends JFrame {
	
	public String sp; // Store the text
	private JLabel password = new JLabel("Password"); // Create a label to show the "password"
	private JTextField Jtfpassword = new JTextField("Deafult:(0000).", 10); // Create a text field for user to enter the password and prompt the default value is (0000)
	private JButton ok = new JButton("OK"); // Create a button to confirm the password
	
	// Constructor of password
	public password(){
		
		// Create panel p1
		JPanel p1 = new JPanel();
		
		// Add label, text field, and button
		p1.add(password);
		p1.add(Jtfpassword);
		p1.add(ok);
		
		// Add panel p1 to the center of the frame
		add(p1, BorderLayout.CENTER);
		
		// Register listener
		ok.addActionListener((ActionListener) new ButtonListener());
		
		// Set the frame
		this.setTitle("Enter password"); // Name of the frame
		this.setSize(400, 70); // Size of the frame
		this.setVisible(true); // Show the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // Center the frame
		this.setResizable(false); // User cannot change the size of frame

	}
	
	// Handle the "ok" buttons
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			// Get the text
			sp = Jtfpassword.getText();
			
			// If password is right, then invoke Calculator()
			if (sp.equals("0000"))
				new Caculator(); 
			
			// Else clear the text and printout the "Error"
			else {
				Jtfpassword.setText("");
				System.out.println("Error");
			}
		}
	}
	
	/** Main method */
	public static void main(String[] args) {
		
		// Invoke the windows of entering password
		password p = new password();
	}
}
