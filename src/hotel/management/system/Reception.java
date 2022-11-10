
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener {
     JButton logout,checkout,newcustomer,Department,employees,manager,customerinfo,search,room,update,updateroom,pickup;


    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
      
newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(15,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
         room = new JButton("Rooms");
        room.setBounds(15,70,200,30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.addActionListener(this);
        add(room);
        
         Department = new JButton("Department");
        Department.setBounds(15,110,200,30);
        Department.setBackground(Color.BLACK);
        Department.setForeground(Color.WHITE);
         Department.addActionListener(this);
        add(Department);
        
          employees = new JButton("All Employees");
        employees.setBounds(15,150,200,30);
        employees.setBackground(Color.BLACK);
        employees.setForeground(Color.WHITE);
         employees.addActionListener(this);
        add(employees);
        
        
          
       customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(15,190,200,30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
        
       manager = new JButton("Manager Info");
        manager.setBounds(15,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.addActionListener(this);
        add(manager);
      
        
            checkout = new JButton("Check Out");
        checkout.setBounds(15,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
      
        
         update = new JButton("Update Status");
        update.setBounds(15,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
      
        
          updateroom = new JButton("Update Room Status");
        updateroom.setBounds(15,350,200,30);
        updateroom.setBackground(Color.BLACK);
        updateroom.setForeground(Color.WHITE);
        updateroom.addActionListener(this);
        add(updateroom);
      
        
          pickup = new JButton("Pickup Service");
        pickup.setBounds(15,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
      
        
         search = new JButton("Search Room");
        search.setBounds(15,430,200,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
      
          logout = new JButton("Logout");
        logout.setBounds(15,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);

        logout.addActionListener(this);
        add(logout);
      
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/reception.jpg")) ;
         Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,50,700,400);
        
        add(image);
        
        
        
        setBounds(350,140,700,570);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource()==newcustomer){
             setVisible(false);
             new AddCustomer();
         }else if(ae.getSource()== room ){
             setVisible(false);
             new ROOM();
         }else if(ae.getSource()== Department ){
             setVisible(false);
             new Department();
         }else if(ae.getSource()== employees){
             setVisible(false);
             new Employee();
         }else if(ae.getSource()== manager){
             setVisible(false);
             new Manager();
         }
         else if(ae.getSource()== customerinfo){
             setVisible(false);
             new CustomerInfo();
         }else if(ae.getSource()== search){
             setVisible(false);
             new searchroom();
         }else if(ae.getSource()== update){
             setVisible(false);
             new Updatecheck();
         }else if(ae.getSource()== updateroom){
             setVisible(false);
             new Updateroom();
         }else if(ae.getSource()== pickup){
             setVisible(false);
             new Pickup();
         }else if(ae.getSource()== checkout){
            setVisible(false);
            new checkout();
        }else if(ae.getSource()== logout){
             setVisible(false);
             System.exit(0);
         }


    }
    
    public static void main (String args []){
        new Reception();
    }
}
