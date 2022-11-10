
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ROOM  extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    ROOM(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bed.jpg"));
    
         Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
       
         
   image.setBounds(550, 30, 450,400);
    add(image);
    
    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(30,10,100,20);
    
   add(l1);
   
   
   JLabel l2 = new JLabel("Availablity");
    l2.setBounds(135,10,100,20);
    
  add(l2);
   
   
   JLabel l3 = new JLabel("Status");
    l3.setBounds(235,10,100,20);
    
   add(l3);
   
   
   JLabel l4 = new JLabel("Room Price");
    l4.setBounds(335,10,100,20);
    
   add(l4);
   
   
   JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(435,10,100,20);
    
   add(l5);
   
        
        table = new JTable();
        
        table.setBounds(30,40,500,400);
        add(table);
        
        
        
        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        back = new JButton("Back");
        
        back.setBounds(200,450,120,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
     add(back);
        
        
        setBounds(200,150,1050,550);
        
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
          setVisible(false);
            new Reception();
    }
    public static void main(String args[]){
        new ROOM(); 
    }
}
