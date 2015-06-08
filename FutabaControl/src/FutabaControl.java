import javax.swing.*;
import java.awt.*;

public class FutabaControl extends JFrame {
	
	JPanel firstPanel, secondPanel, thirdPanel, xPanel, yPanel, nullPanel;
	
	JLabel x, y, empty1, empty2, empty3, empty4, futabaCommands;
	
	JButton up, left, right, down, start;

	
	boolean started = false;
	
	int height = 0;
	
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
		
		
		left = new JButton ("left");
		left.setFont (left.getFont ().deriveFont (14.0f));
		left.setHorizontalAlignment(JLabel.CENTER);
		left.setVerticalAlignment(JLabel.CENTER);
		
		
		right = new JButton ("right");
		right.setFont (right.getFont ().deriveFont (14.0f));
		right.setHorizontalAlignment(JLabel.CENTER);
		right.setVerticalAlignment(JLabel.CENTER);
		
		
		down = new JButton ("down");
		down.setFont (down.getFont ().deriveFont (14.0f));
		down.setHorizontalAlignment(JLabel.CENTER);
		down.setVerticalAlignment(JLabel.CENTER);
		
		
		start = new JButton ("start");
		start.setFont (start.getFont ().deriveFont (14.0f));
		start.setHorizontalAlignment(JLabel.CENTER);
		start.setVerticalAlignment(JLabel.CENTER);
		
		
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
		xPanel.add(x);
		
		y = new JLabel("y");
		y.setFont (y.getFont ().deriveFont (14.0f));
		y.setHorizontalAlignment(JLabel.CENTER);
		y.setVerticalAlignment(JLabel.CENTER);
		yPanel.add(y);
		
		secondPanel.add(xPanel);
		secondPanel.add(yPanel);
		
		
		
		
		//erstellen des Inhaltes von Panel 3
		futabaCommands = new JLabel("GUT");
		futabaCommands.setHorizontalAlignment(JLabel.CENTER);
		futabaCommands.setVerticalAlignment(JLabel.CENTER);
		thirdPanel.add(futabaCommands);
		
		
		
		
		
		//___________________________________
		
		
		
		
		
		
		
		
	setVisible(true);	
		
	}
	
	public void startStop(boolean s){
		
		if(s == true){
			while(height>0){
				if(height>2){
					pitch(-0.4f);
				}else if(height>0 && height >=2){
					pitch(-0.1f);
				} else {
					pitch(0.0f);
				}
			}
			started=false;
		}else{

			while(height<5){
				if(height>2){
					pitch(0.1f);
				}else if(height>0 && height >=2){
					pitch(0.4f);
				} else {
					pitch(0.0f);
				}
			}
			started=true;
			}
			
		
	}
	
	public void pitch(float d){
		System.out.println(d);
	}
	public static void main(String [] args){
		
		//Methode mit String aufrufen, der als Fenstertitel verwendet wird
		FutabaControl beispiel = new FutabaControl();
	
	}

	
}
