import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// Create a class extends JFrame
public class Caculator extends JFrame {
	
	// Create buttons for calculator
	private JButton on = new JButton("ON");
	private JButton delete = new JButton("←");
	private JButton clear = new JButton("CE");
	private JButton clearall = new JButton("C");
	private JButton plus = new JButton("+");
	private JButton pandn = new JButton("±");
	private JButton minus = new JButton("-");
	private JButton root = new JButton("√");
	private JButton multiply = new JButton("*");
	private JButton countdown = new JButton("1/x");
	private JButton divide = new JButton("÷");
	private JButton n0 = new JButton("" + 0);
	private JButton decimalpoint = new JButton(".");
	private JButton equal = new JButton("=");
	
	// Create an array to set number 1~9
	private JButton digits[] = new JButton[10];
	
	// Create a label to show the number and set initial value 0 right
	private static Label lab = new Label("0", Label.RIGHT);
	
	private long result;// 存放結果
	private byte op;// 代表運算子
	
	// Constructor of Caculator
	public Caculator() {
		
		// Create panel p1 (set GridLayout, 4 rows, 3 columns) for some buttons and number 1~9
		JPanel p1 = new JPanel(new GridLayout(4, 3));
		
		// Add buttons
		p1.add(on);
		p1.add(delete);
		p1.add(clear);
		
		// Add number 1~9
		for (int i = 1; i <= 9; i++) {
			digits[i] = new JButton(Integer.toString(i)); // Convert i from Int type to String type
			p1.add(digits[i]);
			digits[i].addActionListener(new ButtonListener()); // Register listener
		}
		
		// Create panel p2 (set GridLayout, 4 rows, 2 columns) for some buttons
		JPanel p2 = new JPanel(new GridLayout(4, 2));
		p2.add(clearall);
		clearall.addActionListener(new ButtonListener()); // Register listener
		p2.add(plus);
		plus.addActionListener(new ButtonListener()); // Register listener
		p2.add(pandn);
		p2.add(minus);
		minus.addActionListener(new ButtonListener()); // Register listener
		p2.add(root);
		p2.add(multiply);
		multiply.addActionListener(new ButtonListener()); // Register listener
		p2.add(countdown);
		p2.add(divide);
		divide.addActionListener(new ButtonListener()); // Register listener
		
		// Create panel p3 (set GridLayout, 1 rows, 5 columns) for some buttons and number 0
		JPanel p3 = new JPanel(new GridLayout(1, 5));
		p3.add(n0);
		n0.addActionListener(new ButtonListener()); // Register listener
		p3.add(decimalpoint);
		p3.add(equal);
		equal.addActionListener(new ButtonListener()); // Register listener

		// Create panel p4
		JPanel p4 = new JPanel(new BorderLayout());
		
		// Add label lab for north, panel p1 for center, panel p2 for east, panel p3 for south
		p4.add(lab, BorderLayout.NORTH);
		p4.add(p1, BorderLayout.CENTER);
		p4.add(p2, BorderLayout.EAST);
		p4.add(p3, BorderLayout.SOUTH);

		// Add panel p4 to the frame
		add(p4);
		
		// Set the frame
		this.setTitle("Caculator"); // Name of the frame
		this.setSize(300, 350); // Size of the frame
		this.setResizable(false); // User cannot change the size of frame
		this.setLocationRelativeTo(null); // Center the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // Show the frame
	}

	// Handle the buttons
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			long num; // 存放由字串轉成的數值
			JButton btn = (JButton) e.getSource();

			// 處理數值1-9
			for (int i = 1; i <= 9; i++) {
				if (btn == digits[i])
					output_num(digits[i]);
			}

			if (btn == clearall) {
				num = 0; // 把儲存的結果歸0
				result = 0;
				op = 0;
				lab.setText(Long.toString(result));
			} 
			
			else if (btn == plus) { // 加
				save_num(plus);
				op = 1;
			} 
			
			else if (btn == minus) { // 減
				save_num(minus);
				op = 2;
			} 
			
			else if (btn == multiply) { // 乘
				save_num(multiply);
				op = 3;
			} 
			
			else if (btn == divide) { // 除
				save_num(divide);
				op = 4;
			} 
			
			else if (btn == equal) {
				num = Long.parseLong(lab.getText()); // 存放由字串轉成的數值
				
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
					catch (ArithmeticException ae) { // 以防被除數為0
						result = 0;
						num = 0;
						System.out.println("被除數不得為0");
					}
					break;

				default:
				}

				num = 0; // 把儲存的結果歸0

				// 輸出運算後的結果到顯示器
				lab.setText(Long.toString(result));
			}
		}
		
		// 輸出數值到顯示器
		private void output_num(JButton digits) {
			lab.setText(Long.toString(Long.parseLong(lab.getText() + digits.getLabel())));
		}

		// 把第一組數值儲存起來
		private void save_num(JButton oper) {
			result = Long.parseLong(lab.getText());
			lab.setText(Long.toString(0));
		}		
	}
}
