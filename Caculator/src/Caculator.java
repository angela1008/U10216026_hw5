import java.awt.*;
import javax.swing.*;

public class Caculator extends JFrame {
	public Caculator(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		for (int i = 1; i <= 9; i++)
			p1.add(new JButton("" + i));
		p1.add(new JButton("c"));
		p1.add(new JButton("" + 0));
		p1.add(new JButton("."));
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 1));
		p2.add(new JButton("+"));
		p2.add(new JButton("-"));
		p2.add(new JButton("*"));
		p2.add(new JButton("/"));
		
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p3.add("=");
		
		JPanel p4 = new JPanel(BorderLayout());
		p4.add(new JTextField("Enter the default password(0000)"), BorderLayout.NORTH);
		p4.add(p3, BorderLayout.SOUTH);
	}

}
