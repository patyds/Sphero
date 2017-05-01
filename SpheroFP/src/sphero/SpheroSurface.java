package sphero;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer.*;

import ds.DoubleLinkList;
import ds.Node;

import javax.swing.*;

public class SpheroSurface extends JPanel{
	private Sphero sphero;
	private boolean once = true;
	public Sphero getSphero() {
		return sphero;
	}

	public void setSphero(Sphero sphero) {
		this.sphero = sphero;
	}

	Node<Sphero> temp;
	private int axis =0;
	
	public SpheroSurface(Sphero sphero){
		this.sphero=sphero;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		sphero.paintSphero(g);
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
		if(once){
			if(trueAngle!=0&&trueAngle!=90&&trueAngle!=180&&trueAngle!=360&&trueAngle!=270){
				//System.out.println("True Angles: "+trueAngle+"  "+sphero.getAngle()+"  "+sphero.getTangle());
				if(sphero.getAngle()!=0&&sphero.getAngle()!=90&&sphero.getAngle()!=180&&sphero.getAngle()!=360&&sphero.getAngle()!=270){
					//System.out.println("Past Angle"+sphero.getAngle());
					if(trueAngle+sphero.getTangle()<=360){
					trueAngle=-sphero.getTangle()+trueAngle;
					}else{
						sphero.setAxis(0);
						int an=angle-(360-sphero.getTangle());
						once=false;
						setPlane(an,sphero);
					}
				}
			}
		}
		once=true;
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
	
	
}