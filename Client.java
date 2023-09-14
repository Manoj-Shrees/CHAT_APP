//Client Interface..........

import javax.swing.*;
import java.awt.*;
 
public class Client extends JFrame{
int check=0,check1=0;
JTextField Messagetext;
JScrollPane scrol;
DefaultListModel model;
DefaultListModel model1;
JList MessageArea,list1 ;
JButton  simely,send,ch_on;
JTabbedPane sym;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
Color x,x1;
public  Client(){
//MessageArea = new JTextArea();
Messagetext = new JTextField();
simely = new JButton();
send = new JButton();
		model=new DefaultListModel();
		model1=new DefaultListModel();
		MessageArea =new JList(model);
		list1=new JList(model1);
                                       scrol=new JScrollPane(list1);

ch_on= new JButton("{ ");
JPanel s1 = new JPanel();
JPanel s2 = new JPanel();
JPanel  s3= new JPanel();
JPanel s4 = new JPanel();
sym = new JTabbedPane();
l1 = new JLabel(new ImageIcon("1.png"));
l2 = new JLabel("2");
l3 = new JLabel("3");
l4 = new JLabel("4");
l5 = new JLabel("5");
l6 = new JLabel("6");
l7 = new JLabel("7");
l8 = new JLabel("8");
l9 = new JLabel("9");

 x = new Color(133,133,252);
 x1 = new Color(238,238,238);
add(Messagetext);
add(MessageArea);
add(simely);
add(send);
add(ch_on);
add(scrol);
setSize(805,500);

//list.setBackground(x);
ch_on.setBackground(x1);
ch_on.setBorder(null);

s1.add(l1);
s1.add(l2);
s1.add(l3);
s1.add(l4);
s1.add(l5);
s1.add(l6);
s1.add(l7);
s1.add(l8);
s1.add(l9);

s1.setLayout(new GridLayout(3,3));

sym.addTab("Simely",s1);
sym.addTab("",s2);
sym.addTab("",s3);
sym.addTab("",s4);

MessageArea.add(sym);

s1.add(l1);
s1.add(l2);
s1.add(l3);
s1.add(l4);
s1.add(l5);
s1.add(l6);
s1.add(l7);
s1.add(l8);
s1.add(l9);

s1.setLayout(new GridLayout());

setLayout(null);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

MessageArea.setLineWrap(true);
MessageArea.setBounds(30,30,600,300);
Messagetext.setBounds(40,350,450,30); 
simely.setBounds(490,350,50,30);
send.setBounds(570,350,50,30);
ch_on.setBounds(745,150,40,30);

sym.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
s1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
s2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
s3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
s4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
}

}