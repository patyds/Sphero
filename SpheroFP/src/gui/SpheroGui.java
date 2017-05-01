package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sphero.Sphero;
import sphero.SpheroSurface;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;

import ds.DoubleLinkList;
import ds.Node;
import ds.Queue;
import grafos.Vertice;

import java.awt.Component;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SpheroGui {

	private Sphero sphero;
	private JPanel JPrincipal;
	private SpheroSurface spheroSurface;
	private int currentSphero;
	private JTextArea commandArea;
	private DoubleLinkList<Sphero> list = new DoubleLinkList<>();
	private ChooseSphero choose = new ChooseSphero();
	
	
	public SpheroGui(){
		fillList();
		sphero = workWith();
		//sphero = new Sphero(700,50,50,"/sphero.png");
		if(sphero==null){
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}else{
			spheroSurface= new SpheroSurface(sphero);
			spheroSurface.setBackground(new Color(255, 255, 255));
			inicialize();
			sphero.setY(0);
			sphero.setX(0);
			spheroSurface.setSphero(sphero);
		}
	}

	public void inicialize(){
		//spheroSurface = new SpheroSurface(sphero)
		//spheroSurface.setMinimumSize(new Dimension(327, 396));
		JPrincipal = new JPanel();
		JPrincipal.setBackground(new Color(64, 224, 208));
		JPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPrincipal.add(spheroSurface, BorderLayout.CENTER);
		
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(new Color(64, 224, 208));
		JPrincipal.add(pnlTitle, BorderLayout.NORTH);
		
		JLabel lblSphero = new JLabel("Sphero");
		lblSphero.setFont(new Font("Courier New", Font.BOLD, 20));
		pnlTitle.add(lblSphero);
		
		
		JPanel pnlOptions = new JPanel();
		pnlOptions.setBackground(new Color(64, 224, 208));
		pnlOptions.setPreferredSize(new Dimension(150, 10));
		pnlOptions.setSize(new Dimension(11, 0));
		JPrincipal.add(pnlOptions, BorderLayout.WEST);
		 Image imgb = new ImageIcon(this.getClass().getResource("/sphero.png")).getImage();
			pnlOptions.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(64, 224, 208));
		pnlOptions.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(64, 224, 208));
		pnlOptions.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblsphero = new JLabel("");
		panel_5.add(lblsphero);
		lblsphero.setIcon(new ImageIcon(imgb));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(64, 224, 208));
		pnlOptions.add(panel_6, BorderLayout.CENTER);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{18, 23, 0, 23, 23, 0, 23, 0, 0, 0, 0, 18, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
				
			JPanel panel_12 = new JPanel();
			panel_12.setBackground(new Color(64, 224, 208));
			GridBagConstraints gbc_panel_12 = new GridBagConstraints();
			gbc_panel_12.insets = new Insets(0, 0, 5, 0);
			gbc_panel_12.fill = GridBagConstraints.BOTH;
			gbc_panel_12.gridx = 0;
			gbc_panel_12.gridy = 0;
			panel_6.add(panel_12, gbc_panel_12);
			
			JLabel lblActions = new JLabel("Actions");
			GridBagConstraints gbc_lblActions = new GridBagConstraints();
			gbc_lblActions.anchor = GridBagConstraints.NORTH;
			gbc_lblActions.insets = new Insets(0, 0, 5, 0);
			gbc_lblActions.gridx = 0;
			gbc_lblActions.gridy = 1;
			panel_6.add(lblActions, gbc_lblActions);
			lblActions.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
			
			JButton btnForward = new JButton("Forward");
			GridBagConstraints gbc_btnForward = new GridBagConstraints();
			gbc_btnForward.anchor = GridBagConstraints.NORTH;
			gbc_btnForward.insets = new Insets(0, 0, 5, 0);
			gbc_btnForward.gridx = 0;
			gbc_btnForward.gridy = 2;
			panel_6.add(btnForward, gbc_btnForward);
			btnForward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Numbers num = new Numbers();
					num.setVisible(true);
					if(num.getSteps()>0){
						move(num.getSteps(),"Forward");
					}
				}
			});
			btnForward.setMaximumSize(new Dimension(95, 23));
			btnForward.setMinimumSize(new Dimension(95, 23));
			btnForward.setPreferredSize(new Dimension(100, 23));
			btnForward.setBackground(Color.WHITE);
			btnForward.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
			
			JButton btnBackward = new JButton("Backward");
			btnBackward.setPreferredSize(new Dimension(100, 23));
			btnBackward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Numbers num = new Numbers();
					num.setVisible(true);
					if(num.getSteps()>0){
						move(-num.getSteps(),"Backward");
					}
				}
			});
			GridBagConstraints gbc_btnBackward = new GridBagConstraints();
			gbc_btnBackward.anchor = GridBagConstraints.NORTH;
			gbc_btnBackward.insets = new Insets(0, 0, 5, 0);
			gbc_btnBackward.gridx = 0;
			gbc_btnBackward.gridy = 3;
			panel_6.add(btnBackward, gbc_btnBackward);
			btnBackward.setMaximumSize(new Dimension(95, 23));
			btnBackward.setMinimumSize(new Dimension(95, 23));
			btnBackward.setBackground(Color.WHITE);
			btnBackward.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
			
			JButton btnRotate = new JButton("Rotate");
			btnRotate.setPreferredSize(new Dimension(100, 23));
			btnRotate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Numbers num = new Numbers();
					num.setVisible(true);
					//System.out.println(num.getSteps());
					if(num.getSteps()>0&&num.getSteps()<361){
						rotate(num.getSteps());
					//	System.out.println(sphero.getAngle()+" "+angle)
					}
				}
			});
			GridBagConstraints gbc_btnRotate = new GridBagConstraints();
			gbc_btnRotate.anchor = GridBagConstraints.NORTH;
			gbc_btnRotate.insets = new Insets(0, 0, 5, 0);
			gbc_btnRotate.gridx = 0;
			gbc_btnRotate.gridy = 4;
			panel_6.add(btnRotate, gbc_btnRotate);
			btnRotate.setMaximumSize(new Dimension(95, 23));
			btnRotate.setMinimumSize(new Dimension(95, 23));
			btnRotate.setBackground(Color.WHITE);
			btnRotate.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
			
			JPanel panel_9 = new JPanel();
			panel_9.setBackground(new Color(64, 224, 208));
			GridBagConstraints gbc_panel_9 = new GridBagConstraints();
			gbc_panel_9.insets = new Insets(0, 0, 5, 0);
			gbc_panel_9.fill = GridBagConstraints.BOTH;
			gbc_panel_9.gridx = 0;
			gbc_panel_9.gridy = 5;
			panel_6.add(panel_9, gbc_panel_9);
			
			JLabel lblTrajectory = new JLabel("Trajectory");
			GridBagConstraints gbc_lblTrajectory = new GridBagConstraints();
			gbc_lblTrajectory.insets = new Insets(0, 0, 5, 0);
			gbc_lblTrajectory.anchor = GridBagConstraints.NORTH;
			gbc_lblTrajectory.gridx = 0;
			gbc_lblTrajectory.gridy = 6;
			panel_6.add(lblTrajectory, gbc_lblTrajectory);
			lblTrajectory.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
			
			JToggleButton tglbtnDrawLine = new JToggleButton("Draw Line");
			GridBagConstraints gbc_tglbtnDrawLine = new GridBagConstraints();
			gbc_tglbtnDrawLine.anchor = GridBagConstraints.NORTH;
			gbc_tglbtnDrawLine.insets = new Insets(0, 0, 5, 0);
			gbc_tglbtnDrawLine.gridx = 0;
			gbc_tglbtnDrawLine.gridy = 7;
			panel_6.add(tglbtnDrawLine, gbc_tglbtnDrawLine);
			tglbtnDrawLine.setMaximumSize(new Dimension(95, 23));
			tglbtnDrawLine.setMinimumSize(new Dimension(95, 23));
			tglbtnDrawLine.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
			tglbtnDrawLine.setBackground(Color.WHITE);
			
			JPanel panel_8 = new JPanel();
			panel_8.setBackground(new Color(64, 224, 208));
			GridBagConstraints gbc_panel_8 = new GridBagConstraints();
			gbc_panel_8.insets = new Insets(0, 0, 5, 0);
			gbc_panel_8.fill = GridBagConstraints.BOTH;
			gbc_panel_8.gridx = 0;
			gbc_panel_8.gridy = 8;
			panel_6.add(panel_8, gbc_panel_8);
			
			JLabel lblSphero_1 = new JLabel("Sphero");
			GridBagConstraints gbc_lblSphero_1 = new GridBagConstraints();
			gbc_lblSphero_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblSphero_1.gridx = 0;
			gbc_lblSphero_1.gridy = 9;
			panel_6.add(lblSphero_1, gbc_lblSphero_1);
			lblSphero_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblSphero_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
			
			JButton btnChooseSphero = new JButton("Choose Sphero");
			btnChooseSphero.setPreferredSize(new Dimension(115, 23));
			GridBagConstraints gbc_btnChooseSphero = new GridBagConstraints();
			gbc_btnChooseSphero.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChooseSphero.insets = new Insets(0, 0, 5, 0);
			gbc_btnChooseSphero.gridx = 0;
			gbc_btnChooseSphero.gridy = 10;
			panel_6.add(btnChooseSphero, gbc_btnChooseSphero);
			btnChooseSphero.setFont(new Font("Courier New", Font.PLAIN, 12));
			btnChooseSphero.setBackground(Color.WHITE);
			btnChooseSphero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveIns(commandArea.getText());
					choose.setVisible(true);
					currentSphero=choose.getId();
					sphero = workWith();
					spheroSurface.setSphero(sphero);
					spheroSurface.repaint();
					readIns();
				}
			});
			
			JButton btnHideSphero = new JButton("Hide Sphero");
			GridBagConstraints gbc_btnHideSphero = new GridBagConstraints();
			gbc_btnHideSphero.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnHideSphero.insets = new Insets(0, 0, 5, 0);
			gbc_btnHideSphero.gridx = 0;
			gbc_btnHideSphero.gridy = 11;
			panel_6.add(btnHideSphero, gbc_btnHideSphero);
			btnHideSphero.setPreferredSize(new Dimension(115, 23));
			btnHideSphero.setBackground(Color.WHITE);
			btnHideSphero.setFont(new Font("Courier New", Font.PLAIN, 12));
			btnHideSphero.setMaximumSize(new Dimension(110, 23));
			btnHideSphero.setMinimumSize(new Dimension(120, 23));
			
			JButton btnReset = new JButton("Reset");
			btnReset.setPreferredSize(new Dimension(115, 23));
			GridBagConstraints gbc_btnReset = new GridBagConstraints();
			gbc_btnReset.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnReset.insets = new Insets(0, 0, 5, 0);
			gbc_btnReset.gridx = 0;
			gbc_btnReset.gridy = 12;
			panel_6.add(btnReset, gbc_btnReset);
			btnReset.setBackground(Color.WHITE);
			btnReset.setFont(new Font("Courier New", Font.PLAIN, 12));
			btnReset.setMaximumSize(new Dimension(105, 23));
			btnReset.setMinimumSize(new Dimension(105, 23));
			
			JPanel panel_11 = new JPanel();
			panel_11.setBackground(new Color(64, 224, 208));
			GridBagConstraints gbc_panel_11 = new GridBagConstraints();
			gbc_panel_11.fill = GridBagConstraints.BOTH;
			gbc_panel_11.gridx = 0;
			gbc_panel_11.gridy = 13;
			panel_6.add(panel_11, gbc_panel_11);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(new Color(64, 224, 208));
			pnlOptions.add(panel_7, BorderLayout.WEST);
			
			JPanel panel_10 = new JPanel();
			panel_10.setBackground(new Color(64, 224, 208));
			pnlOptions.add(panel_10, BorderLayout.EAST);
		
		JPanel pnlCode = new JPanel();
		pnlCode.setPreferredSize(new Dimension(170, 10));
		pnlCode.setBackground(new Color(64, 224, 208));
		JPrincipal.add(pnlCode, BorderLayout.EAST);
		pnlCode.setLayout(new BorderLayout(0, 0));
		
		commandArea = new JTextArea();
		commandArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		commandArea.setBackground(Color.WHITE);
		pnlCode.add(commandArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		pnlCode.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{35, 100, 0};
		gbl_panel.rowHeights = new int[]{23, 23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveIns(commandArea.getText());
				readIns();
			}
		});
		GridBagConstraints gbc_btnRun = new GridBagConstraints();
		gbc_btnRun.insets = new Insets(0, 0, 5, 0);
		gbc_btnRun.anchor = GridBagConstraints.NORTH;
		gbc_btnRun.gridx = 1;
		gbc_btnRun.gridy = 0;
		panel.add(btnRun, gbc_btnRun);
		btnRun.setMaximumSize(new Dimension(90, 23));
		btnRun.setMinimumSize(new Dimension(100, 23));
		btnRun.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnRun.setBackground(SystemColor.text);
		btnRun.setPreferredSize(new Dimension(90, 23));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveIns(commandArea.getText());
				BufferedWriter writer = null;
				String name = JOptionPane.showInputDialog("Name your instructions [No spaces]");
				try{
				    writer = new BufferedWriter( new FileWriter(name+".txt"));
				    writer.write(commandArea.getText());
				    }
				catch ( IOException e){
				}
				finally{
				    try {
				        if ( writer != null)
				        writer.close( );
				    }
				    catch ( IOException e){
				    	JOptionPane.showMessageDialog(null, "There are no instructions to be saved", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				}
				JOptionPane.showMessageDialog(null, "Your instructions were saved :))", "Save", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 1;
		panel.add(btnSave, gbc_btnSave);
		btnSave.setMaximumSize(new Dimension(90, 23));
		btnSave.setMinimumSize(new Dimension(100, 23));
		btnSave.setBackground(Color.WHITE);
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		btnSave.setForeground(Color.BLACK);
		btnSave.setPreferredSize(new Dimension(100, 23));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		pnlCode.add(panel_1, BorderLayout.NORTH);
		
		JButton btnLoad = new JButton("Load");
		panel_1.add(btnLoad);
		btnLoad.setMaximumSize(new Dimension(100, 23));
		btnLoad.setMinimumSize(new Dimension(100, 23));
		btnLoad.setBackground(Color.WHITE);
		btnLoad.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jf = new JFileChooser(".");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				jf.setFileFilter(filter);
				//JOptionPane.showMessageDialog(null, "You're going to open the last saved instructions", "LOAD", JOptionPane.INFORMATION_MESSAGE);
				BufferedReader br = null;
				String everything = null;
				int returnValue = jf.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION){
					try {
						br = new BufferedReader(new FileReader(jf.getSelectedFile()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					try {
					    StringBuilder sb = new StringBuilder();
					    String line = br.readLine();

					    while (line != null) {
					        sb.append(line);
					       sb.append(System.lineSeparator());
					        line = br.readLine();
					    }
					    everything = sb.toString();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
					    try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				commandArea.setText(everything);
			}
		});
		btnLoad.setPreferredSize(new Dimension(100, 23));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 224, 208));
		pnlCode.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		pnlCode.add(panel_3, BorderLayout.EAST);
		
		
		JPanel pnlSpace = new JPanel();
		pnlSpace.setBackground(new Color(64, 224, 208));
		JPrincipal.add(pnlSpace, BorderLayout.SOUTH);
	}
	
	private void fillList() {
		list.addFirst(new Node<>(new Sphero("basic".hashCode(),5,5,"/sphero.png")));
		list.addFirst(new Node<>(new Sphero("blue".hashCode(),5,5,"/spheropic.png")));
		list.addFirst(new Node<>(new Sphero("pink".hashCode(),5,5,"/sphero.png")));
		list.addFirst(new Node<>(new Sphero("purple".hashCode(),5,5,"/sphero.png")));
		list.addFirst(new Node<>(new Sphero("green".hashCode(),5,5,"/sphero.png")));
		list.addFirst(new Node<>(new Sphero("red".hashCode(),5,5,"/sphero.png")));
		list.addFirst(new Node<>(new Sphero("gray".hashCode(),5,5,"/sphero.png")));
		list.addFirst(new Node<>(new Sphero("bb8".hashCode(),5,5,"/bb8.png")));
	}
	
	private Sphero workWith() {
		currentSphero = choose.getId();
		Sphero s = null;
		//FIXX
		if(searchSphero(currentSphero)!=null){
			Node<Sphero> node= searchSphero(currentSphero);
			s= node.getElement();
		}
		return s;
	}
	
	public JPanel getJPrincipal(){
		return JPrincipal;
	}
	
	public Node<Sphero> searchSphero(int id){
		Node<Sphero> aux = list.getFirst();
		for(int i=0;i<list.getSize();i++){
			if(aux.getElement().getId()==id){
				return aux;
			}
			aux=aux.getNext();
		}
		return null;
	}
	
	public void move(int steps, String direction){
		int panelW = spheroSurface.getWidth();
		int panelH = spheroSurface.getHeight();
		int xx,yy;
		boolean completeMove = true;
		double rad = Math.toRadians(sphero.getAngle());
		/*for(i=1;i<=steps;i++){
			xx = (int)(sphero.getX()+1*(Math.cos(rad)));
			yy = (int)(sphero.getY()+1*Math.sin(rad));
			if(xx<0||xx>panelW||yy<0||yy>panelH){
				JOptionPane.showMessageDialog(null, "You can't keep moving in that direction, sorry :|");
				completeMove=false;
				break;
			}else{
				sphero.setX(xx);
				sphero.setY(yy);
				spheroSurface.revalidate();
				spheroSurface.repaint();
			}
		}*/
		try {
			Thread.sleep(100);
			xx = (int)(sphero.getX()+steps*(Math.cos(rad)));
			yy = (int)(sphero.getY()+steps*Math.sin(rad));
			int by = sphero.getY();
			int bx = sphero.getX();
			sphero.setBx(bx);
			sphero.setBy(by);
			if(xx<0||xx>panelW||yy<0||yy>panelH){
				JOptionPane.showMessageDialog(null, "You can't move that far in that direction, sorry :|");
				completeMove=false;
			}else{
				sphero.setX(xx);
				sphero.setY(yy);
				//Vertice v = new Vertice("1",xx,yy);
				spheroSurface.revalidate();
				spheroSurface.repaint();
			}
			if(completeMove){
				String com = commandArea.getText();
				if(com.length()>2){
					commandArea.append("\n"+direction+"("+steps+");");
				}else{
					commandArea.append(direction+"("+steps+");");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void rotate(int s){
		int angle = spheroSurface.setPlane(s,sphero);
		sphero.setAngle(angle);
		//System.out.println("Angulos"+sphero.getAngle()+"  "+ list.getFirst().getElement().getAngle());
		sphero.setTangle(s);
		String com = commandArea.getText();
		if(com.length()>2){
			commandArea.append("\nRotate("+s+");");
		}else{
			commandArea.append("Rotate("+s+");");
		}
	}
	public void saveIns(String ins){
		sphero.setX(0);
		sphero.setY(0);
		String[] res = ins.split("\\;");
		int le=res.length;
		System.out.println(ins);
		System.out.println(sphero.queue.getSize());
		if(sphero.queue.getSize()>0){
			while(sphero.queue.getSize()>0){
				sphero.queue.remove();
			}
		}
		if(ins.substring(ins.length()-1).equals(';')){
			le=res.length-1;
		}
		System.out.println(ins.substring(ins.length()).equals(';')+"  "+(ins.length()));
		System.out.println(sphero.queue.getSize()+"  "+res.length+"   "+le);
		for(int i =0; i<le;i++){
			sphero.queue.add(new Node<>(res[i]));
			System.out.println(res[i]);
		}
		//System.out.println(sphero.queue.getSize());
	}
	public void readIns(){
		commandArea.setEditable(false);
		commandArea.setText("");
		sphero.setAxis(0);
		sphero.setTangle(0);
		sphero.setAngle(0);
		Node<String> aux =sphero.queue.getFirst();
		for(int i=0;i<sphero.queue.getSize();i++){
			String temp= aux.getElement();
			System.out.println(temp+" "+sphero.queue.getSize());
			String[] spl1 = temp.split("\\(");
			String[] spl2 =spl1[1].split("\\)");
			int num = Integer.parseInt(spl2[0]);
			char c;
			if(i==0){
				c = temp.charAt(0);
			}else{
				c = temp.charAt(1);
				if(c!='F'&&c!='R'&&c!='B'){
					System.out.println(i+" "+c);
					c=temp.charAt(2);
				}
			}
			System.out.println(i+" "+c);
			switch(c){
				case 'F':
					move(num,"Forward");
					break;
				case 'B':
					move(-num,"Backward");
					break;
				case 'R':
					rotate(num);
					break;
			}
			aux=aux.getNext();
		}
		commandArea.setEditable(true);
	}
	
}
