import java.awt.*;
import javax.swing.*;

public class Caculator extends JFrame{
	private JButton on = new JButton("ON");
	private JButton delete = new JButton("ก๖");
	private JButton clearall = new JButton("CE");
	private JButton clear = new JButton("C");
	private JButton plus = new JButton("+");
	private JButton n1 = new JButton("" + 1);
	private JButton n2 = new JButton("" + 2);
	private JButton n3 = new JButton("" + 3);
	private JButton pandn = new JButton("กำ");
	private JButton minus = new JButton("-");
	private JButton n4 = new JButton("" + 4);
	private JButton n5 = new JButton("" + 5);
	private JButton n6 = new JButton("" + 6);
	private JButton root = new JButton("กิ");
	private JButton multiply = new JButton("*");
	private JButton n7 = new JButton("" + 7);
	private JButton n8 = new JButton("" + 8);
	private JButton n9 = new JButton("" + 9);
	private JButton countdown = new JButton("1/x");
	private JButton divide = new JButton("กา");
	private JButton n0 = new JButton("" + 0);
	private JButton decimalpoint = new JButton(".");
	private JButton equal = new JButton("=");
	
	
	public Caculator(){
		JPanel p1 = new JPanel(new GridLayout(4, 5, 4, 8));
		p1.add(on);
		p1.add(delete);
		p1.add(clearall);
		p1.add(clear);
		p1.add(plus);
		p1.add(n1);
		p1.add(n2);
		p1.add(n3);
		p1.add(pandn);
		p1.add(minus);
		p1.add(n4);
		p1.add(n5);
		p1.add(n6);
		p1.add(root);
		p1.add(multiply);		
		p1.add(n7);
		p1.add(n8);
		p1.add(n9);
		p1.add(countdown);
		p1.add(divide);
		
		
		JPanel p2 = new JPanel(new GridLayout(1, 3, 4, 4));
		p2.add(n0);
		p2.add(decimalpoint);
		p2.add(equal);
		
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add(new JTextField("0", 13), BorderLayout.NORTH);
		p3.add(p1, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.SOUTH);
		
		add(p3);
	}
	
	public static void main(String[] args){
		Caculator frame = new Caculator();
		frame.setTitle("Caculator");
		frame.setSize(300, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
