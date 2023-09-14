import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.*;
import javax.swing.*;

public class start extends Client implements ActionListener{
                    Socket s,s1,s2;
	DataInputStream din;
	DataOutputStream dout;
	DataOutputStream dlout;
	DataOutputStream dout1;
	DataInputStream din1;
	String name;

public start(String name){


		this.name=name;
                                       try{
                                         //creates a socket object
		s=new Socket("localhost",1445);	
		s1=new Socket("localhost",1445);
		s2=new Socket("localhost",1445);
                                        
                                         //create inputstream for a particular socket
		din=new DataInputStream(s.getInputStream());
		
                                        //create outputstream
		dout=new DataOutputStream(s.getOutputStream());
		
                                        //sending a message for login
                                        dout.writeUTF("welcome");	
		dout.writeUTF(name+" has Logged in.");	
		dlout=new DataOutputStream(s1.getOutputStream());
		dout1=new DataOutputStream(s2.getOutputStream());
		din1=new DataInputStream(s2.getInputStream());

                                       simely.addActionListener(this);
                                       send.addActionListener(this);
                                       ch_on.addActionListener(this);
// creating a thread for maintaning the list of user name
		My1 m1=new My1(dout1,model1,name,din1);
		Thread t1=new Thread(m1);
		t1.start();	
	//creating a thread for receiving a messages
		My m=new My(din,model);
		Thread t=new Thread(m);
		t.start();
}
catch(IOException ioext){
System.out.print("Error in Connection");
}
}

public void actionPerformed(ActionEvent ew){
Object src = ew.getSource();
if(src.equals(simely))
{
if(check == 0){
sym.setBounds(400,120,150,180);
check = 1;
}
else if(check==1){
sym.setBounds(0,0,0,0);
check = 0;
}
}


if(src.equals(send)){
String str="";
str=Messagetext.getText();
Messagetext.setText("");
str=name+"     "+str;
			
try{
			
dout.writeUTF(str);
System.out.println(str);
dout.flush();
}
catch(IOException txterr){
System.out.println("Message cannot  send");
}

}

if(src.equals(ch_on)){
if(check1==0){
ch_on.setBackground(x);
scrol.setBounds(635,30,150,300);
list1.setBounds(635,30,150,300);
ch_on.setBounds(635,150,40,30);
check1 = 1;
}
else if(check1==1){
ch_on.setBounds(745,150,40,30);
scrol.setBounds(0,0,0,0);
list1.setBounds(0,0,0,0);
ch_on.setBackground(x1);
check1 =0;
}
}


	}

}
// class is used to maintaning the list of user name
class My1 implements Runnable{
	DataOutputStream dout1;
	DefaultListModel model1;	
	DataInputStream din1;
	String name,lname;
	ArrayList alname=new ArrayList(); //stores the list of user names
	ObjectInputStream obj; // read the list of user names
	int i=0;
	My1(DataOutputStream dout1,DefaultListModel model1,String name,DataInputStream din1){
		this.dout1=dout1;
		this.model1=model1;
		this.name=name;
		this.din1=din1;
	}
	public void run(){
		try{
		dout1.writeUTF(name);  // write the user name in output stream
		while(true){
			obj=new ObjectInputStream(din1);
			//read the list of user names
			alname=(ArrayList)obj.readObject(); 
			if(i>0)
			model1.clear(); 
			Iterator i1=alname.iterator();
			System.out.println(alname);
			while(i1.hasNext()){
				lname=(String)i1.next();
				i++;
				 //add the user names in list box
				model1.addElement(lname);
				}
			}
		}catch(Exception oe){}
	}
}

//class is used to received the messages
class My implements Runnable{
	DataInputStream din;
	DefaultListModel model;
	My(DataInputStream din, DefaultListModel model){
		this.din=din;
		this.model=model;
	}
	public void run(){
		String str1="";
		while(true){
			try{
				str1=din.readUTF(); // receive the message
				// add the message in list box
				model.addElement(str1);
			}catch(Exception e){  System.out.println("System error can't connect"); }
		}
	}
}