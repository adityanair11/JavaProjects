import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener
{
    JFrame frame;
    JTextField num1;
    JTextField num2;
    JLabel result;
    JButton add;
    JButton subtract;

    Calculator()
    {
        frame = new JFrame("Calculator");

        JLabel label1 = new JLabel("Number 1:");
        JLabel label2 = new JLabel("Number 2:");
        result = new JLabel("Result: ");

        num1 = new JTextField();
        num2 = new JTextField();

        add = new JButton("+");
        subtract = new JButton("-");

        label1.setBounds(50,40,100,30);
        num1.setBounds(150,40,150,30);

        label2.setBounds(50,80,100,30);
        num2.setBounds(150,80,150,30);

        add.setBounds(80,130,80,30);
        subtract.setBounds(190,130,80,30);

        result.setBounds(100,180,200,30);

        add.addActionListener(this);
        subtract.addActionListener(this);

        frame.add(label1);
        frame.add(num1);
        frame.add(label2);
        frame.add(num2);
        frame.add(add);
        frame.add(subtract);
        frame.add(result);

        frame.setSize(380,270);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());

        if(e.getSource()==add)
        {
            result.setText("Result: " + (a+b));
        }
        else if(e.getSource()==subtract)
        {
            result.setText("Result: " + (a-b));
        }
    }

    public static void main(String args[])
    {
        new Calculator();
    }
}