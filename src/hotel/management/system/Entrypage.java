package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Entrypage extends JFrame implements ActionListener {
    
    JMenuItem reception,addEmployee,addrooms,addDrivers;
    Entrypage(){
        setBounds(0,0,1366,768);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dashboard.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 766, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1366,766);
        add(image);
        
         
    JLabel text = new JLabel("Kalyan Hotel Welcomes You");
    text.setBounds(450,50,1000,50);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.PLAIN, 40));
    image.add(text);
    
    JMenuBar mb = new JMenuBar();
    mb.setBounds(0,0,1550,30);
    image.add(mb);
    
    JMenu Hotel = new JMenu("Hotel Management");
    Hotel.setForeground(Color.blue);
    mb.add(Hotel);
    
    
      reception = new JMenuItem("Reception");
    reception.addActionListener(this);
    Hotel.add(reception);
    
    
     
    JMenu Admin = new JMenu("Admin");
    Admin.setForeground(Color.RED);
    mb.add(Admin);
    
    addEmployee = new JMenuItem("Add Employee");
   addEmployee.addActionListener(this);
    Admin.add(addEmployee);
    
      addrooms = new JMenuItem("Add Rooms");
  addrooms.addActionListener(this);
    Admin.add(addrooms);
    
      addDrivers = new JMenuItem("Add Drivers");
    addDrivers.addActionListener(this);
    Admin.add(addDrivers);
    
    
    
    
    
    
    setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
          
            new addEmployee();
        }else if (ae.getActionCommand().equals("Add Rooms")){
            new Addrooms();
        }else if (ae.getActionCommand().equals("Add Drivers")){
            new AddDrivers();
        }else if (ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
    public static void main (String args []){
       new Entrypage();
    }
}
