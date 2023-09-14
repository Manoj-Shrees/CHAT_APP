/****************************************************************
CREATED BY SUWAS (****MANOJ SHREES*****)
*****************************************************************/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// Login class which takes a user name and passed it to client class
public class Login implements ActionListener{
	JFrame frame1;
	JTextField tf,tf1;
	JButton Log,sign;
	JLabel heading;
	JLabel label,label2,label3,label4;
        
	public static void main(String[] args){
		new Login();
	}

	public Login() {
  		 
               
    //Installisation elements ...................
                frame1 = new JFrame("                DREAM-HUNTER          ");
		tf=new JTextField();
                tf1=new JPasswordField();
                label2=new JLabel("Password");
		Log=new JButton("Log.in");
                                      sign=new JButton("Sign_UP");
		heading=new JLabel();
		heading.setFont(new Font("Impact", Font.BOLD,40));
		label=new JLabel("User Name");
		label.setFont(new Font("Serif", Font.PLAIN, 24));
                label2.setFont(new Font("Serif", Font.PLAIN, 24));
		JPanel panel = new JPanel();
		label3=new JLabel("mgdmvdvg");
                label4=new JLabel("zbxkjzdkjf");
                
     //Button Action...........................
                Log.addActionListener(this);
                sign.addActionListener(this);
		
    //Adding elements..........................
                panel.add(heading);
                panel.add(tf);
                panel.add(label);
                panel.add(label2);
                panel.add(tf1);
		panel.add(Log);
                                       panel.add(sign);
                panel.add(label3);
                panel.add(label4);

    //Setting Boundaries and Positions..................
		heading.setBounds(0,0,779,92);
		label.setBounds(100,175,150,30);
		tf.setBounds(300,175,150,30);
                label2.setBounds(100,225,150,30);
		tf1.setBounds(300,225,150,30);
		Log.setBounds(250,330,90,30);
                                      sign.setBounds(400,330,90,30);
		label3.setBounds(150,275,90,30);
		
                frame1.add(panel);
		panel.setLayout(null);
		frame1.setSize(800,500);
	        frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	// pass the user name to MyClient class
	public void actionPerformed(ActionEvent e1){
		String name="";

Object sr = e1.getSource();

if(sr.equals(Log)){
			name=tf.getText();
                                                             start srt = new start(name);
			frame1.dispose();
}

if(sr.equals(sign)){
                                                        new form();                                                          

}
}
}