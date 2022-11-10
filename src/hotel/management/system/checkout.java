package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class checkout  extends JFrame implements ActionListener {
    Choice ccustomer;
JLabel roomnumber,checkin,checkouttime;
JButton checkout,back;
    checkout(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading = new JLabel("Check Out");
        heading.setBounds(100, 20, 100, 30);
        heading.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(heading);


        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 100, 30);
        this.add(lblid);

        this.ccustomer = new Choice();
        this.ccustomer.setBounds(150, 80, 150, 25);
        this.add(this.ccustomer);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/tick.png")) ;
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310,80,20,20);

        add(tick);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        this.add(lblroom);

   roomnumber = new JLabel();
        roomnumber.setBounds(150, 130, 100, 30);
        this.add(roomnumber);

        JLabel lblcheckin = new JLabel("Check In");
        lblcheckin.setBounds(30, 180, 100, 30);
        this.add(lblcheckin);

       checkin = new JLabel();
        checkin.setBounds(150, 180, 100, 30);
        this.add(checkin);

        JLabel lblcheckout = new JLabel("Check Out");
        lblcheckout.setBounds(30, 230, 100, 30);
        this.add(lblcheckout);
         Date date = new Date();
        checkouttime = new JLabel(""+date);
        checkouttime.setBounds(150, 230, 150, 30);
        this.add(checkouttime);

        this.checkout = new JButton("Check Out");
        this.checkout.setBounds(30, 280, 120, 30);
        this.checkout.setFont(new Font("Serif", 1, 14));
        this.checkout.setBackground(Color.BLACK);
        this.checkout.setForeground(Color.WHITE);
checkout.addActionListener(this);
        this.add(this.checkout);

        this.back = new JButton("Back");
        this.back.setBounds(180, 280, 120, 30);
        this.back.setFont(new Font("Serif", 1, 14));
        this.back.setBackground(Color.BLACK);
        this.back.setForeground(Color.WHITE);
back.addActionListener(this);
        this.add(this.back);

        try {
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");

            while(rs.next()) {
                this.ccustomer.add(rs.getString("number"));
                roomnumber.setText(rs.getString("roomno"));
                checkin.setText(rs.getString("checkin"));
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        }


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/checkout.jpg")) ;
        Image i5 = i4.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(310,60,400,250);

        add(image);



        setBounds(300,200,700,400);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availablity= 'Available' where roomno ='"+roomnumber+"'";
            try {
                conn conn = new conn();
                conn.s.executeUpdate(query1);

                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Check Out Done");
setVisible(false);
                new Reception();
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[]){
new checkout();
    }

}