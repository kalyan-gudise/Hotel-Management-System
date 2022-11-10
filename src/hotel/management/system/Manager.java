package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Manager  extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Manager(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          
        
      
    JLabel l1 = new JLabel("Name");
    l1.setBounds(120,10,100,20);
    
   add(l1);
   
   
   JLabel l2 = new JLabel("Age");
    l2.setBounds(220,10,100,20);
    
  add(l2);
   
   
   JLabel l3 = new JLabel("Gender");
    l3.setBounds(320,10,100,20);
    
   add(l3);
   
   
   JLabel l4 = new JLabel("Job");
    l4.setBounds(420,10,100,20);
    
   add(l4);
   
   
   JLabel l5 = new JLabel("Salary");
    l5.setBounds(520,10,100,20);
    
   add(l5);
   
   JLabel l6 = new JLabel("Phone");
    l6.setBounds(620,10,100,20);
    
   add(l6);
   JLabel l7 = new JLabel("E-Mail");
    l7.setBounds(720,10,100,20);
    
   add(l7);
   JLabel l8 = new JLabel("Aadhar");
    l8.setBounds(830,10,100,20);
    
   add(l8);
        
        table = new JTable();
        
        table.setBounds(100,40,800,400);
        add(table);
        
        
        
        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from employee where job = 'Manager'");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        
        back.setBounds(420,450,120,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
     add(back);
        
        
        setBounds(250,150,1000,550);
        
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
          setVisible(false);
            new Reception();
    }
    public static void main(String args[]){
        new Manager(); 
    }
}
