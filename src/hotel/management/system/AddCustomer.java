

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    
     JTextField tfnumber,tfname,tfdeposit,tfcountry;
    JLabel  heading,lblnumber,lblname,lblcountry,lbldeposit,lblroom,checkin,lbltime,lblid;
     JButton add,back;
     JRadioButton rbmale,rbfemale;
            JComboBox  idcombo;
            Choice croom;
    AddCustomer(){
     getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
          heading = new JLabel("New Customer Form");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("Serif", Font.BOLD,20));
        add(heading);
        
        lblid = new JLabel("ID");
        lblid.setBounds(60,80,120,30);
        lblid.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblid);
        
        
        String idOptions []= {"Aadhar Card","Voter Card", "Driving License", "Pan Card", "Passport","Ration Card"};
        
         idcombo = new JComboBox(idOptions);
        idcombo.setBounds(200,80,150,30);
        
        idcombo.setBackground(Color.WHITE);
        add(idcombo);
         
        
          lblnumber = new JLabel("Number");
        lblnumber.setBounds(60,120,120,30);
        lblnumber.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblnumber);
        
         tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,30);
        add(tfnumber);
        
         lblname = new JLabel("Name");
        lblname.setBounds(60,160,120,30);
        lblname.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblname);
        
        
         tfname = new JTextField();
        tfname.setBounds(200,160,150,30);
        add(tfname);
        
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,200,120,30);
        lblgender.setFont(new Font("Serif", Font.PLAIN,17));
        add(lblgender);
        
        
        
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,200,70,30);
        rbmale.setFont(new Font("Serif", Font.BOLD,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        
         rbfemale= new JRadioButton("Female");
        rbfemale.setBounds(280,200,90,30);
        rbfemale.setFont(new Font("Serif", Font.BOLD,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
         ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
       
        
       lblcountry = new JLabel("Country");
        lblcountry.setBounds(60,240,120,30);
        lblcountry.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblcountry);
        
         tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,30);
        add(tfcountry);
        
       
        
        lblroom = new JLabel("Room Number");
        lblroom.setBounds(60,280,120,30);
        lblroom.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            conn conn = new conn();
            String query = "select * from room where availablity ='Available'" ;
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        
        
               lbltime = new JLabel("Check In Time");
       lbltime.setBounds(60,320,120,30);
        lbltime.setFont(new Font("Serif", Font.PLAIN,15));
        add(lbltime);
        
        
        Date date = new Date();
        
           
        
        
          checkin = new JLabel(""+ date);
       checkin.setBounds(200,320,170,30);
        checkin.setFont(new Font("Serif", Font.PLAIN,15));
        add(checkin);
        
        
        
           
       lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(60,360,120,30);
        lbldeposit.setFont(new Font("Serif", Font.PLAIN,15));
        add(lbldeposit);
        
         tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,30);
        add(tfdeposit);
        
        
        
          add = new JButton("Add");
        
        add.setBounds(60,410,130,30);
        add.setFont(new Font("Serif", Font.BOLD,14));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
      add.addActionListener(this);
        add(add);
         
         back = new JButton("Back");
        
        back.setBounds(220,410,130,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
       back.addActionListener(this);
     add(back);
        
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/customer.png"));
    
         Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
       
         
   image.setBounds(350, 30, 400,400);
    add(image);
        
        
        
        
        setBounds(320,150,750,510);
        
      setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== add){
            
        String id = (String)idcombo.getSelectedItem();
        String number = tfnumber.getText();
        String name = tfname.getText();
          String gender = null;
         if(rbmale.isSelected()){
            gender = "Male";
        }else if (rbfemale.isSelected()){
            gender = "Female";
        }
        String country = tfcountry.getText();
        String roomno = croom.getSelectedItem();
        String time  =  checkin.getText();
       String deposit = tfdeposit.getText();
       
       
       try{
            
            String query = "insert into customer value ( '"+id+"','"+number+"', '"+name+"','"+gender+"','"+country+"','"+roomno+"', '"+time+"', '"+deposit+"')";
            String query2 = "update room set availablity = 'Occupied' where roomno = '"+roomno+"'";
           
            conn conn = new conn();
            conn.s.executeUpdate(query);
              conn.s.executeUpdate(query2);
              
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
            setVisible(false);
            new Reception();
           
        } catch(Exception e){
            e.printStackTrace();
        }
       
        } else if(ae.getSource()==back){
          setVisible(false);
            new Reception();
    }
    
        
      
       
    
    

            
       
        
    }
    public static void main(String args []){
        new AddCustomer();
    }
}
