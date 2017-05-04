package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ChooseSphero extends JDialog {

	private JPanel ChooseSphero;
	private SpheroGui spheroGui;
	private JLabel spheroPic;
	private Image imgb;
	public JPanel getChooseSphero() {
		return ChooseSphero;
	}

	public void setChooseSphero(JPanel chooseSphero) {
		ChooseSphero = chooseSphero;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int steps) {
		this.id = steps;
	}

	public ChooseSphero() {
		super();
		setModal(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int x = ((int) tk.getScreenSize().getWidth());
	    int y = ((int) tk.getScreenSize().getHeight()-35);
	    setBounds((x/2)-200, (y/2)-200, 400, 400);
		ChooseSphero = new JPanel();
		ChooseSphero.setBackground(new Color(64, 224, 208));
		ChooseSphero.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ChooseSphero);
		ChooseSphero.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		titlePanel.setBackground(Color.WHITE);
		ChooseSphero.add(titlePanel, BorderLayout.NORTH);
		
		JLabel lblChoose = new JLabel("Choose your Sphero");
		lblChoose.setBackground(new Color(255, 255, 255));
		lblChoose.setFont(new Font("Courier New", Font.PLAIN, 14));
		titlePanel.add(lblChoose);
		
		JPanel pnlBack = new JPanel();
		pnlBack.setBackground(new Color(64, 224, 208));
		ChooseSphero.add(pnlBack, BorderLayout.CENTER);
		pnlBack.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlImage = new JPanel();
		pnlImage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlImage.setBackground(Color.WHITE);
		pnlBack.add(pnlImage);
		
		imgb = new ImageIcon(this.getClass().getResource("/sphero.png")).getImage();
		pnlImage.setLayout(new BorderLayout(0, 0));
		spheroPic = new JLabel("");
		spheroPic.setHorizontalAlignment(SwingConstants.CENTER);
		spheroPic.setIcon(new ImageIcon(imgb));
		pnlImage.add(spheroPic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		pnlBack.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 224, 208));
		pnlBack.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 224, 208));
		pnlBack.add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(64, 224, 208));
		pnlBack.add(panel_4, BorderLayout.EAST);
		
		JPanel pnlBack2 = new JPanel();
		pnlBack2.setPreferredSize(new Dimension(90, 10));
		pnlBack2.setMinimumSize(new Dimension(15, 10));
		pnlBack2.setBackground(new Color(64, 224, 208));
		ChooseSphero.add(pnlBack2, BorderLayout.EAST);
		GridBagLayout gbl_pnlBack2 = new GridBagLayout();
		gbl_pnlBack2.columnWidths = new int[]{0, 0};
		gbl_pnlBack2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlBack2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlBack2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBack2.setLayout(gbl_pnlBack2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		pnlBack2.add(panel, gbc_panel);
		
		JPanel pnlTypes = new JPanel();
		pnlTypes.setPreferredSize(new Dimension(90, 10));
		pnlTypes.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlTypes.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlTypes = new GridBagConstraints();
		gbc_pnlTypes.gridheight = 9;
		gbc_pnlTypes.insets = new Insets(0, 0, 5, 0);
		gbc_pnlTypes.fill = GridBagConstraints.BOTH;
		gbc_pnlTypes.gridx = 0;
		gbc_pnlTypes.gridy = 2;
		pnlBack2.add(pnlTypes, gbc_pnlTypes);
		GridBagLayout gbl_pnlTypes = new GridBagLayout();
		gbl_pnlTypes.columnWidths = new int[]{67, 0};
		gbl_pnlTypes.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlTypes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlTypes.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTypes.setLayout(gbl_pnlTypes);
		
		JButton btnBasic = new JButton("Basic");
		btnBasic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "basic".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/sphero.png")).getImage();
				imgb.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				spheroPic.setIcon(new ImageIcon(imgb));
				
			}
		});
		btnBasic.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnBasic.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnBasic = new GridBagConstraints();
		gbc_btnBasic.insets = new Insets(0, 0, 5, 0);
		gbc_btnBasic.gridx = 0;
		gbc_btnBasic.gridy = 1;
		pnlTypes.add(btnBasic, gbc_btnBasic);
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "blue".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/bluem.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
				spheroPic.setIcon(new ImageIcon(imgb));
			}
		});
		btnBlue.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnBlue.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnBlue = new GridBagConstraints();
		gbc_btnBlue.insets = new Insets(0, 0, 5, 0);
		gbc_btnBlue.gridx = 0;
		gbc_btnBlue.gridy = 2;
		pnlTypes.add(btnBlue, gbc_btnBlue);
		
		JButton btnGreen = new JButton("Green");
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "green".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/green.png")).getImage();
				spheroPic.setIcon(new ImageIcon(imgb));
			}
		});
		btnGreen.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnGreen.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnGreen = new GridBagConstraints();
		gbc_btnGreen.insets = new Insets(0, 0, 5, 0);
		gbc_btnGreen.gridx = 0;
		gbc_btnGreen.gridy = 3;
		pnlTypes.add(btnGreen, gbc_btnGreen);
		
		JButton btnRed = new JButton("Red");
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "red".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/red.png")).getImage();
				spheroPic.setIcon(new ImageIcon(imgb));
			}
		});
		btnRed.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnRed.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnRed = new GridBagConstraints();
		gbc_btnRed.insets = new Insets(0, 0, 5, 0);
		gbc_btnRed.gridx = 0;
		gbc_btnRed.gridy = 4;
		pnlTypes.add(btnRed, gbc_btnRed);
		
		JButton btnPink = new JButton("Pink");
		btnPink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "pink".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/pink.png")).getImage();
				spheroPic.setIcon(new ImageIcon(imgb));
			}
		});
		btnPink.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnPink.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnPink = new GridBagConstraints();
		gbc_btnPink.insets = new Insets(0, 0, 5, 0);
		gbc_btnPink.gridx = 0;
		gbc_btnPink.gridy = 5;
		pnlTypes.add(btnPink, gbc_btnPink);
		
		JButton btnPurple = new JButton("Purple");
		btnPurple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "purple".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/purple.png")).getImage();
				spheroPic.setIcon(new ImageIcon(imgb));
			}
		});
		btnPurple.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnPurple.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnPurple = new GridBagConstraints();
		gbc_btnPurple.insets = new Insets(0, 0, 5, 0);
		gbc_btnPurple.gridx = 0;
		gbc_btnPurple.gridy = 6;
		pnlTypes.add(btnPurple, gbc_btnPurple);
		
		JButton btnbb8 = new JButton("bb8");
		btnbb8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = "bb8".hashCode();
				imgb = new ImageIcon(this.getClass().getResource("/bb8.png")).getImage();
				spheroPic.setIcon(new ImageIcon(imgb));
			}
		});
		btnbb8.setFont(new Font("Courier New", Font.PLAIN, 13));
		btnbb8.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnbb8 = new GridBagConstraints();
		gbc_btnbb8.insets = new Insets(0, 0, 5, 0);
		gbc_btnbb8.gridx = 0;
		gbc_btnbb8.gridy = 7;
		pnlTypes.add(btnbb8, gbc_btnbb8);
		
		JPanel pnlOk = new JPanel();
		pnlOk.setBackground(new Color(64, 224, 208));
		ChooseSphero.add(pnlOk, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok.");
		btnOk.setPreferredSize(new Dimension(70, 23));
		btnOk.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(id);
				setVisible(false);
			}
		});
		btnOk.setFont(new Font("Courier New", Font.PLAIN, 12));
		btnOk.setBackground(new Color(255, 255, 255));
		pnlOk.add(btnOk);
		
		setVisible(true);
	}
}