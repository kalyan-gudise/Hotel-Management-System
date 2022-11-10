package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department  extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Department(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          
        
  
    JLabel l1 = new JLabel("Department");
    l1.setBounds(100,10,100,20);
    
   add(l1);
   
   
   JLabel l2 = new JLabel("Budget");
    l2.setBounds(450,10,100,20);
    
  add(l2);
   

        table = new JTable();
        
        table.setBounds(30,50,600,250);
        add(table);
        
        
        
        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from department");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        
        back.setBounds(280,310,120,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
     add(back);
        
        
        setBounds(400,150,700,400);
        
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
          setVisible(false);
            new Reception();
    }
    public static void main(String args[]){
        new Department(); 
    }
}
