
 
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class addEmployee extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
    JRadioButton rbmale, rbfemale;
     JButton rsubmit;
     JComboBox  cbjob;
     
    addEmployee(){
        setLayout(null);
        
        JLabel lblname = new JLabel(" Full Name");
        lblname.setBounds(55,31,100,28);
        lblname.setFont(new Font("Serif", Font.BOLD,17));
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(200,30,170,30);
        add(tfname);
        
         JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Serif", Font.BOLD,17));
        add(lblage);
        
         tfage = new JTextField();
        tfage.setBounds(200,80,170,30);
        add(tfage);
        
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Serif", Font.BOLD,17));
        add(lblgender);
        
        
        
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,90,30);
        rbmale.setFont(new Font("Serif", Font.BOLD,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        
         rbfemale= new JRadioButton("Female");
        rbfemale.setBounds(300,130,90,30);
        rbfemale.setFont(new Font("Serif", Font.BOLD,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
         JLabel lbljob = new JLabel("Job");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Serif", Font.BOLD,17));
        add(lbljob);
        
        
        String str []= {"Accountant","Chef","Front Desk Clerk",  "HouseKeeping", "Kitchen Staff","Manager","Porter", "Room Service","Security","Waiter/Waitress"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,170,30);
        add(cbjob);
        
          JLabel lbsalary = new JLabel("Salary");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("Serif", Font.BOLD,17));
        add(lbsalary);
        
       tfsalary = new JTextField();
        tfsalary.setBounds(200,230,170,30);
        add(tfsalary);
        
        
          JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Serif", Font.BOLD,17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,280,170,30);
        add(tfphone);
        
          JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Serif", Font.BOLD,17));
        add(lblemail);
        
         tfemail = new JTextField();
        tfemail.setBounds(200,330,170,30);
        add(tfemail);
        
         JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Serif", Font.BOLD,17));
        add(lblaadhar);
        
         tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,170,30);
        add(tfaadhar);
        
        
        rsubmit = new JButton("Submit");
        rsubmit.setBounds(200,430,90,30);
        rsubmit.setFont(new Font("Serif", Font.BOLD,14));
        rsubmit.setBackground(Color.BLACK);
        rsubmit.setForeground(Color.WHITE);
        rsubmit.addActionListener(this);
        
        add(rsubmit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Employee.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
         
    image.setBounds(280, -50, 500,500);
    add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,140,700,550);
        
        
        
        
        
        
        
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        
        String salary = tfsalary.getText();
        String phone = tfage.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }
       
        if(age.equals("")){
            JOptionPane.showMessageDialog(null, "Age should not be empty");
            return;
        }
        
         if(salary.equals("")){
            JOptionPane.showMessageDialog(null, "Salary should not be empty");
            return;
        }
         
          if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "phone should not be empty");
            return;
        }
         if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null, "aadhar should not be empty");
            return;
        }
        
        
       
        
        
        
        if(rbmale.isSelected()){
            gender = "Male";
        }else if (rbfemale.isSelected()){
            gender = "Female";
        }
        String job = (String)cbjob.getSelectedItem();
        try{
            conn conn = new conn();
            String query = "insert into employee value ( '"+name+"','"+age+"', '"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
           conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added Successfully");
            setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main (String args []){
        new addEmployee();
    }
}
