
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener {
HotelManagementSystem(){
    setSize(1300,565);
    
    setLocation(50,50);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/open.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 1366,565);
    add(image);
    
    
    JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(20,400,800,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.PLAIN, 40));
    image.add(text);
    
    JButton next = new JButton("Next");
    next.setBounds(1100,400,150,50);
    next.setForeground(Color.BLACK);
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.PLAIN, 20));
    image.add(next);
    
    
    
    
    
    
    setVisible(true);
    while(true){
         text.setVisible(false);
    
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
}
}
public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new login();
}

    public static void main(String[] args) {
       new HotelManagementSystem();
    
}
}
