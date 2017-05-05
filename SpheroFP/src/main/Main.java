package main;
import java.awt.Toolkit;

import javax.swing.*;

import gui.ChooseSphero;
import gui.SpheroDeck;
import gui.SpheroGui;

public class Main {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setSize(800, 600);
		jFrame.setContentPane(new SpheroGui().getJPrincipal());
		jFrame.setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
        int x = ((int) tk.getScreenSize().getWidth()+1);
        int y = ((int) tk.getScreenSize().getHeight()-35);
        jFrame.setTitle("Sphero");
        jFrame.setBounds(0,0,x,y);
        
        
	}

}
