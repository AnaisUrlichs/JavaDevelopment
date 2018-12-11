package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Simplegui extends JFrame {
	JButton but1;
	JButton but2;
	JButton but3;
	JButton but4;
	JButton but5;
	JLabel label1;
	JPanel panel1;
	JPanel panel2;
	JLabel tf;
	JTextField editArea;
	Box iconPanel;
	int count1;
	int count3;
	int count2;
	JLabel counter;

	public static void main(String[] args) {
		Simplegui fl = new Simplegui();

	}

	public Simplegui() {
		gui();
	}

	public void gui() {

		setTitle("We save numbers");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		but1 = new JButton("1");
		but1.addActionListener(new CustomActionListener());

		but2 = new JButton("2");
		but2.addActionListener(new CustomActionListener());

		but3 = new JButton("3");
		but3.addActionListener(new CustomActionListener());

		counter = new JLabel("Here will be the count!");

		iconPanel = new Box(BoxLayout.Y_AXIS);
		iconPanel.add(but1);
		iconPanel.add(but2);
		iconPanel.add(but3);
		iconPanel.setBackground(Color.gray);
		iconPanel.setVisible(true);
		add(iconPanel, BorderLayout.EAST);

		but4 = new JButton("DELETE");
		but4.addActionListener(new CustomActionListener());
		but5 = new JButton("PERSIST");
		but5.addActionListener(new CustomActionListener());
		panel1 = new JPanel();
		panel1.add(but4);
		panel1.add(but5);
		add(panel1, BorderLayout.SOUTH);

		panel2 = new JPanel();
		tf = new JLabel();
		panel2.add(tf);
		add(panel2, BorderLayout.NORTH);

		editArea = new JTextField();
		add(editArea, BorderLayout.CENTER);

		add(counter, BorderLayout.WEST);

		setVisible(true);

	}

	class CustomActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals(but1.getText())) {
				String content = editArea.getText();

				count1++;
				editArea.setText(content + "1");
				counter.setText(Integer.toString(count1));

			} else if (e.getActionCommand().equals(but2.getText())) {
				String content = editArea.getText();
				count2++;
				editArea.setText(content + "2");
				counter.setText(Integer.toString(count2));


			} else if (e.getActionCommand().equals(but3.getText())) {
				String content = editArea.getText();
				count3++;
				editArea.setText(content + "3");
				counter.setText(Integer.toString(count3));


			} else if (e.getActionCommand().equals(but5.getText())) {
				String content = editArea.getText();
				tf.setText(content);
				editArea.setText("");

			} else if (e.getActionCommand().equals(but4.getText())) {
				editArea.setText("");

			}
		}
	}
}
