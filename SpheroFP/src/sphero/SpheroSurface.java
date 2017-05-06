package sphero;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Timer.*;

import ds.CircularLinked;
import ds.DoubleLinkList;
import ds.Node;
import ds.Queue;
import grafos.Arista;
import grafos.España;
import grafos.Vertice;

import javax.swing.*;

public class SpheroSurface extends JPanel{
	public CircularLinked<Integer> angles = new CircularLinked<Integer>();
	public España<Integer, Vertice> españa = new España<Integer, Vertice>(17);
	public Queue<Vertice> newOrder = new Queue<Vertice>();
	public Node<Sphero> temp;
	private Sphero sphero;
	private int axis =0;
	private boolean grafo = false;
	
	public SpheroSurface(Sphero sphero){
		this.sphero=sphero;
		españa.fillCarreterras(españa);
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(grafo){
			if(españa.aristas.getSize()>0){
				Node<Arista> aux = españa.aristas.getFirst();
				for(int j=0;j<españa.aristas.getSize();j++){
					Arista ar = aux.getElement();
					ar.draw(g);
					aux=aux.getNext();
				}
			}
			if(españa.getSize()>0){
				for(int i=0;i<españa.getSize();i++){
					españa.get(i).draw(g);
				}
			}
			if(newOrder.getSize()>0){
				Node<Vertice> no = newOrder.getFirst();
				for(int k=0;k<newOrder.getSize();k++){
					Vertice v = no.getElement();
					v.Visited(g);
					no=no.getNext();
				}
			}
		}
		sphero.paintSphero(g);
	}
	public void addang(){
		for(int i=0;i<361;i++){
			angles.addLast(new Node<Integer>(i));
		}
	}

	public Node<Sphero> searchSphero(DoubleLinkList<Sphero> list,int id){
		//System.out.println(";)");
		Node<Sphero> aux = list.getFirst();
		//System.out.println(aux.getElement().getId());
		for(int i=0;i<list.getSize();i++){
			if(aux.getElement().getId()==id){
				//System.out.println(aux.getElement().getId());
				return aux;
			}
			aux=aux.getNext();
		}
		return null;
	}
	
	public int setAngle(int plusangle, Sphero sphero){
		int trueAngle=0;
		int pastAngleG = sphero.getAngleG();
		Node<Integer> aux = angles.getFirst();
		for(int i=0; i<angles.getSize();i++){
			int ang = aux.getElement();
			if(ang==pastAngleG){
				for(int j=0;j<plusangle;j++){
					aux=aux.getNext();
				}
				break;
			}
			aux=aux.getNext();
		}
		int angle = aux.getElement();
		if(angle>0&&angle<90){
			trueAngle=360-angle;
		}else if(angle>90&&angle<180){
			trueAngle=180+(180-angle);
		}else if(angle>180&&angle<270){
			trueAngle=90+(270-angle);
		}else if(angle>270&&angle<360){
			trueAngle=90-(angle-270);
		}else if(angle==0||angle==360) trueAngle=0;
		else if(angle==90){ trueAngle=270;}
		else if(angle==180){ trueAngle=180;}
		else if(angle==270){ trueAngle=90;}
		sphero.setAngleG(angle);
		return trueAngle;
	}
	
	public int setPlane(int angle, Sphero sphero){
		//Sphero sphero = temp.getElement();
		int trueAngle=0;
		if(sphero.getAxis()==0){
			if(angle>0&&angle<90){
				trueAngle=360-angle;
			}else if(angle>90&&angle<180){
				trueAngle=180+(180-angle);
			}else if(angle>180&&angle<270){
				trueAngle=90+(270-angle);
			}else if(angle>270&&angle<360){
				trueAngle=90-(angle-270);
			}else if(angle==0||angle==360) trueAngle=0;
			else if(angle==90){ trueAngle=270;}
			else if(angle==180){ trueAngle=180;}
			else if(angle==270){ trueAngle=90;}
		}else if(sphero.getAxis()==90){
			if(angle>0&&angle<90){
				trueAngle=90-angle;
			}else if(angle>90&&angle<180){
				trueAngle=360-(angle-90);
			}else if(angle>180&&angle<270){
				trueAngle=180+(90-(angle-180));
			}else if(angle>270&&angle<360){
				trueAngle=90+(angle-270);
			}else if(angle==0||angle==360) trueAngle=90;
			else if(angle==90){ trueAngle=0;}
			else if(angle==180){ trueAngle=270;}
			else if(angle==270){ trueAngle=180;}
		}else if(sphero.getAxis()==180){
			if(angle>0&&angle<90){
				trueAngle=90+(90-angle);
			}else if(angle>90&&angle<180){
				trueAngle=90-(angle-90);
			}else if(angle>180&&angle<270){
				trueAngle=270+(90-(angle-180));
			}else if(angle>270&&angle<360){
				trueAngle=270-(angle-270);
			}else if(angle==0||angle==360) trueAngle=180;
			else if(angle==90) trueAngle=90;
			else if(angle==180) trueAngle=0;
			else if(angle==270) trueAngle=270;
		}else if(sphero.getAxis()==270){
			if(angle>0&&angle<90){
				trueAngle=180+(90-angle);
			}else if(angle>90&&angle<180){
				trueAngle=90+(90-angle);
			}else if(angle>180&&angle<270){
				trueAngle=90-(angle-180);
			}else if(angle>270&&angle<360){
				trueAngle=90-(angle-270);
			}else if(angle==0||angle==360) trueAngle=270;
			else if(angle==90) trueAngle=180;
			else if(angle==180) trueAngle=90;
			else if(angle==270) trueAngle=0;
		}
		
			if(trueAngle!=0&&trueAngle!=90&&trueAngle!=180&&trueAngle!=360&&trueAngle!=270){
				//System.out.println("True Angles: "+trueAngle+"  "+sphero.getAngle()+"  "+sphero.getTangle());
				if(sphero.getAngleR()!=0&&sphero.getAngleR()!=90&&sphero.getAngleR()!=180&&sphero.getAngleR()!=360&&sphero.getAngleR()!=270){
					//System.out.println("Past Angle"+sphero.getAngle());
					if(trueAngle+sphero.getTangle()<=360){
					trueAngle=-sphero.getTangle()+trueAngle;
					}else{
						sphero.setAxis(0);
						int an=angle-(360-sphero.getTangle());
						setPlane(an,sphero);
					}
				}
		}
		
		//System.out.println("True Angle: "+trueAngle);
		if(trueAngle>0&&trueAngle<=90){
			sphero.setAxis(90);
		}else if(trueAngle>90&&trueAngle<=180){
			sphero.setAxis(180);
		}else if(trueAngle>180&&trueAngle<=270){
			sphero.setAxis(270);
		}else if(trueAngle>270&&trueAngle<=360||trueAngle==0){
			sphero.setAxis(0);
		}
		//System.out.println("axis"+getAxis());
		return trueAngle;
	}
	
	
	public int getAxis() {
		return axis;
	}

	public void setAxis(int axis) {
		this.axis = axis;
	}
	
	
	public Sphero getSphero() {
		return sphero;
	}

	public void setSphero(Sphero sphero) {
		this.sphero = sphero;
	}

	public boolean isGrafo() {
		return grafo;
	}

	public void setGrafo(boolean grafo) {
		this.grafo = grafo;
	}
	
	
}