import javax.swing.JApplet;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.applet.*;

public class RacingApplet extends JApplet
{
	

	private JTextField input1, input2, input3, input4;
	private JLabel santaName, turkeyName, pumpkinName, bunnyName, negative;
	private JButton goButton;
	private Image road, santa, turkey, pumpkin, bunny;
	private JPanel appletPanel;
	private final int APPLET_WIDTH = 500;
	private int x1, x2, x3, x4, y1, y2, y3, y4;
	private Timer aniTimer;
	private int speed1, speed2, speed3, speed4;
	private AudioClip santaSound, turkeySound, pumpkinSound, bunnySound;


  public void init()
  {
 	input1 = new JTextField("0", 2);
	input2 = new JTextField("0", 2);
	input3 = new JTextField("0", 2);
	input4 = new JTextField("0", 2);
	goButton = new JButton("GO!");
	santaName = new JLabel("Santa");
	turkeyName = new JLabel("Turkey");
	pumpkinName = new JLabel("Pumpkin");
	bunnyName = new JLabel("Bunny");
	negative = new JLabel("Negative number,try again & press GO!");

	road = getImage (getDocumentBase(), "road.gif");
	santa = getImage (getDocumentBase(), "santa.gif");
	turkey = getImage (getDocumentBase(), "turkey.gif");
	pumpkin = getImage (getDocumentBase(), "pumpkin.gif");
	bunny = getImage (getDocumentBase(), "bunny.gif");

	aniTimer = new Timer(150, new TimerHandler());

	x1 = 0;	
	x2 = 0;	
	x3 = 0;	
	x4 = 0;
	y1 = 105;
	y2 = 180;
	y3 = 255;
	y4 = 330;

	santaSound = getAudioClip (getDocumentBase(), "santaSound.wav");
	turkeySound = getAudioClip (getDocumentBase(), "turkeySound.wav");
	pumpkinSound = getAudioClip (getDocumentBase(), "pumpkinSound.wav");
	bunnySound = getAudioClip (getDocumentBase(), "bunnySound.wav");
	

	appletPanel = new JPanel();
	appletPanel.add(santaName);
	appletPanel.add(input1);
	appletPanel.add(turkeyName);
	appletPanel.add(input2);
	appletPanel.add(pumpkinName);
	appletPanel.add(input3);
	appletPanel.add(bunnyName);
	appletPanel.add(input4);
	appletPanel.add(goButton);
	getContentPane().add(appletPanel);
	

 goButton.addActionListener(
  new ActionListener()
  {
    public void actionPerformed( ActionEvent e)
    {
	String speed1Text = input1.getText();
	speed1 = Integer.parseInt (speed1Text);
	String speed2Text = input2.getText();
	speed2 = Integer.parseInt (speed2Text);
	String speed3Text = input3.getText();
	speed3 = Integer.parseInt (speed3Text);
	String speed4Text = input4.getText();
	speed4 = Integer.parseInt (speed4Text);

	if (speed1 < 0 || speed2 < 0 || speed3 < 0 || speed4 < 0)
    {
	//only works if you drag the screen out
	appletPanel.add(negative);
	repaint();
    }
	else
    {
	appletPanel.remove(negative);
	if(speed1 > speed2 && speed1 > speed3  && speed1 > speed4)
	santaSound.loop();
	else if(speed2 > speed1 && speed2 > speed3  && speed2 > speed4)
	turkeySound.loop();
	else if(speed3 > speed2 && speed3 > speed1  && speed3 > speed4)
	pumpkinSound.loop();
	else if(speed4 > speed2 && speed4 > speed3  && speed4 > speed1)
	bunnySound.loop();

	aniTimer.start();
    }

    }//end of actionPerformed
  }//end of ActionListner
 );//end of addActionListener	

  }//end of init


  public void paint(Graphics g)
  {
	super.paint( g);

	g.drawLine ( 0, 100, 500, 100);
	g.drawLine ( 0, 175, 500, 175);
	g.drawLine ( 0, 250, 500, 250);
	g.drawLine ( 0, 325, 500, 325);

	g.drawImage(road, 0, 100, 1000, 75, this);
	g.drawImage(road, 0, 175, 1000, 75, this);
	g.drawImage(road, 0, 250, 1000, 75, this);
	g.drawImage(road, 0, 325, 1000, 75, this);

	g.drawImage(santa, x1, y1, this);
	g.drawImage(turkey, x2, y2, this);
	g.drawImage(pumpkin, x3, y3, this);
	g.drawImage(bunny, x4, y4, this);



  }//end of paint


private class TimerHandler implements ActionListener
{
  public void actionPerformed (ActionEvent event)
  {

	x1 = x1 + speed1;
	repaint();
	if(x1 > APPLET_WIDTH)
	{
	x1 = 0;
	//repaint();
	}

	x2= x2 + speed2;
	repaint();
	if(x2 > APPLET_WIDTH)
	{
	x2 = 0;
	//repaint();
	}

	x3= x3 + speed3;
	repaint();
	if(x3 > APPLET_WIDTH)
	{
	x3 = 0;
	//repaint();
	}

	x4= x4 + speed4;
	repaint();
	if(x4 > APPLET_WIDTH)
	{
	x4 = 0;
	//repaint();
	}	

	
  }//end of actionPerformed
}//end of ActionListener 
}//end of class  