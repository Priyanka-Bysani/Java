/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package hosiptal.management.system;

/**
 *
 * @author B JAHNAVI
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class emplogin extends Frame implements ActionListener{
Frame f;
Button b1,b2,b3;
Label l1,l2,l3;
TextField t1,t2;
Connection c;
    PreparedStatement s;
    ResultSet r1;
String s1;
public emplogin(){
 f=new Frame("Employee Login");
  f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        l1=new Label("Username");
        l1.setBounds(50, 100, 100, 50);
        f.add(l1);
        t1=new TextField("");
        t1.setBounds(150,100,150,50);
        f.add(t1);
        l2=new Label("Password");
        l2.setBounds(50, 200, 100, 50);
        f.add(l2);
        t2=new TextField("");
        t2.setBounds(150,200,150,50);
        f.add(t2);
        t2.setEchoChar('*');
        l3=new Label("*Username and Password is incorrect");
        l3.setBounds(50, 250, 250, 50);
        l3.setForeground(Color.RED);
        
        b1=new Button("Login");
        b1.setBounds(50, 350, 80, 30);
        f.add(b1);
        b1.addActionListener(this);
        b2=new Button("Clear");
        b2.setBounds(160, 350, 80, 30);
        f.add(b2);
        b2.addActionListener(this);
        b3=new Button("Exit");
        b3.setBounds(260, 350, 80, 30);
        f.add(b3);
        b3.addActionListener(this);
try
        {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
        String path="C:\\Apps\\emplogin.accdb";
        String url="jdbc:ucanaccess://"+path;
        c=DriverManager.getConnection(url);
        
               
        System.out.println("Connected");
        }
        catch(Exception ex)
        {
            
        }
}
 public void actionPerformed(ActionEvent e) 
    {
 try{
        if(e.getSource()==b1)
        {
            String name=t1.getText();
            String pwd=t2.getText();
            String username;
            String password;
            s1="select * from login_details";
            s=c.prepareStatement(s1);
            r1=s.executeQuery();
            while(r1.next())
            {
                username=r1.getString(2);
                password=r1.getString(3);
                
                if(name.equals(username)&& pwd.equals(password))
                {
                    System.out.println("Success");
                    Patient obj1=new Patient();
                }
                else
                {
                    f.add(l3);
                   System.out.println("Not Success"); 
                }
            }
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            System.out.print("Entered Button 2");
        }
        else if(e.getSource()==b3)
        {
            System.out.print("Entered Button 3");
            System.exit(0);
            
        }
    }
        catch(Exception ex)
        {
            
        }
  }
}