import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class admin extends JFrame implements ActionListener{
        ServerSocket ss;
	Socket s;
	ArrayList al=new ArrayList();
	ArrayList al1=new ArrayList();
	ArrayList al2=new ArrayList();
	ArrayList alname=new ArrayList();
	Socket s1,s2;
         
      
JTextField t1,t2;
JButton b;
public admin(){
	
JLabel l1 = new JLabel("<html> <h3> ADMIN_ID: </h3> </html>");
JLabel l2 = new JLabel("<html> <h3> PASSWORD: </h3> </html>");
b = new JButton("CONNECT");
t1 = new JTextField();
t2 = new JPasswordField();

setVisible(true);
pack();
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);

add(l1);
add(t1);
add(l2);
add(t2);
add(b);


l1.setBounds(200,100,100,30);
t1.setBounds(330,100,150,35);
l2.setBounds(200,170,100,30);
t2.setBounds(330,170,150,35);
b.setBounds(290,250,100,35);

b.addActionListener(this);
}

public void actionPerformed(ActionEvent e) 
{
Object src = e.getSource();
if(src.equals(b))
{
String a = t1.getText();
String b = t2.getText();
if(a.equals("suwas")&& b.equals("suwasizpunk"))
{
try {
ss=new ServerSocket(1445);	// create server socket
System.out.println("Waiting For Client To conect.............");
		while(true){
			s=ss.accept();	//accept the client socket
			s1=ss.accept();
			s2=ss.accept();
                                                            setVisible(false);
			al.add(s);	// add the client socket in arraylist
			al1.add(s1);
			al2.add(s2);
			System.out.println("Client is Connected");
			MyThread2 m=new MyThread2(s2,al2,alname); //new thread for maintaning the list of user name
			Thread t2=new Thread(m);
			t2.start();

			MyThread r=new MyThread(s,al);//new thread for receive and sending the messages
			Thread t=new Thread(r);
			t.start();
			
			MyThread1 my=new MyThread1(s1,al1,s,s2); // new thread for update the list of user name
			Thread t1=new Thread(my);
			t1.start();
		}
}
catch(IOException r){
System.out.print("error to provide portnumber");
}
}

else
{
JOptionPane.showMessageDialog(this,"invalid id and pasword!!!");
}
 
}
}

public static void main(String[] arg){
admin adm = new admin();
}
}
class MyThread1 implements Runnable{
	Socket s1,s,s2;
	static ArrayList al1;
	DataInputStream ddin;
	String sname;
	MyThread1(Socket s1,ArrayList al1,Socket s,Socket s2){
		this.s1=s1;
		this.al1=al1;
		this.s=s;
		this.s2=s2;
	}
	public void run(){	
		try{
		ddin=new DataInputStream(s1.getInputStream());
		while(true){
		sname=ddin.readUTF();
		System.out.println("Exit  :"+sname);
		MyThread2.alname.remove(sname);//remove the logout user name from arraylist
		MyThread2.every();
		al1.remove(s1);
		MyThread.al.remove(s);
		MyThread2.al2.remove(s2);
		if(al1.isEmpty())
			System.out.println("waiting for client to connect......."); //all client has been logout
		}
		}catch(Exception ie){}
	}
}

// class is used to maintain the list of all online users
class MyThread2 implements Runnable{
	Socket s2;
	static ArrayList al2;
	static ArrayList alname;
	static DataInputStream din1;	
	static DataOutputStream dout1;

	MyThread2(Socket s2,ArrayList al2,ArrayList alname){
		this.s2=s2;
		this.al2=al2;
		this.alname=alname;
	}
	public void run(){
		try{
		din1= new DataInputStream(s2.getInputStream());
		alname.add(din1.readUTF());	// store the user name in arraylist
		every();
		}catch(Exception oe){System.out.println("Main expression"+oe);}
	}
	// send the list of user name to all client
	static void every()throws Exception{
		Iterator i1=al2.iterator();
		Socket st1;		

		while(i1.hasNext()){
			st1=(Socket)i1.next();
			dout1=new DataOutputStream(st1.getOutputStream());
			ObjectOutputStream obj=new ObjectOutputStream(dout1);
			obj.writeObject(alname); //write the list of users in stream of all clients
			dout1.flush();
			obj.flush();
		}
	}
}
//class is used to receive the message and send it to all clients
class MyThread implements Runnable{
	Socket s;
	static ArrayList al;
	DataInputStream din;
	DataOutputStream dout;

	MyThread(Socket s, ArrayList al){
		this.s=s;
		this.al=al;
	}
	public void run(){
		String str;
		int i=1;
		try{
		din=new DataInputStream(s.getInputStream());
		}catch(Exception e){}
		
		while(i==1){
				try{
					
					str=din.readUTF(); //read the message
					distribute(str);
				}catch (IOException e){}
			}
	}
	// send it to all clients
	public void distribute(String str)throws IOException{
		Iterator i=al.iterator();
		Socket st;
		while(i.hasNext()){
			st=(Socket)i.next();
			dout=new DataOutputStream(st.getOutputStream());
			dout.writeUTF(str);
			dout.flush();
		}
	}
}