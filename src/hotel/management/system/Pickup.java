package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
   Choice typeofcar;
    JCheckBox available;
    Pickup(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel heading = new JLabel("PickUp Service");
        heading.setBounds(450,25,200,30);
        heading.setFont(new Font("Serif", Font.BOLD,30));
        add(heading);


        JLabel Bedtype = new JLabel("Type of Car");
        Bedtype.setBounds(50,100,100,20);
        Bedtype.setFont(new Font("Serif", Font.PLAIN,15));
        add(Bedtype);

        this.typeofcar = new Choice();
        this.typeofcar.setBounds(150, 100, 200, 20);
        this.add(this.typeofcar);

        try {
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");

            while(rs.next()) {
                this.typeofcar.add(rs.getString("model"));
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        }


        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);





        JLabel l1 = new JLabel("Name");
        l1.setBounds(50,160,100,20);

        add(l1);


        JLabel l2 = new JLabel("Age");
        l2.setBounds(180,160,100,20);

        add(l2);


        JLabel l3 = new JLabel("Gender");
        l3.setBounds(320,160,100,20);

        add(l3);


        JLabel l4 = new JLabel("Company");
        l4.setBounds(470,160,100,20);

        add(l4);


        JLabel l5 = new JLabel("Model");
        l5.setBounds(620,160,100,20);

        add(l5);
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(750,160,100,20);

        add(l6);
        JLabel l7 = new JLabel("Location");
        l7.setBounds(900,160,100,20);

        add(l7);


        table = new JTable();

        table.setBounds(30,200,1000,200);
        add(table);



        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");

            table.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception e){
            e.printStackTrace();
        }


        submit = new JButton("Submit");

        submit.setBounds(350,450,120,30);
        submit.setFont(new Font("Serif", Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");

        back.setBounds(550,450,120,30);
        back.setFont(new Font("Serif", Font.BOLD,14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setBounds(200,150,1050,550);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query = "select * from driver where model = '"+typeofcar.getSelectedItem()+"'";


                conn conn = new conn();

                ResultSet rs ;

                rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }


        }else{

            setVisible(false);
            new Reception();
        }
    }
    public static void main(String args[]){
        new Pickup();
    }
}
