package Assignment24;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LibraryGUI
{
    JFrame frame;
    JTextField idField;
    JTextField nameField;
    JTextField priceField;
    JTextField lidField;
    JTextArea output;

    LibraryGUI()
    {
        frame=new JFrame("Library Management System");

        JLabel idLabel=new JLabel("Book ID:");
        JLabel nameLabel=new JLabel("Book Name:");
        JLabel priceLabel=new JLabel("Price:");
        JLabel lidLabel=new JLabel("Library ID:");

        idField=new JTextField();
        nameField=new JTextField();
        priceField=new JTextField();
        lidField=new JTextField();

        JButton add=new JButton("Add Book");
        JButton display=new JButton("Display Books");

        output=new JTextArea();
        output.setEditable(false);

        idLabel.setBounds(30,30,100,30);
        idField.setBounds(130,30,180,30);

        nameLabel.setBounds(30,70,100,30);
        nameField.setBounds(130,70,180,30);

        priceLabel.setBounds(30,110,100,30);
        priceField.setBounds(130,110,180,30);

        lidLabel.setBounds(30,150,100,30);
        lidField.setBounds(130,150,180,30);

        add.setBounds(40,200,120,30);
        display.setBounds(180,200,140,30);

        JScrollPane scroll=new JScrollPane(output);
        scroll.setBounds(30,250,350,200);

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/siulibrary",
                        "root",
                        "Adi@0917"
                    );

                    String query="insert into Books(Bid,Bname,Price,Lid) values(?,?,?,?)";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,Integer.parseInt(idField.getText()));
                    myStmt.setString(2,nameField.getText());
                    myStmt.setInt(3,Integer.parseInt(priceField.getText()));
                    myStmt.setInt(4,Integer.parseInt(lidField.getText()));

                    myStmt.executeUpdate();

                    JOptionPane.showMessageDialog(
                        frame,
                        "Book Added Successfully"
                    );

                    myStmt.close();
                    con.close();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Error: "+ex.getMessage()
                    );
                }
            }
        });

        display.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/siulibrary",
                        "root",
                        "Adi@0917"
                    );

                    Statement myStmt=con.createStatement();

                    String query="select * from Books";

                    ResultSet rs=myStmt.executeQuery(query);

                    output.setText("");

                    while(rs.next())
                    {
                        output.append(
                            "Book ID   : "+rs.getInt("Bid")+"\n"+
                            "Book Name : "+rs.getString("Bname")+"\n"+
                            "Price     : "+rs.getInt("Price")+"\n"+
                            "Library ID: "+rs.getInt("Lid")+"\n"+
                            "-----------------------------\n"
                        );
                    }

                    rs.close();
                    myStmt.close();
                    con.close();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Error: "+ex.getMessage()
                    );
                }
            }
        });

        frame.add(idLabel);
        frame.add(idField);

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(priceLabel);
        frame.add(priceField);

        frame.add(lidLabel);
        frame.add(lidField);

        frame.add(add);
        frame.add(display);
        frame.add(scroll);

        frame.setSize(430,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        new LibraryGUI();
    }
}