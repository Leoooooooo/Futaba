import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class FutabaControl extends JFrame implements ActionListener{
	
	JPanel firstPanel, secondPanel, thirdPanel, xPanel, yPanel, nullPanel;
	
	JLabel x, y, empty1, empty2, empty3, empty4;
	
	JTextArea futabaCommands;
	
	JButton up, left, right, down, start;

	String output ="";
	
	boolean started = false;
	
	int height = 0, xDis = 0, yDis = 0;

	float xAcc, yAcc;
	
	public FutabaControl(){
		
		//Basiseinstellungen setzen
		super(); 
		setSize(850,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		
		//erstellen von anderen tollen Container
		nullPanel = new JPanel(new GridLayout(1,2));
		
		//erstellen der drei Panel mit Layout
		
		firstPanel = new JPanel(new GridLayout(3,3));
		secondPanel = new JPanel(new GridLayout(1,2));
		thirdPanel = new JPanel(new GridLayout(1,1));
		
		add(nullPanel);
		nullPanel.add(firstPanel);
		nullPanel.add(secondPanel);
		add(thirdPanel);
		
		// erstellen des Inhaltes von Panel 1
		empty1 = new JLabel(" ");
		empty2 = new JLabel(" ");
		empty3 = new JLabel(" ");
		empty4 = new JLabel(" ");
		
		
		up = new JButton ("up");
		up.setFont (up.getFont ().deriveFont (14.0f));
		up.setHorizontalAlignment(JLabel.CENTER);
		up.setVerticalAlignment(JLabel.CENTER);
		up.addActionListener(this);
		
		
		left = new JButton ("left");
		left.setFont (left.getFont ().deriveFont (14.0f));
		left.setHorizontalAlignment(JLabel.CENTER);
		left.setVerticalAlignment(JLabel.CENTER);
		left.addActionListener(this);
		
		right = new JButton ("right");
		right.setFont (right.getFont ().deriveFont (14.0f));
		right.setHorizontalAlignment(JLabel.CENTER);
		right.setVerticalAlignment(JLabel.CENTER);
		right.addActionListener(this);
		
		down = new JButton ("down");
		down.setFont (down.getFont ().deriveFont (14.0f));
		down.setHorizontalAlignment(JLabel.CENTER);
		down.setVerticalAlignment(JLabel.CENTER);
		down.addActionListener(this);
		
		start = new JButton ("start");
		start.setFont (start.getFont ().deriveFont (14.0f));
		start.setHorizontalAlignment(JLabel.CENTER);
		start.setVerticalAlignment(JLabel.CENTER);
		start.addActionListener(this);
		
		
		firstPanel.add(empty1);
		firstPanel.add(up);
		firstPanel.add(empty2);
		firstPanel.add(left);
		firstPanel.add(start);
		firstPanel.add(right);
		firstPanel.add(empty3);
		firstPanel.add(down);
		firstPanel.add(empty4);

		//erstellen des Inhaltes von Panel 2
		
		xPanel = new JPanel(new GridLayout(1,1));
		yPanel = new JPanel (new GridLayout(1,1));
		
		x = new JLabel("x");
		x.setFont (x.getFont ().deriveFont (14.0f));
		x.setHorizontalAlignment(JLabel.CENTER);
		x.setVerticalAlignment(JLabel.CENTER);

		
		y = new JLabel("y");
		y.setFont (y.getFont ().deriveFont (14.0f));
		y.setHorizontalAlignment(JLabel.CENTER);
		y.setVerticalAlignment(JLabel.CENTER);
	
		
		secondPanel.add(x);
		secondPanel.add(y);


		
		//erstellen des Inhaltes von Panel 3
		
		
		futabaCommands = new JTextArea(" ");
		futabaCommands.setEnabled(false);
		futabaCommands.setHorizontalAlignment(JLabel.CENTER);
		futabaCommands.setVerticalAlignment(JLabel.CENTER);
		thirdPanel.add(futabaCommands);
		
		scrollPane = new JScrollPane(futabaCommands);
		
		
				
	setVisible(true);	
		
	}
	
	public void startStop(boolean s){
		
		if(s == true){
			while(height>0){
				started=false;
				start.setText("Start");
				if(height>2){
					pitch(-0.2f);
				}else if(height>=0 && height >=2){
					pitch(-0.1f);
				} else {
					pitch(0.0f);
					return;
				}
			}

		}else{

			while(height<5){
				start.setText("Stop");
				started=true;
				if(height>2){
					pitch(0.1f);
				}else if(height>0 && height >=2){
					pitch(0.4f);
				} else {
					pitch(0.0f);
					return;
				}
			}
			
			
			}
			
		
	}
	
	
	
	public void flightControl(int xDis, int yDis){

			//x Acceleration
			if(xDis>15){
				xAcc = -0.6f;
			} else if(xDis<=15 && xDis>5){
				xAcc = -0.2f;
			} else if(xDis<5 && xDis >1){
				xAcc = -0.1f;
			} else if(xDis>=-1 && xDis <= 1){
				xAcc = 0.0f;
			} else if(xDis<5 && xDis >1){
				xAcc = 0.1f;
			} else if(xDis<=15 && xDis>5){
				xAcc = 0.2f;
			} else if(xDis<15){
				xAcc = 0.6f;
			}
			//y Acceleration
			if(yDis>15){
				yAcc = -0.6f;
			} else if(yDis<=15 && yDis>5){
				yAcc = -0.2f;
			} else if(yDis<5 && yDis >1){
				yAcc = -0.1f;
			} else if(yDis>=-1 && yDis <= 1){
				yAcc = 0.0f;
			} else if(yDis<5 && yDis >1){
				yAcc = 0.1f;
			} else if(yDis<=15 && yDis>5){
				yAcc = 0.2f;
			} else if(yDis<15){
				yAcc = 0.6f;
			}

			output += "Fly right with " + xAcc + " Times your potential Power"+" and fly forward with " + yAcc +" Times your Power.<br>";
			futabaCommands.setText(("<html>" + output + "</html>"));
			
			
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == this.up){
			yDis = yDis + 3;
			y.setText(yDis+"y");
			flightControl(xDis,yDis);
		}
		if(ae.getSource() == this.down){
			yDis = yDis - 3;
			y.setText(yDis+"y");
			flightControl(xDis,yDis);
		}
		if(ae.getSource() == this.right){
			xDis = xDis + 3;
			x.setText(xDis+"x");
			flightControl(xDis,yDis);
		}
		if(ae.getSource() == this.left){
			xDis = xDis - 3;
			x.setText(xDis+"x");
			flightControl(xDis,yDis);
		}
		if(ae.getSource() == this.start){
			startStop(started);
		}
	}

	public void pitch(float d){
		if(d<=0){
			height = height + 1;
		}else{
			height = height - 1;
		}
		output += "pitch " + d + "; <br> ";
		futabaCommands.setText(("<html>" + output + "</html>"));
	}

	public static void main(String [] args){
		
		//Methode mit String aufrufen, der als Fenstertitel verwendet wird
		FutabaControl beispiel = new FutabaControl();
	
	}

	
}
