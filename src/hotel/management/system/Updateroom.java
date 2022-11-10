
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Updateroom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfroom;

    JTextField tfclean;
    JTextField tfavailable;
    JButton check;
    JButton update;
    JButton back;

    Updateroom() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager)null);



        JLabel heading = new JLabel("Update Room Status");
        heading.setBounds(30, 20, 200, 30);
        heading.setFont(new Font("Serif", 1, 20));
        this.add(heading);


        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 100, 20);
        this.add(lblid);
        this.ccustomer = new Choice();
        this.ccustomer.setBounds(200, 80, 130, 25);
        this.add(this.ccustomer);

        try {
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");

            while(rs.next()) {
                this.ccustomer.add(rs.getString("number"));
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        this.add(lblroom);
        this.tfroom = new JTextField();
        this.tfroom.setBounds(200, 120, 130, 20);
        this.add(this.tfroom);
        JLabel lblavailable = new JLabel("Availabilty");
        lblavailable.setBounds(30, 160, 100, 20);
        this.add(lblavailable);


        this.tfavailable = new JTextField();
        this.tfavailable.setBounds(200, 160, 130, 20);
        this.add(this.tfavailable);


        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30, 200, 100, 20);
        this.add(lblcheckin);
        this.tfclean = new JTextField();
        this.tfclean.setBounds(200, 200, 130, 20);
        this.add(this.tfclean);


        this.check = new JButton("Check");
        this.check.setBounds(30, 250, 100, 30);
        this.check.setFont(new Font("Serif", 1, 14));
        this.check.setBackground(Color.BLACK);
        this.check.setForeground(Color.WHITE);
        this.check.addActionListener(this);
        this.add(this.check);


        this.update = new JButton("Update");
        this.update.setBounds(150, 250, 100, 30);
        this.update.setFont(new Font("Serif", 1, 14));
        this.update.setBackground(Color.BLACK);
        this.update.setForeground(Color.WHITE);
        this.update.addActionListener(this);
        this.add(this.update);



        this.back = new JButton("Back");
        this.back.setBounds(270, 250, 100, 30);
        this.back.setFont(new Font("Serif", 1, 14));
        this.back.setBackground(Color.BLACK);
        this.back.setForeground(Color.WHITE);
        this.back.addActionListener(this);
        this.add(this.back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource ("Icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(270, 200, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 40, 300, 250);
        this.add(image);


        this.setBounds(350, 150, 700, 400);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String number;
        String room;
        if (ae.getSource() == this.check) {
            number = this.ccustomer.getSelectedItem();
            room = "select * from customer where number = '" + number + "'";

            try {
                conn conn = new conn();
                ResultSet rs = conn.s.executeQuery(room);

                while(rs.next()) {
                    this.tfroom.setText(rs.getString("roomno"));


                }

                ResultSet rs2 = conn.s.executeQuery("select * from room where roomno = '" + this.tfroom.getText() + "'");

                while(rs2.next()) {
                    tfavailable.setText(rs2.getString("availablity"));
                    tfclean.setText(rs2.getString("status"));
                }
            } catch (Exception var10) {
                var10.printStackTrace();
            }
        } else if (ae.getSource() == this.update) {
            number = this.ccustomer.getSelectedItem();
            room = this.tfroom.getText();
            String available = this.tfavailable.getText();
            String status = this.tfclean.getText();

            try {
                conn conn = new conn();
                conn.s.executeUpdate("update room set availablity = '" + available + "',status = '" + status+ "'where roomno ='"+room+"'");
                JOptionPane.showMessageDialog((Component)null, "Data Updated Successfully");
                this.setVisible(false);
                new Reception();
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        } else {
            this.setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new Updateroom();
    }
}
