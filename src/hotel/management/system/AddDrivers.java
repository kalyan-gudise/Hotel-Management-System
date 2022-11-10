

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {
    
    JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
    JLabel  heading,lblname,lblage,lblgender,lblcompany,lblmodel,lblavailable,lbllocation;
     JButton add,cancel;
            JComboBox  gendercombo,availablecombo;
    AddDrivers() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
          heading = new JLabel("Add Driver");
        heading.setBounds(150,10,200,20);
        heading.setFont(new Font("Serif", Font.BOLD,20));
        add(heading);
        
          lblname = new JLabel("Name");
        lblname.setBounds(60,60,120,30);
        lblname.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(200,60,150,30);
        add(tfname);
        
         lblage = new JLabel("Age");
        lblage.setBounds(60,110,120,30);
        lblage.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblage);
        
         tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        
       lblgender = new JLabel("Gender");
        lblgender.setBounds(60,160,120,30);
        lblgender.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblgender);
        
        
        String genderOptions []= {"Male","Female"};
        
         gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,160,150,30);
        
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        lblcompany = new JLabel("Car Company");
        lblcompany.setBounds(60,210,120,30);
        lblcompany.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,210,150,30);
        add(tfcompany);
        
        
          lblmodel = new JLabel("Car Model");
        lblmodel.setBounds(60,260,120,30);
        lblmodel.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200,260,150,30);
        add(tfmodel);
        
          lblavailable = new JLabel("Available");
        lblavailable.setBounds(60,310,120,30);
        lblavailable.setFont(new Font("Serif", Font.PLAIN,15));
        add(lblavailable);
         
          String availableOptions []= {"Available", "Busy"};
        
         availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,310,150,30);
        
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
         lbllocation = new JLabel("Location");
        lbllocation.setBounds(60,360,120,30);
        lbllocation.setFont(new Font("Serif", Font.PLAIN,15));
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200,360,150,30);
        add(tflocation);
        
        
          add = new JButton("Add");
        
        add.setBounds(60,410,130,30);
        add.setFont(new Font("Serif", Font.BOLD,15));
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
         cancel = new JButton("Cancel");
        
        cancel.setBounds(220,410,130,30);
        cancel.setFont(new Font("Serif", Font.BOLD,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
     add(cancel);
        
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Driver.jpg"));
    
         Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
         
 image.setBounds(420,120,300,200);
    add(image);
       
         
   
        
        
        
        setBounds(290,140,800,520);
        
      setVisible(true);
}
    
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource()==add){
             
             String name = tfname.getText();
             String age = tfage.getText();
                String gender = (String)gendercombo.getSelectedItem(); 
                
                 String company = tfcompany.getText();
                  String model = tfmodel.getText();
                  String available = (String)availablecombo.getSelectedItem();
             String location = tflocation.getText();
           
            
             
             
             try{
            conn conn = new conn();
            String query = "insert into driver value ( '"+name+"','"+age+"', '"+gender+"','"+company+"','"+model+"', '"+available+"', '"+location+"')";
            
           conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
            setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
             

  

         }else{
             setVisible(false);
         }
         
         
     }
    public static void main(String args []){
        new AddDrivers();
    
}
}
