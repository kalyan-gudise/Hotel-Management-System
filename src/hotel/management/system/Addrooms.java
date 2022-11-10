
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addrooms extends JFrame implements ActionListener {
    
    JTextField tfroomno,tfroomprice;
    JLabel  heading,lblroomno,lblavailable,lblclean,lblroomprice,lblbed;
     JButton add,cancel;
            JComboBox availablecombo, cleancombo,bedcombo;
    Addrooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
          heading = new JLabel("Add Rooms");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("Serif", Font.BOLD,17));
        add(heading);
        
          lblroomno = new JLabel("Room No");
        lblroomno.setBounds(60,80,120,30);
        lblroomno.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblroomno);
        
         tfroomno = new JTextField();
        tfroomno.setBounds(200,80,150,30);
        add(tfroomno);
        
         lblavailable = new JLabel("Available");
        lblavailable.setBounds(60,130,120,30);
        lblavailable.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblavailable);
        
        
        String availableOptions []= {"Available","Occupied"};
        
         availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
       lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(60,180,120,30);
        lblclean.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblclean);
        
        
        String cleanOptions []= {"Cleaned","Dirty"};
        
         cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        lblroomprice = new JLabel("Room Price");
        lblroomprice.setBounds(60,230,120,30);
        lblroomprice.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblroomprice);
        
        tfroomprice = new JTextField();
        tfroomprice.setBounds(200,230,150,30);
        add(tfroomprice);
        
        
          lblbed = new JLabel("Bed Type");
        lblbed.setBounds(60,280,120,30);
        lblbed.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblbed);
        
        
        String bedOptions []= {"Single Bed","Double Bed"};
        
         bedcombo = new JComboBox(bedOptions);
        bedcombo.setBounds(200,280,150,30);
        
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);
        
        
          add = new JButton("Add");
        
        add.setBounds(60,350,130,30);
        add.setFont(new Font("Serif", Font.BOLD,14));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
         cancel = new JButton("Cancel");
        
        cancel.setBounds(220,350,130,30);
        cancel.setFont(new Font("Serif", Font.BOLD,14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
     add(cancel);
        
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/room.jpg"));
    
         
        JLabel image = new JLabel(i1);
         
   image.setBounds(450, 60, 400,280);
    add(image);
        
        
        
        
        setBounds(270,150,900,470);
        
      setVisible(true);
}
    
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource()==add){
             
             String roomno = tfroomno.getText();
                        String availability = (String)availablecombo.getSelectedItem(); 
                         String status = (String)cleancombo.getSelectedItem();
             String roomprice = tfroomprice.getText();
           
            
             String bedtype = (String)bedcombo.getSelectedItem();
             
             try{
            conn conn = new conn();
            String query = "insert into room value ( '"+roomno+"','"+availability+"', '"+status+"','"+roomprice+"','"+bedtype+"')";
            
           conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "New Room Added Successfully");
            setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
             

  

         }else{
             setVisible(false);
         }
         
         
     }
    public static void main(String args []){
        new Addrooms();
    
}
}
