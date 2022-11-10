package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class searchroom  extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    searchroom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          
        
          JLabel heading = new JLabel("Search for Room");
        heading.setBounds(400,30,200,30);
        heading.setFont(new Font("Serif", Font.BOLD,20));
        add(heading);
        
         
          JLabel Bedtype = new JLabel("Bed Type");
        Bedtype.setBounds(50,100,100,20);
        Bedtype.setFont(new Font("Serif", Font.BOLD,20));
        add(Bedtype);
        
        bedtype = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        
        available = new JCheckBox("Only Display Available");
          available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        
        
    
    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(50,160,100,20);
    
   add(l1);
   
   
   JLabel l2 = new JLabel("Availablity");
    l2.setBounds(270,160,100,20);
    
  add(l2);
   
   
   JLabel l3 = new JLabel("Status");
    l3.setBounds(450,160,100,20);
    
   add(l3);
   
   
   JLabel l4 = new JLabel("Room Price");
    l4.setBounds(670,160,100,20);
    
   add(l4);
   
   
   JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(890,160,100,20);
    
   add(l5);
   
        
        table = new JTable();
        
        table.setBounds(30,200,1000,200);
        add(table);
        
        
        
        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        submit = new JButton("Submit");
        
        submit.setBounds(350,450,120,30);
        submit.setFont(new Font("Serif", Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
       submit.addActionListener(this);
     add(submit);
        
      back = new JButton("Back");
        
        back.setBounds(550,450,120,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
     add(back);
        
  
        
        setBounds(200,150,1050,550);
        
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query1 = "select * from room where bedtype = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from room where availablity = 'Available' AND bedtype = '"+bedtype.getSelectedItem()+"'";
                
                conn conn = new conn();
                
                ResultSet rs ;
                if(available.isSelected()){
                  rs=  conn.s.executeQuery(query2);
                  
                }else{
                    rs = conn.s.executeQuery(query1);
                    
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }


        }else{
        
          setVisible(false);
            new Reception();
    }
    }
    public static void main(String args[]){
        new searchroom(); 
    }
}
