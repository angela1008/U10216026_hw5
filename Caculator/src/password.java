import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class password extends JFrame {
	
	public String sp;
	private JLabel password = new JLabel("Password");
	private JTextField Jtfpassword = new JTextField("Deafult:(0000).", 10);
	private JButton ok = new JButton("OK");
	
	public password(){
		JPanel p1 = new JPanel();
		p1.add(password);
		p1.add(Jtfpassword);
		p1.add(ok);
		
		add(p1, BorderLayout.CENTER);
		
		ok.addActionListener((ActionListener) new ButtonListener());
		
		this.setTitle("Enter password");
		this.setSize(400, 70);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);		

	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			sp = Jtfpassword.getText();
			if (sp.equals("0000")) {
				new Caculator(); // If password is right, then invoke Calculator()
			} else {
				Jtfpassword.setText("");
				System.out.println("Error");
			}
		}
	}
	
	public static void main(String[] args) {
		password p = new password();
	}
}
