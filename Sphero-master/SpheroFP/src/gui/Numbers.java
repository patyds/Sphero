package gui;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Numbers extends JDialog {

	private JPanel Numbers;
	private int steps;

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public Numbers() {
		super();
		setModal(true);
		setBounds(100, 100, 220, 200);
		Numbers = new JPanel();
		Numbers.setBackground(new Color(64, 224, 208));
		Numbers.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Numbers);
		GridBagLayout gbl_Numbers = new GridBagLayout();
		gbl_Numbers.columnWidths = new int[]{0, 0, 0, 0};
		gbl_Numbers.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_Numbers.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_Numbers.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Numbers.setLayout(gbl_Numbers);
		
		JLabel lblNewLabel = new JLabel("How many steps?");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		Numbers.add(lblNewLabel, gbc_lblNewLabel);
		
		JTextArea number = new JTextArea();
		GridBagConstraints gbc_number = new GridBagConstraints();
		gbc_number.gridwidth = 3;
		gbc_number.insets = new Insets(0, 0, 5, 0);
		gbc_number.fill = GridBagConstraints.BOTH;
		gbc_number.gridx = 0;
		gbc_number.gridy = 1;
		Numbers.add(number, gbc_number);
		
		JButton btnOne = new JButton("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("1");
			}
		});
		btnOne.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnOne.setMaximumSize(new Dimension(25, 23));
		btnOne.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnOne = new GridBagConstraints();
		gbc_btnOne.insets = new Insets(0, 0, 5, 5);
		gbc_btnOne.gridx = 0;
		gbc_btnOne.gridy = 2;
		Numbers.add(btnOne, gbc_btnOne);
		
		JButton btnTwo = new JButton("2");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("2");
			}
		});
		btnTwo.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnTwo.setMaximumSize(new Dimension(25, 23));
		btnTwo.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnTwo = new GridBagConstraints();
		gbc_btnTwo.insets = new Insets(0, 0, 5, 5);
		gbc_btnTwo.gridx = 1;
		gbc_btnTwo.gridy = 2;
		Numbers.add(btnTwo, gbc_btnTwo);
		
		JButton btnFour = new JButton("4");
		btnFour.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("4");
			}
		});
		
		JButton btnThree = new JButton("3");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("3");
			}
		});
		btnThree.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnThree.setMaximumSize(new Dimension(25, 23));
		btnThree.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnThree = new GridBagConstraints();
		gbc_btnThree.insets = new Insets(0, 0, 5, 0);
		gbc_btnThree.gridx = 2;
		gbc_btnThree.gridy = 2;
		Numbers.add(btnThree, gbc_btnThree);
		btnFour.setMaximumSize(new Dimension(25, 23));
		btnFour.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnFour = new GridBagConstraints();
		gbc_btnFour.anchor = GridBagConstraints.NORTH;
		gbc_btnFour.insets = new Insets(0, 0, 5, 5);
		gbc_btnFour.gridx = 0;
		gbc_btnFour.gridy = 3;
		Numbers.add(btnFour, gbc_btnFour);
		
		JButton btnFive = new JButton("5");
		btnFive.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("5");
			}
		});
		btnFive.setMaximumSize(new Dimension(25, 23));
		btnFive.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnFive = new GridBagConstraints();
		gbc_btnFive.insets = new Insets(0, 0, 5, 5);
		gbc_btnFive.gridx = 1;
		gbc_btnFive.gridy = 3;
		Numbers.add(btnFive, gbc_btnFive);
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("7");
			}
		});
		
		JButton btnSix = new JButton("6");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("6");
			}
		});
		btnSix.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnSix.setMaximumSize(new Dimension(25, 23));
		btnSix.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnSix = new GridBagConstraints();
		gbc_btnSix.insets = new Insets(0, 0, 5, 0);
		gbc_btnSix.gridx = 2;
		gbc_btnSix.gridy = 3;
		Numbers.add(btnSix, gbc_btnSix);
		btnSeven.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnSeven.setMaximumSize(new Dimension(25, 23));
		btnSeven.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnSeven = new GridBagConstraints();
		gbc_btnSeven.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeven.gridx = 0;
		gbc_btnSeven.gridy = 4;
		Numbers.add(btnSeven, gbc_btnSeven);
		
		JButton btnEight = new JButton("8");
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("8");
			}
		});
		btnEight.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnEight.setMaximumSize(new Dimension(25, 23));
		btnEight.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnEight = new GridBagConstraints();
		gbc_btnEight.insets = new Insets(0, 0, 5, 5);
		gbc_btnEight.gridx = 1;
		gbc_btnEight.gridy = 4;
		Numbers.add(btnEight, gbc_btnEight);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.setText("");
			}
		});
		
		JButton btnNine = new JButton("9");
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("9");
			}
		});
		btnNine.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnNine.setMaximumSize(new Dimension(25, 23));
		btnNine.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnNine = new GridBagConstraints();
		gbc_btnNine.insets = new Insets(0, 0, 5, 0);
		gbc_btnNine.gridx = 2;
		gbc_btnNine.gridy = 4;
		Numbers.add(btnNine, gbc_btnNine);
		btnReset.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnReset.setMaximumSize(new Dimension(25, 23));
		btnReset.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 0;
		gbc_btnReset.gridy = 5;
		Numbers.add(btnReset, gbc_btnReset);
		
		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number.append("0");
			}
		});
		btnZero.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnZero.setMaximumSize(new Dimension(25, 23));
		btnZero.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnZero = new GridBagConstraints();
		gbc_btnZero.insets = new Insets(0, 0, 0, 5);
		gbc_btnZero.gridx = 1;
		gbc_btnZero.gridy = 5;
		Numbers.add(btnZero, gbc_btnZero);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steps = Integer.parseInt(number.getText());
				setSteps(steps);
				setVisible(false);
			}
		});
		btnDone.setMaximumSize(new Dimension(25, 23));
		btnDone.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.gridx = 2;
		gbc_btnDone.gridy = 5;
		Numbers.add(btnDone, gbc_btnDone);
	}

}
