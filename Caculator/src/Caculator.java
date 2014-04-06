import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Caculator extends JFrame {
	private JButton on = new JButton("ON");
	private JButton delete = new JButton("ก๖");
	private JButton clearall = new JButton("CE");
	private JButton clear = new JButton("C");
	private JButton plus = new JButton("+");
	private JButton pandn = new JButton("กำ");
	private JButton minus = new JButton("-");
	private JButton root = new JButton("กิ");
	private JButton multiply = new JButton("*");
	private JButton countdown = new JButton("1/x");
	private JButton divide = new JButton("กา");
	private JButton n0 = new JButton("" + 0);
	private JButton decimalpoint = new JButton(".");
	private JButton equal = new JButton("=");

	private JButton digits[] = new JButton[10];
	
	private static Label lab = new Label("0", Label.RIGHT);
	

	public Caculator() {

		JPanel p1 = new JPanel(new GridLayout(4, 3));
		p1.add(on);
		p1.add(delete);
		p1.add(clearall);
		for (int i = 1; i <= 9; i++) {
			digits[i] = new JButton(Integer.toString(i));
			p1.add(digits[i]);
		}

		JPanel p2 = new JPanel(new GridLayout(4, 2));
		p2.add(clear);
		p2.add(plus);
		p2.add(pandn);
		p2.add(minus);
		p2.add(root);
		p2.add(multiply);
		p2.add(countdown);
		p2.add(divide);

		JPanel p3 = new JPanel(new GridLayout(1, 5));
		p3.add(n0);
		p3.add(decimalpoint);
		p3.add(equal);

		JPanel p4 = new JPanel(new BorderLayout());
		p4.add(lab, BorderLayout.NORTH);
		p4.add(p1, BorderLayout.CENTER);
		p4.add(p2, BorderLayout.EAST);
		p4.add(p3, BorderLayout.SOUTH);

		add(p4);
	}

	public static void main(String[] args) {
		Caculator frame = new Caculator();
		frame.setTitle("Caculator");
		frame.setSize(300, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
