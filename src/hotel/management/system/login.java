
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100,30);
        add(user);
        
      username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
         JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100,30);
        add(pass);
        
        
        password = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        
         login = new JButton("Login");
        login.setBounds(50,150,80,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
           cancel = new JButton("Cancel");
        cancel.setBounds(140,150,80,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(350, 10, 200,200);
    add(image);
        
        
        setBounds(400,200,600,300);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
            String user = username.getText();
            String pass = password.getText();
            
            try{
                conn c = new conn();
                
                String query = "select * from login where username ='"+user+"' and password ='"+pass+"'";
                
              ResultSet rs =  c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Entrypage();
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        } 
        else if(ae.getSource() == cancel){
        setVisible(false);
    }
    
   
}


public static void main(String args []){
new login();
}
}