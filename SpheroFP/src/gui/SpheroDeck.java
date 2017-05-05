package gui;

import sphero.SpheroSurface;
import sphero.Sphero;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import ds.DoubleLinkList;
import ds.Node;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

public class SpheroDeck {
	private Sphero sphero;
	private JPanel JPrincipal;
	private SpheroSurface spheroSurface;
	private JTextArea freeCode;
	private DoubleLinkList<Sphero> list = new DoubleLinkList<>();
	private int currentSphero;
	
	
	
	public SpheroDeck(){
		//Just adding Spheros to the list
		list.addFirst(new Node<>(new Sphero("basic".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("blue".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("pink".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("purple".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("green".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("red".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("gray".hashCode(),5,5,"sphero.png")));
		list.addFirst(new Node<>(new Sphero("bb8".hashCode(),5,5,"sphero.png")));
		
		sphero = new Sphero(700,5,5,"sphero.png");
		spheroSurface = new SpheroSurface(sphero);
		
		inicialize();
		sphero.setY(0);
		sphero.setX(0);
	}

	public void inicialize(){
		JPrincipal = new JPanel();
		JPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPrincipal.add(spheroSurface, BorderLayout.CENTER);
		
		JToolBar JToolBar = new JToolBar();
		JToolBar.setMaximumSize(new Dimension(14, 2));
		JToolBar.setOrientation(SwingConstants.VERTICAL);
		JPrincipal.add(JToolBar, BorderLayout.WEST);
		

		
		//ImageIcon back = new ImageIcon("backward.png");
		JButton backwardbtn = new JButton();
		backwardbtn.setMinimumSize(new Dimension(50, 30));
		backwardbtn.setMaximumSize(new Dimension(60, 35));
	    Image imgb = new ImageIcon(this.getClass().getResource("/backward.png")).getImage();
	    backwardbtn.setIcon(new ImageIcon(imgb));
		backwardbtn.setBackground(SystemColor.inactiveCaptionBorder);
		backwardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
		JToolBar.add(lblActions);
		
		JButton fowardbtn = new JButton();
		fowardbtn.setMaximumSize(new Dimension(60, 35));
		Image imgf = new ImageIcon(this.getClass().getResource("/foward.png")).getImage();
	    fowardbtn.setIcon(new ImageIcon(imgf));
		fowardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers num = new Numbers();
				num.setVisible(true);
				if(num.getSteps()>0){
					int steps = num.getSteps();
					//double rad = Math.toRadians(sphero.getAngle());
					//int xx = (int)(sphero.getX()+(steps*(Math.cos(rad))));
					//sphero.setX(xx);
					//int yy = (int)(sphero.getY()+(steps*Math.sin(rad)));
					//sphero.setY(yy);
					//System.out.println(sphero.getY()+" "+Math.sin(rad)+" "+sphero.getX()+" "+sphero.getAngle());
					spheroSurface.repaint();
				}
			}
		});
		fowardbtn.setBackground(SystemColor.inactiveCaptionBorder);
		JToolBar.add(fowardbtn);
		JToolBar.add(backwardbtn);
		
		
		
		JButton btnRotate = new JButton();
		btnRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers num = new Numbers();
				num.setVisible(true);
				//System.out.println(num.getSteps());
				if(num.getSteps()>0&&num.getSteps()<361){
					//int angle = spheroSurface.setPlane(num.getSteps());
					//sphero.setAngle(angle);
					sphero.setTangle(num.getSteps());
				//	System.out.println(sphero.getAngle()+" "+angle)
				}
			}
		});
		btnRotate.setMaximumSize(new Dimension(60, 35));
		Image imgr = new ImageIcon(this.getClass().getResource("/rotate.png")).getImage();
	    btnRotate.setIcon(new ImageIcon(imgr));
		btnRotate.setBackground(SystemColor.inactiveCaptionBorder);
		JToolBar.add(btnRotate);
		
		JButton movebtn = new JButton("Move to");
		movebtn.setMaximumSize(new Dimension(60, 23));
		movebtn.setMinimumSize(new Dimension(60, 23));
		movebtn.setBackground(SystemColor.inactiveCaptionBorder);
		movebtn.setPreferredSize(new Dimension(50, 43));
		movebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if(input.getText().length()>0){
					int steps = Integer.parseInt(input.getText());
					sphero.setX(sphero.getX()+steps);
					spheroSurface.repaint();
				}*/
			}
		});
		JToolBar.add(movebtn);
		
		JButton stopbtn = new JButton("Stop");
		stopbtn.setMaximumSize(new Dimension(60, 23));
		stopbtn.setMinimumSize(new Dimension(56, 23));
		stopbtn.setAlignmentY(Component.TOP_ALIGNMENT);
		stopbtn.setBackground(SystemColor.inactiveCaptionBorder);
		stopbtn.setPreferredSize(new Dimension(50, 43));
		stopbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JToolBar.add(stopbtn);
		
		JLabel lblTrajectory = new JLabel("Trajectory");
		lblTrajectory.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
		JToolBar.add(lblTrajectory);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setMinimumSize(new Dimension(85, 23));
		btnDraw.setMaximumSize(new Dimension(85, 23));
		btnDraw.setBackground(SystemColor.inactiveCaptionBorder);
		JToolBar.add(btnDraw);
		
		JButton btnDontDraw = new JButton("Don't Draw");
		btnDontDraw.setBackground(SystemColor.inactiveCaptionBorder);
		JToolBar.add(btnDontDraw);
		
		JLabel lblSphero = new JLabel("Sphero");
		lblSphero.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
		JToolBar.add(lblSphero);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setMaximumSize(new Dimension(91, 23));
		btnReset.setBackground(SystemColor.inactiveCaptionBorder);
		JToolBar.add(btnReset);
		
		JButton btnHide = new JButton("Hide Sphero");
		btnHide.setBackground(SystemColor.inactiveCaptionBorder);
		JToolBar.add(btnHide);
		
		JPanel controlPanel = new JPanel();
		JPrincipal.add(controlPanel, BorderLayout.EAST);
		controlPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		controlPanel.add(panel_1, BorderLayout.SOUTH);
		
		JButton runbtn = new JButton("Run");
		runbtn.setPreferredSize(new Dimension(60, 23));
		runbtn.setMinimumSize(new Dimension(60, 23));
		runbtn.setMaximumSize(new Dimension(60, 23));
		runbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(runbtn);
		
		JButton loadbtn = new JButton("Load");
		panel_1.add(loadbtn);
		
		JButton savebtn = new JButton("Save");
		panel_1.add(savebtn);
		
		freeCode = new JTextArea();
		controlPanel.add(freeCode, BorderLayout.CENTER);
	}
	
	
	
	
	 public JPanel getJPrincipal(){
		return JPrincipal;
	};
	
	
		

}
