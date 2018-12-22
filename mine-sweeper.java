package minesweeping;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		BoardClass board = new BoardClass();
		board.setBoardClass();

		
	}
}






package minesweeping;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BoardClass {
	private CellClass[][] cells;
	private int cellID = 0;
	private int side = 8;
	private int limit = side - 2;
	JFrame frame;

	public void setBoardClass() {
		frame = new JFrame();
		frame.add(addCells());

		plantMines();
		setCellValues();

		JButton b1 = new JButton("Restart");
		b1.addActionListener(new CustomActionListener());

		frame.add(b1, BorderLayout.SOUTH);

		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

		new Timer().schedule(new TimerTask() {

			int second = 300;

			@Override
			public void run() {
				frame.setTitle("Application will close in " + second--
						+ " second.");
			}
		}, 0, 1000);

	}

	public JPanel addCells() {
		JPanel panel = new JPanel(new GridLayout(side, side));
		cells = new CellClass[side][side];
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				cells[i][j] = new CellClass(this);
				cells[i][j].setId(getID());
				panel.add(cells[i][j].getButton());
			}
		}
		return panel;
	}

	public void plantMines() {
		ArrayList<Integer> loc = generateMinesLocation(10);
		for (int i : loc) {
			getCell(i).setValue(-1);
		}
	}

	public ArrayList<Integer> generateMinesLocation(int q) {
		ArrayList<Integer> loc = new ArrayList<Integer>();
		int random;
		for (int i = 0; i < q;) {
			random = (int) (Math.random() * (side * side));
			if (!loc.contains(random)) {
				loc.add(random);
				i++;
			}
		}
		return loc;
	}

	public void setCellValues() {
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				if (cells[i][j].getValue() != -1) {
					if (j >= 1 && cells[i][j - 1].getValue() == -1)
						cells[i][j].incrementValue();
					if (j <= limit && cells[i][j + 1].getValue() == -1)
						cells[i][j].incrementValue();
					if (i >= 1 && cells[i - 1][j].getValue() == -1)
						cells[i][j].incrementValue();
					if (i <= limit && cells[i + 1][j].getValue() == -1)
						cells[i][j].incrementValue();
					if (i >= 1 && j >= 1
							&& cells[i - 1][j - 1].getValue() == -1)
						cells[i][j].incrementValue();
					if (i <= limit && j <= limit
							&& cells[i + 1][j + 1].getValue() == -1)
						cells[i][j].incrementValue();
					if (i >= 1 && j <= limit
							&& cells[i - 1][j + 1].getValue() == -1)
						cells[i][j].incrementValue();
					if (i <= limit && j >= 1
							&& cells[i + 1][j - 1].getValue() == -1)
						cells[i][j].incrementValue();
				}
			}
		}
	}

	public void scanForEmptyCells() {
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				if (!cells[i][j].isNotChecked()) {
					if (j >= 1 && cells[i][j - 1].isEmpty())
						cells[i][j - 1].checkCell();
					if (j <= limit && cells[i][j + 1].isEmpty())
						cells[i][j + 1].checkCell();
					if (i >= 1 && cells[i - 1][j].isEmpty())
						cells[i - 1][j].checkCell();
					if (i <= limit && cells[i + 1][j].isEmpty())
						cells[i + 1][j].checkCell();
					if (i >= 1 && j >= 1 && cells[i - 1][j - 1].isEmpty())
						cells[i - 1][j - 1].checkCell();
					if (i <= limit && j <= limit
							&& cells[i + 1][j + 1].isEmpty())
						cells[i + 1][j + 1].checkCell();
					if (i >= 1 && j <= limit && cells[i - 1][j + 1].isEmpty())
						cells[i - 1][j + 1].checkCell();
					if (i <= limit && j >= 1 && cells[i + 1][j - 1].isEmpty())
						cells[i + 1][j - 1].checkCell();
				}
			}
		}
	}

	public int getID() {
		int id = cellID;
		cellID++;
		return id;
	}

	public CellClass getCell(int id) {
		for (CellClass[] a : cells) {
			for (CellClass b : a) {
				if (b.getId() == id)
					return b;

			}
		}
		return null;
	}

	public void fail() {
		for (CellClass[] a : cells) {
			for (CellClass b : a) {
				b.reveal();
			}

		}
	}

	class CustomActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
	       
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


			BoardClass board = new BoardClass();
			board.setBoardClass();

		}
	}
}





package minesweeping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellClass implements ActionListener {
	private JButton button;
	private BoardClass board;
	private int value;
	private int id;
	private boolean notChecked;

	public CellClass(BoardClass board) {
		button = new JButton();
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(20, 20));
		button.setMargin(new Insets(0, 0, 0, 0));
		this.board = board;
		notChecked = true;
	}

	public JButton getButton() {
		return button;
	}

	public int getValue() {
		return value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void displayValue() {
		if (value == -1) {
			button.setText("\u2600");
			button.setBackground(Color.RED);
		} else if (value != 0) {
			button.setText(String.valueOf(value));
		}
	}

	public void checkCell() {
		button.setEnabled(false);
		displayValue();
		notChecked = false;
		if (value == 0)
			board.scanForEmptyCells();
		if (value == -1)
			board.fail();
	}

	public void incrementValue() {
		value++;
	}

	public boolean isNotChecked() {
		return notChecked;
	}

	public boolean isEmpty() {
		return isNotChecked() && value == 0;
	}

	public void reveal() {
		displayValue();
		button.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		checkCell();
	}

}

