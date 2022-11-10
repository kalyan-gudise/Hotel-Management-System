package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Updatecheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
   JTextField tfroom,tfpending,tfpaid,tfcheckin, tfname;
   JButton check, update, back;
     Updatecheck(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
          
     JLabel heading = new JLabel("Update Status");
        heading.setBounds(90,20,200,30);
        heading.setFont(new Font("Serif", Font.BOLD,20));
        add(heading);
        
           JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
           ccustomer = new Choice();
           ccustomer.setBounds(200,80,130,25);
        add(ccustomer);
        
           try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
               
        }catch(Exception e){
            e.printStackTrace();
        }
           
           
           
            JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,130,20);
        add(tfroom);
            
        
         JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        add(lblname);
        
        tfname = new JTextField();
         tfname.setBounds(200,160,130,20);
        add( tfname);
            
         JLabel lblcheckin = new JLabel("Check In Time");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);
        
        tfcheckin = new JTextField();
         tfcheckin.setBounds(200,200,130,20);
        add( tfcheckin);
            
        
         JLabel lblpaid = new JLabel("Paid");
        lblpaid.setBounds(30,240,100,20);
        add(lblpaid);
        
        tfpaid = new JTextField();
         tfpaid.setBounds(200,240,130,20);
        add( tfpaid);
            
         JLabel lblpending = new JLabel("Pending");
        lblpending.setBounds(30,280,100,20);
        add(lblpending);
        
        tfpending = new JTextField();
         tfpending.setBounds(200,280,130,20);
        add( tfpending);
            
      check = new JButton("Check");
        
        check.setBounds(60,340,100,30);
        check.setFont(new Font("Serif", Font.BOLD,14));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
       check.addActionListener(this);
     add(check);
        
     update = new JButton("Update");
        
        update.setBounds(180,340,100,30);
        update.setFont(new Font("Serif", Font.BOLD,14));
        update.setBackground(Color.BLACK);
      update.setForeground(Color.WHITE);
       update.addActionListener(this);
     add(update);
        
      back = new JButton("Back");
        
        back.setBounds(120,380,100,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
     add(back);
        
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/check.png")) ;
     Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
     image.setBounds(350,70,300,250);
     add(image);
     
           
        setBounds(350,150,700,500);
        
      setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== check){
             String id = ccustomer.getSelectedItem();
             String query = "select * from customer where number = '"+id+"'";
             try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery(query);
            
           while(rs.next()){
               tfroom.setText(rs.getString("roomno"));
                tfname.setText(rs.getString("name"));
                 tfcheckin.setText(rs.getString("checkin"));
                  tfpaid.setText(rs.getString("deposit"));
           }
           ResultSet rs2 = conn.s.executeQuery("select * from room where roomno = '"+tfroom.getText()+"'");
           while(rs2.next()){
               String roomprice = rs2.getString("roomprice");
               int amountpaid = Integer.parseInt(roomprice)- Integer.parseInt(tfpaid.getText());
               tfpending.setText(""+amountpaid);
               
               
           }
        }catch(Exception e){
            e.printStackTrace();
        }
           
         }else if(ae.getSource()== update){
             String number = ccustomer.getSelectedItem();
             String room = tfroom.getText();
             String name = tfname.getText();
             String checkin = tfcheckin.getText();
               String deposit = tfpaid.getText();
               
               try{
            conn conn = new conn();
           conn.s.executeUpdate("update customer set roomno = '"+room+"',name = '"+name+"', checkin = '"+checkin+"', deposit = '"+deposit+"'");
           JOptionPane.showMessageDialog(null,"Data Updated Successfully");
           setVisible(false);
           new Reception();
               }catch(Exception e){
            e.printStackTrace();
               }
         }else{
             setVisible(false);
           new Reception();
         }
     }

      public static void main(String args[]){
        new Updatecheck(); 
    }
}

