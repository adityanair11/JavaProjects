package Assignment24;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookIssueGUI
{
    JFrame frame;
    JTextField issueId;
    JTextField bookId;
    JTextField memberId;
    JTextField copyId;
    JTextField libraryId;
    JTextField issueDate;
    JTextField returnDate;
    JTextArea output;

    BookIssueGUI()
    {
        frame=new JFrame("Book Issue Tracking System");

        JLabel l1=new JLabel("Issue ID:");
        JLabel l2=new JLabel("Book ID:");
        JLabel l3=new JLabel("Member ID:");
        JLabel l4=new JLabel("Copy ID:");
        JLabel l5=new JLabel("Library ID:");
        JLabel l6=new JLabel("Issue Date:");
        JLabel l7=new JLabel("Return Date:");

        issueId=new JTextField();
        bookId=new JTextField();
        memberId=new JTextField();
        copyId=new JTextField();
        libraryId=new JTextField();
        issueDate=new JTextField();
        returnDate=new JTextField();

        JButton add=new JButton("Issue Book");
        JButton display=new JButton("Display");

        output=new JTextArea();
        output.setEditable(false);

        l1.setBounds(30,20,100,25);
        issueId.setBounds(130,20,180,25);

        l2.setBounds(30,55,100,25);
        bookId.setBounds(130,55,180,25);

        l3.setBounds(30,90,100,25);
        memberId.setBounds(130,90,180,25);

        l4.setBounds(30,125,100,25);
        copyId.setBounds(130,125,180,25);

        l5.setBounds(30,160,100,25);
        libraryId.setBounds(130,160,180,25);

        l6.setBounds(30,195,100,25);
        issueDate.setBounds(130,195,180,25);

        l7.setBounds(30,230,100,25);
        returnDate.setBounds(130,230,180,25);

        add.setBounds(60,270,110,30);
        display.setBounds(200,270,110,30);

        JScrollPane scroll=new JScrollPane(output);
        scroll.setBounds(30,315,350,200);

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

                    String query="insert into Issue" +
                        "(Issueid,Memid,Bid,Bnid,Lid,Issuedate,Returndate)" +
                        " values(?,?,?,?,?,?,?)";

                    PreparedStatement myStmt=con.prepareStatement(query);

                    myStmt.setInt(1,Integer.parseInt(issueId.getText()));
                    myStmt.setInt(2,Integer.parseInt(memberId.getText()));
                    myStmt.setInt(3,Integer.parseInt(bookId.getText()));
                    myStmt.setInt(4,Integer.parseInt(copyId.getText()));
                    myStmt.setInt(5,Integer.parseInt(libraryId.getText()));
                    myStmt.setDate(6,Date.valueOf(issueDate.getText()));
                    myStmt.setDate(7,Date.valueOf(returnDate.getText()));

                    myStmt.executeUpdate();

                    JOptionPane.showMessageDialog(
                        frame,
                        "Book Issued Successfully"
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

                    String query="select * from Issue";

                    ResultSet rs=myStmt.executeQuery(query);

                    output.setText("");

                    while(rs.next())
                    {
                        output.append(
                            "Issue ID    : "+rs.getInt("Issueid")+"\n"+
                            "Member ID   : "+rs.getInt("Memid")+"\n"+
                            "Book ID     : "+rs.getInt("Bid")+"\n"+
                            "Copy ID     : "+rs.getInt("Bnid")+"\n"+
                            "Library ID  : "+rs.getInt("Lid")+"\n"+
                            "Issue Date  : "+rs.getDate("Issuedate")+"\n"+
                            "Return Date : "+rs.getDate("Returndate")+"\n"+
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

        frame.add(l1);
        frame.add(issueId);

        frame.add(l2);
        frame.add(bookId);

        frame.add(l3);
        frame.add(memberId);

        frame.add(l4);
        frame.add(copyId);

        frame.add(l5);
        frame.add(libraryId);

        frame.add(l6);
        frame.add(issueDate);

        frame.add(l7);
        frame.add(returnDate);

        frame.add(add);
        frame.add(display);
        frame.add(scroll);

        frame.setSize(430,570);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        new BookIssueGUI();
    }
}