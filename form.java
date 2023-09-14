import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class form extends JFrame implements KeyListener{
JButton b1;
JCheckBox jc1;
JTextField t1,t2,t3,t4,t5,t6;
public String a,b,c,d,e;
JRadioButton r1,r2;
//JFrame f;

public form(){
super();
String[] country={"AMERICA","AFRICA","ENGLAND","AUSTRIALIA","INDIA","NEPAL"};
String[] state={"katmadu","himachal pradesh","tamilnadu"};
String[] city={"chandigarh","solan","subathu"};

JLabel l1 = new JLabel(new ImageIcon("l1.png"));
JLabel l2 = new JLabel("<html> <H3 align = center> WELCOME TO DreamX </H3> <br> TO USE THE SERVICE  PLEASE REGISER THE FOLLOWING TO CONTINUE... </HTML>");
JLabel l3 = new JLabel("ENTER FIRST NAME:");
JLabel l4 = new JLabel("LAST NAME:");
JLabel l5 = new JLabel("E_MAIL ID:");	
JLabel l6 = new JLabel("PASSWORD:");
JLabel l7 = new JLabel("CONFORM PASSWORD:");
JLabel l8 = new JLabel("SEX:");
JLabel l9 = new JLabel("MOB/tel NO:");
JLabel l10 =new JLabel("SELECT YOUR REGION YOU BELONG:");
JLabel l11 = new JLabel("<html> <b> <u> <h3> TERMS & CONDITION </h3> </b> </u> </html>");
JLabel l12 = new JLabel("<html> <h1>©  COPYRIGHT  DreamX  </h1> </html>");

t1 = new JTextField();
t2 = new JTextField();
t3 = new JTextField();
t4 = new JPasswordField();
t5 = new JPasswordField();
t6 = new JTextField();

t4.setToolTipText("Password Should Not Contain  { / * - ~ ! $ % ^ & ( < ? > ) _ - + ' ` } ");
t5.setToolTipText("<html>password should not contain { / * - ~ ! $ % ^ & ( < ? > ) _ - + ' ` }  <br> both the password contain same character!! </html>");

JComboBox co1 = new JComboBox(country);
JComboBox co2 = new JComboBox(state);
JComboBox co3 = new JComboBox(city);


ButtonGroup bg = new ButtonGroup();

 r1 = new JRadioButton("MALE");
r2 = new JRadioButton("FEMALE");

jc1 = new JCheckBox("I Accept the terms and Conditions and want to continue to create my new account!!");

JPanel p = new JPanel();
b1 = new JButton("Submit ");
setSize(1120,680);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

p.setLayout(null); 
bg.add(r1);
bg.add(r2);

add(p);

p.add(l1);
p.add(l2);
p.add(l3);
p.add(t1);
p.add(l4);
p.add(t2);
p.add(l5);
p.add(t3);
p.add(l6);
p.add(t4);
p.add(l7);
p.add(t5);
p.add(l8);
p.add(r1);
p.add(r2);
p.add(l9);
p.add(t6);
p.add(l10);
p.add(co1);
p.add(co2);
p.add(co3);
p.add(l11);
p.add(jc1);
p.add(b1);
p.add(l12);

l1.setBounds(1,1,300,102);
l2.setBounds(350,1,500,102);
l3.setBounds(50,150,150,20);
t1.setBounds(200,150,200,20);
l4.setBounds(500,150,100,20);
t2.setBounds(600,150,200,20);
l5.setBounds(50,200,100,20);
t3.setBounds(200,200,200,20);
l6.setBounds(500,200,100,20);
t4.setBounds(600,200,200,20);
l7.setBounds(50,250,150,20);
t5.setBounds(200,250,200,20);
l8.setBounds(500,250,100,20);
r1.setBounds(600,250,80,20);
r2.setBounds(700,250,80,20);
l9.setBounds(50,300,100,20);
t6.setBounds(200,300,200,20);
l10.setBounds(500,300,300,20);
co1.setBounds(500,350,150,30);
co2.setBounds(680,350,150,30);
co3.setBounds(860,350,150,30);
l11.setBounds(430,430,150,20);
jc1.setBounds(250,460,700,20);
b1.setBounds(500,540,100,30);
l12.setBounds(330,600,500,30);

b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//b1.setEnabled(false);
//b1.addActionListener(this);
t4.addKeyListener ( this ) ;
t5.addKeyListener ( this ) ;
}

 public void actionPerformed(ActionEvent e)
{
Object src = e.getSource();
if(src.equals(b1))
{

} 
}
 
public void keyTyped ( KeyEvent e ){  
String a = t4.getText();
String b = t5.getText();
switch(a)
{
case "_":
case "+":
case "-":
case "@":
case "*":
case "/":
case "^":
case "$":
case "&":
case "(":
case ")":
case "#":
case "!":
case "~":
case "'":
JOptionPane.showMessageDialog(this,"Password Should Not Contain {/*-~!$%^&(<?>)_-+'`}");
a="";
break;
} 	
     } 
public void keyPressed ( KeyEvent e){  
	 
		}  
		
public void keyReleased ( KeyEvent e ){  
		
		}
public static void main(String[] arg)
{
form j=new form();
} 
}

/*public class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent me){
		
		}
	}*/