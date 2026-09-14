import javax.swing.*;
import java.awt.event.*;

public class BankBalance implements ActionListener
{
    JFrame frame;
    JTextField balanceField;
    JTextField amountField;
    JLabel result;
    JButton deposit;
    JButton withdraw;

    BankBalance()
    {
        frame = new JFrame("Bank Balance Calculator");

        JLabel balanceLabel = new JLabel("Initial Balance:");
        JLabel amountLabel = new JLabel("Transaction Amount:");
        result = new JLabel("Balance: ");

        balanceField = new JTextField();
        amountField = new JTextField();

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");

        balanceLabel.setBounds(40,40,120,30);
        balanceField.setBounds(170,40,160,30);

        amountLabel.setBounds(40,80,130,30);
        amountField.setBounds(170,80,160,30);

        deposit.setBounds(70,130,100,30);
        withdraw.setBounds(210,130,100,30);

        result.setBounds(100,180,250,30);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        frame.add(balanceLabel);
        frame.add(balanceField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(deposit);
        frame.add(withdraw);
        frame.add(result);

        frame.setSize(400,270);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        double balance = Double.parseDouble(balanceField.getText());
        double amount = Double.parseDouble(amountField.getText());

        if(e.getSource()==deposit)
        {
            balance = balance + amount;
        }
        else if(e.getSource()==withdraw)
        {
            balance = balance - amount;
        }

        result.setText("Balance: " + balance);
    }

    public static void main(String args[])
    {
        new BankBalance();
    }
}