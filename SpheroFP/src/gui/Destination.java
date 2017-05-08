package gui;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Destination extends JDialog {
	private String[] cities ={"Coruña","Vigo","Valladolid","Madrid","Badajoz","Jaén","Sevilla","Cádiz","Granada","Murcia","Albacete","Valencia","Barcelona","Gerona","Zaragoza","Bilbao","Oviedo"};
	private String start;
	private String finish;

	public Destination() {
		super();
		getContentPane().setBackground(new Color(64, 224, 208));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDestination.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDestination, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		GridBagConstraints gbc_lblStart = new GridBagConstraints();
		gbc_lblStart.insets = new Insets(0, 0, 5, 5);
		gbc_lblStart.gridx = 1;
		gbc_lblStart.gridy = 1;
		panel.add(lblStart, gbc_lblStart);
		
		JComboBox startBox = new JComboBox(cities);
		startBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		GridBagConstraints gbc_startBox = new GridBagConstraints();
		gbc_startBox.insets = new Insets(0, 0, 5, 0);
		gbc_startBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_startBox.gridx = 3;
		gbc_startBox.gridy = 1;
		panel.add(startBox, gbc_startBox);
		
		JLabel lblFinish = new JLabel("Finish");
		lblFinish.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		GridBagConstraints gbc_lblFinish = new GridBagConstraints();
		gbc_lblFinish.insets = new Insets(0, 0, 5, 5);
		gbc_lblFinish.gridx = 1;
		gbc_lblFinish.gridy = 2;
		panel.add(lblFinish, gbc_lblFinish);
		
		JComboBox finishBox = new JComboBox(cities);
		finishBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		GridBagConstraints gbc_finishBox = new GridBagConstraints();
		gbc_finishBox.insets = new Insets(0, 0, 5, 0);
		gbc_finishBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_finishBox.gridx = 3;
		gbc_finishBox.gridy = 2;
		panel.add(finishBox, gbc_finishBox);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 3;
		panel.add(panel_5, gbc_panel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start=startBox.getSelectedItem().toString();
				finish= finishBox.getSelectedItem().toString();
				setVisible(false);
			}
		});
		btnOk.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnOk.setBackground(new Color(255, 255, 255));
		panel_1.add(btnOk);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 224, 208));
		getContentPane().add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 224, 208));
		getContentPane().add(panel_3, BorderLayout.EAST);
		setModal(true);
		setBounds(200, 200, 420, 200);
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

}
