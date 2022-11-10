package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo  extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          
        
      
    JLabel l1 = new JLabel("ID");
    l1.setBounds(120,10,100,20);
    
   add(l1);
   
   
   JLabel l2 = new JLabel("Number");
    l2.setBounds(220,10,100,20);
    
  add(l2);
   
   
   JLabel l3 = new JLabel("Name");
    l3.setBounds(310,10,100,20);
    
   add(l3);
   
   
   JLabel l4 = new JLabel("Gender");
    l4.setBounds(410,10,100,20);
    
   add(l4);
   
   
   JLabel l5 = new JLabel("Country");
    l5.setBounds(510,10,100,20);
    
   add(l5);
   
   JLabel l6 = new JLabel("Room Number");
    l6.setBounds(610,10,100,20);
    
   add(l6);
   JLabel l7 = new JLabel("Check In");
    l7.setBounds(710,10,100,20);
    
   add(l7);
   JLabel l8 = new JLabel("Depoit");
    l8.setBounds(810,10,100,20);
    
   add(l8);
        
        table = new JTable();
        
        table.setBounds(100,40,800,400);
        add(table);
        
        
        
        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            
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
        new CustomerInfo(); 
    }
}
