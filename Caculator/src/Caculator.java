import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Caculator extends JFrame {
	private JButton on = new JButton("ON");
	private JButton delete = new JButton("��");
	private JButton clear = new JButton("CE");
	private JButton clearall = new JButton("C");
	private JButton plus = new JButton("+");
	private JButton pandn = new JButton("��");
	private JButton minus = new JButton("-");
	private JButton root = new JButton("��");
	private JButton multiply = new JButton("*");
	private JButton countdown = new JButton("1/x");
	private JButton divide = new JButton("��");
	private JButton n0 = new JButton("" + 0);
	private JButton decimalpoint = new JButton(".");
	private JButton equal = new JButton("=");

	private JButton digits[] = new JButton[10];
	
	private static Label lab = new Label("0", Label.RIGHT);
	
	private long result;// �s�񵲪G
	private byte op;// �N��B��l

	public Caculator() {

		JPanel p1 = new JPanel(new GridLayout(4, 3));
		p1.add(on);
		p1.add(delete);
		p1.add(clear);
		for (int i = 1; i <= 9; i++) {
			digits[i] = new JButton(Integer.toString(i));
			p1.add(digits[i]);
			digits[i].addActionListener(new ButtonListener());
		}

		JPanel p2 = new JPanel(new GridLayout(4, 2));
		p2.add(clearall);
		clearall.addActionListener(new ButtonListener());
		p2.add(plus);
		plus.addActionListener(new ButtonListener());
		p2.add(pandn);
		p2.add(minus);
		minus.addActionListener(new ButtonListener());
		p2.add(root);
		p2.add(multiply);
		multiply.addActionListener(new ButtonListener());
		p2.add(countdown);
		p2.add(divide);
		divide.addActionListener(new ButtonListener());

		JPanel p3 = new JPanel(new GridLayout(1, 5));
		p3.add(n0);
		n0.addActionListener(new ButtonListener());
		p3.add(decimalpoint);
		p3.add(equal);
		equal.addActionListener(new ButtonListener());

		JPanel p4 = new JPanel(new BorderLayout());
		p4.add(lab, BorderLayout.NORTH);
		p4.add(p1, BorderLayout.CENTER);
		p4.add(p2, BorderLayout.EAST);
		p4.add(p3, BorderLayout.SOUTH);

		add(p4);
		
		this.setTitle("Caculator");
		this.setSize(300, 350);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			long num;// �s��Ѧr���ন���ƭ�
			JButton btn = (JButton) e.getSource();

			// �B�z�ƭ�1-9
			for (int i = 1; i <= 9; i++) {
				if (btn == digits[i])
					output_num(digits[i]);
			}

			if (btn == clearall) {
				num = 0;// ���x�s�����G�k0
				result = 0;
				op = 0;
				lab.setText(Long.toString(result));
			} 
			
			else if (btn == plus) {// �[
				save_num(plus);
				op = 1;
			} 
			
			else if (btn == minus) {// ��
				save_num(minus);
				op = 2;
			} 
			
			else if (btn == multiply) {// ��
				save_num(multiply);
				op = 3;
			} 
			
			else if (btn == divide) {// ��
				save_num(divide);
				op = 4;
			} 
			
			else if (btn == equal) {
				num = Long.parseLong(lab.getText());// �s��Ѧr���ন���ƭ�
				
				switch (op) {				
				case 1:
					result += num;
					break;

				case 2:
					result -= num;
					break;

				case 3:
					result *= num;
					break;

				case 4:
					try {
						result /= num;						
					} 
					catch (ArithmeticException ae) {
						result = 0;
						num = 0;
						System.out.println("�Q���Ƥ��o��0");
					}
					break;

				default:
				}

				num = 0;

				// ��X�B��᪺���G����ܾ�
				lab.setText(Long.toString(result));
			}
		}
		
		// ��X�ƭȨ���ܾ�
		private void output_num(JButton digits) {
			lab.setText(Long.toString(Long.parseLong(lab.getText() + digits.getLabel())));
		}

		// ��Ĥ@�ռƭ��x�s�_��
		private void save_num(JButton oper) {
			result = Long.parseLong(lab.getText());
			lab.setText(Long.toString(0));
		}		
	}
	
//	public static void main(String[] args) {
//		Caculator frame = new Caculator();
//		
//	}
}
